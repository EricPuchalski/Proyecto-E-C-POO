/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import java.util.ArrayList;
import org.example.dao.WarehouseRepository;
import org.example.model.Warehouse;

import org.example.dao.exceptions.NonexistentEntityException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 *
 * @author facundo
 */
public class WarehouseService implements CRUD<Warehouse> {
    private WarehouseRepository warehouseRepository;

    public WarehouseService() {
        this.warehouseRepository = new WarehouseRepository();
    }
    

    @Override
     public void save(Warehouse warehouse) {
 
         warehouseRepository.create(warehouse);
    }

    @Override
     public void upDate(Warehouse warehouse) throws Exception {
        if (warehouseRepository.findWarehouse(warehouse.getId()) != null) {
            warehouseRepository.edit(warehouse);
        }
    }

    @Override
    public Warehouse findOne(String code) {
        for (Warehouse warehouse : warehouseRepository.findWarehouseEntities()) {
            if (code.equals(warehouse.getCode())) {
                return warehouse;
            }
        }
        return null;
    }
    public Warehouse findOneById(Long id){
        return warehouseRepository.findWarehouse(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findWarehouseEntities();
    }

    @Override
      public void delete(String code) throws NonexistentEntityException {
        Warehouse deleteWarehouse = findOne(code);
        if (deleteWarehouse != null) {
            warehouseRepository.destroy(deleteWarehouse.getId());
        }
    }
    public List<Warehouse> findAllWarehousesByEmail(String email){
        if (email == null || email.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowercaseEmail = email.toLowerCase();
        List<Warehouse> warehousesFound= new ArrayList<>();
        warehousesFound = this.findAllEnabledWarehouses()
        .stream()
        .filter(tr -> tr.getEmail().toLowerCase().startsWith(lowercaseEmail))
        .collect(Collectors.toList());
        
        return warehousesFound;
    }
    
        public List<Warehouse> findAllEnabledWarehouses(){
        return warehouseRepository.findWarehouseEntities()
            .stream()
            .filter(customer -> customer.getStatus().equals(Warehouse.Estado.ENABLED))
            .collect(Collectors.toList());
    }
        public void disableAccountByEmail(String email){
        Warehouse warehouse = warehouseRepository.findWarehouseEnabledByCuit(email);
        if (warehouse!=null) {
            try {
                warehouseRepository.disableAccountByEmail(email);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

                public Warehouse findWarehouseEnabledByCuit(String email){
        Warehouse warehouseFound = warehouseRepository.findWarehouseEnabledByCuit(email);
        if (warehouseFound.getStatus().equals(Warehouse.Estado.ENABLED)) {
                return warehouseRepository.findWarehouseEnabledByCuit(email);
            }
        return null;
    }
    
}
