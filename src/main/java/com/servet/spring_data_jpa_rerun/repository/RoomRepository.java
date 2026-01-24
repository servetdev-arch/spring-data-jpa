package com.servet.spring_data_jpa_rerun.repository;

import com.servet.spring_data_jpa_rerun.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
