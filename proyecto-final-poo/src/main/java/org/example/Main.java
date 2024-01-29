package org.example;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.util.LoadData;
import org.example.view.FrameMain;


import javax.swing.SwingUtilities;

import org.example.util.Conexion;


public class Main {
    public static void main(String[] args) {
        try {
            // Operaciones iniciales
            Conexion.connect();
            LoadData.loadData();
            
            // Creación e inicio de la interfaz gráfica en el EDT
            SwingUtilities.invokeLater(() -> {
                FrameMain frameMain = new FrameMain();
                // frameMain.setVisible(true);
            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
