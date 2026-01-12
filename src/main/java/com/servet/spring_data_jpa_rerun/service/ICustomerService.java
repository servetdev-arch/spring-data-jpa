package com.servet.spring_data_jpa_rerun.service;

import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}
