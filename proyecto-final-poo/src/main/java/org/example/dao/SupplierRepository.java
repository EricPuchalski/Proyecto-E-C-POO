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
import org.example.model.Product;
import org.example.model.Supplier;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class SupplierRepository implements Serializable {

    public SupplierRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;



    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void upLoad() {
        Supplier p1 = new Supplier("0001", "Apple", "villa lugano", "123", "manza@gmail");
        Supplier p2 = new Supplier("0002", "Yamaha", "Villa Cabello", "345", "sancor@gmail");
        Supplier p3 = new Supplier("0003", "Nike", "villa cariñito", "678", "nike@gmail");
        Supplier p4 = new Supplier("0004", "Adidas", "villa miseria", "910", "adid@gmail");
        Supplier p5 = new Supplier("0005", "Honda", "villa 327", "012", "honda@gmail");
        this.create(p1);
        this.create(p2);
        this.create(p3);
        this.create(p4);
        this.create(p5);
    }

    public Supplier create(Supplier supplier) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(supplier);
            em.getTransaction().commit();
            return supplier;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Supplier findSupplierEnabledByCuit(String cuit) {
        EntityManager em = getEntityManager();
        try {
            for (Supplier object : findSupplierEntities()) {
                if (object.getCuit().equals(cuit)) {
                    return em.find(Supplier.class, object.getId());
                }
            }
            // Si no se encontró ningún cliente con el CUIT especificado
            return null;
        } finally {
            em.close();
        }
    }


    public Supplier disableAccountByCuit(String cuit) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplier;
            try {
                for (Supplier object : findSupplierEntities()) {
                    if (object.getCuit().equals(cuit)) {
                        supplier = em.getReference(Supplier.class, object.getId());
                        supplier.setStatus(Supplier.Status.DISABLED);
                          em.createQuery("UPDATE Product p SET p.status = :status WHERE p.supplier.cuit = :cuit")
                            .setParameter("status", Product.Status.DISABLED) 
                            .setParameter("cuit", cuit)
                            .executeUpdate();
                                    em.getTransaction().commit();
                        return supplier;
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

    public Supplier edit(Supplier supplier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            supplier = em.merge(supplier);
            em.getTransaction().commit();
            return supplier;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = supplier.getId();
                if (findSupplier(id) == null) {
                    throw new NonexistentEntityException("The supplier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Supplier> findSupplierEntities() {
        return findSupplierEntities(true, -1, -1);
    }

    public List<Supplier> findSupplierEntities(int maxResults, int firstResult) {
        return findSupplierEntities(false, maxResults, firstResult);
    }

    private List<Supplier> findSupplierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supplier.class));
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

    public Supplier findSupplier(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupplierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Supplier> rt = cq.from(Supplier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Supplier supplier;
            try {
                supplier = em.getReference(Supplier.class, id);
                supplier.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("EL supplier con el id:  " + id + " ya no existe.", enfe);
            }
            // Elimina todos los productos asociados al proveedor en una sola transacción
            Query query = em.createQuery("DELETE FROM Product p WHERE p.supplier.id = :supplierId");
            query.setParameter("supplierId", id);
            query.executeUpdate();

            // Finalmente, elimina el proveedor
            em.remove(supplier);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
