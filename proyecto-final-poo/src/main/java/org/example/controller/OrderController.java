package org.example.controller;

import java.util.ArrayList;
import org.example.model.OrderLine;
import org.example.model.Order;
import org.example.service.OrderService;

import java.util.List;
import javax.swing.JTable;
import org.example.model.Carrier;
import org.example.model.Customer;

public class OrderController {

    private final OrderService orderService;
    private CustomerController customerController;
    private CarrierController carrierController;

    public OrderController() {
        this.orderService = new OrderService();
        this.customerController = new CustomerController();
        this.carrierController = new CarrierController();
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
        if (tblCustomers.getRowCount() > 0 && tblCustomers.getSelectedRow() != -1 &&
            tblCarriers.getRowCount() > 0 && tblCarriers.getSelectedRow() !=  1) {

            String idCliente = String.valueOf(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 3));
            String idTransportista = String.valueOf(tblCarriers.getValueAt(tblCarriers.getSelectedRow(), 2));
            cuits.add(idCliente);
            cuits.add(idTransportista);
        }   
        return cuits;
    }
}
