//package org.example.view;
//
//import org.example.controller.CustomerController;
//import org.example.model.Customer;
//
//import java.util.Scanner;
//
//public class MenuCliente {
//
//
//    private CustomerController customerController;
//    private String opcion;
//    private boolean regresarMenuPrincipal;//**
//
//    public MenuCliente(CustomerController customerController) {
//        this.customerController = customerController;
//        this.regresarMenuPrincipal = true;//**
//
//    }
//
//    public void mostrarMenuCliente() {
//        Scanner scanner = new Scanner(System.in);
//        do {//**
//
//            System.out.println("Por favor ingrese la opción que desee: ");
//            System.out.println("----------------------------");
//            System.out.println("1. Crear cliente");
//            System.out.println("2. Ver clientes");
//            System.out.println("3. Buscar cliente por CUIT");
//            System.out.println("4. Editar cliente");
//            System.out.println("5. Eliminar cliente");
//            System.out.println("6. Salir del Menu de cliente");
//            System.out.println("----------------------------");
//            this.opcion = scanner.nextLine();
//
//            switch (opcion) {
//                case "1":
//                    System.out.println("Por favor ingrese el CUIT");
//                    String cuit = scanner.nextLine();
//                    if (customerController.findOne(cuit) == null) {
//                        System.out.println("Por favor ingrese el nombre");
//                        String nombre = scanner.nextLine();
//                        System.out.println("Por favor ingrese el apellido");
//                        String apellido = scanner.nextLine();
//                        System.out.println("Por favor ingrese la dirección");
//                        String direccion = scanner.nextLine();
//                        System.out.println("Por favor ingrese el telefono");
//                        String telefono = scanner.nextLine();
//
//                        customerController.create(new Customer(cuit, nombre, apellido, direccion, telefono));
//                        System.out.println("Cliente creado correctamente");
//                    } else {
//                        System.out.println("El cliente ingresado ya existe.");
//                    }
//
//
//                    break;
//                case "2":
//                    System.out.println("============== La lista de Clientes actuales es: ===============");
//                    for (Customer cl : customerController.findAll()) {
//                        System.out.println(cl.toString());
//                    }
//
//                    break;
//                case "3":
//                    System.out.println("Por favor ingrese el CUIT del cliente");
//                    String cuitCliente = scanner.nextLine();
//                    if (customerController.findOne(cuitCliente) != null) {
//                        System.out.println("----------------------------");
//                        System.out.println(customerController.findOne(cuitCliente).toString());
//                        System.out.println("----------------------------");
//                    } else {
//                        System.out.println("----------------------------");
//                        System.out.println("No existe un cliente con ese cuit");
//                        System.out.println("----------------------------");
//                    }
//
//                    break;
//                case "4":
//                    System.out.println("Por favor ingrese el CUIT del cliente a editar");
//                    String cuitClienteEditar = scanner.nextLine();
//                    if (customerController.findOne(cuitClienteEditar) != null) {
//                        System.out.println("Por favor ingrese el nuevo nombre");
//                        String nuevoNombre = scanner.nextLine();
//                        System.out.println("Por favor ingrese el nuevo apellido");
//                        String nuevoApellido = scanner.nextLine();
//                        System.out.println("Por favor ingrese la nueva dirección");
//                        String nuevaDireccion = scanner.nextLine();
//                        System.out.println("Por favor ingrese el telefono nuevo");
//                        String nuevoTelefono = scanner.nextLine();
//                        System.out.println("Cliente editado correctamente");
//                        customerController.upDate(new Customer(cuitClienteEditar, nuevoNombre, nuevoApellido, nuevaDireccion, nuevoTelefono));
//                    } else {
//                        System.out.println("El cuit ingresado es inexistente");
//                    }
//
//                    break;
//                case "5":
//                    System.out.println("Por favor ingrese el cuit del cliente a eliminar");
//                    String cuitClienteEliminado = scanner.nextLine();
//                    Customer customerEliminado = customerController.findOne(cuitClienteEliminado);
//                    if (customerEliminado != null) {
//                        customerController.delete(customerEliminado.getCuit());
//                        System.out.println("Cliente eliminado correctamente");
//                    } else {
//                        System.out.println("El cliente con el CUIT proporcionado no fue encontrado.");
//                    }
//
//
//                    break;
//                case "6":
//                    System.out.println("Ha salido exitosamente");
//                    this.regresarMenuPrincipal = true;
//
//                    break;
//                default:
//                    System.out.println("Opción inválida");
//                    break;
//
//            }
//        } while (!regresarMenuPrincipal);//**
//    }
//
//    public void setRegresarMenuPrincipal(boolean regresarMenuPrincipal) {
//        this.regresarMenuPrincipal = regresarMenuPrincipal;
//    }
//}