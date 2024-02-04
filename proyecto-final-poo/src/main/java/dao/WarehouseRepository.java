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
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    private EmployeeRepository employeeRepository;
    
    public WarehouseRepository() {
        this.emf = Conexion.getEmf();
        this.sectorRepository = new SectorRepository();
        this.employeeRepository = new EmployeeRepository();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void upLoad() throws Exception {
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
        
        Employee empleado1 = new Employee("1235433", "Juan", "Perez", "Calle 273", "232323",this.findWarehouse(1l));
        Employee empleado2 = new Employee("4562324", "María", "López", "Avenida 45", "454545",this.findWarehouse(2l));
        Employee empleado3 = new Employee("7896754", "Augusto", "Britez", "Calle 67", "676767",this.findWarehouse(3l));
        Employee empleado4 = new Employee("1067515", "Ruben", "Luka", "Avenida 819", "898989",this.findWarehouse(4l));
        Employee empleado5 = new Employee("1217665", "Pepe", "Felix", "Calle 110", "101010",this.findWarehouse(5l));


        employeeRepository.create(empleado1);
        employeeRepository.create(empleado2);
        employeeRepository.create(empleado3);
        employeeRepository.create(empleado4);
        employeeRepository.create(empleado5);    

        
        deposito1.setEmployee(empleado1);
        this.edit(deposito1);
                deposito2.setEmployee(empleado2);
        this.edit(deposito2);
                deposito3.setEmployee(empleado3);
        this.edit(deposito3);
                deposito4.setEmployee(empleado4);
        this.edit(deposito4);
                deposito5.setEmployee(empleado5);
        this.edit(deposito5);

    }
   
        public void disableAccountByEmail(String email) throws NonexistentEntityException{
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Warehouse warehouse;
            try {
                for (Warehouse object : findWarehouseEntities()) {
                if (object.getEmail().equals(email)) {
                    warehouse = em.getReference(Warehouse.class, object.getId());
                    warehouse.setStatus(Warehouse.Estado.DISABLED);
                }
            }
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + email + " no longer exists.", enfe);
            }
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        public Warehouse findWarehouseEnabledByCuit(String email) {
        EntityManager em = getEntityManager();
        try {
            for (Warehouse object : findWarehouseEntities()) {
                if (object.getEmail().equals(email)) {
                    return em.find(Warehouse.class, object.getId());
                }
            }
            // Si no se encontró ningún cliente con el CUIT especificado
            return null;
        } finally {
            em.close();
        }
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
            // Obtén la lista de empleados asociados al depósito
            Employee employee = warehouse.getEmployee();
            employee.setDeposit(null);
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
