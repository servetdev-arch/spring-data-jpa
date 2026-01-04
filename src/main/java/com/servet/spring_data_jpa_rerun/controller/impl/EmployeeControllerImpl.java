package com.servet.spring_data_jpa_rerun.controller.impl;

import com.servet.spring_data_jpa_rerun.controller.IEmployeeController;
import com.servet.spring_data_jpa_rerun.dto.DtoEmployee;
import com.servet.spring_data_jpa_rerun.dto.DtoEmployeeIU;
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
    public DtoEmployee saveEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {
        return employeeService.saveEmployee(dtoEmployeeIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoEmployee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoEmployee getEmployeeById(@PathVariable(name = "id",required = true) Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteEmployee(@PathVariable(name = "id") Integer id) {
         employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoEmployee updateEmployee(@PathVariable(name = "id") Integer id,@RequestBody DtoEmployeeIU dtoEmployeeIU) {
        return employeeService.updateEmployeeById(id,dtoEmployeeIU);
    }
}
