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