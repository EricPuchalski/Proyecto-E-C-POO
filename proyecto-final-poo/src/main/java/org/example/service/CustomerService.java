package org.example.service;

import java.util.ArrayList;
import org.example.dao.CustomerRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Customer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CustomerService implements CRUD<Customer>{
    private CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository();
    }
    
    public Customer findCustomerEnabledByCuit(String cuit){
        Customer customerFound = customerRepository.findCustomerEnabledByCuit(cuit);
        if (customerFound.getEstado().equals(Customer.Estado.ENABLED)) {
                return customerRepository.findCustomerEnabledByCuit(cuit);
            }
        return null;
    }
    public void disableAccountByCuit(String cuit){
        Customer customer = customerRepository.findCustomerEnabledByCuit(cuit);
        if (customer!=null) {
            try {
                customerRepository.disableAccountByCuit(cuit);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List<Customer> findAllEnabledCustomers(){
        return customerRepository.findCustomerEntities()
            .stream()
            .filter(customer -> customer.getEstado().equals(Customer.Estado.ENABLED))
            .collect(Collectors.toList());
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

    @Override
    public void save(Customer t) {
    if (!(t.getCuit().isEmpty() || t.getName().isEmpty() || t.getSurname().isEmpty() || t.getAdress().isEmpty() || t.getPhone().isEmpty())) {
        customerRepository.create(t);
    }     
    }
    public List<Customer> findAllCustomersByCuit(String cuit){
        if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowerCaseCuit = cuit.toLowerCase();
        List<Customer> customersFound= new ArrayList<>();
        customersFound = this.findAllEnabledCustomers()
        .stream()
        .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowerCaseCuit))
        .collect(Collectors.toList());
        return customersFound;
        }
 
}

