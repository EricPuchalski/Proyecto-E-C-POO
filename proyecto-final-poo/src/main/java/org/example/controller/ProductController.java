package org.example.controller;

import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;

public class ProductController implements CRUD<Product>{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    public void create(Product product){
        productService.save(product);
    }

    public Product findOne(String codigo){
        return productService.findOne(codigo);
    }

    public List<Product> findAll(){
        return productService.findAll();
    }

    public void delete(String codigo){
        productService.delete(codigo);
    }

    public void upDate(Product product){
        productService.upDate(product);
    }


}
