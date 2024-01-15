package org.example.view;

import org.example.controller.*;
import org.example.model.*;
import org.example.repository.*;
import org.example.service.*;
import org.example.util.CalcDistance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPedido {
    private boolean regresarMenuPrincipal;//**
    OrderController orderController;
     DepositController depositController;
     SectorRepository sectorRepository;
     CarrierController carrierController;
     ProductController productController;

     EmployeeController employeeController;
     EmpleadoRepository empleadoRepository;
     EmployeeService employeeService;



    CustomerController customerController;


    public MenuPedido(OrderController orderController, DepositController depositController, SectorRepository sectorRepository, CarrierController carrierController, ProductController productController, CustomerController customerController, EmpleadoRepository empleadoRepository, EmployeeService employeeService, EmployeeController employeeController) {
        this.orderController = orderController;
        this.depositController = depositController;
        this.sectorRepository = sectorRepository;
        this.carrierController = carrierController;
        this.productController = productController;
        this.customerController = customerController;
        this.empleadoRepository = empleadoRepository;
        this.employeeService = new EmployeeService(empleadoRepository);
        this.employeeController = employeeController;

    }

    public void mostrarMenuPedido() {
        int seguirAgregandoProductos;

        Scanner scanner = new Scanner(System.in);

            do {//**
                System.out.println("Por favor ingrese la opción que desee: ");
                System.out.println("1. Crear Pedido");
                System.out.println("2. Procesar pedido");
                System.out.println("3. Completar pedido");
                System.out.println("4. Enviar a despacho");
                System.out.println("5. Despachar pedido");
                System.out.println("6. Transitar pedido");
                System.out.println("7. Enviar a sucursal destino");
                System.out.println("8. Entregar pedido");
                System.out.println("9. Calcular distancia del pedido");
                System.out.println("10.Ver todos los pedidos ");
                System.out.println("11. Salir del menu pedido");
                System.out.println("----------------------------");

                int opcion = scanner.nextInt();
                scanner.nextLine();


                switch (opcion) {
                    case 1:
                        System.out.println("Por favor ingrese el numero del pedido");
                        String numeroPedido = scanner.nextLine();
                        Order orderExiste = orderController.buscarPedidoPorNumero(numeroPedido);
                        if(orderExiste !=null){
                            System.out.println(" El pedido ya existe no se puede crear un pedido con el mismo numero ");
                            break;
                        }


                        System.out.println("Por favor seleccione el cliente del pedido");
                        for (Customer cl : customerController.findAll()
                        ) {
                            System.out.println(cl.toString());
                        }

                        String cuitCliente = scanner.next();
                        Customer customer = customerController.findOne(cuitCliente);

                        System.out.println("Por favor seleccione el deposito de origen");
                        System.out.println("----------------------------");
                        for (Deposit dp : depositController.findAll()
                        ) {
                            System.out.println(dp.toString());
                        }

                        System.out.println("----------------------------");
                        scanner.nextLine();
                        String codigoDeposito = scanner.nextLine();
                        Deposit depositOrigen = depositController.findOne(codigoDeposito);

                        System.out.println("Por favor seleccione el deposito de destino");
                        System.out.println("----------------------------");
                        for (Deposit dp : depositController.findAll()
                        ) {
                            System.out.println(dp.toString());
                        }
                        System.out.println("----------------------------");
                        String codigoDepositoDestino = scanner.nextLine();
                        Deposit depositDestino = depositController.findOne(codigoDepositoDestino);

                        System.out.println("Por favor seleccione el transportista");
                        for (Carrier tr : carrierController.findAll()
                        ) {
                            System.out.println(tr.toString());
                        }
                        String cuitTransportista = scanner.nextLine();

                        Carrier carrier = carrierController.findOne(cuitTransportista);

                        if ((carrier != null && customer != null && depositOrigen != null && depositDestino != null)) {
                            String estadoPedido = depositOrigen.getSectors().get(0).getDescription();
                            Tracking tracking = new Tracking(LocalDate.of(2023, 10, 20), depositOrigen.getPosition().getLatitude(), depositOrigen.getPosition().getLongitude());
                            Order order = new Order(numeroPedido, customer, depositOrigen, depositDestino, carrier, estadoPedido, tracking);
                            order.setInicioPedido(LocalDate.now());

                            do {
                                System.out.println("Por favor ingrese el producto");
                                for (Product pr : productController.findAll()
                                ) {
                                    System.out.println(pr.toString());
                                }
                                String codigoProducto = scanner.nextLine();
                                int cantidadProducto = 0;
                                try {
                                    System.out.println("Por favor ingrese la cantidad");
                                    cantidadProducto = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Se produjo un error con la cantidad introducida");
                                }

                                scanner.nextLine();
                                OrderLine orderLine = new OrderLine(productController.findOne(codigoProducto), cantidadProducto);
                                if (orderLine.getProduct() != null) {
                                    order.getLineasPedidos().add(orderLine);
                                }
                                System.out.println("----------------------------");
                                System.out.println("Desea seguir agregando productos?");
                                System.out.println("1.SI");
                                System.out.println("2.NO");
                                System.out.println("----------------------------");
                                seguirAgregandoProductos = scanner.nextInt();
                                scanner.nextLine();
                            } while (seguirAgregandoProductos == 1);
                            if (order.getLineasPedidos().isEmpty()) {
                                System.out.println("Error, vuelva a intentarlo nuevamente");
                                break;
                            }
                            orderController.crearPedido(order);
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("Error, vuelva a intentarlo nuevamente");
                            System.out.println("----------------------------");
                            break;
                        }

                        break;

                    case 2:
                        System.out.println("Por favor ingrese el numero del pedido para procesarlo");
                        String nroPedido = scanner.nextLine();
                        System.out.println("Por favor asigne el empleado a cargo");
                        employeeController.findAll();
                        for (Employee employeeRecorrido : employeeController.findAll()
                        ) {
                            System.out.println(employeeRecorrido.toString());
                        }
                        String cuitEmpleado = scanner.nextLine();

                        Order orderEncontrado = orderController.buscarPedidoPorNumero(nroPedido);


                        if ((orderEncontrado != null && employeeController.findOne(cuitEmpleado) != null) && orderEncontrado.getEstadoPedido().equals("Pendiente")) {

                            orderController.procesarPedido(nroPedido, cuitEmpleado);
                            System.out.println("El pedido fue procesado");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se pudo procesar, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("Por favor ingrese el numero del pedido para completarlo");
                        String nroPedidoCompletar = scanner.nextLine();
                        Order pedidoCompletarOrder = orderController.buscarPedidoPorNumero(nroPedidoCompletar);
                        if ((pedidoCompletarOrder != null) && pedidoCompletarOrder.getEstadoPedido().equals("En Proceso")) {
                            orderController.completarPedido(nroPedidoCompletar);
                            System.out.println("El pedido fue completado");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se pudo completar, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 4:
                        System.out.println("Por favor ingrese el numero del pedido para enviarlo a despacho");
                        String nroPedidoEnviarADespacho = scanner.nextLine();
                        Order orderEnviarADespacho = orderController.buscarPedidoPorNumero(nroPedidoEnviarADespacho);
                        if ((orderEnviarADespacho != null) && orderEnviarADespacho.getEstadoPedido().equals("Completo")) {
                            orderController.enviarADespacho(nroPedidoEnviarADespacho);
                            System.out.println("El pedido fue enviado a despacho");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se pudo enviar a despacho, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 5:
                        System.out.println("Por favor ingrese el número del pedido para despacharlo");
                        String nroPedidoDespacho = scanner.nextLine();
                        Order orderDespacho = orderController.buscarPedidoPorNumero(nroPedidoDespacho);
                        if ((orderDespacho != null) && orderDespacho.getEstadoPedido().equals("Esperando Despacho")) {
                            orderController.despacharPedido(nroPedidoDespacho);
                            System.out.println("El pedido fue despachado");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se encontró, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 6:
                        System.out.println("Por favor ingrese el número del pedido para enviarlo a transito");
                        String nroPedidoTransito = scanner.nextLine();
                        Order orderTransito = orderController.buscarPedidoPorNumero(nroPedidoTransito);
                        if ((orderTransito != null) && orderTransito.getEstadoPedido().equals("Despacho")) {
                            orderController.transitarPedido(nroPedidoTransito);
                            System.out.println("El pedido fue enviado a transito");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se encontró, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }

                        break;
                    case 7:
                        System.out.println(" Por favor ingrese el numero del pedido para enviarlo a entrega ");
                        String numeroPedidoEnviarAEntrega = scanner.nextLine();
                        System.out.println("Por favor ingrese el CUIT del empleado receptor:");
                        for (Employee ep : employeeController.findAll()
                        ) {
                            System.out.println(ep.toString());
                        }
                        String cuitEmpleadoReceptor = scanner.nextLine();
                        Order orderEnviarAEntrega = orderController.buscarPedidoPorNumero(numeroPedidoEnviarAEntrega);

                        if ((orderEnviarAEntrega != null && employeeController.findOne(cuitEmpleadoReceptor) != null) && orderEnviarAEntrega.getEstadoPedido().equals("En transito")) {

                            orderController.enviarAEntrega(numeroPedidoEnviarAEntrega, cuitEmpleadoReceptor);
                            System.out.println("El pedido fue enviado a entrega");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se encontró, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;

                    case 8:
                        System.out.println("Por favor ingrese el número del pedido para entregarlo");
                        String nroPedidoEntregar = scanner.nextLine();
                        Order orderEntregar = orderController.buscarPedidoPorNumero(nroPedidoEntregar);
                        if ((orderEntregar != null) && orderEntregar.getEstadoPedido().equals("Esperando Entrega")) {
                            List<OrderLine> lineasPedido = orderEntregar.getLineasPedidos();
                            List<Integer> calificacionesProveedor = new ArrayList<>();

                            for (OrderLine orderLine : lineasPedido) {
                                int calificacion = 0;
                                try {
                                    System.out.println("Por favor ingrese la calificación del proveedor del producto " + orderLine.getProduct().getName() + " :");
                                    calificacion = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Se produjo un error en la calificación");
                                    break;
                                }
                                scanner.nextLine(); // Consumir el salto de línea
                                calificacionesProveedor.add(calificacion);
                            }

                            orderController.entregarPedido(nroPedidoEntregar, calificacionesProveedor);
                            System.out.println("El pedido fue entregado");
                            System.out.println(orderEntregar.toString());
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se encontró, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 9:
                        CalcDistance calcDistance = new CalcDistance();
                        System.out.println("Por favor ingrese el número del pedido para calcular la distancia");
                        String nroPedidoDistancia = scanner.nextLine();
                        Order orderDistancia = orderController.buscarPedidoPorNumero(nroPedidoDistancia);
                        if (orderDistancia != null) {

                            System.out.println("El pedido se encuentra a "
                                    + Math.round(calcDistance.calcDistance(orderDistancia.getTracking().getLatitude()
                                    , orderDistancia.getTracking().getLongitude()
                                    , orderDistancia.getDepositDestino().getPosition().getLatitude()
                                    , orderDistancia.getDepositDestino().getPosition().getLongitude())) + " kms de la sucursal destino");
                        } else {
                            System.out.println("----------------------------");
                            System.out.println("El pedido no se encontró, intentelo nuevamente");
                            System.out.println("----------------------------");
                        }
                        break;
                    case 10:
                        List<Order> orders = orderController.mostrarTodosLosPedidos();
                        for (Order order : orders) {
                            System.out.println(order.toString()); // O utiliza el método que imprime la información relevante del pedido
                        }
                        break;
                    case 11:
                        System.out.println("Ha salido exitosamente");
                        this.regresarMenuPrincipal = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida del menú.");
                        break;
                }
            }while (!regresarMenuPrincipal);//**

    }
    public void setRegresarMenuPrincipal(boolean regresarMenuPrincipal) {
        this.regresarMenuPrincipal = regresarMenuPrincipal;
    }


}





