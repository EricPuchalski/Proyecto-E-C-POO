package org.example.service;
//
//
import java.util.ArrayList;
import org.example.model.Carrier;
//import org.example.repository.TransportistaRepository;
//

import org.example.dao.CarrierRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
//
    public class CarrierService implements CRUD<Carrier>{

    public CarrierService() {
        this.carrierRepository = new CarrierRepository();
    }
        

 private CarrierRepository carrierRepository;

    @Override
    public void save(Carrier carrier) {
        carrierRepository.create(carrier);
    }

    @Override
    public void upDate(Carrier carrier) throws Exception {
        if (carrierRepository.findCarrier(carrier.getId()) != null) {
            carrierRepository.edit(carrier);
        }
    }

    @Override
     public Carrier findOne(String cuit) {
        for (Carrier carrier : carrierRepository.findCarrierEntities()) {
            if (cuit.equals(carrier.getCuit())) {
                return carrier;
            }
        }
        return null;
    }


    @Override
   public List<Carrier> findAll() {
        return carrierRepository.findCarrierEntities();
    }

    @Override
     public void delete(String cuit) throws NonexistentEntityException {
        Carrier deleteCarrier = findOne(cuit);
        if (deleteCarrier != null) {
            carrierRepository.destroy(deleteCarrier.getId());
        }
    }
 
     public List<Carrier> findAllCarriersByCuit(String cuit){
         if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowerCaseCuit = cuit.toLowerCase();

        List<Carrier> carriersFound= new ArrayList<>();
        carriersFound = this.findAllEnabledCustomers()
        .stream()
        .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowerCaseCuit))
        .collect(Collectors.toList());
        
        return carriersFound;
     }
 
 
     public Carrier findCarrierEnabledByCuit(String cuit){
        Carrier carrierFound = carrierRepository.findCarrierEnabledByCuit(cuit);
        if (carrierFound.getStatus().equals(Carrier.Status.ENABLED)) {
                return carrierRepository.findCarrierEnabledByCuit(cuit);
            }
        return null;
    }
    public void disableAccountByCuit(String cuit){
        Carrier customer = carrierRepository.findCarrierEnabledByCuit(cuit);
        if (customer!=null) {
            try {
                carrierRepository.disableAccountByCuit(cuit);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CarrierService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List<Carrier> findAllEnabledCustomers(){
        return carrierRepository.findCarrierEntities()
            .stream()
            .filter(customer -> customer.getStatus().equals(Carrier.Status.ENABLED))
            .collect(Collectors.toList());
    }
}