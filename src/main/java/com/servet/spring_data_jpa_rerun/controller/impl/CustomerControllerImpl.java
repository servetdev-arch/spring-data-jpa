package com.servet.spring_data_jpa_rerun.controller.impl;

import com.servet.spring_data_jpa_rerun.controller.ICustomerController;
import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;
import com.servet.spring_data_jpa_rerun.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/save")
    @Override
    public DtoCustomer saveCustomer(@RequestBody DtoCustomer dtoCustomer) {
        return customerService.saveCustomer(dtoCustomer);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoCustomer updateCustomer(@PathVariable Long id, @RequestBody DtoCustomer dtoCustomer) {
        return customerService.updateCustomerById(id, dtoCustomer);
    }

}
