package org.example.controller;
import java.util.ArrayList;
import org.example.model.Carrier;
import org.example.service.CarrierService;
import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.exceptions.NonexistentEntityException;

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
        public static List<String> getCarrierTypes() {
            List<String> carrierTypes = new ArrayList();
            carrierTypes.add(Carrier.CarrierType.MARITIME.toString());
            carrierTypes.add(Carrier.CarrierType.LAND.toString());
            carrierTypes.add(Carrier.CarrierType.AIR.toString());
            return carrierTypes;
        }
    
        public List<Carrier> findAllCarriersByCuit(String cuit){
        if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacÃ­o, retornar una lista vacÃ­a
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
