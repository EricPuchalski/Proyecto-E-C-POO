package org.example.controller;

import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Supplier;
import org.example.service.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierController implements CRUD<Supplier> {

    private final SupplierService supplierService;

    public SupplierController() {
        this.supplierService = new SupplierService();
    }

    public boolean checkIfExistUniq(String cuit, String phone, String email) {
    return supplierService.checkIfExistUniq(cuit, phone, email);}
    public Supplier findOneByPhoneNumber(String phoneNumber) {
        return supplierService.findOneByPhoneNumber(phoneNumber);
    }
    public Supplier checkIfExistUniq(String cuit, String phoneNumber){
        return new Supplier();
    }
    public Supplier findOne(String cuit) {
        return supplierService.findOne(cuit);
    }

    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    public void delete(String cuit) throws NonexistentEntityException {
        supplierService.delete(cuit);
    }

    public Supplier create(Supplier supplier) {
        return supplierService.save(supplier);
    }

    public Supplier upDate(Supplier supplier) throws Exception {
        return supplierService.upDate(supplier);
    }

    public List<Supplier> findAllByCuit(String cuit) {
        return supplierService.findAllSuppliersByCuit(cuit);
    }

    public Supplier findSupplierEnabledByCuit(String cuit) {
        return supplierService.findSupplierEnabledByCuit(cuit);
    }

    public void disableAccountByCuit(String cuit) {
        supplierService.disableAccountByCuit(cuit);
    }

    public List<Supplier> findAllEnabledEmployees() {
        return supplierService.findAllEnabledEmployees()
                .stream()
                .filter(supplier -> supplier.getStatus().equals(Supplier.Status.ENABLED))
                .collect(Collectors.toList());
    }
    public Supplier findSupplierEnabledByPhone(String phone) {
        return supplierService.findSupplierEnabledByPhone(phone);
    }

    public Supplier findSupplierEnabledByEmail(String email) {
   return supplierService.findSupplierEnabledByEmail(email);
    }
}
