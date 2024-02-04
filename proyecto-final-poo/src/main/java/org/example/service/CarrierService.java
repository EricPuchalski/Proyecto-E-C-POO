package org.example.service;
//
//
import org.example.model.Carrier;
//import org.example.repository.TransportistaRepository;
//
import dao.CarrierRepository;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//
    public class CarrierService implements CRUD<Carrier>{

    public CarrierService() {
        this.carrierRepository = new CarrierRepository();
    }
        

 private CarrierRepository carrierRepository;

    @Override
    public void save(Carrier carrier) {
        if (!carrierRepository.findCarrierEntities().contains(carrier.getCuit())) {
            }else{ carrierRepository.create(carrier);
        }
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
        carriersFound = this.findAll()
        .stream()
        .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowerCaseCuit))
        .collect(Collectors.toList());
        
        return carriersFound;
     }
 
 
 
}
//    private Carrier carrier;
//
//
//    public CarrierService(TransportistaRepository transportistaRepository) {
//        this.transportistaRepository = transportistaRepository;
//    }
//
//    @Override
//    public void save(Carrier carrier) {
//        if (transportistaRepository.findOne(carrier.getCuit())== null) {
//            transportistaRepository.save(carrier);
//        }
//    }
//
//    @Override
//    public void upDate(Carrier carrier) {
//        if(findOne(carrier.getCuit()) != null){
//            transportistaRepository.upDate(carrier);
//        }
//    }
//
//    @Override
//    public Carrier findOne(String cuit) {
//        Carrier carrier = null;
//        if (transportistaRepository.findOne(cuit)!= null) {
//            carrier = transportistaRepository.findOne(cuit);
//
//        }
//        return carrier;
//    }
//
//
//    @Override
//    public List<Carrier> findAll() {
//        return transportistaRepository.findAll();
//    }
//
//
//    @Override
//    public void delete(String cuit) {
//        if (findOne(cuit)!= null){
//            transportistaRepository.delete(cuit);
//        }
//    }
//}