package org.example.service;

import org.example.dao.ProductRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Product;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductService implements CRUD<Product>{
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    @Override
       public void save(Product product) {

            productRepository.create(product);

    }

    @Override
     public void upDate(Product product) {
        if (productRepository.findProduct(product.getId()) != null) {
            try {
                productRepository.edit(product);
            } catch (Exception ex) {
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    public void delete(String code) {
        Product deleteProduct = findOne(code);
        if (deleteProduct != null) {
            try {
                productRepository.destroy(deleteProduct.getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
