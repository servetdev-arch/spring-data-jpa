package com.servet.spring_data_jpa_rerun.service.impl;

import com.servet.spring_data_jpa_rerun.dto.DtoHome;
import com.servet.spring_data_jpa_rerun.dto.DtoRoom;
import com.servet.spring_data_jpa_rerun.entity.Home;
import com.servet.spring_data_jpa_rerun.entity.Room;
import com.servet.spring_data_jpa_rerun.repository.HomeRepository;
import com.servet.spring_data_jpa_rerun.repository.RoomRepository;
import com.servet.spring_data_jpa_rerun.service.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();
        List<Room> dbRooms = optional.get().getRoom();
        BeanUtils.copyProperties(dbHome, dtoHome);
        if (dbRooms != null && !dbRooms.isEmpty()){
            for (Room room : dbRooms){
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }

        return dtoHome;
    }

    @Override
    @Transactional
    public DtoHome saveHome(DtoHome dtoHome) {
        Home home = new Home();
        BeanUtils.copyProperties(dtoHome,home , "id", "rooms");

        List<Room> roomList = new ArrayList<>();

        for (DtoRoom dtoRoom : dtoHome.getRooms()){
            Room room = new Room();
            BeanUtils.copyProperties(dtoRoom, room, "id");
            roomList.add(room);
        }

        roomRepository.saveAll(roomList);
        home.setRooms(roomList);

        Home savedHome = homeRepository.save(home);

        DtoHome response = new DtoHome();
        BeanUtils.copyProperties(savedHome, response);

        List<DtoRoom> dtoRoomList = new ArrayList<>();

        for (Room room : savedHome.getRoom()){
            DtoRoom dtoRoom = new DtoRoom();
            BeanUtils.copyProperties(room,dtoRoom);
            dtoRoomList.add(dtoRoom);
        }
        response.setRooms(dtoRoomList);
        return response;
    }
}
