package com.servet.spring_data_jpa_rerun.controller.impl;

import com.servet.spring_data_jpa_rerun.controller.IHomeController;
import com.servet.spring_data_jpa_rerun.dto.DtoHome;
import com.servet.spring_data_jpa_rerun.service.IHomeService;
import com.servet.spring_data_jpa_rerun.service.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/list/{id}")
    @Override
    public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
        return homeService.findHomeById(id);
    }

    @PostMapping("/save")
    @Override
    public DtoHome saveHome(@RequestBody DtoHome dtoHome) {
        return homeService.saveHome(dtoHome);
    }
}
