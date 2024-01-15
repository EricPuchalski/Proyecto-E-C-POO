package org.example.controller;

import org.example.model.Supplier;
import org.example.service.SupplierService;

import java.util.List;

public class SupplierController implements CRUD<Supplier> {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    public Supplier findOne(String cuit) {
        return supplierService.findOne(cuit);
    }

    public List<Supplier> findAll() {
        return supplierService.findAll();
    }


    public void delete(String cuit) {
        supplierService.delete(cuit);
    }

    public void create(Supplier supplier) {
        supplierService.save(supplier);
    }

    public void upDate(Supplier supplier) {
        supplierService.upDate(supplier);
    }

}
