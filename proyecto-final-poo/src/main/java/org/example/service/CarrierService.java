//package org.example.service;
//
//
//import org.example.model.Carrier;
//import org.example.repository.TransportistaRepository;
//
//import java.util.List;
//
//public class CarrierService implements CRUD<Carrier>{
//
//    private TransportistaRepository transportistaRepository;
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