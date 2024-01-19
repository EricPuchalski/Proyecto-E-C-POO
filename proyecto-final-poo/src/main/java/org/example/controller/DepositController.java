//package org.example.controller;
//
//import org.example.model.Warehouse;
//import org.example.service.DepositService;
//
//import java.util.List;
//
//public class DepositController implements CRUD<Warehouse>{
//    private DepositService depositService;
//
//    public DepositController(DepositService depositService) {
//        this.depositService = depositService;
//    }
//
//    @Override
//    public void create(Warehouse deposit) {
//        depositService.save(deposit);
//    }
//
//    @Override
//    public Warehouse findOne(String id) {
//        return depositService.findOne(id);
//    }
//
//    @Override
//    public List<Warehouse> findAll() {
//        return depositService.findAll();
//    }
//
//
//    @Override
//    public void upDate(Warehouse deposit) {
//        depositService.upDate(deposit);
//
//    }
//
//    @Override
//    public void delete(String id) {
//        depositService.delete(id);
//    }
//}
