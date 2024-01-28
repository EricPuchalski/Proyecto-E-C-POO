package org.example;

import dao.EmployeeRepository;
import dao.OrderLineRepository;
import dao.OrderRepository;
import dao.ProductRepository;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import org.example.util.Conexion;
import org.example.util.LoadData;
import org.example.view.FrameMain;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.example.util.Conexion;


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
