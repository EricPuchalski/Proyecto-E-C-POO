package org.example.service;

import org.example.dao.ProductRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements CRUD<Product>{
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    @Override
    public void save(Product t) {
        if (!(t.getSupplier().getName().isEmpty() || t.getCategory().getNombre().isEmpty() ||  t.getName().isEmpty())) {
            productRepository.create(t);
        }
    }

    @Override
     public void upDate(Product product) throws Exception {
        if (productRepository.findProduct(product.getId()) != null) {
            productRepository.edit(product);
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
