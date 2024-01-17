//package org.example.repository;
//
//import org.example.model.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PedidoRepository {
//    private List<Order> orders;
//    private List<OrderLine> orderLines;
//    private SectorRepository sectorRepository;
//    private EmpleadoRepository empleadoRepository;
//    public PedidoRepository() {
//        orders = new ArrayList<>();
//        this.sectorRepository = new SectorRepository();
//        this.empleadoRepository = new EmpleadoRepository();
//    }
//
//    public void crearPedido(Order order) {
//        orders.add(order);
//    }
//
//    public Order buscarPedidoPorNumero(String numeroDePedido) {
//        for (Order order : orders) {
//            if (order.getOrderNumber().equals(numeroDePedido)) {
//                return order;
//            }
//        }
//        return null;
//    }
//    public void crearLineaPedido(Order order, OrderLine orderLine){
//        order.getOrderLines().add(orderLine);
//    }
//    public List<Order> obtenerTodosLosPedidos() {
//        return orders;
//    }
//    public void procesarPedido(String numero, String cuitEmpleado){
//        Order orderEncontrado = buscarPedidoPorNumero(numero);
//        if (orderEncontrado !=null){
//            orderEncontrado.setEmployee(empleadoRepository.findOne(cuitEmpleado));
//            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(1).getDescription());
//        }
//
//    }
//
//
//    public void completarPedido(String numero){
//        Order orderEncontrado = buscarPedidoPorNumero(numero);
//        if (orderEncontrado !=null){
//            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(2).getDescription());
//        }
//    }
//
//    public void enviarADespacho(String numero){
//        Order orderEncontrado = buscarPedidoPorNumero(numero);
//        if (orderEncontrado !=null){
//            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(3).getDescription());
//        }
//    }
//
//public void despacharPedido(String numero) {
//    Order orderEncontrado = buscarPedidoPorNumero(numero);
//    if (orderEncontrado != null) {
//        orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseOrig().getSectors().get(4).getDescription());
//
//        if (orderEncontrado.getDespatchNote() == null) {
//            // Generar el remito y agregarlo al pedido
//            LocalDate fechaEmision = LocalDate.now();
//            Carrier carrier = orderEncontrado.getCarrier();
//            Employee employeeEmisor = orderEncontrado.getEmployee();
//            Employee employeeReceptor = null; // El receptor se establecerá cuando se entregue el pedido
//            DespatchNote despatchNote = new DespatchNote(fechaEmision, carrier, employeeEmisor, employeeReceptor);
//            orderEncontrado.setDespatchNote(despatchNote);
//        }
//
//        if (orderEncontrado.getTracking() == null) {
//            Tracking tracking = new Tracking(orderEncontrado);
//
//            // Obtener la latitud y longitud del depósito de origen
//            Warehouse depositOrigen = orderEncontrado.getWarehouseOrig();
//            double latitud = depositOrigen.getPosition().getLatitude();
//            double longitud = depositOrigen.getPosition().getLongitude();
//
//            tracking.setLatitude(latitud);
//            tracking.setLongitude(longitud);
//            tracking.setTrackingNumber(tracking.generarNumeroRastreo());
//
//            orderEncontrado.setTracking(tracking);
//        }
//    }
//}
//
//    public void enviarAEntrega(String numero, String cuitEmpleadoReceptor) {
//        Order orderEncontrado = buscarPedidoPorNumero(numero);
//        if (orderEncontrado != null) {
//            orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseDest().getSectors().get(5).getDescription());
//
//            if (orderEncontrado.getTracking() != null) {
//                // Obtener la latitud y longitud del depósito de destino  para e lseguimiento
//                Warehouse depositDestino = orderEncontrado.getWarehouseDest();
//                double latitud = depositDestino.getPosition().getLatitude();
//                double longitud = depositDestino.getPosition().getLongitude();
//
//                // Actualizamos la latitud y longitud en el seguimiento
//                orderEncontrado.getTracking().setLatitude(latitud);
//                orderEncontrado.getTracking().setLongitude(longitud);
//                orderEncontrado.setOnTransit(false);
//            }
//            DespatchNote despatchNote = orderEncontrado.getDespatchNote();
//
//            if (despatchNote != null) {
//                // Buscar el empleado receptor por su CUIT
//                Employee employeeReceptor = empleadoRepository.findOne(cuitEmpleadoReceptor);
//
//                if (employeeReceptor != null) {
//                    // Asignar el empleado receptor al remito
////                    despatchNote.setEmployeeReceiver(employeeReceptor);
//                }
//            }
//        }
//    }
//
//  public void entregarPedido(String numero, List<Integer> calificacionesProveedor) {
//      Order orderEncontrado = buscarPedidoPorNumero(numero);
//      if (orderEncontrado != null) {
//          orderEncontrado.setOrderStatus(orderEncontrado.getWarehouseDest().getSectors().get(6).getDescription());
//          List<OrderLine> lineasPedido = orderEncontrado.getOrderLines();
//          if (lineasPedido.size() != calificacionesProveedor.size()) {
//              System.out.println("Error: La cantidad de calificaciones no coincide con la cantidad de proveedores.");
//              return;
//          } else {
//              orderEncontrado.setOrderFinish(LocalDate.now());
//          }
//
//          // Establecemos la calificación del proveedor para cada línea de pedido
//          for (int i = 0; i < lineasPedido.size(); i++) {
//              OrderLine orderLine = lineasPedido.get(i);
//              orderLine.setSupplierRating(calificacionesProveedor.get(i));
//          }
//      }
//
//
//  }
//
//    public void transitarPedido(String numero){
//        Order order = buscarPedidoPorNumero(numero);
//        if (order !=null){
//            order.setOnTransit(true);
//            order.setOrderStatus("En transito");
//        }
//    }
//
//    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
//        int cantidadPedidos = 0;
//        for (Order order : orders) {
//            if (order.getWarehouseOrig().getCode().equals(codigoSucursal)) {
//                cantidadPedidos++;
//            }
//        }
//        return cantidadPedidos;
//    }
////COMENTARIO EN PEDIDOREPOSITORY
//public int contarPedidosEnEstadoPendiente() {
//    int contador = 0;
//    for (Order order : orders) {
//        if (order.getOrderStatus().equals("Pendiente")) {
//            contador++;
//        }
//    }
//    return contador;
//}
//
//
//}
