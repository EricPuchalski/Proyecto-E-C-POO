/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;
import org.example.model.Customer;
import org.example.model.Order;

import java.util.List;
    
/**
 *
 * @author facundo
 */
public class InformationRepository {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public InformationRepository(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public int getNumberOfOrdersByBranch(String branchCode) {
        int orderCount = 0;
        List<Order> orders = orderRepository.findOrderEntities();
        for (Order order : orders) {
            if (order.getWarehouseOrig().getCode().equals(branchCode)) {
                orderCount++;
            }
        }
        return orderCount;
    }

    public int countOrdersInPendingStatus() {
        int pendingCount = 0;
        List<Order> orders = orderRepository.findOrderEntities();
        for (Order order : orders) {
            if (order.getOrderStatus().equals("Pending")) {
                pendingCount++;
            }
        }
        return pendingCount;
    }

    public int getCustomerOrderHistory(Long id) {
        Customer customer = customerRepository.findCustomer(id);
        int historyCount = 0;
        for (Order order : orderRepository.findOrderEntities()) {
            if (order.getCustomer().getCuit().equals(customer.getCuit()) && order.getOrderStatus().equals("Delivery")) {
                historyCount++;
            }
        }
        return historyCount;
    }

   public void showOrderStatus() {
    for (Order order : orderRepository.findOrderEntities()) {
        System.out.println("Order ID: " + order.getId() + ", Status: " + order.getOrderStatus());
    }
}
}
