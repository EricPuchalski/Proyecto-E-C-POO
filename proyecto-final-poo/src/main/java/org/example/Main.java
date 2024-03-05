package org.example;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.util.LoadData;
import org.example.view.FrameMain;


import javax.swing.SwingUtilities;
import org.example.model.Customer;
import org.example.service.CustomerService;

import org.example.util.Conexion;


public class Main {
    public static void main(String[] args) {
        try {
            // Operaciones iniciales
            Conexion.connect();
            LoadData.loadData();
            CustomerService customerService = new CustomerService();
            Customer customer = new Customer("151011", "Eric", "Puch", "Josesito 232", "3243242");
           Customer savedCustomer = customerService.save(customer);
            System.out.println(savedCustomer.getCuit());
            // Creación e inicio de la interfaz gráfica en el EDT
            SwingUtilities.invokeLater(() -> {
                FrameMain frameMain = new FrameMain();
                // frameMain.setVisible(true);
            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ARREGLAR METODO DE CREAR EMPLEADO
}
