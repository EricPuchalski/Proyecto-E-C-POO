package org.example.controller;


import java.util.ArrayList;
import org.example.model.Warehouse;


import java.util.List;
import javax.swing.JTable;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.service.WarehouseService;

public class WarehouseController implements CRUD<Warehouse>{
    private WarehouseService warehouseService;

    public WarehouseController() {
        this.warehouseService = new WarehouseService();
    }

    @Override
    public Warehouse create(Warehouse deposit) {
        return warehouseService.save(deposit);
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
    public Warehouse upDate(Warehouse deposit) throws Exception {
        return warehouseService.upDate(deposit);

    }

    @Override
    public void delete(String id) throws NonexistentEntityException {
        warehouseService.delete(id);
    }
    public List<Warehouse> findAllWarehousesByEmail(String email){
        return warehouseService.findAllWarehousesByEmail(email);

    }
        public List<Warehouse> findAllEnabledWarehouses(){
        return warehouseService.findAllEnabledWarehouses();
    }
    public Warehouse findWarehouseEnabledByCode(String email){
        return warehouseService.findWarehouseEnabledByCode(email);
    }
    public void disableAccountByCuit(String email){
        warehouseService.disableAccountByEmail(email);
    }
            public Warehouse findWarehouseEnabledByPhone(String phone){
                return warehouseService.findWarehouseEnabledByPhone(phone);
    }
        public Warehouse findWarehouseEnabledByEmail(String email){
            return warehouseService.findWarehouseEnabledByEmail(email);
    }
        public boolean checkIfExistUniq(String code, String phone, String email) {
        return warehouseService.checkIfExistUniq(code, phone, email);}
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
