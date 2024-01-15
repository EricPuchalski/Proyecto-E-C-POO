package org.example.repository;

import org.example.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class ProveedorRepository implements CRUD<Supplier>{
    public List<Supplier> proveedores;

    public ProveedorRepository() {
        proveedores = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {
        Supplier p1 = new Supplier("0001","Apple","villa lugano", "123","manza@gmail");
        Supplier p2 = new Supplier("0002","Yamaha","Villa Cabello", "345","sancor@gmail");
        Supplier p3 = new Supplier("0003","Nike","villa cariñito", "678","nike@gmail");
        Supplier p4 = new Supplier("0004","Adidas","villa miseria", "910","adid@gmail");
        Supplier p5 = new Supplier("0005","Honda","villa 327", "012","honda@gmail");
        proveedores.add(p1);
        proveedores.add(p2);
        proveedores.add(p3);
        proveedores.add(p4);
        proveedores.add(p5);
    }

    @Override
    public void save(Supplier supplier) {
        proveedores.add(supplier);

    }

    @Override
    public void upDate(Supplier supplier) {
        if(findOne(supplier.getCuit()) != null){
            findOne(supplier.getCuit()).setName(supplier.getName());
            findOne(supplier.getCuit()).setAdress(supplier.getAdress());
            findOne(supplier.getCuit()).setPhone(supplier.getPhone());
            findOne(supplier.getCuit()).setEmail(supplier.getEmail());
        }

    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier>proveedoresHabilitados = new ArrayList<>();
        for(Supplier pr : proveedores){
            if(pr.getStatus() == Supplier.Status.ENABLED){
                proveedoresHabilitados.add(pr);
            }
        }
        return proveedoresHabilitados;
    }



    @Override
    public Supplier findOne(String cuit) {
        Supplier supplier = null;
        for (Supplier pr : proveedores){
            if (pr.getCuit().equals(cuit)){
                supplier = pr;
            }
        }
        return supplier;
    }

    @Override
    public void delete(String cuit) {
        if(findOne(cuit) != null){
            findOne(cuit).setStatus(Supplier.Status.DISABLED);
        }
    }
}
