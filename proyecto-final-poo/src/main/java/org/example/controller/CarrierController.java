package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import org.example.model.Carrier;
import org.example.service.CarrierService;

import java.util.List;

public class CarrierController {
    private CarrierService carrierService;

    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    public void create(Carrier carrier){
        carrierService.save(carrier);
    }

    public Carrier findOne(String cuit){
        return carrierService.findOne(cuit);
    }

    public void delete(String cuit) throws NonexistentEntityException{
        carrierService.delete(cuit);
    }

    public List<Carrier> findAll(){
       return carrierService.findAll();
    }

    public void upDate(Carrier carrier) throws Exception {
        carrierService.upDate(carrier);
    }

}
