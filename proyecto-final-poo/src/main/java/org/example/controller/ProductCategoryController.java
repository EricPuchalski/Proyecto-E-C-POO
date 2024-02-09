/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;


import java.util.List;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.ProductCategory;
import org.example.service.ProductCategoryService;

/**
 *
 * @author ericp
 */
public class ProductCategoryController implements CRUD<ProductCategory>{
    private ProductCategoryService productCategoryService;

    public ProductCategoryController() {
        this.productCategoryService = new ProductCategoryService();
    }
    
    @Override
    public ProductCategory create(ProductCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductCategory findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }

    @Override
    public ProductCategory upDate(ProductCategory t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ProductCategory findByName(String name){
        ProductCategory pC = new ProductCategory();
        for (ProductCategory productCategory : this.findAll()) {
            if (productCategory.getNombre().equals(name)) {
                pC = productCategory;
            }
        }
        return pC;
    }
}
