package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import org.example.model.Warehouse;


import java.util.List;
import org.example.service.WarehouseService;

public class WarehouseController implements CRUD<Warehouse>{
    private WarehouseService warehouseService;

    public WarehouseController() {
        this.warehouseService = new WarehouseService();
    }

    @Override
    public void create(Warehouse deposit) {
        warehouseService.save(deposit);
    }

    @Override
    public Warehouse findOne(String id) {
        return warehouseService.findOne(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseService.findAll();
    }


    @Override
    public void upDate(Warehouse deposit) throws Exception {
        warehouseService.upDate(deposit);

    }

    @Override
    public void delete(String id) throws NonexistentEntityException {
        warehouseService.delete(id);
    }
}
