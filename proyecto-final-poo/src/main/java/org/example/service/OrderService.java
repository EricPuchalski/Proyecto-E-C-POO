package org.example.service;

import org.example.dao.OrderRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements CRUD<Order> {
    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    @Override
    public void save(Order order) {
        orderRepository.create(order);
    }

    @Override
    public Order findOne(String orderNumber) {
        for (Order order : orderRepository.findOrderEntities()) {
            if (orderNumber.equals(order.getOrderNumber())) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findOrderEntities();
    }

    @Override
    public void upDate(Order order) throws Exception {
        if (orderRepository.findOrder(order.getId()) != null) {
            orderRepository.edit(order);
        }
    }

    @Override
    public void delete(String orderNumber) throws NonexistentEntityException {
        Order deleteOrder = findOne(orderNumber);
        if (deleteOrder != null) {
            orderRepository.destroy(deleteOrder.getId());
        }
    }
    public void processOrder(String orderNumber, String cuitEmpleado){
       Order order = orderRepository.findOrderByOrderNumber(orderNumber);
       if (order != null && order.getWarehouseOrig() != null && order.getWarehouseOrig().getSectors() != null) {
           orderRepository.processOrder(orderNumber, cuitEmpleado);
       } else {
           
       }
    }
    public void completeOrder(String orderNumber){
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);;
        if (orderFound != null && orderFound.getWarehouseOrig() != null && orderFound.getWarehouseOrig().getSectors() != null) {
            orderRepository.completeOrder(orderNumber);
        }

    }
    public void sendOrderToDispatch(String orderNumber){
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);;
        if (orderFound != null && orderFound.getWarehouseOrig() != null && orderFound.getWarehouseOrig().getSectors() != null) {
            orderRepository.sendOrderToDispatch(orderNumber);
        }
    }
    public void dispatchOrder(String orderNumber){
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getWarehouseOrig() != null && orderFound.getWarehouseOrig().getSectors() != null && orderFound.getDespatchNote() == null && orderFound.getTracking() == null) {
            orderRepository.dispatchOrder(orderNumber);
        }

    }
    public void orderTransit(String orderNumber){
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if(orderFound != null){
        orderRepository.orderTransit(orderNumber);
    }

    }
    public void sendToDelivery(String orderNumber, String cuitEmployeeReceiv){
        Order orderFound = orderRepository.findOrderByOrderNumber(orderNumber);
        if (orderFound != null && orderFound.getWarehouseDest() != null && orderFound.getWarehouseDest().getSectors() != null && orderFound.getTracking() != null && orderFound.getDespatchNote()!=null ) {
            orderRepository.sendToDelivery(orderNumber, cuitEmployeeReceiv);
        }
    }
    public List<Order> findAllOrdersByCustomers(Long idCustomer){
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getCustomer().getId().equals(idCustomer)) {
                orders.add(order);
            }
        }
        return orders;
    }
    public List<Order> findAllOrdersByWarehouseOrig(Long idWarehouse){
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
}
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
