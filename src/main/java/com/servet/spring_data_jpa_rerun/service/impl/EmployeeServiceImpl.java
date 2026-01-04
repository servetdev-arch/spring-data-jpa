package com.servet.spring_data_jpa_rerun.service.impl;

import com.servet.spring_data_jpa_rerun.dto.DtoEmployee;
import com.servet.spring_data_jpa_rerun.dto.DtoEmployeeIU;
import com.servet.spring_data_jpa_rerun.entity.Employee;
import com.servet.spring_data_jpa_rerun.repository.EmployeeRepository;
import com.servet.spring_data_jpa_rerun.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {
        DtoEmployee response = new DtoEmployee();
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployeeIU, employee);

        Employee dbEmployee = employeeRepository.save(employee) ;
        BeanUtils.copyProperties(dbEmployee, response);
        return response;
    }

    @Override
    public List<DtoEmployee> getAllEmployee() {
        List<DtoEmployee> dtoList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee employee : employeeList){
            DtoEmployee dto = new DtoEmployee();
            BeanUtils.copyProperties(employee,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoEmployee getEmployeeById(Integer id) {
        DtoEmployee dto = new DtoEmployee();
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            Employee dbEmployee = optional.get();
            BeanUtils.copyProperties(dbEmployee,dto);
        }
        return dto;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            employeeRepository.delete(optional.get());
        }
    }

    @Override
    public DtoEmployee updateEmployeeById(Integer id, DtoEmployeeIU dtoEmployeeIU) {
        DtoEmployee dtoEmployee = new DtoEmployee();
     Optional<Employee> optional = employeeRepository.findById(id);

     if (optional.isPresent()){
         Employee dbEmployee = optional.get();

         dbEmployee.setFirstName(dtoEmployeeIU.getFirstName());
         dbEmployee.setLastName(dtoEmployeeIU.getLastName());
         dbEmployee.setBirthDate(dtoEmployeeIU.getBirthDate());
         dbEmployee.setSalary(dtoEmployeeIU.getSalary());

        Employee updatedEmployee = employeeRepository.save(dbEmployee);
        BeanUtils.copyProperties(updatedEmployee,dtoEmployee);
        return dtoEmployee;
     }
     return null;
    }
}
