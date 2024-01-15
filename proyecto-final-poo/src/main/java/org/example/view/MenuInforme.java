package org.example.view;


import org.example.controller.CustomerController;

import org.example.controller.InformationController;
import org.example.controller.OrderController;
import org.example.model.Customer;

import org.example.model.Order;

import java.util.Scanner;

public class MenuInforme {
    private InformationController informationController;
    private CustomerController customerController;

    private OrderController orderController;

    private boolean regresarMenuPrincipal;//**

    public MenuInforme(InformationController informationController, CustomerController customerController, OrderController orderController) {
        this.informationController = informationController;
        this.customerController = customerController;
        this.orderController = orderController;
        this.regresarMenuPrincipal = true;//**

    }

    public void mostrarMenuInforme() {
        Scanner scanner = new Scanner(System.in);
        do {//**

            System.out.println("Por favor ingrese la opción que desee: ");
            System.out.println("1. Mostrar cantidad de pedidos realizados por una sucursal");
            System.out.println("2. Mostrar cantidad de pedidos en estado Pendiente");
            System.out.println("3. Mostrar historial de pedidos finalizados de un cliente");

            System.out.println("4. Mostrar los estados de los pedidos");
            System.out.println("5. Salir del menu Informe");


            System.out.println("----------------------------");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Por favor ingrese el código de la sucursal para obtener la cantidad de pedidos realizados:");

                    String codigoSucursal = scanner.nextLine();

                    int cantidadPedidos = informationController.obtenerCantidadPedidosPorSucursal(codigoSucursal);
                    System.out.println("La cantidad de pedidos realizados por la sucursal con código " + codigoSucursal + " es: " + cantidadPedidos);
                    break;

                case "2":
                    int cantidadPedidosPendientes = informationController.contarPedidosEnEstadoPendiente();
                    System.out.println("La cantidad de pedidos en estado Pendiente es: " + cantidadPedidosPendientes);
                    break;

                case "3":
                    System.out.println("Por favor ingrese el cuit del cliente: ");
                    String cuit = scanner.nextLine();
                    Customer customerBuscado = customerController.findOne(cuit);
                    int contador = informationController.obtenerHistorialDeUnCliente(cuit);
                    if (contador > 0) {
                        System.out.println("El cliente " + customerBuscado.getName() + " " + customerBuscado.getSurname() + " tiene: " + contador + " pedidos en su historial");
                    } else {
                        System.out.println("El cliente " + customerBuscado.getName() + " " + customerBuscado.getSurname() + " no tiene pedidos en su historial");
                    }
                    break;
                case "4":
                    System.out.println("Los estados de todos los pedidos son: ");
                    for (Order order : orderController.mostrarTodosLosPedidos()
                    ) {
                        System.out.println("El pedido numero: " + order.getNumeroPedido() + " tiene de estado: " + order.getEstadoPedido());
                    }
                    break;
                case "5":
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
