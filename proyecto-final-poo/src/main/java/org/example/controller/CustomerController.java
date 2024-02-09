package org.example.controller;



import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.exceptions.NonexistentEntityException;

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

    public List<Customer> findAllEnabledCustomers(){
        return customerService.findAllEnabledCustomers();
    }
    public Customer findCustomerEnabledByCuit(String cuit){
        return customerService.findCustomerEnabledByCuit(cuit);
    }
    public Customer disableAccountByCuit(String cuit){
        return customerService.disableAccountByCuit(cuit);
    }
    public void delete(String cuit) throws NonexistentEntityException {
        customerService.delete(cuit);
    }

    public  Customer create(Customer customer){
        return customerService.save(customer);
    }
    public Customer upDate(Customer customer) throws Exception {
        return customerService.upDate(customer);
    }
    public List<Customer> findAllCustomersByCuit(String cuit){
        return customerService.findAllCustomersByCuit(cuit);
   
    }
}
