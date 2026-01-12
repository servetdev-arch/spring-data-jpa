package com.servet.spring_data_jpa_rerun.service.impl;

import com.servet.spring_data_jpa_rerun.dto.DtoAddress;
import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;
import com.servet.spring_data_jpa_rerun.entity.Address;
import com.servet.spring_data_jpa_rerun.repository.AddressRepository;
import com.servet.spring_data_jpa_rerun.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public DtoAddress findAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        DtoCustomer dtoCustomer = new DtoCustomer();
        Optional<Address> optional = addressRepository.findById(id);

        if (optional.isEmpty()){
            return null;
        }

        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());

        dtoAddress.setCustomer(dtoCustomer);

        return dtoAddress;
    }
}
