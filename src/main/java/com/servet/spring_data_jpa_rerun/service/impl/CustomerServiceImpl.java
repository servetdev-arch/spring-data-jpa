package com.servet.spring_data_jpa_rerun.service.impl;

import com.servet.spring_data_jpa_rerun.dto.DtoAddress;
import com.servet.spring_data_jpa_rerun.dto.DtoCustomer;
import com.servet.spring_data_jpa_rerun.entity.Address;
import com.servet.spring_data_jpa_rerun.entity.Customer;
import com.servet.spring_data_jpa_rerun.repository.CustomerRepository;
import com.servet.spring_data_jpa_rerun.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }

    @Override
    @Transactional
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(dtoCustomer, customer , "id", "address");

        if (dtoCustomer.getAddress() != null){
            Address address = new Address();
            BeanUtils.copyProperties(dtoCustomer.getAddress(),address,"id","customer");

            customer.setAddress(address);
            address.setCustomer(customer);
        }

        Customer savedCustomer = customerRepository.save(customer);

        DtoCustomer response = new DtoCustomer();

        BeanUtils.copyProperties(savedCustomer,response);

        if (savedCustomer.getAddress()!=null){
            DtoAddress dtoAddress = new DtoAddress();
            BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
            response.setAddress(dtoAddress);
        }
        return response;
    }

    @Override
    public DtoCustomer updateCustomerById(Long id, DtoCustomer dtoCustomer) {

       Optional<Customer> optional = customerRepository.findById(id);

       if (optional.isEmpty()){
           return null;
       }

       Customer customer = optional.get();

       BeanUtils.copyProperties(dtoCustomer,customer, "id", "address");

       if (dtoCustomer.getAddress() != null){
           Address address = new Address();

           if (customer.getAddress() !=null){
               address = customer.getAddress();
           }
           else {
               address = new Address();
               customer.setAddress(address);
               address.setCustomer(customer);
           }

           BeanUtils.copyProperties(dtoCustomer.getAddress(), address , "id", "customer");

       }
       Customer updatedCustomer = customerRepository.save(customer);

       DtoCustomer response = new DtoCustomer();

       BeanUtils.copyProperties(updatedCustomer, response);

       if (updatedCustomer.getAddress() != null) {
           DtoAddress dtoAddress = new DtoAddress();
           BeanUtils.copyProperties(updatedCustomer.getAddress(), dtoAddress);
           response.setAddress(dtoAddress);
       }
       return response;
    }
}
