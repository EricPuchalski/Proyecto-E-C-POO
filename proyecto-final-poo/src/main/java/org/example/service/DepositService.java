package org.example.service;

import org.example.model.Deposit;
import org.example.repository.DepositoRepository;

import java.util.List;

public class DepositService implements CRUD<Deposit>{
    private DepositoRepository depositoRepository;

    public DepositService(DepositoRepository depositoRepository) {
        this.depositoRepository = depositoRepository;
    }

    public void save(Deposit deposit) {
        if (findOne(deposit.getCode()) == null) {
            depositoRepository.save(deposit);
        }
    }

    public List<Deposit> findAll() {
       return depositoRepository.findAll();
    }


    public Deposit findOne(String codigo) {
        Deposit deposit = null;
        if (depositoRepository.findOne(codigo) != null) {
            deposit = depositoRepository.findOne(codigo);
        }
        return deposit;
    }


    public void upDate(Deposit deposit) {
        if (findOne(deposit.getCode()) != null) {
            depositoRepository.upDate(deposit);
        }
    }

    public void delete(String codigo) {
        if (findOne(codigo) != null) {
            depositoRepository.delete(codigo);
        }
    }

}
