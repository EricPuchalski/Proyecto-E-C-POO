package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;

public class CustomerController implements CRUD<Customer>{

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public Customer findOne(String cuit){
        return customerService.findOne(cuit);

    }

    public List<Customer> findAll() {
        return customerService.findAll();
    }


    public void delete(String cuit) throws NonexistentEntityException {
        customerService.delete(cuit);
    }

    public  void create(Customer customer){
        customerService.save(customer);
    }
    public void upDate(Customer customer) throws Exception {
        customerService.upDate(customer);
    }
}