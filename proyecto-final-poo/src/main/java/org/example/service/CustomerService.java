package org.example.service;

import org.example.model.Customer;
import org.example.repository.ClienteRepository;

import java.util.List;

public class CustomerService implements CRUD<Customer>{
    private ClienteRepository clienteRepository;

    public CustomerService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    public void save(Customer customer){
        if (clienteRepository.findOne(customer.getCuit())!=null) {
        }else {clienteRepository.save(customer);

        }
    }


    public List<Customer>findAll(){
        return clienteRepository.findAll();
    }


    public Customer findOne(String cuit){
        Customer customer = null;
        if (clienteRepository.findOne(cuit)!=null) {
            customer = clienteRepository.findOne(cuit);

        }
        return customer;

    }


    public void upDate(Customer customer){
        if(findOne(customer.getCuit()) != null){
            clienteRepository.upDate(customer);
        }
    }
    public void delete(String cuit){
        if (findOne(cuit)!= null){
            clienteRepository.delete(cuit);
        }
    }
}

