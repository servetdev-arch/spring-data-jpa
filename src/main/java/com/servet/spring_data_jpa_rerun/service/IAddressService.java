package com.servet.spring_data_jpa_rerun.service;

import com.servet.spring_data_jpa_rerun.dto.DtoAddress;

public interface IAddressService {

    public DtoAddress findAddressById(Long id);
}
