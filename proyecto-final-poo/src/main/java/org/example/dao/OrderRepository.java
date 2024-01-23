/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import org.example.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Order;
import org.example.model.Tracking;
import org.example.model.Warehouse;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class OrderRepository implements Serializable {
    private CustomerRepository customerRepository;
    private WarehouseRepository warehouseRepository;
    private CarrierRepository carrierRepository;

    public OrderRepository() {
        this.emf = Conexion.getEmf();
        this.customerRepository = new CustomerRepository();
        this.warehouseRepository = new WarehouseRepository();
        this.carrierRepository = new CarrierRepository();
    }

    public void upload(){

        Order o1 = new Order("123", customerRepository.findCustomer(1l), warehouseRepository.findWarehouse(1l), warehouseRepository.findWarehouse(2l), carrierRepository.findCarrier(1l), warehouseRepository.findWarehouse(1l).getSectors().get(3).getDescription(), LocalDate.of(2023, 3, 3));
        this.create(o1);
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Order order) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tracking tracking = order.getTracking();
            if (tracking != null) {
                tracking = em.getReference(tracking.getClass(), tracking.getId());
                order.setTracking(tracking);
            }
            em.persist(order);
            if (tracking != null) {
                Order oldOrderOfTracking = tracking.getOrder();
                if (oldOrderOfTracking != null) {
                    oldOrderOfTracking.setTracking(null);
                    oldOrderOfTracking = em.merge(oldOrderOfTracking);
                }
                tracking.setOrder(order);
                tracking = em.merge(tracking);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Order order) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Order persistentOrder = em.find(Order.class, order.getId());
            Tracking trackingOld = persistentOrder.getTracking();
            Tracking trackingNew = order.getTracking();
            if (trackingNew != null) {
                trackingNew = em.getReference(trackingNew.getClass(), trackingNew.getId());
                order.setTracking(trackingNew);
            }
            order = em.merge(order);
            if (trackingOld != null && !trackingOld.equals(trackingNew)) {
                trackingOld.setOrder(null);
                trackingOld = em.merge(trackingOld);
            }
            if (trackingNew != null && !trackingNew.equals(trackingOld)) {
                Order oldOrderOfTracking = trackingNew.getOrder();
                if (oldOrderOfTracking != null) {
                    oldOrderOfTracking.setTracking(null);
                    oldOrderOfTracking = em.merge(oldOrderOfTracking);
                }
                trackingNew.setOrder(order);
                trackingNew = em.merge(trackingNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = order.getId();
                if (findOrder(id) == null) {
                    throw new NonexistentEntityException("The order with id " + id + " no longer exists.");
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
            Order order;
            try {
                order = em.getReference(Order.class, id);
                order.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The order with id " + id + " no longer exists.", enfe);
            }
            Tracking tracking = order.getTracking();
            if (tracking != null) {
                tracking.setOrder(null);
                tracking = em.merge(tracking);
            }
            em.remove(order);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> findOrderEntities() {
        return findOrderEntities(true, -1, -1);
    }

    public List<Order> findOrderEntities(int maxResults, int firstResult) {
        return findOrderEntities(false, maxResults, firstResult);
    }

    private List<Order> findOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Order.class));
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

    public Order findOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Order.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Order> rt = cq.from(Order.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
