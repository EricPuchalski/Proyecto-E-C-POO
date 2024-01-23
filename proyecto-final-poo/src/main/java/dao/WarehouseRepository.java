/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.model.Warehouse;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class WarehouseRepository implements Serializable {
    private SectorRepository sectorRepository;
    
    public WarehouseRepository() {
        this.emf = Conexion.getEmf();
        this.sectorRepository = new SectorRepository();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void upLoad() {

        
        Warehouse deposito1 = new Warehouse("1","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        Warehouse deposito2 = new Warehouse("2","Deposito Australia","San martin 2324","1232312","depositoAU@gmail.com", "Oceania", new Position(-22.593680,144.544854));
        Warehouse deposito3 = new Warehouse("3","Deposito Argentina","San juan 2324","4132","depositoAR@gmail.com", "America",  new Position(-34.537211,-58.547629));
        Warehouse deposito4 = new Warehouse("4", "Deposito Sudafrica", "Av. Colón 1234", "3512345678", "depositoSA@gmail.com", "Africa", new Position(-30.849319,24.201486));
        Warehouse deposito5 = new Warehouse("5", "Deposito España", "Av. San Martín 4321", "2612345678", "depositoES@gmail.com", "Europa",new Position(39.514578,-2.490630));
        deposito1.getSectors().addAll(sectorRepository.findSectorEntities());
        deposito2.getSectors().addAll(sectorRepository.findSectorEntities());
        deposito3.getSectors().addAll(sectorRepository.findSectorEntities());
        deposito4.getSectors().addAll(sectorRepository.findSectorEntities());
        deposito5.getSectors().addAll(sectorRepository.findSectorEntities());
        
        this.create(deposito1);
        this.create(deposito2);
        this.create(deposito3);
        this.create(deposito4);
        this.create(deposito5);

    }
    public void create(Warehouse warehouse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(warehouse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Warehouse warehouse) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            warehouse = em.merge(warehouse);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = warehouse.getId();
                if (findWarehouse(id) == null) {
                    throw new NonexistentEntityException("The warehouse with id " + id + " no longer exists.");
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
            Warehouse warehouse;
            try {
                warehouse = em.getReference(Warehouse.class, id);
                warehouse.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The warehouse with id " + id + " no longer exists.", enfe);
            }
            em.remove(warehouse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Warehouse> findWarehouseEntities() {
        return findWarehouseEntities(true, -1, -1);
    }

    public List<Warehouse> findWarehouseEntities(int maxResults, int firstResult) {
        return findWarehouseEntities(false, maxResults, firstResult);
    }

    private List<Warehouse> findWarehouseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Warehouse.class));
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

    public Warehouse findWarehouse(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Warehouse.class, id);
        } finally {
            em.close();
        }
    }

    public int getWarehouseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Warehouse> rt = cq.from(Warehouse.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}