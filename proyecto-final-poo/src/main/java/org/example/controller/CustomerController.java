package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Customer> findAllCustomersByCuit(String cuit){
          if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowerCaseCuit = cuit.toLowerCase();
        List<Customer> customersFound= new ArrayList<>();
        customersFound = this.findAll()
        .stream()
        .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowerCaseCuit))
        .collect(Collectors.toList());
        
        
        return customersFound;
   
    }
}
