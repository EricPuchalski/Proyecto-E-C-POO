package org.example;

import java.awt.Frame;
import org.example.util.Conexion;
import org.example.util.LoadData;
import org.example.view.FrameMain;


public class Main {
    public static void main(String[] args) {
        Conexion.connect();
        LoadData.loadData();
        FrameMain frameMain = new FrameMain();

    }
}
