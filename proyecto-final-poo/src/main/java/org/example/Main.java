package org.example;

import org.example.util.Conexion;
import org.example.util.LoadData;


public class Main {
    public static void main(String[] args) {
        Conexion.connect();
        LoadData.loadData();

    }
}
