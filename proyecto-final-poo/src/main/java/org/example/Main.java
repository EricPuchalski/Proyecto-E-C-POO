package org.example;

import java.awt.Frame;
import javax.swing.SwingUtilities;

import org.example.util.Conexion;
import org.example.util.LoadData;
import org.example.view.FrameMain;


public class Main {
    public static void main(String[] args) {
        // Operaciones iniciales
        Conexion.connect();
        LoadData.loadData();

        // Creación e inicio de la interfaz gráfica en el EDT
        SwingUtilities.invokeLater(() -> {
            FrameMain frameMain = new FrameMain();
           // frameMain.setVisible(true);
        });
    }
}
