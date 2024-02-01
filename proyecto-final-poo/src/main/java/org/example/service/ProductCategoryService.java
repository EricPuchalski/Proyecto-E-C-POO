/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import java.util.List;
import org.example.dao.ProductCategoryRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.ProductCategory;

/**
 *
 * @author ericp
 */
public class ProductCategoryService implements CRUD<ProductCategory>{
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService() {
        this.productCategoryRepository = new ProductCategoryRepository();
    }
    
    
    @Override
    public void save(ProductCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void upDate(ProductCategory t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductCategory findOne(String cuit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findProductCategoryEntities();
    }

    @Override
    public void delete(String cuit) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
