package org.example.service;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import org.example.dao.OrderRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Order;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.example.model.Warehouse;

public class OrderService implements CRUD<Order> {

    private OrderRepository orderRepository = new OrderRepository();

    public OrderService() {
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        // Llamamos al método save del repositorio y retornamos su resultado, no hace nada jaja
        return orderRepository.save(order);
    }

    public Order createOrder(Order order, Warehouse warehouseOrig, Warehouse warehouseDest, String cuitCustomer, String cuitCarrier) {

        Order orderExist = findOne(order.getOrderNumber());
        if (orderExist == null) {
            return orderRepository.createOrder(order, warehouseOrig, warehouseDest, cuitCustomer, cuitCarrier);
        }
        return null;
    }


    @Override
    public Order findOne(String orderNumber) {
        Order orderExist = orderRepository.findOrderByOrderNumber(orderNumber);
        for (Order order : orderRepository.findOrderEntities()) {
            if (orderExist != null) {
                if (orderNumber.equals(order.getOrderNumber())) {
                    return order;
                }
            }

        }
        return null;
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findOrderEntities();
    }

    @Override
    public Order upDate(Order order) throws Exception {
        if (orderRepository.findOrder(order.getId()) != null) {
            return orderRepository.edit(order);
        }
        return null;
    }

    @Override
    public void delete(String orderNumber) throws NonexistentEntityException {
        Order deleteOrder = orderRepository.findOrderByOrderNumber(orderNumber);
// Order deleteOrder = findOne(orderNumber);
        if (deleteOrder != null) {
            orderRepository.destroy(deleteOrder.getId());
        }
    }

    public Order processOrder(String orderNumber, String cuitEmpleado) {
        Order order = orderRepository.findOrderByOrderNumber(orderNumber);
        if (order != null && order.getWarehouseOrig() != null && order.getOrderStatus().equals("Pendiente")) {
            return orderRepository.processOrder(orderNumber, cuitEmpleado);
        } else {
            return null;

        }
    }

    public Order completeOrder(String orderNumber) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getOrderStatus().equals("En Proceso")) {
            return orderRepository.completeOrder(orderNumber);
        } else {
            return null;
        }
    }//nuevo

    public Order sendOrderToDispatch(String orderNumber) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getOrderStatus().equals("Completo")) {
            return orderRepository.sendOrderToDispatch(orderNumber);
        } else {
            return null;
        }
    }//nuevo

    public Order dispatchOrder(String orderNumber) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getOrderStatus().equals("Esperando Despacho")) {
            return orderRepository.dispatchOrder(orderNumber);
        } else {
            return null;
        }
    }

    public Order orderTransit(String orderNumber) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getOrderStatus().equals("Despacho")) {
            return orderRepository.orderTransit(orderNumber);
        } else {
            return null;
        }
    }//nuevo

    public Order sendToDelivery(String orderNumber, String cuitEmployeeReceiv) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getOrderStatus().equals("En transito")) {
            try {
                return orderRepository.sendToDelivery(orderNumber, cuitEmployeeReceiv);
            } catch (Exception ex) {
                Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public Order deliverOrder(String orderNumber) {
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getWarehouseDest() != null && orderFound.getOrderStatus().equals("Esperando Entrega")) {
            return orderRepository.deliverOrder(orderNumber);
        } else {
            return null;
        }
    }//NUEVO A VER SI FUNKADOLizaaaaa

    public List<Order> findAllOrdersByCustomers(Long idCustomer) {
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getCustomer().getId().equals(idCustomer)) {
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> findAllOrdersByWarehouseOrig(Long idWarehouse) {
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getWarehouseOrig().getId().equals(idWarehouse)) {
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> findAllOrdersByNumber(String orderNumber) {
        if (orderNumber == null || orderNumber.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }

        String lowercaseNumber = orderNumber.toLowerCase(); // Convertir el nombre de búsqueda a minúsculas

        List<Order> ordersFound = this.findAll()
                .stream()
                .filter(tr -> tr.getOrderNumber().toLowerCase().startsWith(lowercaseNumber))
                .collect(Collectors.toList());
        return ordersFound;
    }

    public List<Order> findAllUndeliveredOrders() {
        return orderRepository.findOrderEntities()
                .stream()
                .filter(order -> !order.getOrderStatus().equals("Entrega"))
                .collect(Collectors.toList());
    }


}
/*
 @Override ASI ORIGINALMENTE ESTABA
    public Order findOne(String orderNumber) {
        Order orderExist = orderRepository.findOrderByOrderNumber(orderNumber);
        for (Order order : orderRepository.findOrderEntities()) {
            if (orderExist != null) {
                if (orderNumber.equals(order.getOrderNumber())) {
                    return order;
                }
            }

        }
        return null;
    }

 */


//package org.example.service;
//
//import org.example.model.OrderLine;
//import org.example.model.Order;
//import org.example.repository.EmpleadoRepository;
//import org.example.repository.PedidoRepository;
//import org.example.repository.SectorRepository;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderService {
//    private SectorRepository sectorRepository;
////    private TransportistaRepository transportistaRepository;
//    private PedidoRepository pedidoRepository;
//
//    private EmpleadoRepository empleadoRepository;
//
//    private Order order;
//
//    public OrderService(PedidoRepository pedidoRepository) {
//        this.sectorRepository = new SectorRepository();
////        this.transportistaRepository = new TransportistaRepository();
//        this.pedidoRepository=pedidoRepository;
//        this.empleadoRepository = new EmpleadoRepository();
//    }
//
//    public void crearPedido(Order order) {
//            pedidoRepository.crearPedido(order);
//    }
//
//    public List<Order> obtenerTodosLosPedidos() {
//        List<Order> pedidosEncontrados = new ArrayList<>();
//        for (Order order : pedidoRepository.obtenerTodosLosPedidos()
//             ) {
//            pedidosEncontrados.add(order);
//        }
//        return pedidosEncontrados;
//    }
//
//    public void agregarLineaDePedido(Order order, OrderLine orderLine) {
//        pedidoRepository.crearLineaPedido(order, orderLine);
//    }
//
//
//    public Order buscarPedidoPorNumero(String numero) {
//        Order order = pedidoRepository.buscarPedidoPorNumero(numero);
//        if (order == null) {
//            return null;
//        } else {
//            return order;
//        }
//    }
//
//    public void procesarPedido(String numero, String cuitEmpleado){
//            pedidoRepository.procesarPedido(numero, cuitEmpleado);
//    }
//
//    public void completarPedido(String numero){
//        pedidoRepository.completarPedido(numero);
//    }
//
//    public void enviarADespacho(String numero) {
//        Order orderEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
//        if (orderEncontrado != null) {
//            pedidoRepository.enviarADespacho(numero);
//        }
//    }
//
//    public void despacharPedido(String numero) {
//        Order orderEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
//        if (orderEncontrado != null) {
//            pedidoRepository.despacharPedido(numero);
//
//        }
//    }
//
//    public void enviarAEntrega(String numero, String cuitEmpleadoReceptor) {
//        Order orderEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
//        if (orderEncontrado != null) {
//            pedidoRepository.enviarAEntrega(numero, cuitEmpleadoReceptor);
//        }
//    }
//
//    public void entregarPedido(String numero, List<Integer> calificacionesProveedor) {
//        Order orderEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
//        if (orderEncontrado != null) {
//            pedidoRepository.entregarPedido(numero, calificacionesProveedor);
//        }
//    }
//
//
//    public void transitarPedido(String numero){
//        pedidoRepository.transitarPedido(numero);
//    }
//
//    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
//        return pedidoRepository.obtenerCantidadPedidosPorSucursal(codigoSucursal);
//    }
//    public int contarPedidosEnEstadoPendiente(){
//        return pedidoRepository.contarPedidosEnEstadoPendiente();
//    }
//
//
//}
//
//

/* CAMBIADO POR EL NUEVO
   public List<Order> findAllOrdersByWarehouseOrig(Long idWarehouse) {
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getWarehouseOrig().getId().equals(idWarehouse)) {
                orders.add(order);
            }
        }
        return orders;
    }
 */
