package com.servet.spring_data_jpa_rerun.controller;

import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
}
