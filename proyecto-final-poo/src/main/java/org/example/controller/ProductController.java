package org.example.controller;




import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.exceptions.NonexistentEntityException;

public class ProductController implements CRUD<Product>{
    private final ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }


    public Product findOneById(Long id){
        return productService.findOneById(id);

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

    public void delete(String codigo) throws NonexistentEntityException{
        productService.delete(codigo);
    }

    public void upDate(Product product) throws Exception{
        productService.upDate(product);
    }

    public List<Product> findAllProductsByName(String name) {
        return productService.findAllProductsByName(name);
    }
    
}
