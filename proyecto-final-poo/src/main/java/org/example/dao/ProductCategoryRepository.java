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
import org.example.model.ProductCategory;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class ProductCategoryRepository implements Serializable {

    public ProductCategoryRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void upload(){
        ProductCategory computing = new ProductCategory("Computing");
        ProductCategory clean = new ProductCategory("Clean");
        ProductCategory home = new ProductCategory("Home");
        ProductCategory garden = new ProductCategory("Garden");
        ProductCategory electronic = new ProductCategory("Electronic");
        ProductCategory toy = new ProductCategory("Toy");
        
        this.create(computing);
        this.create(home);
        this.create(garden);
        this.create(clean);
        this.create(electronic);
        this.create(toy);
    }
    public ProductCategory create(ProductCategory productCategory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productCategory);
            em.getTransaction().commit();
            return productCategory;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public ProductCategory edit(ProductCategory productCategory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productCategory = em.merge(productCategory);
            em.getTransaction().commit();
            return productCategory;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productCategory.getId();
                if (findProductCategory(id) == null) {
                    throw new NonexistentEntityException("The productCategory with id " + id + " no longer exists.");
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
            ProductCategory productCategory;
            try {
                productCategory = em.getReference(ProductCategory.class, id);
                productCategory.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productCategory with id " + id + " no longer exists.", enfe);
            }
            em.remove(productCategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductCategory> findProductCategoryEntities() {
        return findProductCategoryEntities(true, -1, -1);
    }

    public List<ProductCategory> findProductCategoryEntities(int maxResults, int firstResult) {
        return findProductCategoryEntities(false, maxResults, firstResult);
    }

    private List<ProductCategory> findProductCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductCategory.class));
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

    public ProductCategory findProductCategory(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductCategory.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductCategory> rt = cq.from(ProductCategory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
