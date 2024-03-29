package org.example.service;

import java.util.ArrayList;
import org.example.dao.ProductRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Product;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProductService implements CRUD<Product>{
    private ProductRepository productRepository=new ProductRepository();
    public ProductService(){

    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    

    @Override
    public Product save(Product t) {
        Product productExist = findProductEnabledByCode(t.getCode());
        if (!(t.getSupplier().getName().isEmpty() || t.getCategory().getNombre().isEmpty() ||  t.getName().isEmpty())) {
            if (productExist==null) {
                return productRepository.create(t);
            }
        }
        return null;
    }

    @Override
     public Product upDate(Product product) throws Exception {
        if (productRepository.findProduct(product.getId()) != null) {
           return productRepository.edit(product);
        }
        return null;
    }

    @Override
    public Product findOne(String code) {
        for (Product product : productRepository.findProductEntities()) {
            if (code.equals(product.getCode())) {
                return product;
            }
        }
        return null;
    }

    public Product findOneById(Long id){
        return productRepository.findProduct(id);
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findProductEntities();
    }

    @Override
    public void delete(String code) throws NonexistentEntityException {
        Product deleteProduct = findOne(code);
        if (deleteProduct != null) {
            productRepository.destroy(deleteProduct.getId());
        }
    }
    
    public List<Product> findAllProductsByName(String name){
                if (name == null || name.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }

        String lowercaseName = name.toLowerCase(); // Convertir el nombre de búsqueda a minúsculas

        List<Product> productsFound = this.findAll()
                .stream()
                .filter(tr -> tr.getName().toLowerCase().startsWith(lowercaseName))
                .collect(Collectors.toList());
        return productsFound;
    }

    public Product findProductEnabledByCode(String code){
        Product productFound = productRepository.findProductEnabledByCode(code);
        if (productFound != null && productFound.getStatus().equals(Product.Status.ENABLED)) {
            return productFound;
        }
        return null;
    }

    public Product disableProductByCode(String cuit){
        Product productFound = productRepository.findProductEnabledByCode(cuit);
        if (productFound!=null) {
            try {
                productRepository.disableAccountByCode(cuit);
                return productFound;
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public List<Product> findAllEnabledProducts(){
        return productRepository.findProductEntities()
            .stream()
            .filter(customer -> customer.getStatus().equals(Product.Status.ENABLED))
            .collect(Collectors.toList());
    }

}
  //  private ProductoRepository productoRepository;
  //  private boolean productoExistente;
  //  public ProductService(ProductoRepository productoRepository) {
 //       this.productoRepository = productoRepository;
 //   }

  //  public void save(Product product) {
  //      if (findOne(product.getCode()) == null) {
  //          productoRepository.save(product);
  //      }
 //   }

//    public List<Product> findAll() {
 //       return productoRepository.findAll();
   // }



  //  public Product findOne(String codigo) {
  //      Product product = null;
  //      if (productoRepository.findOne(codigo) != null) {
  ///          product = productoRepository.findOne(codigo);

  //      }
 //       return product;
 //   }


 //   public void upDate(Product product) {
 //       if (findOne(product.getCode()) != null) {
 //           productoRepository.upDate(product);
 //       }
//    }

 //   public void delete(String codigo) {
 ////           productoRepository.delete(codigo);
 //       }
  //  }

//}
