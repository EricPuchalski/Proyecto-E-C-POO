package org.example;

import dao.EmployeeRepository;
import dao.OrderLineRepository;
import dao.OrderRepository;
import dao.ProductRepository;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.model.Order;
import org.example.model.OrderLine;
import org.example.util.Conexion;
import org.example.util.LoadData;
import org.example.view.FrameMain;


public class Main {
    public static void main(String[] args) {
        Conexion.connect();
        LoadData.loadData();
        FrameMain frameMain = new FrameMain();
//        OrderRepository orderRepository = new OrderRepository();
//        Order order = orderRepository.findOrderByOrderNumber("123");
//        ProductRepository productRepository = new ProductRepository();
//        OrderLineRepository orderLineRepository = new OrderLineRepository();
//        OrderLine ol = new OrderLine(productRepository.findProduct(1l), 3);
//        List<OrderLine> orderLines = new ArrayList<>();
//        orderLineRepository.create(ol);
//        orderLines.add(ol);
//        order.setOrderLines(orderLines);
//        try {
//            orderRepository.edit(order);
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(order.getOrderNumber());
////        FrameMain frameMain = new FrameMain();
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        System.out.println(employeeRepository.findEmployeeByCuit("1235433").getCUIT());
//        orderRepository.processOrder("123", "1235433");
//        orderRepository.completeOrder("123");
//        orderRepository.sendOrderToDispatch("123");
//        orderRepository.dispatchOrder("123");
//        orderRepository.sendToDelivery("123", "7896754");
//        List<Integer> ratings = new ArrayList<>();
//        ratings.add(4);
//        orderRepository.deliverOrder("123", ratings);
//        orderRepository.orderTransit("123");

    // HACER EL METODO PARA HACER UNA LINEA DE PEDIDO.
//    EmployeeRepository employeeRepository = new EmployeeRepository();
    }
}
