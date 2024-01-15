package org.example.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Deposit;
import org.example.model.Position;
import org.example.model.Sector;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class DepositoRepository implements CRUD<Deposit>{
    private List<Deposit> deposits;
    private SectorRepository sectorRepository;
    public DepositoRepository() {
        this.deposits = new ArrayList<>();
        this.sectorRepository = new SectorRepository();
        upLoad();
    }

    @Override
    public void upLoad() {
        Deposit deposit1 = new Deposit("1","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        Deposit deposit2 = new Deposit("2","Deposito Australia","San martin 2324","1232312","depositoAU@gmail.com", "Oceania", new Position(-22.593680,144.544854));
        Deposit deposit3 = new Deposit("3","Deposito Argentina","San juan 2324","4132","depositoAR@gmail.com", "America",  new Position(-34.537211,-58.547629));
        Deposit deposit4 = new Deposit("4", "Deposito Sudafrica", "Av. Colón 1234", "3512345678", "depositoSA@gmail.com", "Africa", new Position(-30.849319,24.201486));
        Deposit deposit5 = new Deposit("5", "Deposito España", "Av. San Martín 4321", "2612345678", "depositoES@gmail.com", "Europa",new Position(39.514578,-2.490630));


        deposit1.getSectors().addAll(sectorRepository.findAll());
        deposit2.getSectors().addAll(sectorRepository.findAll());
        deposit3.getSectors().addAll(sectorRepository.findAll());
        deposit4.getSectors().addAll(sectorRepository.findAll());
        deposit5.getSectors().addAll(sectorRepository.findAll());

        deposits.add(deposit1);
        deposits.add(deposit2);
        deposits.add(deposit3);
        deposits.add(deposit4);
        deposits.add(deposit5);
    }

    @Override
    public void save(Deposit deposit) {
        deposits.add(deposit);
    }

    @Override
    public void upDate(Deposit deposit) {
        if (findOne(deposit.getCode()) == null){
            deposit.setName(deposit.getName());
            deposit.setAdress(deposit.getAdress());
            deposit.setPhone(deposit.getPhone());
            deposit.setEmail(deposit.getEmail());
            deposit.setSectors(deposit.getSectors());
        }
    }

    @Override
    public List<Deposit> findAll() {
        List<Deposit>depositosHabilitados = new ArrayList<>();
        for(Deposit dr : deposits){
            if(dr.getStatus() == Deposit.Estado.ENABLED){
                depositosHabilitados.add(dr);
            }
        }
        return depositosHabilitados;
    }



    @Override
    public Deposit findOne(String id) {
        Deposit deposit = null;
        for (Deposit dr : deposits){
            if (dr.getCode().equals(id)){
                deposit = dr;
            }
        }
        return deposit;
    }

    @Override
    public void delete(String id) {
        if (findOne(id) != null) {
            findOne(id).setStatus(Deposit.Estado.DISABLED);
        }
    }
    public List<Sector> buscarSectoresDeUnDepositoPorCodigo(String codigo){
        List<Sector> sectoresDelDeposito = new ArrayList<>();
        Deposit deposit = findOne(codigo);
        for (Sector sector: deposit.getSectors()
        ) {
            sectoresDelDeposito.add(sector);
        }
        return sectoresDelDeposito;
    }
}
