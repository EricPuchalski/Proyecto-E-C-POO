package org.example.repository;


import org.example.model.Customer;
import org.example.model.Order;


import java.util.List;

public class InformeRepository {
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;


    public InformeRepository(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        int cantidadPedidos = 0;
        List<Order> orders = pedidoRepository.obtenerTodosLosPedidos();
        for (Order order : orders) {
            if (order.getDepositOrigen().getCode().equals(codigoSucursal)) {
                cantidadPedidos++;
            }
        }
        return cantidadPedidos;
    }

    public int contarPedidosEnEstadoPendiente() {
        int contador = 0;
        List<Order> orders = pedidoRepository.obtenerTodosLosPedidos();
        for (Order order : orders) {
            if (order.getEstadoPedido().equals("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }

   public int obtenerHistorialDeUnCliente(String cuit){
       Customer customerBuscado = clienteRepository.findOne(cuit);
       int contador = 0;
       for (Order order : pedidoRepository.obtenerTodosLosPedidos()
       ) {
           if (order.getCustomer().getCuit().equals(customerBuscado.getCuit()) && order.getEstadoPedido().equals("Entrega")){
               contador++;
           }
       }
       return contador;
   }

    public void mostrarEstadoDePedidos(){
        for (Order order : pedidoRepository.obtenerTodosLosPedidos()
             ) {

        }
    }
}