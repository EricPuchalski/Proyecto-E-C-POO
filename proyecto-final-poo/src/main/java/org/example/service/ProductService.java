package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductoRepository;

import java.util.List;

public class ProductService implements CRUD<Product>{

    private ProductoRepository productoRepository;
    private boolean productoExistente;
    public ProductService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void save(Product product) {
        if (findOne(product.getCode()) == null) {
            productoRepository.save(product);
        }
    }

    public List<Product> findAll() {
        return productoRepository.findAll();
    }



    public Product findOne(String codigo) {
        Product product = null;
        if (productoRepository.findOne(codigo) != null) {
             product = productoRepository.findOne(codigo);

        }
        return product;
    }


    public void upDate(Product product) {
        if (findOne(product.getCode()) != null) {
            productoRepository.upDate(product);
        }
    }

    public void delete(String codigo) {
        if (findOne(codigo) != null) {
            productoRepository.delete(codigo);
        }
    }

}
