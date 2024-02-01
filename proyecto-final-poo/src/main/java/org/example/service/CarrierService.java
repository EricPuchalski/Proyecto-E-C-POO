package org.example.service;
//
//
import org.example.model.Carrier;
//import org.example.repository.TransportistaRepository;
//
import org.example.dao.CarrierRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import java.util.List;
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
 
 
 
 
 
}