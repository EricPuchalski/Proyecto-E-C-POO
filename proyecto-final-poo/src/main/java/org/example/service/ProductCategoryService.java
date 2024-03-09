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
public class ProductCategoryService{
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService() {
        this.productCategoryRepository = new ProductCategoryRepository();
    }

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }



    public List<ProductCategory> findAll() {
        return productCategoryRepository.findProductCategoryEntities();
    }

    
}
