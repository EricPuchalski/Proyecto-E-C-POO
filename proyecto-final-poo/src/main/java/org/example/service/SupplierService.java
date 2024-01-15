package org.example.service;

import org.example.model.Supplier;
import org.example.repository.ProveedorRepository;

import java.util.List;

public class SupplierService implements CRUD<Supplier> {
    ProveedorRepository proveedorRepository;

    public SupplierService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public void save(Supplier supplier) {
        if (findOne(supplier.getCuit()) == null) {
            proveedorRepository.save(supplier);
        }
    }

    public List<Supplier> findAll() {
        return proveedorRepository.findAll();
    }



    public Supplier findOne(String cuit) {
        Supplier supplier = null;
        if (proveedorRepository.findOne(cuit) != null) {
            supplier = proveedorRepository.findOne(cuit);
        }
        return supplier;
    }



    public void upDate(Supplier supplier) {
        if (findOne(supplier.getCuit()) != null) {
            proveedorRepository.upDate(supplier);
        }
    }

    public void delete(String cuit) {
        if (findOne(cuit) != null) {
            proveedorRepository.delete(cuit);
        }
    }
}
