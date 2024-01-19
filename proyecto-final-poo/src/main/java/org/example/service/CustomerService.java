package org.example.service;

import dao.CustomerRepository;
import dao.exceptions.NonexistentEntityException;
import org.example.model.Customer;

import java.util.List;

public class CustomerService implements CRUD<Customer>{
    private CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository();
    }
    public void save(Customer customer){
        if (!customerRepository.findCustomerEntities().contains(customer.getCuit())) {
        }else{
            customerRepository.create(customer);
        }
    }

    public List<Customer>findAll(){
        return customerRepository.findCustomerEntities();
    }

    public Customer findOne(String cuit){
        for (Customer customer : customerRepository.findCustomerEntities()  ) {
            if (cuit.equals(customer.getCuit())) {
                return customer;
            }
        }
        return null;
    }

    public void upDate(Customer customer) throws Exception {
        if(customerRepository.findCustomer(customer.getId())!= null){
            customerRepository.edit(customer);
        }
    }
    public void delete(String cuit) throws NonexistentEntityException {
        Customer deleteCustomer = findOne(cuit);
        if (findOne(cuit)!= null){
            customerRepository.destroy(deleteCustomer.getId());
        }
    }
}

