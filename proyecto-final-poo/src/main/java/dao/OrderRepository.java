/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
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

    public void upload(){

        Order o1 = new Order("123", customerRepository.findCustomer(1l), warehouseRepository.findWarehouse(1l), warehouseRepository.findWarehouse(2l), carrierRepository.findCarrier(1l), warehouseRepository.findWarehouse(1l).getSectors().get(3).getDescription(), LocalDate.now());
        Order o2 = new Order("129", customerRepository.findCustomer(2l), warehouseRepository.findWarehouse(2l), warehouseRepository.findWarehouse(1l), carrierRepository.findCarrier(2l), warehouseRepository.findWarehouse(1l).getSectors().get(1).getDescription(), LocalDate.of(2023, 1, 2));
        Order o3 = new Order("143", customerRepository.findCustomer(3l), warehouseRepository.findWarehouse(3l), warehouseRepository.findWarehouse(5l), carrierRepository.findCarrier(3l), warehouseRepository.findWarehouse(1l).getSectors().get(2).getDescription(), LocalDate.of(2023, 3, 3));
        Order o4 = new Order("163", customerRepository.findCustomer(4l), warehouseRepository.findWarehouse(4l), warehouseRepository.findWarehouse(5l), carrierRepository.findCarrier(4l), warehouseRepository.findWarehouse(1l).getSectors().get(5).getDescription(), LocalDate.of(2023, 2, 4));
        Order o5 = new Order("113", customerRepository.findCustomer(5l), warehouseRepository.findWarehouse(5l), warehouseRepository.findWarehouse(2l), carrierRepository.findCarrier(1l), warehouseRepository.findWarehouse(1l).getSectors().get(4).getDescription(), LocalDate.of(2023, 5, 6));
        Order o6 = new Order("193", customerRepository.findCustomer(6l), warehouseRepository.findWarehouse(1l), warehouseRepository.findWarehouse(3l), carrierRepository.findCarrier(2l), warehouseRepository.findWarehouse(1l).getSectors().get(4).getDescription(), LocalDate.of(2023, 1, 1));
        Order o7 = new Order("183", customerRepository.findCustomer(2l), warehouseRepository.findWarehouse(2l), warehouseRepository.findWarehouse(1l), carrierRepository.findCarrier(3l), warehouseRepository.findWarehouse(1l).getSectors().get(1).getDescription(), LocalDate.of(2023, 1, 3));
        Order o8 = new Order("132", customerRepository.findCustomer(2l), warehouseRepository.findWarehouse(3l), warehouseRepository.findWarehouse(2l), carrierRepository.findCarrier(4l), warehouseRepository.findWarehouse(1l).getSectors().get(2).getDescription(), LocalDate.of(2023, 1, 1));
        Order o9 = new Order("126", customerRepository.findCustomer(1l), warehouseRepository.findWarehouse(3l), warehouseRepository.findWarehouse(2l), carrierRepository.findCarrier(4l), warehouseRepository.findWarehouse(1l).getSectors().get(1).getDescription(), LocalDate.of(2023, 1, 3));
        
        this.create(o1);
        this.create(o2);
        this.create(o3);
        this.create(o4);
        this.create(o5);
        this.create(o6);
        this.create(o7);
        this.create(o8);
        this.create(o9);
        
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void processOrder(String orderNumber, String cuitEmpleado) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Order order = findOrderByOrderNumber(orderNumber);
            order.setEmployee(employeeRepository.findEmployeeByCuit(cuitEmpleado));
            order.setOrderStatus(order.getWarehouseOrig().getSectors().get(1).getDescription());
            em.merge(order); // Actualiza la entidad en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void completeOrder(String orderNumber) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Order orderFound = findOrderByOrderNumber(orderNumber);
            orderFound.setOrderStatus(orderFound.getWarehouseOrig().getSectors().get(2).getDescription());
            em.merge(orderFound); // Actualiza la entidad en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
    }
        public void sendOrderToDispatch(String orderNumber) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Order orderEncontrado = findOrderByOrderNumber(orderNumber);
            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(3).getDescription());
            em.merge(orderEncontrado); // Actualiza la entidad en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
    }
        
    public void dispatchOrder(String orderNumber) {
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
       } catch (Exception e) {
           if (transaction != null && transaction.isActive()) {
               transaction.rollback();
           }
           // Manejo de excepciones según sea necesario
       } finally {
           em.close();
       }
   }
public void orderTransit(String orderNumber) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();

        Order order = findOrderByOrderNumber(orderNumber);

        order.setOnTransit(true);
        order.setOrderStatus("En transito");
        this.edit(order);


        transaction.commit();
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
}

    public void sendToDelivery(String orderNumber, String cuitEmployeeReceiv) {
    EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();
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
            

            DespatchNote despatchNote = despatchNoteRepository.findDespatchNote(orderFound.getDespatchNote().getId()) ;

                // Buscar el empleado receptor por su CUIT
                Employee employeeReceptor = employeeRepository.findEmployeeByCuit(cuitEmployeeReceiv);
               
                if (employeeReceptor != null) {
                    // Asignar el empleado receptor al remito
                    despatchNote.setEmployeeReceiver(employeeReceptor);
                    despatchNoteRepository.edit(despatchNote);

                
            }


        transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
    }

    public void deliverOrder(String orderNumber, List<Integer> supplierRatings) {
    EntityManager em = getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    try {
        transaction.begin();
        Order orderFound = findOrderByOrderNumber(orderNumber);

        if (orderFound != null && orderFound.getWarehouseDest() != null && orderFound.getWarehouseDest().getSectors() != null) {
            orderFound.setOrderStatus(orderFound.getWarehouseDest().getSectors().get(6).getDescription());
            List<OrderLine> orderLines = orderFound.getOrderLines();

            if (orderLines.size() != supplierRatings.size()) {
                System.out.println("Error: La cantidad de calificaciones no coincide con la cantidad de proveedores.");
                return;
            } else {
                orderFound.setOrderFinish(LocalDate.now());
            }

            // Establecemos la calificación del proveedor para cada línea de pedido
            for (int i = 0; i < orderLines.size(); i++) {
                OrderLine orderLine = orderLines.get(i);
                orderLine.setSupplierRating(supplierRatings.get(i));
                orderLineRepository.edit(orderLine);
            }

            em.merge(orderFound); // Actualiza la entidad en la base de datos
        } else {
            // Manejo de nulls o registro de errores según sea necesario
        }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Manejo de excepciones según sea necesario
        } finally {
            em.close();
        }
    }

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

    public void create(Order order) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GenerateOrderNumber generateOrderNumber = new GenerateOrderNumber();
            String randomOrderNumber = generateOrderNumber.generateRandomOrderNumber();
            order.setOrderNumber(randomOrderNumber);
            em.persist(order);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Order order) throws NonexistentEntityException, Exception {
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
    
}
