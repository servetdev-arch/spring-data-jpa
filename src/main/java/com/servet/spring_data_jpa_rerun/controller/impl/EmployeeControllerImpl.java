package com.servet.spring_data_jpa_rerun.controller.impl;

import com.servet.spring_data_jpa_rerun.controller.IEmployeeController;
import com.servet.spring_data_jpa_rerun.entity.Employee;
import com.servet.spring_data_jpa_rerun.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/save")
    @Override
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/list")
    @Override
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/list/{id}")
    @Override
    public Employee getEmployeeById(@PathVariable(name = "id",required = true) Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteEmployee(@PathVariable(name = "id") Integer id) {
         employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Employee updateEmployee(@PathVariable(name = "id") Integer id,@RequestBody Employee updateEmployee) {
        return employeeService.updateEmployeeById(id,updateEmployee);
    }
}
