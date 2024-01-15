package org.example.view;

import org.example.controller.DepositController;
import org.example.model.Deposit;
import org.example.model.Position;

import java.util.Scanner;

public class MenuDeposito {

    private DepositController depositController;
    private String opcion;
    private boolean regresarMenuPrincipal;//**

    public MenuDeposito(DepositController depositController) {
        this.depositController = depositController;
    }

    public void mostrarMenuDeposito() {
        Scanner scanner = new Scanner(System.in);
        do {//**
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Crear depósito");
        System.out.println("2. Ver depósitos");
        System.out.println("3. Buscar depósito por código");
        System.out.println("4. Editar depósito");
        System.out.println("5. Eliminar depósito");
        System.out.println("6. Salir del Menú de depósito");
        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Por favor ingrese el código del depósito");
                    String codigo = scanner.nextLine();
                    if (depositController.findOne(codigo) == null) {
                        System.out.println("Por favor ingrese el nombre del depósito");
                        String nombre = scanner.nextLine();
                        System.out.println("Por favor ingrese la dirección del depósito");
                        String direccion = scanner.nextLine();
                        System.out.println("Por favor ingrese el teléfono del depósito");
                        String telefono = scanner.nextLine();
                        System.out.println("Por favor ingrese el email del depósito");
                        String email = scanner.nextLine();
                        System.out.println("Por favor ingrese el continente del depósito");
                        String continente = scanner.nextLine();
                        System.out.println("Por favor ingrese la latitud del depósito");
                        Double lat = scanner.nextDouble();
                        System.out.println("Por favor ingrese la longitud del depósito");
                        Double lon = scanner.nextDouble();

                        depositController.create(new Deposit(codigo, nombre, direccion, telefono, email, continente, new Position(lat, lon)));
                    } else {
                        System.out.println("El depósito ingresado ya existe.");
                    }
                    break;
                case "2":
                    for (Deposit dp: depositController.findAll()) {
                        System.out.println(dp.toString());
                    }
                    break;
                case "3":
                    System.out.println("Por favor ingrese el código del depósito");
                    String codigoDeposito = scanner.nextLine();
                    if (depositController.findOne(codigoDeposito) != null) {
                        System.out.println(depositController.findOne(codigoDeposito).toString());
                    } else {
                        System.out.println("No existe un depósito con ese código");
                    }
                    break;
                case "4":
                    System.out.println("Por favor ingrese el código del depósito a editar");
                    String codigoDepositoEditar = scanner.nextLine();
                    if (depositController.findOne(codigoDepositoEditar) != null) {
                        System.out.println("Por favor ingrese el nuevo nombre del depósito");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Por favor ingrese la nueva dirección del depósito");
                        String nuevaDireccion = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo teléfono del depósito");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo email del depósito");
                        String nuevoEmail = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo continente del depósito");
                        String nuevoContinente = scanner.nextLine();
                        System.out.println("Por favor ingrese la nueva latitud del depósito");
                        Double nlat = scanner.nextDouble();
                        System.out.println("Por favor ingrese la nueva longitud del depósito");
                        Double nlon = scanner.nextDouble();
                        System.out.println("Deposito editado correctamente");
                        depositController.upDate(new Deposit(codigoDepositoEditar, nuevoNombre, nuevaDireccion, nuevoTelefono, nuevoEmail, nuevoContinente, new Position(nlat, nlon)));
                    } else {
                        System.out.println("El código del depósito ingresado es inexistente");
                    }
                    break;
                case "5":
                    System.out.println("Por favor ingrese el código del depósito a eliminar");
                    String codigoDepositoEliminar = scanner.nextLine();
                    Deposit depositEliminar = depositController.findOne(codigoDepositoEliminar);
                    if (depositEliminar !=null){
                        depositController.delete(depositEliminar.getCode());
                        System.out.println("Deposito eliminado correctamente");
                    } else {
                        System.out.println("No se encontró ningun deposito con el codigo ingresado");
                    }


                    break;
                case "6":
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
