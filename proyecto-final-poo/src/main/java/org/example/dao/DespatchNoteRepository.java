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
import org.example.model.DespatchNote;

/**
 *
 * @author ericp
 */
public class DespatchNoteRepository implements Serializable {

    public DespatchNoteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DespatchNote despatchNote) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(despatchNote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DespatchNote despatchNote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            despatchNote = em.merge(despatchNote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = despatchNote.getId();
                if (findDespatchNote(id) == null) {
                    throw new NonexistentEntityException("The despatchNote with id " + id + " no longer exists.");
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
            DespatchNote despatchNote;
            try {
                despatchNote = em.getReference(DespatchNote.class, id);
                despatchNote.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The despatchNote with id " + id + " no longer exists.", enfe);
            }
            em.remove(despatchNote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DespatchNote> findDespatchNoteEntities() {
        return findDespatchNoteEntities(true, -1, -1);
    }

    public List<DespatchNote> findDespatchNoteEntities(int maxResults, int firstResult) {
        return findDespatchNoteEntities(false, maxResults, firstResult);
    }

    private List<DespatchNote> findDespatchNoteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DespatchNote.class));
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

    public DespatchNote findDespatchNote(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DespatchNote.class, id);
        } finally {
            em.close();
        }
    }

    public int getDespatchNoteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DespatchNote> rt = cq.from(DespatchNote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
