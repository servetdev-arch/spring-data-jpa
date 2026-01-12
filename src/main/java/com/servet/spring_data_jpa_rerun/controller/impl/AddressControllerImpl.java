package com.servet.spring_data_jpa_rerun.controller.impl;

import com.servet.spring_data_jpa_rerun.controller.IAddressController;
import com.servet.spring_data_jpa_rerun.dto.DtoAddress;
import com.servet.spring_data_jpa_rerun.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    IAddressService addressService;
    @GetMapping("/list/{id}")
    @Override
    public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
        return addressService.findAddressById(id);
    }
}
