/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import org.example.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Carrier;
import org.example.model.Customer;
import org.example.model.DespatchNote;
import org.example.model.Employee;
import org.example.model.Order;
import org.example.model.OrderLine;
import org.example.model.Tracking;
import org.example.model.Warehouse;
import org.example.util.Conexion;
import org.example.util.GenerateOrderNumber;

/**
 *
 * @author ericp
 */
public class OrderRepository implements Serializable {

    private CustomerRepository customerRepository;
    private WarehouseRepository warehouseRepository;
    private CarrierRepository carrierRepository;
    private EmployeeRepository employeeRepository;
    private DespatchNoteRepository despatchNoteRepository;
    private OrderLineRepository orderLineRepository;
    private TrackingRepository trackingRepository;
    private OrderRepository orderRepository;

    public OrderRepository() {
        this.emf = Conexion.getEmf();
        this.customerRepository = new CustomerRepository();
        this.warehouseRepository = new WarehouseRepository();
        this.carrierRepository = new CarrierRepository();
        this.employeeRepository = new EmployeeRepository();
        this.despatchNoteRepository = new DespatchNoteRepository();
        this.orderLineRepository = new OrderLineRepository();
        this.trackingRepository = new TrackingRepository();
    }

    public OrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public boolean informOrderPosition(String orderNumber, double latitud, double longitud) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Order order = findOrderByOrderNumber(orderNumber);
            order.getTracking().setLatitude(latitud);
            order.getTracking().setLongitude(longitud);
            trackingRepository.edit(order.getTracking());
            em.merge(order); // Actualiza la entidad en la base de datos
            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    public Order processOrder(String orderNumber, String cuitEmpleado) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Order order = findOrderByOrderNumber(orderNumber);
            order.setEmployee(employeeRepository.findEmployeeByCuit(cuitEmpleado));
            order.setOrderStatus(order.getWarehouseOrig().getSectors().get(1).getDescription());
            em.merge(order); // Actualiza la entidad en la base de datos
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
        return null;
    }

    public Order completeOrder(String orderNumber) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Order orderFound = findOrderByOrderNumber(orderNumber);
            orderFound.setOrderStatus(orderFound.getWarehouseOrig().getSectors().get(2).getDescription());
            em.merge(orderFound); // Actualiza la entidad en la base de datos
            transaction.commit();
            return orderFound;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
        return null;
    }

    public Order sendOrderToDispatch(String orderNumber) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Order orderEncontrado = findOrderByOrderNumber(orderNumber);
            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(3).getDescription());
            em.merge(orderEncontrado); // Actualiza la entidad en la base de datos
            transaction.commit();
            return orderEncontrado;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
        return null;
    }

    public Order dispatchOrder(String orderNumber) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Order orderFound = findOrderByOrderNumber(orderNumber);

            orderFound.setOrderStatus(orderFound.getWarehouseOrig().getSectors().get(4).getDescription());

            // Generar el remito y agregarlo al pedido
            LocalDate fechaEmision = LocalDate.now();
            Carrier carrier = orderFound.getCarrier();
            Employee employeeEmisor = orderFound.getEmployee();
            Employee employeeReceptor = null; // El receptor se establecerá cuando se entregue el pedido
            DespatchNote despatchNote = new DespatchNote(fechaEmision, carrier, employeeEmisor, employeeReceptor);
            despatchNoteRepository.create(despatchNote);
            orderFound.setDespatchNote(despatchNote);

            Tracking tracking = new Tracking(orderFound);

            // Obtener la latitud y longitud del depósito de origen
            Warehouse depositOrigen = orderFound.getWarehouseOrig();
            double latitud = depositOrigen.getPosition().getLatitude();
            double longitud = depositOrigen.getPosition().getLongitude();

            tracking.setLatitude(latitud);
            tracking.setLongitude(longitud);
            tracking.setDateAndTime(LocalDate.now());
            tracking.setTrackingNumber(tracking.generarNumeroRastreo());

            orderFound.setTracking(tracking);

            em.merge(orderFound); // Actualiza la entidad en la base de datos

            transaction.commit();
            return orderFound;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
        return null;
    }

    public Order orderTransit(String orderNumber) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Order order = findOrderByOrderNumber(orderNumber);

            order.setOnTransit(true);
            order.setOrderStatus("En transito");
            this.edit(order);

            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public Order sendToDelivery(String orderNumber, String cuitEmployeeReceiv) throws Exception {

        Order orderFound = findOrderByOrderNumber(orderNumber);

        orderFound.setOrderStatus(orderFound.getWarehouseDest().getSectors().get(5).getDescription());
        // Obtener la latitud y longitud del depósito de destino para el seguimiento

        Warehouse depositDestino = orderFound.getWarehouseDest();
        double latitud = depositDestino.getPosition().getLatitude();
        double longitud = depositDestino.getPosition().getLongitude();

        // Actualizamos la latitud y longitud en el seguimiento
        orderFound.getTracking().setLatitude(latitud);
        orderFound.getTracking().setLongitude(longitud);

        trackingRepository.edit(orderFound.getTracking());
        orderFound.setOnTransit(false);
        this.edit(orderFound);

        DespatchNote despatchNote = despatchNoteRepository.findDespatchNote(orderFound.getDespatchNote().getId());

        // Buscar el empleado receptor por su CUIT
        Employee employeeReceptor = employeeRepository.findEmployeeByCuit(cuitEmployeeReceiv);

        if (employeeReceptor != null) {
            // Asignar el empleado receptor al remito
            despatchNote.setEmployeeReceiver(employeeReceptor);
            despatchNoteRepository.edit(despatchNote);

        }

        return orderFound;
    }

    public Order deliverOrder(String orderNumber) {
       EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();
        Order orderFound = findOrderByOrderNumber(orderNumber);

        // Actualizar el estado y la fecha de finalización de la orden
        orderFound.setOrderStatus(orderFound.getWarehouseDest().getSectors().get(6).getDescription());
        orderFound.setOrderFinish(LocalDate.now());

        // Actualizar la entidad en la base de datos
        em.merge(orderFound);

        transaction.commit();
        return orderFound;
    } catch (Exception e) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
        // Manejo de excepciones
    } finally {
        em.close();
    }
    return null;
    }//Nuevo a ver si fuUNKASOOOOOOO XDLOL

    public Order findOrderByOrderNumber(String orderNumber) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.orderNumber = :orderNumber", Order.class);
            query.setParameter("orderNumber", orderNumber);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public Order createOrder(Order order, Warehouse warehouseOrig, Warehouse warehouseDest, String cuitCustomer, String cuitCarrier) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GenerateOrderNumber generateOrderNumber = new GenerateOrderNumber();
            String randomOrderNumber = generateOrderNumber.generateRandomOrderNumber();
            order.setOrderNumber(randomOrderNumber);
            Customer orderCustomer = customerRepository.findCustomerEnabledByCuit(cuitCustomer);
            Carrier orderCarrier = carrierRepository.findCarrierEnabledByCuit(cuitCarrier);
            order.setWarehouseOrig(warehouseOrig);
            order.setWarehouseDest(warehouseDest);
            order.setCustomer(orderCustomer);
            order.setCarrier(orderCarrier);
            order.setOrderStart(LocalDate.now());
            order.setOrderStatus(order.getWarehouseOrig().getSectors().get(0).getDescription());

            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Order create(Order order) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GenerateOrderNumber generateOrderNumber = new GenerateOrderNumber();
            String randomOrderNumber = generateOrderNumber.generateRandomOrderNumber();
            order.setOrderNumber(randomOrderNumber);
            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Order edit(Order order) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Order persistentOrder = em.find(Order.class, order.getId());
            Tracking trackingOld = persistentOrder.getTracking();
            Tracking trackingNew = order.getTracking();
            if (trackingNew != null) {
                trackingNew = em.getReference(trackingNew.getClass(), trackingNew.getId());
                order.setTracking(trackingNew);
            }
            order = em.merge(order);
            if (trackingOld != null && !trackingOld.equals(trackingNew)) {
                trackingOld.setOrder(null);
                trackingOld = em.merge(trackingOld);
            }
            if (trackingNew != null && !trackingNew.equals(trackingOld)) {
                Order oldOrderOfTracking = trackingNew.getOrder();
                if (oldOrderOfTracking != null) {
                    oldOrderOfTracking.setTracking(null);
                    oldOrderOfTracking = em.merge(oldOrderOfTracking);

                }
                trackingNew.setOrder(order);
                trackingNew = em.merge(trackingNew);
            }

            em.getTransaction().commit();
            return order;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = order.getId();
                if (findOrder(id) == null) {
                    throw new NonexistentEntityException("The order with id " + id + " no longer exists.");
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
            Order order;
            try {
                order = em.getReference(Order.class, id);
                order.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The order with id " + id + " no longer exists.", enfe);
            }
            Tracking tracking = order.getTracking();
            if (tracking != null) {
                tracking.setOrder(null);
                tracking = em.merge(tracking);
            }
            em.remove(order);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> findOrderEntities() {
        return findOrderEntities(true, -1, -1);
    }

    public List<Order> findOrderEntities(int maxResults, int firstResult) {
        return findOrderEntities(false, maxResults, firstResult);
    }

    private List<Order> findOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Order.class));
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

    public Order findOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Order.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Order> rt = cq.from(Order.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }


    public Order save(Order order) {
        // Este método no hace nada, simplemente devuelve null jajaja
        return null;
    }
}
