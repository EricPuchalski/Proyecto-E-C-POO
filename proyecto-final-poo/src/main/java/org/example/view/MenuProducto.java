package org.example.view;

import org.example.controller.ProductController;
import org.example.controller.SupplierController;
import org.example.model.ProductCategory;
import org.example.model.Product;
import org.example.model.Supplier;
import org.example.repository.ProveedorRepository;
import org.example.service.SupplierService;

import java.util.Scanner;

public class MenuProducto {
    private String opcion;
    private ProductController productController;
    SupplierController supplierController;

    private boolean regresarMenuPrincipal;//**


    public MenuProducto(ProductController productController) {
        this.productController = productController;
        this.supplierController = new SupplierController(new SupplierService(new ProveedorRepository()));
        this.regresarMenuPrincipal = true;//**

    }


    public void mostrarMenuProducto() {
        Scanner scanner = new Scanner(System.in);
        do {//**

            System.out.println("----------------------------");
            System.out.println("Por favor ingrese la opción que desee: ");
            System.out.println("----------------------------");
            System.out.println("1. Crear Producto");
            System.out.println("2. Ver Productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Editar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir del Menu de producto");
            System.out.println("----------------------------");
            this.opcion = scanner.nextLine();


            switch (opcion) {
                case "1":
                    String nombre = null;
                    Double peso = 0.0;
                    Double alturaProducto = 0.0;
                    Double anchoProducto = 0.0;
                    Double largoProducto = 0.0;

                    System.out.println("Por favor ingrese el codigo");
                    String codigo = scanner.nextLine();
                    if (productController.findOne(codigo) == null) {
                        System.out.println("Por favor ingrese el nombre");
                        nombre = scanner.nextLine();
                        try {
                            System.out.println("Por favor ingrese el peso");
                            peso = scanner.nextDouble();
                            System.out.println("Por favor ingrese la altura");
                            alturaProducto = scanner.nextDouble();
                            System.out.println("Por favor ingrese el ancho del producto");
                            anchoProducto = scanner.nextDouble();
                            System.out.println("Por favor ingrese el largo del producto");
                            largoProducto = scanner.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Se produjo un error con los datos introducidos");
                            break;
                        }

                    } else {
                        System.out.println("----------------------------");
                        System.out.println("El producto ingresado ya existe");
                        System.out.println("----------------------------");
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("Por favor ingrese la Categoria del producto");
                    System.out.println("-----------------------------");
                    System.out.println("1.Informatica");
                    System.out.println("2.Hogar");
                    System.out.println("3.Limpieza");
                    System.out.println("4.Jardin");
                    System.out.println("5.Electronica");
                    System.out.println("6.Juguete");
                    System.out.println("----------------------------");


                    String tipoProducto = scanner.nextLine();
                    supplierController.findAll();
                    System.out.println("----------------------------");
                    System.out.println("Por favor ingrese el cuit del proveedor");
                    String nombreProveedor = scanner.nextLine();

                    Supplier supplierDelProducto = supplierController.findOne(nombreProveedor);
                    ProductCategory productCategory = new ProductCategory();

                    switch (tipoProducto) {
                        case "1":
                            productCategory.setNombre("Informatica");
                            break;
                        case "2":
                            productCategory.setNombre("Hogar");
                            break;
                        case "3":
                            productCategory.setNombre("Limpieza");
                            break;
                        case "4":
                            productCategory.setNombre("Jardin");
                            break;
                        case "5":
                            productCategory.setNombre("Electronica");
                            break;
                        case "6":
                            productCategory.setNombre("Juguete");
                            break;
                        default:
                            System.out.println("No existe esa categoria de producto");
                            break;
                    }
                    if (supplierDelProducto != null && productCategory != null) {
                        productController.create(new Product(codigo, nombre, anchoProducto, alturaProducto, largoProducto, peso, productCategory, supplierDelProducto));
                        System.out.println("Producto creado exitosamente");
                    } else {
                        System.out.println("La creación del producto falló");
                    }


                    break;
                case "2":
                    System.out.println("============== La lista de Productos actuales es: ===============");
                    for (Product pr : productController.findAll()) {
                        System.out.println(pr.toString());
                    }
                    break;

                case "3":
                    System.out.println("Por favor ingrese el codigo del producto");
                    String codigoProducto = scanner.nextLine();
                    if (productController.findOne(codigoProducto) != null)
                        System.out.println("El producto es: " + productController.findOne(codigoProducto));
                    else System.out.println("El codigo ingresado no coincide con ningún producto");
                    break;
                case "4":
                    System.out.println("Por favor ingrese el coodigo del producto a editar: ");
                    String codigoProductoEditado = scanner.nextLine();
                    if (productController.findOne(codigoProductoEditado) != null) {
                        System.out.println("Por favor ingrese el nuevo nombre");
                        String nuevoNombre = scanner.nextLine();
                        Double nuevoPeso = 0.0;
                        Double nuevaAltura = 0.0;
                        Double nuevoAncho = 0.0;
                        Double nuevoLargo = 0.0;
                        try {
                            System.out.println("Por favor ingrese el nuevo peso");
                            nuevoPeso = scanner.nextDouble();
                            System.out.println("Por favor ingrese la nueva altura");
                            nuevaAltura = scanner.nextDouble();
                            System.out.println("Por favor ingrese el nuevo ancho del producto");
                            nuevoAncho = scanner.nextDouble();
                            System.out.println("Por favor ingrese el nuevo largo del producto");
                            nuevoLargo = scanner.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Se produjo un error con los datos introducidos");
                            break;
                        }

                        scanner.nextLine();
                        System.out.println("Ingrese la nueva categoria del producto: ");
                        System.out.println("-----------------------------");
                        System.out.println("1.Informatica");
                        System.out.println("2.Hogar");
                        System.out.println("3.Limpieza");
                        System.out.println("4.Jardin");
                        System.out.println("5.Electronica");
                        System.out.println("6.Juguete");

                        String opcionProducto = scanner.nextLine();
                        ProductCategory nuevaCategoria = new ProductCategory();
                        switch (opcionProducto) {
                            case "1":
                                nuevaCategoria.setNombre("Informatica");
                                break;
                            case "2":
                                nuevaCategoria.setNombre("Hogar");
                                break;
                            case "3":
                                nuevaCategoria.setNombre("Limpieza");
                                break;
                            case "4":
                                nuevaCategoria.setNombre("Jardin");
                                break;
                            case "5":
                                nuevaCategoria.setNombre("Electronica");
                                break;
                            case "6":
                                nuevaCategoria.setNombre("Juguete");
                                break;
                            default:
                                System.out.println("No existe esa categoria de producto");
                                break;
                        }
                        supplierController.findAll();
                        for (Supplier pr : supplierController.findAll()) {
                            System.out.println(pr.toString());
                        }
                        System.out.println("Por favor ingrese el cuit del nuevo proveedor");
                        String cuitNuevoProveedor = scanner.nextLine();
                        Supplier supplierNuevo = supplierController.findOne(cuitNuevoProveedor);

                        productController.upDate(new Product(codigoProductoEditado, nuevoNombre, nuevoAncho, nuevaAltura, nuevoLargo, nuevoPeso, nuevaCategoria, supplierNuevo));
                        System.out.println("Producto editado correctamente");

                    } else {
                        System.out.println("El codigo ingresado es incorrecto");
                    }
                    break;
                case "5":
                    System.out.println("Por favor ingrese el codigo del producto a eliminar");
                    String codigoProductoEliminado = scanner.nextLine();
                    if (productController.findOne(codigoProductoEliminado) != null) {
                        productController.delete(codigoProductoEliminado);
                    } else {
                        System.out.println("El codigo ingresado es incorrecto");
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
