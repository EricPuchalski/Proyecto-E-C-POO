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
import org.example.model.OrderLine;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class OrderLineRepository implements Serializable {

    public OrderLineRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrderLine orderLine) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(orderLine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrderLine orderLine) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            orderLine = em.merge(orderLine);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = orderLine.getId();
                if (findOrderLine(id) == null) {
                    throw new NonexistentEntityException("The orderLine with id " + id + " no longer exists.");
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
            OrderLine orderLine;
            try {
                orderLine = em.getReference(OrderLine.class, id);
                orderLine.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderLine with id " + id + " no longer exists.", enfe);
            }
            em.remove(orderLine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrderLine> findOrderLineEntities() {
        return findOrderLineEntities(true, -1, -1);
    }

    public List<OrderLine> findOrderLineEntities(int maxResults, int firstResult) {
        return findOrderLineEntities(false, maxResults, firstResult);
    }

    private List<OrderLine> findOrderLineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrderLine.class));
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

    public OrderLine findOrderLine(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrderLine.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderLineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrderLine> rt = cq.from(OrderLine.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
