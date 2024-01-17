//package org.example.controller;
//
//import org.example.model.OrderLine;
//import org.example.model.Order;
//import org.example.service.OrderService;
//
//import java.util.List;
//
//public class OrderController {
//
//    private final OrderService orderService;
//
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
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
//}
