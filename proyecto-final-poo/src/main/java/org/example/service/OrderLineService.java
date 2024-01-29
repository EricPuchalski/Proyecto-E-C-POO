/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import dao.OrderLineRepository;
import dao.exceptions.NonexistentEntityException;
import java.util.List;
import org.example.model.OrderLine;

/**
 *
 * @author ericp
 */
public class OrderLineService implements CRUD<OrderLine>{
    private OrderLineRepository orderLineRepository;

    public OrderLineService() {
        this.orderLineRepository = new OrderLineRepository();
    }

    @Override
    public void save(OrderLine t) {
        orderLineRepository.create(t);
    }

    @Override
    public void upDate(OrderLine t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderLine findOne(String cuit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrderLine> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String cuit) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
