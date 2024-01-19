/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.example.model.Product;
import org.example.util.Conexion;

/**
 *
 * @author ericp
 */
public class ProductRepository implements Serializable {
    private ProductCategoryRepository productCategoryRepository;
    private SupplierRepository supplierRepository;

    public ProductRepository() {
        this.emf = Conexion.getEmf();
        this.productCategoryRepository = new ProductCategoryRepository();
        this.supplierRepository = new SupplierRepository();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void upLoad() {

        Product p1 = new Product("1", "Monitor", 0.5, 0.6, 1, 3, productCategoryRepository.findProductCategory(1l), supplierRepository.findSupplier(1l));
        Product p2 = new Product("2", "Mouse", 0.01, 0.005, 2, 0.198, productCategoryRepository.findProductCategory(1l), supplierRepository.findSupplier(2l));
        Product p3 = new Product("3", "Pava eléctrica", 0.5, 0.04, 3, 2, productCategoryRepository.findProductCategory(5l), supplierRepository.findSupplier(3l));
        Product p4 = new Product("4", "Peluche oso", 0.9, 1, 2, 0.6, productCategoryRepository.findProductCategory(6l), supplierRepository.findSupplier(4l));
        Product p5 = new Product("5", "Escoba", 0.03, 2, 2, 0.5, productCategoryRepository.findProductCategory(2l), supplierRepository.findSupplier(5l));
        Product p6 = new Product("6", "Silla", 1, 1.4, 2, 6.4, productCategoryRepository.findProductCategory(2l), supplierRepository.findSupplier(1l));
        Product p7 = new Product("7", "Toalla", 1, 2, 2, 0.1, productCategoryRepository.findProductCategory(2l), supplierRepository.findSupplier(2l));
        Product p8 = new Product("8", "Sábana", 2, 2.4, 2, 0.7, productCategoryRepository.findProductCategory(2l), supplierRepository.findSupplier(3l));
        Product p9 = new Product("9", "Teclado", 0.05, 0.005, 5, 1, productCategoryRepository.findProductCategory(1l), supplierRepository.findSupplier(4l));
        Product p10 = new Product("10", "Estante", 2.2, 1.1, 2, 10, productCategoryRepository.findProductCategory(2l), supplierRepository.findSupplier(4l));
        Product p11 = new Product("11", "Detergente", 0.4, 0.05, 2, 0.2, productCategoryRepository.findProductCategory(4l), supplierRepository.findSupplier(1l));
        Product p13 = new Product("13", "Mousepad", 0.4, 2, 2, 0.01, productCategoryRepository.findProductCategory(1l), supplierRepository.findSupplier(3l));
        Product p14 = new Product("14", "Bombilla", 0.0001, 3, 2, 0.01, productCategoryRepository.findProductCategory(5l), supplierRepository.findSupplier(4l));
        Product p16 = new Product("16", "Gnomo de jardín", 1.2, 3, 2, 3, productCategoryRepository.findProductCategory(3l), supplierRepository.findSupplier(1l));
        Product p17 = new Product("17", "Licuadora", 0.3, 3, 2, 2.5, productCategoryRepository.findProductCategory(5l), supplierRepository.findSupplier(2l));
        Product p18 = new Product("18", "Cafetera", 0.2, 3.3, 2, 2, productCategoryRepository.findProductCategory(5l), supplierRepository.findSupplier(3l));

        this.create(p1);
        this.create(p2);
        this.create(p3);
        this.create(p4);
        this.create(p5);
        this.create(p6);
        this.create(p7);
        this.create(p8);
        this.create(p9);
        this.create(p10);
        this.create(p11);
        this.create(p13);
        this.create(p14);
        this.create(p16);
        this.create(p17);
        this.create(p18);



    }
    public void create(Product product) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Product product) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            product = em.merge(product);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = product.getId();
                if (findProduct(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Product findProduct(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Product> rt = cq.from(Product.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
