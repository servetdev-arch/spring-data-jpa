package com.servet.spring_data_jpa_rerun.service;

import com.servet.spring_data_jpa_rerun.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);

    public DtoHome saveHome(DtoHome dtoHome);
}
