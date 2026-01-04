package com.servet.spring_data_jpa_rerun.controller;

import com.servet.spring_data_jpa_rerun.dto.DtoEmployee;
import com.servet.spring_data_jpa_rerun.dto.DtoEmployeeIU;
import com.servet.spring_data_jpa_rerun.entity.Employee;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface IEmployeeController {

    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU);

    public List<DtoEmployee> getAllEmployee();

    public DtoEmployee getEmployeeById(Integer id);

    public void deleteEmployee(Integer id);

    public DtoEmployee updateEmployee(Integer id , DtoEmployeeIU dtoEmployeeIU);
}
