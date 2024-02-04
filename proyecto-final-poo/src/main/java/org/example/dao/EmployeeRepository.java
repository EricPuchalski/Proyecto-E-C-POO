
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
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Employee;
import org.example.util.Conexion;

/**

     *
     * @author ericp
     */
    public class EmployeeRepository implements Serializable {
       public EmployeeRepository() {
        this.emf = Conexion.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
 public Employee findEmployeeByCuit(String cuit) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT o FROM Employee o WHERE o.cuit = :cuit", Employee.class);
            query.setParameter("cuit", cuit);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
           } finally {
            em.close();
        }
    }
           
        public void create(Employee employee) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                em.persist(employee);
                em.getTransaction().commit();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        public void edit(Employee employee) throws NonexistentEntityException, Exception {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                employee = em.merge(employee);
                em.getTransaction().commit();
            } catch (Exception ex) {
                String msg = ex.getLocalizedMessage();
                if (msg == null || msg.length() == 0) {
                    Long id = employee.getId();
                    if (findEmployee(id) == null) {
                        throw new NonexistentEntityException("The employee with id " + id + " no longer exists.");
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
        
        Employee employee;
        try {
            employee = em.getReference(Employee.class, id);
            employee.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("El empleado co el id " + id + " no existe mas.", enfe);
        }
        
        // Primero, elimina las referencias al empleado en la tabla WAREHOUSES
        Query query = em.createQuery("UPDATE Warehouse w SET w.employee = null WHERE w.employee.id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
        
        // Luego, elimina al empleado
        em.remove(employee);
        
        em.getTransaction().commit();
    } finally {
        if (em != null) {
            em.close();
        }
    }
}
        public List<Employee> findEmployeeEntities() {
            return findEmployeeEntities(true, -1, -1);
        }

        public List<Employee> findEmployeeEntities(int maxResults, int firstResult) {
            return findEmployeeEntities(false, maxResults, firstResult);
        }

        private List<Employee> findEmployeeEntities(boolean all, int maxResults, int firstResult) {
            EntityManager em = getEntityManager();
            try {
                CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
                cq.select(cq.from(Employee.class));
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

        public Employee findEmployee(Long id) {
            EntityManager em = getEntityManager();
            try {
                return em.find(Employee.class, id);
            } finally {
                em.close();
            }
        }

        public int getEmployeeCount() {
            EntityManager em = getEntityManager();
            try {
                CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
                Root<Employee> rt = cq.from(Employee.class);
                cq.select(em.getCriteriaBuilder().count(rt));
                Query q = em.createQuery(cq);
                return ((Long) q.getSingleResult()).intValue();
            } finally {
                em.close();
            }
        }

    }
