/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Order;
import org.example.model.Tracking;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class TrackingRepository implements Serializable {
    private OrderRepository orderRepository;

    public TrackingRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tracking tracking) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Order order = tracking.getOrder();
            if (order != null) {
                order = em.getReference(order.getClass(), order.getId());
                tracking.setOrder(order);
            }
            em.persist(tracking);
            if (order != null) {
                Tracking oldTrackingOfOrder = order.getTracking();
                if (oldTrackingOfOrder != null) {
                    oldTrackingOfOrder.setOrder(null);
                    oldTrackingOfOrder = em.merge(oldTrackingOfOrder);
                }
                order.setTracking(tracking);
                order = em.merge(order);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tracking tracking) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tracking persistentTracking = em.find(Tracking.class, tracking.getId());
            Order orderOld = persistentTracking.getOrder();
            Order orderNew = tracking.getOrder();
            if (orderNew != null) {
                orderNew = em.getReference(orderNew.getClass(), orderNew.getId());
                tracking.setOrder(orderNew);
            }
            tracking = em.merge(tracking);
            if (orderOld != null && !orderOld.equals(orderNew)) {
                orderOld.setTracking(null);
                orderOld = em.merge(orderOld);
            }
            if (orderNew != null && !orderNew.equals(orderOld)) {
                Tracking oldTrackingOfOrder = orderNew.getTracking();
                if (oldTrackingOfOrder != null) {
                    oldTrackingOfOrder.setOrder(null);
                    oldTrackingOfOrder = em.merge(oldTrackingOfOrder);
                }
                orderNew.setTracking(tracking);
                orderNew = em.merge(orderNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tracking.getId();
                if (findTracking(id) == null) {
                    throw new NonexistentEntityException("The tracking with id " + id + " no longer exists.");
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
            Tracking tracking;
            try {
                tracking = em.getReference(Tracking.class, id);
                tracking.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tracking with id " + id + " no longer exists.", enfe);
            }
            Order order = tracking.getOrder();
            if (order != null) {
                order.setTracking(null);
                order = em.merge(order);
            }
            em.remove(tracking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tracking> findTrackingEntities() {
        return findTrackingEntities(true, -1, -1);
    }

    public List<Tracking> findTrackingEntities(int maxResults, int firstResult) {
        return findTrackingEntities(false, maxResults, firstResult);
    }

    private List<Tracking> findTrackingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tracking.class));
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

    public Tracking findTracking(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tracking.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrackingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tracking> rt = cq.from(Tracking.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
