/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import dao.WarehouseRepository;
import org.example.model.Warehouse;
import dao.exceptions.NonexistentEntityException;
import java.util.List;


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
        if (!warehouseRepository.findWarehouseEntities().contains(warehouse.getCode())) {
        }else{
                        warehouseRepository.create(warehouse);
                     }
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
    
    
}
