package com.servet.spring_data_jpa_rerun.controller;

import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;
import com.servet.spring_data_jpa_rerun.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);

    public DtoHome saveHome(DtoHome dtoHome);

    public DtoHome updateHome(Long id, DtoHome dtoHome);
}
