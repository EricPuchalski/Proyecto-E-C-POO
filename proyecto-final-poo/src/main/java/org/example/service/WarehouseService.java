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

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
    
    

    @Override
    public Warehouse save(Warehouse warehouse) {
        if (!(warehouse.getCode().isEmpty() || warehouse.getName().isEmpty() || warehouse.getPhone().isEmpty())) {
            if (checkIfExistUniq(warehouse.getCode(), warehouse.getPhone(), warehouse.getEmail()) == false) {
                return warehouseRepository.create(warehouse);
            }
        }
        return null;
    }

    @Override
     public Warehouse upDate(Warehouse warehouse) throws Exception {
        if (warehouseRepository.findWarehouseEnabledByCuit(warehouse.getEmail()) != null) {
            return warehouseRepository.edit(warehouse);
        }
        return null;
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
        public Warehouse disableAccountByEmail(String email){
        Warehouse warehouse = warehouseRepository.findWarehouseEnabledByCuit(email);
        if (warehouse!=null) {
            try {
                return warehouseRepository.disableAccountByEmail(email);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

                public Warehouse findWarehouseEnabledByCode(String email){
        Warehouse warehouseFound = warehouseRepository.findWarehouseEnabledByCuit(email);
        if(warehouseFound!=null){
                    if (warehouseFound.getStatus().equals(Warehouse.Estado.ENABLED)) {
                return warehouseRepository.findWarehouseEnabledByCuit(email);
            }
        }

        return null;
    }
        public Warehouse findWarehouseEnabledByPhone(String phone){
        for(Warehouse cr: findAllEnabledWarehouses()){
            if (cr.getPhone().equals(phone)) {
                return cr;
            }
        }
        return null;
    }
        public Warehouse findWarehouseEnabledByEmail(String email){
        for(Warehouse cr: findAllEnabledWarehouses()){
            if (cr.getEmail().equals(email)) {
                return cr;
            }
        }
        return null;
    }
        public boolean checkIfExistUniq(String code, String phone, String email) {
        Warehouse carrierByCuit = findWarehouseEnabledByCode(code);
        Warehouse carrierByEmail = findWarehouseEnabledByEmail(email);
        Warehouse carrierByPhone = findWarehouseEnabledByPhone(phone);
        if (carrierByCuit != null || carrierByEmail != null || carrierByPhone != null) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
