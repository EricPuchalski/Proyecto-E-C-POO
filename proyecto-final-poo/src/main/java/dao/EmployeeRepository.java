
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
import org.example.util.Conexion;

/**

     *
     * @author ericp
     */
    public class EmployeeRepository implements Serializable {
        WarehouseRepository warehouseRepository = new WarehouseRepository();

        public EmployeeRepository() {
            this.emf = Conexion.getEmf();
            this.warehouseRepository = new WarehouseRepository();
            
        }
   

           public void upLoad() {
            Employee empleado1 = new Employee("1235433", "Juan", "Perez", "Calle 273", "232323",warehouseRepository.findWarehouse(1l));
            Employee empleado2 = new Employee("4562324", "María", "López", "Avenida 45", "454545",warehouseRepository.findWarehouse(2l));
            Employee empleado3 = new Employee("7896754", "Augusto", "Britez", "Calle 67", "676767",warehouseRepository.findWarehouse(3l));
            Employee empleado4 = new Employee("1067515", "Ruben", "Luka", "Avenida 819", "898989",warehouseRepository.findWarehouse(4l));
            Employee empleado5 = new Employee("1217665", "Pepe", "Felix", "Calle 110", "101010",warehouseRepository.findWarehouse(5l));
            Employee empleado6 = new Employee("1238767", "Leonel", "Pratto", "Calle 213", "234323",warehouseRepository.findWarehouse(1l));
            Employee empleado7 = new Employee("4564325", "Luisa", "Martinez", "Avenida 45", "452545",warehouseRepository.findWarehouse(2l));
            Employee empleado8 = new Employee("7891234", "Pedro", "Gabon", "Calle 67", "126767",warehouseRepository.findWarehouse(3l));
            Employee empleado9 = new Employee("1015423", "Laura", "Rodríguez", "Avenida 89", "128989",warehouseRepository.findWarehouse(4l));
            Employee empleado10 = new Employee("2122145", "Carlos", "Sánchez", "Calle 140", "871010",warehouseRepository.findWarehouse(5l));
            Employee empleado11 = new Employee("1223764", "Juan", "Modric", "Calle 223", "265323",warehouseRepository.findWarehouse(1l));
            Employee empleado12 = new Employee("4563435", "Fernando", "López", "Avenida 45", "416545",warehouseRepository.findWarehouse(2l));
            Employee empleado13 = new Employee("7896544", "Pedro", "Gómez", "Calle 67", "670567",warehouseRepository.findWarehouse(3l));
            Employee empleado14 = new Employee("1051141", "Laura", "Bravo", "Avenida 829", "898539",warehouseRepository.findWarehouse(4l));
            Employee empleado15 = new Employee("1241111", "Vanesa", "Lukovic", "Calle 170", "135010",warehouseRepository.findWarehouse(5l));


            this.create(empleado1);
            this.create(empleado2);
            this.create(empleado3);
            this.create(empleado4);
            this.create(empleado5);    
            this.create(empleado6);
            this.create(empleado7);
            this.create(empleado8);
            this.create(empleado9);
            this.create(empleado10);  
            this.create(empleado11);
            this.create(empleado12);
            this.create(empleado13);
            this.create(empleado14);
            this.create(empleado15);  


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
                    throw new NonexistentEntityException("The employee with id " + id + " no longer exists.", enfe);
                }
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
