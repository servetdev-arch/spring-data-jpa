package com.servet.spring_data_jpa_rerun.controller;


import com.servet.spring_data_jpa_rerun.dto.DtoAddress;

public interface IAddressController {

    public DtoAddress findAddressById(Long id);
}
