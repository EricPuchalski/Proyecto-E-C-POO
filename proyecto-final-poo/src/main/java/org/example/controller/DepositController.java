package org.example.controller;

import org.example.model.Deposit;
import org.example.service.DepositService;

import java.util.List;

public class DepositController implements CRUD<Deposit>{
    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @Override
    public void create(Deposit deposit) {
        depositService.save(deposit);
    }

    @Override
    public Deposit findOne(String id) {
        return depositService.findOne(id);
    }

    @Override
    public List<Deposit> findAll() {
        return depositService.findAll();
    }


    @Override
    public void upDate(Deposit deposit) {
        depositService.upDate(deposit);

    }

    @Override
    public void delete(String id) {
        depositService.delete(id);
    }
}
