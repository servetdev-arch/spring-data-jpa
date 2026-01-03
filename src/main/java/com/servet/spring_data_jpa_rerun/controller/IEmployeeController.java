package com.servet.spring_data_jpa_rerun.controller;

import com.servet.spring_data_jpa_rerun.entity.Employee;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface IEmployeeController {

    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(Integer id);

    public void deleteEmployee(Integer id);

    public Employee updateEmployee(Integer id , Employee updateEmployee);
}
