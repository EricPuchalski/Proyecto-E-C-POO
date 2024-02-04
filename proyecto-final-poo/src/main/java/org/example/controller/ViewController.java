/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.awt.Component;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.example.model.Carrier;
import org.example.model.Customer;
import org.example.model.Employee;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.Supplier;
import org.example.model.Warehouse;

/**
 *
 * @author ericp
 */
public class ViewController {

    private CustomerController customerController = new CustomerController();
    private CarrierController carrierController = new CarrierController();
    private WarehouseController warehouseController = new WarehouseController();
    private ProductController productController = new ProductController();
    private EmployeeController employeeController = new EmployeeController();
    private OrderController orderController = new OrderController();
    private SupplierController supplierController = new SupplierController();

    public static void panelChange(JPanel panelRemove, JPanel panelNew, Component o) {
        JFrame contenedor = (JFrame) SwingUtilities.getWindowAncestor(o);
        contenedor.remove(panelRemove);
        contenedor.add(panelNew);
        contenedor.validate();
        contenedor.repaint();
    }

    public TableModel modelTableCustomers() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Nombre", "Apellido", "cuit"};
        newModel.setColumnIdentifiers(titulos);

        for (Customer e : customerController.findAllEnabledCustomers()) {
            Object[] obj = {e.getId(), e.getName(), e.getSurname(), e.getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableCustomersByCuit(String cuit) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Nombre", "Apellido", "cuit"};
        newModel.setColumnIdentifiers(titulos);

        for (Customer e : customerController.findAllCustomersByCuit(cuit)) {
            Object[] obj = {e.getId(), e.getName(), e.getSurname(), e.getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    }
     public TableModel modelTableSuppliers() {
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String titulos[] = {"Id", "Cuit", "Nombre", "Estado","Direccion","Teléfono","email"};
        modeloTabla.setColumnIdentifiers(titulos);
        List<Supplier> listSuppliers = supplierController.findAllEnabledEmployees();

        if(!listSuppliers.isEmpty()){
            for (Supplier sp: listSuppliers){
                Object[] obj = {sp.getId(),sp.getCuit(),sp.getName(),sp.getStatus(),sp.getAdress(),sp.getPhone(),sp.getEmail()};
                modeloTabla.addRow(obj);
            }
        }

        return modeloTabla;
    }
          public TableModel modelTableSuppliersByCuit(String cuit) {
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String titulos[] = {"Id", "Cuit", "Nombre", "Estado","Direccion","Teléfono","email"};
        modeloTabla.setColumnIdentifiers(titulos);
        List<Supplier> listSuppliers = supplierController.findAllByCuit(cuit);

        if(!listSuppliers.isEmpty()){
            for (Supplier sp: listSuppliers){
                Object[] obj = {sp.getId(),sp.getCuit(),sp.getName(),sp.getStatus(),sp.getAdress(),sp.getPhone(),sp.getEmail()};
                modeloTabla.addRow(obj);
            }
        }

        return modeloTabla;
    }

    public TableModel modelTableCarriers() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Nombre", "cuit", "Tipo"};
        newModel.setColumnIdentifiers(titulos);

        for (Carrier e : carrierController.findAllEnabledCustomers()) {
            Object[] obj = {e.getId(), e.getName(), e.getCuit(), e.getType()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableCarriersByCuit(String cuit) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Nombre", "cuit", "Tipo"};
        newModel.setColumnIdentifiers(titulos);

        for (Carrier e : carrierController.findAllCarriersByCuit(cuit)) {
            Object[] obj = {e.getId(), e.getName(), e.getCuit(), e.getType()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableWarehouses() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Code", "Nombre", "Dirección", "Teléfono", "Email", "Continente", "Empleado"};
        newModel.setColumnIdentifiers(titulos);

        for (Warehouse e : warehouseController.findAllEnabledWarehouses()) {
            Object[] obj = {e.getId(), e.getCode(), e.getName(), e.getAdress(), e.getPhone(), e.getEmail(), e.getContinent(), e.getEmployee().getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableWarehousesByEmail(String email) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Code", "Nombre", "Dirección", "Teléfono", "Email", "Continente", "Empleado"};
        newModel.setColumnIdentifiers(titulos);

        for (Warehouse e : warehouseController.findAllWarehousesByEmail(email)) {
            Object[] obj = {e.getId(), e.getCode(), e.getName(), e.getAdress(), e.getPhone(), e.getEmail(), e.getContinent(), e.getEmployee().getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableProducts() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id","Codigo", "Nombre", "Proveedor", "Peso"};
        newModel.setColumnIdentifiers(titulos);
        if (!productController.findAll().isEmpty()) {
            for (Product e : productController.findAllEnabledEmployees()) {
                Object[] obj = {e.getId(),e.getCode(), e.getName(), e.getSupplier().getName(), e.getWeight()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableProductsByName(String name) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Id", "Nombre", "Proveedor", "Peso"};
        newModel.setColumnIdentifiers(titulos);
        for (Product e : productController.findAllProductsByName(name)) {
            Object[] obj = {e.getId(), e.getName(), e.getSupplier().getName(), e.getWeight()};
            newModel.addRow(obj);
        }
        return newModel;
    }

    public TableModel modelTableEmployees() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cuit", "Nombre", "Apellido", "Deposito"};
        newModel.setColumnIdentifiers(titulos);
        if (!employeeController.findAll().isEmpty()) {
            for (Employee e : employeeController.findAllEnabledCustomers()) {
                Object[] obj = {e.getId(), e.getCuit(), e.getNombre(), e.getApellido(), e.getDeposit().getEmail()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableEmployeesByCuit(String cuit) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cuit", "Nombre", "Apellido", "Deposito"};
        newModel.setColumnIdentifiers(titulos);
        if (!employeeController.findAllEmployeesByCuit(cuit).isEmpty()) {
            for (Employee e : employeeController.findAllEmployeesByCuit(cuit)) {
                Object[] obj = {e.getId(), e.getCuit(), e.getNombre(), e.getApellido(), e.getDeposit().getEmail()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableOrders() {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cliente", "Transportista", "Numero"};
        newModel.setColumnIdentifiers(titulos);
        if (!orderController.findAll().isEmpty()) {
            for (Order e : orderController.findAll()) {
                Object[] obj = {e.getId(), e.getCustomer().getName(), e.getCarrier().getName(), e.getOrderNumber()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableOrdersByNumber(String orderNumber) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cliente", "Transportista", "Numero"};
        newModel.setColumnIdentifiers(titulos);
        if (!orderController.findAllOrdersByNumber(orderNumber).isEmpty()) {
            for (Order e : orderController.findAllOrdersByNumber(orderNumber)) {
                Object[] obj = {e.getId(), e.getCustomer().getName(), e.getCarrier().getName(), e.getOrderNumber()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableOrdersByCustomer(Long idCustomer) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cliente", "Transportista", "Numero"};
        newModel.setColumnIdentifiers(titulos);
        if (!orderController.findAllOrdersByCustomer(idCustomer).isEmpty()) {
            for (Order e : orderController.findAllOrdersByCustomer(idCustomer)) {
                Object[] obj = {e.getId(), e.getCustomer().getName(), e.getCarrier().getName(), e.getOrderNumber()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }

    public TableModel modelTableOrdersByWarehouseOrig(Long idWarehouse) {
        DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cliente", "Transportista", "Numero"};
        newModel.setColumnIdentifiers(titulos);
        if (!orderController.findAllOrdersByWarehouseOrig(idWarehouse).isEmpty()) {
            for (Order e : orderController.findAllOrdersByWarehouseOrig(idWarehouse)) {
                Object[] obj = {e.getId(), e.getCustomer().getCuit(), e.getCarrier().getName(), e.getOrderNumber()};
                newModel.addRow(obj);
            }
        }
        return newModel;
    }
      // Método para obtener un modelo de tabla que contenga los depósitos
    public DefaultTableModel modelTableWarehousess() {
        DefaultTableModel model = new DefaultTableModel();
        // Agregamos las columnas necesarias al modelo
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Teléfono");
        model.addColumn("Email");
        model.addColumn("Continente");
        
        // Obtenemos la lista de depósitos
        for (Warehouse warehouse : warehouseController.findAll()) {
            // Agregamos una fila por cada depósito
            model.addRow(new Object[]{
                warehouse.getCode(),
                warehouse.getName(),
                warehouse.getAdress(),
                warehouse.getPhone(),
                warehouse.getEmail(),
                warehouse.getContinent()
            });
        }
        return model;
    }
}

