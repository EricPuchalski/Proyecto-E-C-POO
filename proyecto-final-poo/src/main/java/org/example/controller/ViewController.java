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
import org.example.model.Warehouse;

/**
 *
 * @author ericp
 */
public class ViewController {
    private CustomerController customerController = new CustomerController();
    private CarrierController carrierController = new CarrierController();
    private WarehouseController warehouseController = new WarehouseController();
            
    public static void panelChange(JPanel panelRemove,JPanel panelNew, Component o){
    JFrame contenedor = (JFrame) SwingUtilities.getWindowAncestor(o);
    contenedor.remove(panelRemove);
    contenedor.add(panelNew);
    contenedor.validate();
    contenedor.repaint();
}
    public TableModel modelTableCustomers(){
       DefaultTableModel newModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        } 
        };
        String titulos[] = {"Id", "Nombre", "Apellido", "cuit"};
        newModel.setColumnIdentifiers(titulos);


        for (Customer e: customerController.findAll()){
            Object[] obj = {e.getId(), e.getName(),e.getSurname(), e.getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    } 
      public TableModel modelTableCustomersByCuit(String cuit){
       DefaultTableModel newModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        } 
        };
        String titulos[] = {"Id", "Nombre", "Apellido", "cuit"};
        newModel.setColumnIdentifiers(titulos);


        for (Customer e: customerController.findAllCustomersByCuit(cuit)){
            Object[] obj = {e.getId(), e.getName(),e.getSurname(), e.getCuit()};
            newModel.addRow(obj);
        }
        return newModel;
    } 
        public TableModel modelTableCarriers(){
       DefaultTableModel newModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        } 
        };
        String titulos[] = {"Id", "Nombre", "cuit", "Tipo"};
        newModel.setColumnIdentifiers(titulos);


        for (Carrier e: carrierController.findAll()){
            Object[] obj = {e.getId(), e.getName(),e.getCuit(), e.getType()};
            newModel.addRow(obj);
        }
        return newModel;
    } 
    public TableModel modelTableCarriersByCuit(String cuit){
       DefaultTableModel newModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        } 
        };
        String titulos[] = {"Id", "Nombre", "cuit", "Tipo"};
        newModel.setColumnIdentifiers(titulos);


        for (Carrier e: carrierController.findAllCarriersByCuit(cuit)){
            Object[] obj = {e.getId(), e.getName(),e.getCuit(), e.getType()};
            newModel.addRow(obj);
        }
        return newModel;
    } 
    public TableModel modelTableWarehouses(){
       DefaultTableModel newModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        } 
        };
        String titulos[] = {"Id", "Nombre", "cuit", "Tipo"};
        newModel.setColumnIdentifiers(titulos);


        for (Carrier e: carrierController.findAll()){
            Object[] obj = {e.getId(), e.getName(),e.getCuit(), e.getType()};
            newModel.addRow(obj);
        }
        return newModel;
    } 
}
