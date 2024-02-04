package org.example.service;


import org.example.dao.SupplierRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Supplier;

import java.util.List;
import java.util.stream.Collectors;
import org.example.model.Product;

public class SupplierService implements CRUD<Supplier> {
    private SupplierRepository supplierRepository;

    public SupplierService() {
        this.supplierRepository = new SupplierRepository();
    }

    @Override
    public void save(Supplier t) {
        if (!(t.getCuit().isEmpty() || t.getName().isEmpty() ||  t.getAdress().isEmpty() || t.getPhone().isEmpty()||t.getEmail().isEmpty())) {
        supplierRepository.create(t);
        }
    }

    @Override
    public Supplier findOne(String cuit) {
    for (Supplier sp : supplierRepository.findSupplierEntities()) {
        if(cuit.equals(sp.getCuit())){
            return sp;
        }
        return null;
    }

    
    for (Supplier supplier : supplierRepository.findSupplierEntities()) {
        if (cuit.equals(supplier.getCuit())) {
            return supplier;
        }
    }
    return null;
}

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findSupplierEntities();
    }
    
    public List<Supplier> findAllSuppliersByCuit(String cuit) {
         if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }
        List<Supplier> suppliersFound = this.findAll()
                .stream()
                .filter(tr -> tr.getCuit().toLowerCase().startsWith(cuit))
                .collect(Collectors.toList());
        return suppliersFound;
    }

    @Override
    public void upDate(Supplier supplier) throws Exception {
        if (supplierRepository.findSupplier(supplier.getId()) != null) {
            supplierRepository.edit(supplier);
        }
    }

    @Override
    public void delete(String cuit) throws NonexistentEntityException {
        Supplier deleteSupplier = findOne(cuit);
        if (deleteSupplier != null) {
            supplierRepository.destroy(deleteSupplier.getId());
        }
    }
}
//package org.example.service;

//import org.example.model.Supplier;
//import org.example.repository.ProveedorRepository;

//import java.util.List;

//public class SupplierService implements CRUD<Supplier> {
//    ProveedorRepository proveedorRepository;

 //   public SupplierService(ProveedorRepository proveedorRepository) {
 //       this.proveedorRepository = proveedorRepository;
 //   }

  //  public void save(Supplier supplier) {
  //      if (findOne(supplier.getCuit()) == null) {
  //          proveedorRepository.save(supplier);
  //      }
  //  }

   // public List<Supplier> findAll() {
  //      return proveedorRepository.findAll();
  //  }



  //  public Supplier findOne(String cuit) {
  //      Supplier supplier = null;
  //      if (proveedorRepository.findOne(cuit) != null) {
  //          supplier = proveedorRepository.findOne(cuit);
  //      }
  //      return supplier;
  //  }



   // public void upDate(Supplier supplier) {
  //      if (findOne(supplier.getCuit()) != null) {
 //           proveedorRepository.upDate(supplier);
 //       }
 //   }

  //  public void delete(String cuit) {
 //       if (findOne(cuit) != null) {
  //          proveedorRepository.delete(cuit);
  //      }
 //   }
//}
