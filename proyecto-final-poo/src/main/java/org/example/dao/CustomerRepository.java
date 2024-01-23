/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import org.example.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Customer;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class CustomerRepository implements Serializable {


    public CustomerRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void upLoad(){
        Customer c1 = new Customer("1510","Eric", "Puch", "Josesito 232","3243242");
        Customer c2 = new Customer("3182","Juan", "Mendez", "San jose 34354","23435");
        Customer c3 = new Customer("2353","Elric", "Jalil", "Calle 150","34543543");
        Customer c4 = new Customer("3453","Carlos", "Perez", "Calle 32","653634");
        Customer c5 = new Customer("5463","Gustavo", "Lopez", "calle 09","6435345");
        Customer c6 = new Customer("5345","Pablo", "Gonzalez", "Bolivar 232","43543");
        Customer c7 = new Customer("5435","Martin", "Khea", "Calle 90","65454");
        Customer c8 = new Customer("1234", "John", "Doe", "Street 123", "1234567");
        Customer c9 = new Customer("5678", "Jane", "Smith", "Avenue 456", "9876543");
        Customer c10 = new Customer("9012", "Michael", "Johnson", "Road 789", "5678901");
        Customer c11 = new Customer("3456", "Emily", "Davis", "Lane 321", "1098765");
        Customer c12 = new Customer("7890", "David", "Anderson", "Court 654", "4321098");
        Customer c13 = new Customer("2348", "Sarah", "Wilson", "Plaza 987", "8765432");
        Customer c14 = new Customer("6769", "Daniel", "Taylor", "Square 654", "2109876");
        Customer c15 = new Customer("0655", "Olivia", "Thomas", "Circle 321", "5432109");
        Customer c16 = new Customer("4561", "Matthew", "Roberts", "Park 789", "8901234");
        Customer c17 = new Customer("8911", "Sophia", "Clark", "Garden 123", "5678901");
        Customer c18 = new Customer("2341", "James", "Lewis", "Drive 456", "4321098");
        Customer c19 = new Customer("6289", "Emma", "Lee", "Boulevard 789", "8765432");
        Customer c20 = new Customer("0123", "Benjamin", "Walker", "Highway 321", "2109876");
        Customer c21 = new Customer("4562", "Ava", "Hall", "Lane 654", "5432109");
        Customer c22 = new Customer("8921", "William", "Young", "Street 987", "8901234");
        Customer c23 = new Customer("2340", "Mia", "Allen", "Avenue 123", "5678901");
        Customer c24 = new Customer("6819", "Alexander", "King", "Road 456", "4321098");
        Customer c25 = new Customer("0122", "Sofia", "Wright", "Court 789", "8765432");
        Customer c26 = new Customer("4522", "Charlotte", "Lopez", "Plaza 321", "2109876");
        Customer c27 = new Customer("8201", "Joseph", "Hill", "Square 654", "5432109");
        Customer c28 = new Customer("9210","Erik", "Asd", "Josesito 222","3243942");


        this.create(c1);
        this.create(c2);
        this.create(c3);
        this.create(c4);
        this.create(c5);
        this.create(c6);
        this.create(c7);
        this.create(c8);
        this.create(c9);
        this.create(c10);
        this.create(c11);
        this.create(c12);
        this.create(c13);
        this.create(c14);
        this.create(c15);
        this.create(c16);
        this.create(c17);
        this.create(c18);
        this.create(c19);
        this.create(c20);
        this.create(c21);
        this.create(c22);
        this.create(c23);
        this.create(c24);
        this.create(c25);
        this.create(c26);
        this.create(c27);
        this.create(c28);
    }
    public void create(Customer customer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            customer = em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customer.getId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
