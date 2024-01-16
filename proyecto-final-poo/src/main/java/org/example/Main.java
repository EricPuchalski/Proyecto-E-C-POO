package org.example;

import dao.CustomerDao;
import org.example.model.Customer;
import org.example.util.Conexion;




public class Main {
    public static void main(String[] args) {
        Conexion.connect();
        CustomerDao customerDao = new CustomerDao();

    }
}
