package com.servet.spring_data_jpa_rerun.service;

import com.servet.spring_data_jpa_rerun.dto.DtoEmployee;
import com.servet.spring_data_jpa_rerun.dto.DtoEmployeeIU;
import com.servet.spring_data_jpa_rerun.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public DtoEmployee saveEmployee(DtoEmployeeIU employee);

    public List<DtoEmployee> getAllEmployee();

    public DtoEmployee getEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);

    public DtoEmployee updateEmployeeById(Integer id, DtoEmployeeIU dtoEmployeeIU);
}
