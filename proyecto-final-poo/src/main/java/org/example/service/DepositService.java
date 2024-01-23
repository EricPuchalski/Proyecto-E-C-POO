//package org.example.service;
//
//import org.example.model.Warehouse;
//import org.example.repository.DepositoRepository;
//
//import java.util.List;
//
//public class DepositService implements CRUD<Warehouse>{
//    private DepositoRepository depositoRepository;
//
//    public DepositService(DepositoRepository depositoRepository) {
//        this.depositoRepository = depositoRepository;
//    }
//
//    public void save(Warehouse deposit) {
//        if (findOne(deposit.getCode()) == null) {
//            depositoRepository.save(deposit);
//        }
//    }
//
//    public List<Warehouse> findAll() {
//       return depositoRepository.findAll();
//    }
//
//
//    public Warehouse findOne(String codigo) {
//        Warehouse deposit = null;
//        if (depositoRepository.findOne(codigo) != null) {
//            deposit = depositoRepository.findOne(codigo);
//        }
//        return deposit;
//    }
//
//
//    public void upDate(Warehouse deposit) {
//        if (findOne(deposit.getCode()) != null) {
//            depositoRepository.upDate(deposit);
//        }
//    }
//
//    public void delete(String codigo) {
//        if (findOne(codigo) != null) {
//            depositoRepository.delete(codigo);
//        }
//    }
//
//}
