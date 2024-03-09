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
public class OrderLineService{
    private OrderLineRepository orderLineRepository;

    public OrderLineService() {
        this.orderLineRepository = new OrderLineRepository();
    }

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    

    public OrderLine save(OrderLine t) {
        return orderLineRepository.create(t);
    }

    
}
