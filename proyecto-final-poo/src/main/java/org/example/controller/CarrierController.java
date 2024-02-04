package org.example.controller;






import java.util.ArrayList;
import java.util.List;
import org.example.service.CarrierService;


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
         return carrierService.findAllCarriersByCuit(cuit);
        }

    }


