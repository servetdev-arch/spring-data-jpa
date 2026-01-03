package com.servet.spring_data_jpa_rerun.service;

import com.servet.spring_data_jpa_rerun.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);

    public Employee updateEmployeeById(Integer id, Employee updateEmployee);
}
