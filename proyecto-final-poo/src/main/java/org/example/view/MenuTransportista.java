package org.example.view;

import org.example.controller.OrderController;
import org.example.controller.CarrierController;
import org.example.model.*;

import java.util.Scanner;

public class MenuTransportista {

    private CarrierController carrierController;
    private OrderController orderController;
    private boolean regresarMenuPrincipal;//**


    public MenuTransportista(CarrierController carrierController, OrderController orderController) {
        this.carrierController = carrierController;
        this.orderController = orderController;
        this.regresarMenuPrincipal = true;//**

    }

    public void mostrarMenuTransportista() {
        Scanner scanner = new Scanner(System.in);
        do {//**

            System.out.println(" ");
            System.out.println("Por favor ingrese la opción que desee: ");
            System.out.println(" ");
            System.out.println("1. Crear transportista");
            System.out.println("2. Ver transportistas");
            System.out.println("3. Buscar transportista por CUIT");
            System.out.println("4. Editar transportista");
            System.out.println("5. Eliminar transportista");
            System.out.println("6. Informar posición del pedido");
            System.out.println("7. Salir del Menu de transportista");
            System.out.println("----------------------------");

            String opcion = scanner.nextLine();


            switch (opcion) {
                case "1":
                    System.out.println("Por favor ingrese el CUIT");
                    String cuit = scanner.nextLine();
                    if (carrierController.findOne(cuit) == null) {
                        System.out.println("Por favor ingrese el nombre");
                        String nombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el teléfono");
                        String telefono = scanner.nextLine();
                        System.out.println("Por favor ingrese el email");
                        String email = scanner.nextLine();
                        System.out.println("Por favor ingrese el tipo de transportista");
                        System.out.println("1.Aereo");
                        System.out.println("2.Terrestre");
                        System.out.println("3.Maritimo");
                        CarrierType carrierType = new CarrierType();
                        String opcionTipo = scanner.nextLine();
                        switch (opcionTipo) {
                            case "1":
                                carrierType.setDescription("Aereo");
                                break;
                            case "2":
                                carrierType.setDescription("Terrestre");
                                break;
                            case "3":
                                carrierType.setDescription("Maritimo");
                                break;
                            default:
                                System.out.println("No existe ese tipo de transportista");
                        }
                        carrierController.create(new Carrier(cuit, nombre, telefono, email, carrierType));
                        System.out.println(" Transportista creado exitosamente ");
                    } else {
                        System.out.println("El transportista ya existe");
                    }

                    break;
                case "2":
                    System.out.println("============== La lista actual de Transportistas es: ===============");
                    for (Carrier tr : carrierController.findAll()) {
                        System.out.println(tr.toString());
                    }
                    break;
                case "3":
                    for (Carrier tr : carrierController.findAll()
                    ) {
                        System.out.println(tr.toString());
                    }
                    System.out.println("Por favor ingrese el CUIT del transportista");
                    String cuitTransportista = scanner.nextLine();

                    Carrier tr = carrierController.findOne(cuitTransportista);
                    if (tr != null) {
                        System.out.println("El transportista buscado es: " + tr.toString());
                    } else {
                        System.out.println("El cuit ingresado no corresponde a ningún transportista");
                    }

                    break;
                case "4":
                    System.out.println("Por favor ingrese el CUIT del transportista");
                    String cuitTransportistaEditar = scanner.nextLine();
                    if (carrierController.findOne(cuitTransportistaEditar) != null) {
                        System.out.println("Por favor ingrese el nuevo nombre");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo teléfono");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo email");
                        String nuevoEmail = scanner.nextLine();
                        System.out.println("Por favor ingrese el tipo de transportista");
                        System.out.println("1.Aereo");
                        System.out.println("2.Terrestre");
                        System.out.println("3.Maritimo");
                        String nuevoTipo = scanner.nextLine();
                        switch (nuevoTipo) {
                            case "1":
                                carrierController.findOne(cuitTransportistaEditar).getType().setDescription("Aereo");
                                break;
                            case "2":
                                carrierController.findOne(cuitTransportistaEditar).getType().setDescription("Terrestre");
                                break;
                            case "3":
                                carrierController.findOne(cuitTransportistaEditar).getType().setDescription("Maritimo");
                                break;
                            default:
                                System.out.println("No existe ese tipo de transportista");

                        }
                        System.out.println("Transportista editado correctamente");
                        carrierController.upDate(new Carrier(cuitTransportistaEditar, nuevoNombre, nuevoTelefono, nuevoEmail, carrierController.findOne(cuitTransportistaEditar).getType()));
                    } else {
                        System.out.println("No se encontró un transportista con el CUIT ingresado");
                    }

                    break;
                case "5":
                    System.out.println("Por favor ingrese el cuit del transportista a eliminar: ");
                    String cuitTransportistaEliminado = scanner.nextLine();
                    if (carrierController.findOne(cuitTransportistaEliminado) != null) {
                        carrierController.delete(cuitTransportistaEliminado);
                        System.out.println(" Transportista eliminado exitosamente");
                    } else {
                        System.out.println("El transportista ingresado no existe");
                    }
                    break;
                case "6":
                System.out.println("Por favor ingrese el numero del pedido para informar su posición");
                String nroPedido = scanner.nextLine();
                Order orderEncontrado = orderController.buscarPedidoPorNumero(nroPedido);

                if (orderEncontrado != null) {
                    System.out.println("Por favor ingrese su cuit para determinar si el pedido le corresponde");
                    String cuitTransportistaPedido = scanner.nextLine();

                    if (orderEncontrado.getCarrier() != null && orderEncontrado.getCarrier().getCuit().equals(cuitTransportistaPedido)) {
                        System.out.println("Por favor ingrese la nueva latitud: ");
                        double latitud = scanner.nextDouble();
                        System.out.println("Por favor ingrese la nueva longitud: ");
                        double longitud = scanner.nextDouble();
                        orderEncontrado.getTracking().setLatitude(latitud);
                        orderEncontrado.getTracking().setLongitude(longitud);
                        System.out.println(" la latitud del pedido es "+ orderEncontrado.getTracking().getLatitude());
                        System.out.println(" ");
                        System.out.println(" la longitud del pedido es "+ orderEncontrado.getTracking().getLongitude());
                    } else {
                        System.out.println("El pedido no le corresponde o el transportista no está definido.");
                    }
                } else {
                    System.out.println("No se encontró ningún pedido con el número ingresado.");
                }
                break;
                case "7":
                    System.out.println("Ha salido exitosamente");
                    this.regresarMenuPrincipal = true;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }while (!regresarMenuPrincipal);//**


    }public void setRegresarMenuPrincipal(boolean regresarMenuPrincipal) {
        this.regresarMenuPrincipal = regresarMenuPrincipal;
    }
}
