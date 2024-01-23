//package org.example.repository;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.example.controller.SupplierController;
//import org.example.model.ProductCategory;
//import org.example.model.Product;
//import org.example.service.SupplierService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Setter
//@Getter
//public class ProductoRepository implements CRUD<Product>{
//    private List<Product> products;
//    SupplierController supplierController = new SupplierController(new SupplierService(new ProveedorRepository()));
//
//
//    public ProductoRepository() {
//        this.products = new ArrayList<>();
//        upLoad();
//    }
//
//    @Override
//    public void upLoad() {
//        ProductCategory informatica = new ProductCategory("Informatica");
//        ProductCategory limpieza = new ProductCategory("Limpieza");
//        ProductCategory hogar = new ProductCategory("Hogar");
//        ProductCategory jardin = new ProductCategory("Jardin");
//        ProductCategory electronica = new ProductCategory("Electronica");
//        ProductCategory juguete = new ProductCategory("Juguete");
//
//        Product p1 = new Product("1", "Monitor", 0.5, 0.6, 2, 3, informatica, supplierController.findOne("0001"));
//        Product p2 = new Product("2", "Mouse", 0.01, 0.005, 2, 0.198, informatica, supplierController.findOne("0002"));
//        Product p3 = new Product("3", "Pava eléctrica", 0.5, 0.04, 2, 2, electronica, supplierController.findOne("0003"));
//        Product p4 = new Product("4", "Peluche oso", 0.9, 1, 2, 0.6, juguete, supplierController.findOne("0004"));
//        Product p5 = new Product("5", "Escoba", 0.03, 2, 2, 0.5, hogar, supplierController.findOne("0005"));
//        Product p6 = new Product("6", "Silla", 1, 1.4, 2, 6.4, hogar, supplierController.findOne("0001"));
//        Product p7 = new Product("7", "Toalla", 1, 2, 2, 0.1, hogar, supplierController.findOne("0002"));
//        Product p8 = new Product("8", "Sábana", 2, 2.4, 2, 0.7, hogar, supplierController.findOne("0003"));
//        Product p9 = new Product("9", "Teclado", 0.05, 0.005, 2, 1, informatica, supplierController.findOne("0004"));
//        Product p10 = new Product("10", "Estante", 2, 1.1, 2, 10, hogar, supplierController.findOne("0005"));
//        Product p11 = new Product("11", "Detergente", 0.4, 0.05, 2, 0.2, limpieza, supplierController.findOne("0001"));
//        Product p12 = new Product("12", "Peluche Barney", 0.7, 1.7, 2, 0.4, juguete, supplierController.findOne("0002"));
//        Product p13 = new Product("13", "Mousepad", 0.4, 2, 2, 0.01, informatica, supplierController.findOne("0003"));
//        Product p14 = new Product("14", "Bombilla", 0.0001, 3, 2, 0.01, hogar, supplierController.findOne("0004"));
//        Product p15 = new Product("15", "Maceta", 0.5, 3, 2, 1.3, jardin, supplierController.findOne("0005"));
//        Product p16 = new Product("16", "Gnomo de jardín", 1, 3, 2, 3, jardin, supplierController.findOne("0001"));
//        Product p17 = new Product("17", "Licuadora", 0.3, 3, 2, 2.5, electronica, supplierController.findOne("0002"));
//        Product p18 = new Product("18", "Cafetera", 0.2, 3, 2, 2, electronica, supplierController.findOne("0003"));
//        Product p19 = new Product("19", "Muñeco Goku", 1.2, 3, 2, 1, juguete, supplierController.findOne("0004"));
//        Product p20 = new Product("20", "Muñeco Pikachu", 0.09, 3, 2, 0.6, juguete, supplierController.findOne("0005"));
//
//
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//        products.add(p4);
//        products.add(p5);
//        products.add(p6);
//        products.add(p7);
//        products.add(p8);
//        products.add(p9);
//        products.add(p10);
//        products.add(p11);
//        products.add(p12);
//        products.add(p13);
//        products.add(p14);
//        products.add(p15);
//        products.add(p16);
//        products.add(p17);
//        products.add(p18);
//        products.add(p19);
//        products.add(p20);
//
//    }
//
//    @Override
//    public void save(Product product) {
//        products.add(product);
//    }
//
//    @Override
//    public void upDate(Product product) {
//        if (findOne(product.getCode()) != null){
//            findOne(product.getCode()).setName(product.getName());
//            findOne(product.getCode()).setHeight(product.getHeight());
//            findOne(product.getCode()).setWidth(product.getWidth());
//            findOne(product.getCode()).setWeight(product.getWeight());
//            findOne(product.getCode()).setLength(product.getLength());
//            findOne(product.getCode()).setSupplier(product.getSupplier());//**
//        }
//    }
//
//    @Override
//    public List<Product> findAll() {
//        List<Product>productosHabilitados = new ArrayList<>();
//        for (Product pr : products){
//            if(pr.getStatus().equals(Product.Status.ENABLED)){
//                productosHabilitados.add(pr);
//            }
//        }
//        return productosHabilitados;
//    }
//
//
//
//    @Override
//    public Product findOne(String id) {
//
//        Product product = null;
//        for (Product pr : products){
//            if (pr.getCode().equals(id) || pr.getName().equals(id)){
//                product = pr;
//            }
//        }
//        return product;
//    }
//
//    @Override
//    public void delete(String id) {
//        for (Product pr : products){
//            if (findOne(id) != null){
//                pr.setStatus(Product.Status.DISABLED);
//            }
//        }
//    }
//
//}
