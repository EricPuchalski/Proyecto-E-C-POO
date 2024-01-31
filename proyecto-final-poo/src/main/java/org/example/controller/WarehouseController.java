package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import org.example.model.Warehouse;


import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
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
    
    public Warehouse findOneById(Long id){
        return warehouseService.findOneById(id);
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
    public List<Warehouse> findAllWarehousesByEmail(String email){
        if (email == null || email.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowercaseEmail = email.toLowerCase();
        List<Warehouse> warehousesFound= new ArrayList<>();
        warehousesFound = this.findAll()
        .stream()
        .filter(tr -> tr.getEmail().toLowerCase().startsWith(lowercaseEmail))
        .collect(Collectors.toList());
        
        
        return warehousesFound;
        
    
        
    }
    public List<Warehouse> warehousesIdForOrder(JTable tableOrig, JTable tableDest){
        List<Warehouse> warehouses = new ArrayList<>();
        if(tableOrig.getRowCount() > 0){
            if(tableOrig.getSelectedRow()!=-1){
                if(tableDest.getRowCount() > 0){
                    if(tableDest.getSelectedRow()!=-1){
                        Long idOrig = Long.parseLong(String.valueOf(tableOrig.getValueAt(tableOrig.getSelectedRow(),0)));
                        Warehouse warehouseOrig = this.findOneById(idOrig);
                        Long idDest =Long.parseLong(String.valueOf(tableDest.getValueAt(tableDest.getSelectedRow(),0)) );
                        Warehouse warehouseDest = this.findOneById(idDest);
                        warehouses.add(warehouseOrig);
                        warehouses.add(warehouseDest);
                    }
                }
            }
        }
        return warehouses;
        
    }
}
