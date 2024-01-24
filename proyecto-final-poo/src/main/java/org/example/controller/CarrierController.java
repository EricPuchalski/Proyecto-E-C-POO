package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import org.example.model.Carrier;
import org.example.service.CarrierService;

import java.util.List;
import java.util.stream.Collectors;

public class CarrierController {
    private CarrierService carrierService;

    public CarrierController() {
        this.carrierService = new CarrierService();
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
    
        public List<Carrier> findAllCarriersByCuit(String cuit){
        List<Carrier> carriersFound= new ArrayList<>();
        carriersFound = this.findAll()
        .stream()
        .filter(tr -> tr.getCuit().startsWith(cuit))
        .collect(Collectors.toList());
        
        if(!carriersFound.isEmpty()){
            return carriersFound;
        }
        return null;
    }

}
