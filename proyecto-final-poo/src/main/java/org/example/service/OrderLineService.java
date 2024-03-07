/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import java.util.List;
import org.example.dao.OrderLineRepository;
import org.example.dao.exceptions.NonexistentEntityException;
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

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    
    @Override
    public OrderLine save(OrderLine t) {
        return orderLineRepository.create(t);
    }

    @Override
    public OrderLine upDate(OrderLine t) throws Exception {
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
