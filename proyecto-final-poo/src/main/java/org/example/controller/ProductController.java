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
    public Product create(Product product){
        return productService.save(product);
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

    public Product upDate(Product product) throws Exception{
        return productService.upDate(product);
    }

    public List<Product> findAllProductsByName(String name) {
        return productService.findAllProductsByName(name);
    }
    
    public Product findProductEnabledByCode(String code){
        return productService.findProductEnabledByCode(code);
    }
    public Product disableAccountByCuit(String code){
        return productService.disableProductByCode(code);
    }
    public List<Product> findAllEnabledEmployees(){
        return productService.findAllEnabledProducts()
            .stream()
            .filter(customer -> customer.getStatus().equals(Product.Status.ENABLED))
            .collect(Collectors.toList());
    }
}
