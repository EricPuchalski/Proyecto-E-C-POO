package org.example.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class ClienteRepository implements CRUD<Customer>{

    private List<Customer> customers;
    private boolean clienteExistente;
    public ClienteRepository() {
        this.customers = new ArrayList<>();
        upLoad();
    }

    public void upLoad(){
        Customer c1 = new Customer("123","Eric", "Puch", "Josesito 232","3243242");
        Customer c2 = new Customer("32323","Juan", "Mendez", "San jose 34354","23435");
        Customer c3 = new Customer("234324","Elric", "Jalil", "Calle 150","34543543");
        Customer c4 = new Customer("3453","Carlos", "Perez", "Calle 32","653634");
        Customer c5 = new Customer("54634","Gustavo", "Lopez", "calle 09","6435345");
        Customer c6 = new Customer("534534","Pablo", "Gonzalez", "Bolivar 232","43543");
        Customer c7 = new Customer("543534","Martin", "Khea", "Calle 90","65454");


        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);
        customers.add(c7);


    }

    public void save(Customer customer) {
        customers.add(customer);
    }

    public void delete(String id) {
        Customer customerExistente = findOne(id);
        if (customerExistente != null) {
            customerExistente.setEstado(Customer.Estado.DISABLED);
        }
    }
    public List<Customer> findAll() {
        List<Customer>clientesHabilitados = new ArrayList<>();
        for(Customer cr : customers){
            if(cr.getEstado() == Customer.Estado.ENABLED){
                clientesHabilitados.add(cr);
            }
        }
        return clientesHabilitados;
    }


    public Customer findOne(String id) {
        Customer customer = null;
        for (Customer cr : customers){
            if (cr.getCuit().equals(id)){
                customer = cr;
            }
        }
        return customer;
    }
    public void upDate(Customer customer) {
        Customer customerExistente = findOne(customer.getCuit());
        if (customerExistente != null) {
            customerExistente.setName(customer.getName());
            customerExistente.setSurname(customer.getSurname());
            customerExistente.setAdress(customer.getAdress());
            customerExistente.setPhone(customer.getPhone());
    }
}







}
