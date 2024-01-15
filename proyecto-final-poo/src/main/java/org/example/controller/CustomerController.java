package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;

public class CustomerController implements CRUD<Customer>{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer findOne(String cuit){
        return customerService.findOne(cuit);

    }

    public List<Customer> findAll() {
        return customerService.findAll();
    }


    public void delete(String cuit) {
        customerService.delete(cuit);
    }

    public  void create(Customer customer){
        customerService.save(customer);
    }
    public void upDate(Customer customer) {
        customerService.upDate(customer);
    }
}
