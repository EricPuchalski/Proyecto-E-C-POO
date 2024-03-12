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
            Conexion.connect();
            LoadData.loadData();
            SwingUtilities.invokeLater(() -> {
                FrameMain frameMain = new FrameMain();
            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
