package org.example.repository;

import org.example.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Order> orders;
    private List<OrderLine> orderLines;
    private SectorRepository sectorRepository;
    private EmpleadoRepository empleadoRepository;
    public PedidoRepository() {
        orders = new ArrayList<>();
        this.sectorRepository = new SectorRepository();
        this.empleadoRepository = new EmpleadoRepository();
    }

    public void crearPedido(Order order) {
        orders.add(order);
    }

    public Order buscarPedidoPorNumero(String numeroDePedido) {
        for (Order order : orders) {
            if (order.getNumeroPedido().equals(numeroDePedido)) {
                return order;
            }
        }
        return null;
    }
    public void crearLineaPedido(Order order, OrderLine orderLine){
        order.getLineasPedidos().add(orderLine);
    }
    public List<Order> obtenerTodosLosPedidos() {
        return orders;
    }
    public void procesarPedido(String numero, String cuitEmpleado){
        Order orderEncontrado = buscarPedidoPorNumero(numero);
        if (orderEncontrado !=null){
            orderEncontrado.setEmployee(empleadoRepository.findOne(cuitEmpleado));
            orderEncontrado.setEstadoPedido(orderEncontrado.getDepositOrigen().getSectors().get(1).getDescription());
        }

    }


    public void completarPedido(String numero){
        Order orderEncontrado = buscarPedidoPorNumero(numero);
        if (orderEncontrado !=null){
            orderEncontrado.setEstadoPedido(orderEncontrado.getDepositOrigen().getSectors().get(2).getDescription());
        }
    }

    public void enviarADespacho(String numero){
        Order orderEncontrado = buscarPedidoPorNumero(numero);
        if (orderEncontrado !=null){
            orderEncontrado.setEstadoPedido(orderEncontrado.getDepositOrigen().getSectors().get(3).getDescription());
        }
    }

public void despacharPedido(String numero) {
    Order orderEncontrado = buscarPedidoPorNumero(numero);
    if (orderEncontrado != null) {
        orderEncontrado.setEstadoPedido(orderEncontrado.getDepositOrigen().getSectors().get(4).getDescription());

        if (orderEncontrado.getDespatchNote() == null) {
            // Generar el remito y agregarlo al pedido
            LocalDate fechaEmision = LocalDate.now();
            Carrier carrier = orderEncontrado.getCarrier();
            Employee employeeEmisor = orderEncontrado.getEmployee();
            Employee employeeReceptor = null; // El receptor se establecerá cuando se entregue el pedido
            DespatchNote despatchNote = new DespatchNote(fechaEmision, carrier, employeeEmisor, employeeReceptor);
            orderEncontrado.setDespatchNote(despatchNote);
        }

        if (orderEncontrado.getTracking() == null) {
            Tracking tracking = new Tracking(orderEncontrado);

            // Obtener la latitud y longitud del depósito de origen
            Deposit depositOrigen = orderEncontrado.getDepositOrigen();
            double latitud = depositOrigen.getPosition().getLatitude();
            double longitud = depositOrigen.getPosition().getLongitude();

            tracking.setLatitude(latitud);
            tracking.setLongitude(longitud);
            tracking.setTrackingNumber(tracking.generarNumeroRastreo());

            orderEncontrado.setTracking(tracking);
        }
    }
}

    public void enviarAEntrega(String numero, String cuitEmpleadoReceptor) {
        Order orderEncontrado = buscarPedidoPorNumero(numero);
        if (orderEncontrado != null) {
            orderEncontrado.setEstadoPedido(orderEncontrado.getDepositDestino().getSectors().get(5).getDescription());

            if (orderEncontrado.getTracking() != null) {
                // Obtener la latitud y longitud del depósito de destino  para e lseguimiento
                Deposit depositDestino = orderEncontrado.getDepositDestino();
                double latitud = depositDestino.getPosition().getLatitude();
                double longitud = depositDestino.getPosition().getLongitude();

                // Actualizamos la latitud y longitud en el seguimiento
                orderEncontrado.getTracking().setLatitude(latitud);
                orderEncontrado.getTracking().setLongitude(longitud);
                orderEncontrado.setEnTransito(false);
            }
            DespatchNote despatchNote = orderEncontrado.getDespatchNote();

            if (despatchNote != null) {
                // Buscar el empleado receptor por su CUIT
                Employee employeeReceptor = empleadoRepository.findOne(cuitEmpleadoReceptor);

                if (employeeReceptor != null) {
                    // Asignar el empleado receptor al remito
                    despatchNote.setEmployeeReceiver(employeeReceptor);
                }
            }
        }
    }

  public void entregarPedido(String numero, List<Integer> calificacionesProveedor) {
      Order orderEncontrado = buscarPedidoPorNumero(numero);
      if (orderEncontrado != null) {
          orderEncontrado.setEstadoPedido(orderEncontrado.getDepositDestino().getSectors().get(6).getDescription());
          List<OrderLine> lineasPedido = orderEncontrado.getLineasPedidos();
          if (lineasPedido.size() != calificacionesProveedor.size()) {
              System.out.println("Error: La cantidad de calificaciones no coincide con la cantidad de proveedores.");
              return;
          } else {
              orderEncontrado.setFinPedido(LocalDate.now());
          }

          // Establecemos la calificación del proveedor para cada línea de pedido
          for (int i = 0; i < lineasPedido.size(); i++) {
              OrderLine orderLine = lineasPedido.get(i);
              orderLine.setSupplierRating(calificacionesProveedor.get(i));
          }
      }


  }

    public void transitarPedido(String numero){
        Order order = buscarPedidoPorNumero(numero);
        if (order !=null){
            order.setEnTransito(true);
            order.setEstadoPedido("En transito");
        }
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        int cantidadPedidos = 0;
        for (Order order : orders) {
            if (order.getDepositOrigen().getCode().equals(codigoSucursal)) {
                cantidadPedidos++;
            }
        }
        return cantidadPedidos;
    }
//COMENTARIO EN PEDIDOREPOSITORY
public int contarPedidosEnEstadoPendiente() {
    int contador = 0;
    for (Order order : orders) {
        if (order.getEstadoPedido().equals("Pendiente")) {
            contador++;
        }
    }
    return contador;
}


}
