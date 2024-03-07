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

public class CarrierService implements CRUD<Carrier> {
    public CarrierService() {
    }

    public CarrierService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }


    
    
    private CarrierRepository carrierRepository=new CarrierRepository();
    
    @Override
    public Carrier save(Carrier carrier) {
        if (!(carrier.getCuit().isEmpty() || carrier.getName().isEmpty() || carrier.getPhone().isEmpty())) {
            if (!(checkIfExistUniq(carrier.getCuit(), carrier.getPhone(), carrier.getEmail()))) {
                return carrierRepository.create(carrier);
            }
        }
        return null;
    }
    
    @Override
    public Carrier upDate(Carrier carrier) throws Exception {
        if (carrierRepository.findCarrier(carrier.getId()) != null) {
            return carrierRepository.edit(carrier);
        }
        return null;
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
    
    public boolean checkIfExistUniq(String cuit, String phone, String email) {
        Carrier carrierByCuit = findCarrierEnabledByCuit(cuit);
        Carrier carrierByEmail = findCarrierEnabledByEmail(email);
        Carrier carrierByPhone = findCarrierEnabledByPhone(phone);
        if (carrierByCuit != null || carrierByEmail != null || carrierByPhone != null) {
            return true;
        } else {
            return false;
        }
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
    
    public List<Carrier> findAllCarriersByCuit(String cuit) {
        if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        String lowerCaseCuit = cuit.toLowerCase();
        
        List<Carrier> carriersFound = new ArrayList<>();
        carriersFound = this.findAllEnabledCarriers()
                .stream()
                .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowerCaseCuit))
                .collect(Collectors.toList());
        
        return carriersFound;
    }

    public Carrier findCarrierEnabledByPhone(String phone) {
        for (Carrier cr : findAllEnabledCarriers()) {
            if (cr.getPhone().equals(phone)) {
                return cr;
            }
        }
        return null;
    }

    public Carrier findCarrierEnabledByEmail(String email) {
        for (Carrier cr : findAllEnabledCarriers()) {
            if (cr.getEmail().equals(email)) {
                return cr;
            }
        }
        return null;
    }
    
    public Carrier findCarrierEnabledByCuit(String cuit) {
        Carrier carrierFound = carrierRepository.findCarrierEnabledByCuit(cuit);
        if (carrierFound!=null) {
                    if (carrierFound.getStatus().equals(Carrier.Status.ENABLED)) {
            return carrierRepository.findCarrierEnabledByCuit(cuit);
        }
        }

        return null;
    }

    public Carrier disableAccountByCuit(String cuit) {
        Carrier carrier = carrierRepository.findCarrierEnabledByCuit(cuit);
        if (carrier != null) {
            try {
                return carrierRepository.disableAccountByCuit(cuit);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CarrierService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Carrier> findAllEnabledCarriers() {
        return carrierRepository.findCarrierEntities()
                .stream()
                .filter(carrier -> carrier.getStatus().equals(Carrier.Status.ENABLED))
                .collect(Collectors.toList());
    }


}
