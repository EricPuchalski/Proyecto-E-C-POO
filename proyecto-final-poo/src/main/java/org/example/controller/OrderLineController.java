/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import javax.swing.JTable;
import org.example.model.OrderLine;
import org.example.service.OrderLineService;

/**
 *
 * @author ericp
 */
public class OrderLineController implements CRUD<OrderLine>{
    private OrderLineService orderLineService;
    private ProductController productController;
    public OrderLineController() {
        this.orderLineService = new OrderLineService();
        this.productController = new ProductController();
    }



    @Override
    public OrderLine findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrderLine> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void upDate(OrderLine t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(OrderLine t) {
        orderLineService.save(t);
    }
    
}
