package com.servet.spring_data_jpa_rerun.service.impl;

import com.servet.spring_data_jpa_rerun.entity.Employee;
import com.servet.spring_data_jpa_rerun.repository.EmployeeRepository;
import com.servet.spring_data_jpa_rerun.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Employee dbEmployee = getEmployeeById(id);
        if (dbEmployee!=null)
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(Integer id, Employee updateEmployee) {
        Employee dbEmployee = getEmployeeById(id);
        if (dbEmployee!=null){
            dbEmployee.setFirstName(updateEmployee.getFirstName());
            dbEmployee.setLastName(updateEmployee.getLastName());
            dbEmployee.setBirthDate(updateEmployee.getBirthDate());
            dbEmployee.setSalary(updateEmployee.getSalary());
            employeeRepository.save(dbEmployee);
            return dbEmployee;
        }
        return null;
    }
}
