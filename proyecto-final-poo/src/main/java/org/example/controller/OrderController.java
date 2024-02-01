package org.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import org.example.model.OrderLine;
import org.example.model.Order;
import org.example.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import org.example.model.Carrier;
import org.example.model.Customer;
import org.example.model.Warehouse;

public class OrderController implements CRUD<Order> {

    private final OrderService orderService;
    private CustomerController customerController;
    private CarrierController carrierController;
    private WarehouseController warehouseController;

    public OrderController() {
        this.orderService = new OrderService();
        this.customerController = new CustomerController();
        this.carrierController = new CarrierController();
        this.warehouseController = new WarehouseController();
    }

//    public void crearPedido(Order order){
//        orderService.crearPedido(order);
//    }
//
//    public void agregarLineaPedido(Order order, OrderLine orderLine){
//        orderService.agregarLineaDePedido(order, orderLine);
//    }
//
//    public void mostrarPedido(String nro){
//        for (Order pedidos: orderService.obtenerTodosLosPedidos()
//             ) {
//            if (pedidos.getOrderNumber().equals(nro)){
//                System.out.println(pedidos.toString());
//            }
//        }
//    }
//
//    public List<Order> mostrarTodosLosPedidos(){
//        return orderService.obtenerTodosLosPedidos();
//    }
//
//    public Order buscarPedidoPorNumero(String numero){
//        return orderService.buscarPedidoPorNumero(numero);
//    }
//
//    public void procesarPedido(String numero,String cuitEmpleado) {
//        orderService.procesarPedido(numero, cuitEmpleado);
//    }
//
//    public void completarPedido(String numero) {
//        orderService.completarPedido(numero);
//    }
//
//    public void enviarADespacho(String numero) {
//        orderService.enviarADespacho(numero);
//    }
//    public void despacharPedido(String numero) {
//        orderService.despacharPedido(numero);
//    }
//    public void enviarAEntrega(String numero, String cuitEmpleadoReceptor){
//        orderService.enviarAEntrega(numero, cuitEmpleadoReceptor);
//    }
//    public void entregarPedido(String numero, List<Integer> calificacionesProveedor) {
//        orderService.entregarPedido(numero, calificacionesProveedor);
//    }
//
//    public void transitarPedido(String numero){
//        orderService.transitarPedido(numero);
//    }
//    public int obtenerCantidadPedidoPorSucursal(String sucursal){
//        return orderService.obtenerCantidadPedidosPorSucursal(sucursal);
//    }
//    public int contarPedidosEnEstadoPendiente(){
//        return orderService.contarPedidosEnEstadoPendiente();
//    }
    public List<String> returnCuitsCustomerCarrier(JTable tblCustomers, JTable tblCarriers) {
        List<String> cuits = new ArrayList<>();
        if (tblCustomers.getRowCount() > 0 && tblCustomers.getSelectedRow() != -1
                && tblCarriers.getRowCount() > 0 && tblCarriers.getSelectedRow() != -1) {

            String idCliente = String.valueOf(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 3));
            String idTransportista = String.valueOf(tblCarriers.getValueAt(tblCarriers.getSelectedRow(), 2));
            cuits.add(idCliente);
            cuits.add(idTransportista);
        }
        return cuits;
    }

    public void createOrder(Order order, Warehouse warehouseOrig, Warehouse warehouseDest, String cuitCustomer, String cuitCarrier) {
        Customer orderCustomer = customerController.findOne(cuitCustomer);
        Carrier orderCarrier = carrierController.findOne(cuitCarrier);
        order.setWarehouseOrig(warehouseOrig);
        order.setWarehouseDest(warehouseDest);
        order.setCustomer(orderCustomer);
        order.setCarrier(orderCarrier);
        order.setOrderStart(LocalDate.now());
        order.setOrderStatus(order.getWarehouseOrig().getSectors().get(0).getDescription());

        this.create(order);
        System.out.println(orderCustomer.getName());
    }

    public Order findOneByOrderNumber(String orderNumber) {
        return orderService.findOne(orderNumber);
    }

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public void upDate(Order t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Order t) {
        orderService.save(t);
    }

    @Override
    public Order findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public void processOrder(String orderNumber, String cuitEmpleado) {
        orderService.processOrder(orderNumber, cuitEmpleado);
    }

    public void completeOrder(String orderNumber) {
        orderService.completeOrder(orderNumber);
    }

    public void sendOrderToDispatch(String orderNumber) {
        orderService.sendOrderToDispatch(orderNumber);
    }

    public void dispatchOrder(String orderNumber) {
        orderService.dispatchOrder(orderNumber);
    }

    public void orderTransit(String orderNumber) {
        orderService.orderTransit(orderNumber);
    }

    public void sendToDelivery(String orderNumber, String cuitEmployeeReceiv) {
        orderService.sendToDelivery(orderNumber, cuitEmployeeReceiv);
    }

    public List<Order> findAllByCustomer(Long idCustomer) {
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getCustomer().getId().equals(idCustomer)) {
                orders.add(order);
            }
        }
        return orders;
    }
        public List<Order> findAllByWarehouseOrig(Long idWarehouse) {
        List<Order> orders = new ArrayList();
        for (Order order : this.findAll()) {
            if (order.getWarehouseOrig().getId().equals(idWarehouse)) {
                orders.add(order);
            }
        }
        return orders;
    }
}
