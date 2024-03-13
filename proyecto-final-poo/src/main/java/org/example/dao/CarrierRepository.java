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
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Carrier;
import org.example.model.Order;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class CarrierRepository implements Serializable {
    private OrderRepository orderRepository;


    public CarrierRepository() {
        this.emf = Conexion.getEmf();
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void upLoad() {
            
        Carrier t1 = new Carrier("12321","Correo Argentino","12342", "correo_argentino@gmail.com",Carrier.CarrierType.AIR);
        Carrier t2 = new Carrier("32133","OCA","4352", "oca@gmail.com",Carrier.CarrierType.LAND);
        Carrier t3 = new Carrier("23255","OCASA","7653432", "oacasa@gmail.com",Carrier.CarrierType.MARITIME);
        Carrier t4 = new Carrier("34443","AMAZON","4235234", "amazon@gmail.com",Carrier.CarrierType.AIR);
        Carrier t5 = new Carrier("67611","DHL","12321", "dhl@gmail.com",Carrier.CarrierType.LAND);
        Carrier t6 = new Carrier("67624","FedEx","123321", "fedex@gmail.com",Carrier.CarrierType.MARITIME);

        this.create(t1);
        this.create(t2);
        this.create(t3);
        this.create(t4);
        this.create(t5);
        this.create(t6);
            

    }
    public Carrier create(Carrier carrier) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrier);
            em.getTransaction().commit();
            return carrier;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

         public Carrier findCarrierEnabledByCuit(String cuit) {
        EntityManager em = getEntityManager();
        try {
            for (Carrier object : findCarrierEntities()) {
                if (object.getCuit().equals(cuit)) {
                    return em.find(Carrier.class, object.getId());
                }
            }
            // Si no se encontró ningún cliente con el CUIT especificado
            return null;
        } finally {
            em.close();
        }
    }


    public Carrier disableAccountByCuit(String cuit) throws NonexistentEntityException{
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrier carrier;
            try {
                for (Carrier object : findCarrierEntities()) {
                if (object.getCuit().equals(cuit)) {
                    carrier = em.getReference(Carrier.class, object.getId());
                    carrier.setStatus(Carrier.Status.DISABLED);
                    em.getTransaction().commit();
                    return carrier;

                }
                
            }
                
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + cuit + " no longer exists.", enfe);
            }
            
            
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }
    public Carrier edit(Carrier carrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carrier = em.merge(carrier);
            em.getTransaction().commit();
            return carrier;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = carrier.getId();
                if (findCarrier(id) == null) {
                    throw new NonexistentEntityException("The carrier with id " + id + " no longer exists.");
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
            Carrier carrier;
            try {
                carrier = em.getReference(Carrier.class, id);
                carrier.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(carrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carrier> findCarrierEntities() {
        return findCarrierEntities(true, -1, -1);
    }

    public List<Carrier> findCarrierEntities(int maxResults, int firstResult) {
        return findCarrierEntities(false, maxResults, firstResult);
    }

    private List<Carrier> findCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrier.class));
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

    public Carrier findCarrier(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrier> rt = cq.from(Carrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
