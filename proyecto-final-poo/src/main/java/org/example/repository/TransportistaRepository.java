//package org.example.repository;
//
//import org.example.model.Carrie;
//import org.example.model.Carrier;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TransportistaRepository implements CRUD<Carrier>{
//    private List<Carrier> carriers;
//    private List<Carrie> carrierTypes;
//    public TransportistaRepository() {
//        this.carriers = new ArrayList<>();
//        this.carrierTypes = new ArrayList<>();
//        upLoad();
//    }
//    @Override
//    public void upLoad() {
//        Carrie terrestre = new Carrie("Terrestre");
//        Carrie aereo = new Carrie("Aereo");
//        Carrie maritimo = new Carrie("Maritimo");
//
//        carrierTypes.add(aereo);
//        carrierTypes.add(maritimo);
//        carrierTypes.add(terrestre);
//
//        Carrier t1 = new Carrier("12321","Correo Argentino","12342", "dsads@gmail.com", terrestre);
//        Carrier t2 = new Carrier("3213","OCA","4352", "ds@gmail.com",aereo);
//        Carrier t3 = new Carrier("232","OCASA","7653432", "asd@gmail.com",aereo);
//        Carrier t4 = new Carrier("34","AMAZON","4235234", "34@gmail.com",maritimo);
//        Carrier t5 = new Carrier("676","DHL","12321", "dsadds@gmail.com",terrestre);
//
//        carriers.add(t1);
//        carriers.add(t2);
//        carriers.add(t3);
//        carriers.add(t4);
//        carriers.add(t5);
//
//    }
//
//    @Override
//    public void save(Carrier carrier) {
//        carriers.add(carrier);
//    }
//
//    @Override
//    public void upDate(Carrier carrier) {
//        Carrier carrierExistente = findOne(carrier.getCuit());
//        if (carrierExistente != null) {
//            carrierExistente.setName(carrier.getName());
//            carrierExistente.setPhone(carrier.getPhone());
//            carrierExistente.setEmail(carrier.getEmail());
//            carrierExistente.setType(carrier.getType());
//        }
//    }
//
//    @Override
//    public List<Carrier> findAll() {
//        List<Carrier>transportistasHabilitados = new ArrayList<>();
//        for(Carrier tr : carriers){
//            if(tr.getStatus() == Carrier.Status.ENABLED){
//                transportistasHabilitados.add(tr);
//            }
//        }
//        return transportistasHabilitados;
//    }
//
//
//    @Override
//    public Carrier findOne(String id) {
//        Carrier carrier = null;
//        for (Carrier tr : carriers){
//            if (tr.getCuit().equals(id)){
//                carrier = tr;
//            }
//        }
//        return carrier;
//    }
//
//    @Override
//    public void delete(String id) {
//        if (findOne(id) != null) {
//            findOne(id).setStatus(Carrier.Status.DISABLED);
//        }
//    }
//}
