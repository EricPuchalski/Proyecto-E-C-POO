import org.example.dao.ProductRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Supplier;
import org.example.service.ProductService;
import org.example.model.Product.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepositoryMock;

    @Before
    public void setUp() {
        productRepositoryMock = mock(ProductRepository.class);
        productService = new ProductService(productRepositoryMock);
    }

    @Test
    public void testSaveProduct() {
        // Arrange
        ProductCategory category = new ProductCategory("Electronics"); // Nombre de la categoría de ejemplo
        Supplier supplier = new Supplier("12345678901", "Proveedor prueba", "Calle prueba 123", "123456789", "proveedor@example.com");
        Product newProduct = new Product("1", "New Product", 10.0, 5, 1, 19, category, supplier);
        when(productRepositoryMock.create(newProduct)).thenReturn(newProduct);

        // Act
        Product savedProduct = productService.save(newProduct);

        // Assert
        assertNotNull(savedProduct);
        assertEquals(newProduct, savedProduct);
        verify(productRepositoryMock).create(newProduct);
    }


    @Test
    public void testUpdateProduct() throws NonexistentEntityException, Exception {
        // Arrange
        ProductCategory category = new ProductCategory("Electronics"); // Nombre de la categoría de ejemplo
        Supplier supplier = new Supplier("12345678901", "Proveedor prueba", "Calle prueba 123", "123456789", "proveedor@example.com");
        Product existingProduct = new Product("1", "Existing Product", 20.0, 8, 2, 19, category, supplier);
        when(productRepositoryMock.findProduct(existingProduct.getId())).thenReturn(existingProduct);
        when(productRepositoryMock.edit(existingProduct)).thenReturn(existingProduct);

        // Act
        Product updatedProduct = productService.upDate(existingProduct);

        // Assert
        assertNotNull(updatedProduct);
        assertEquals(existingProduct, updatedProduct);
        verify(productRepositoryMock).edit(existingProduct);
        verify(productRepositoryMock).findProduct(existingProduct.getId());
    }
    @Test
    public void testFindOneProduct() {
        // Arrange
        String code = "1";
        Product expectedProduct = new Product(code, "Existing Product", 20.0, 8, 2, 19, null, null);
        when(productRepositoryMock.findProductEntities()).thenReturn(List.of(expectedProduct));

        // Act
        Product foundProduct = productService.findOne(code);

        // Assert
        assertNotNull(foundProduct);
        assertEquals(expectedProduct, foundProduct);
    }
    @Test
    public void testFindAllProducts() {
        // Arrange
        Product product1 = new Product("1", "Product 1", 10.0, 5, 1, 19, null, null);
        Product product2 = new Product("2", "Product 2", 15.0, 7, 2, 19, null, null);
        when(productRepositoryMock.findProductEntities()).thenReturn(List.of(product1, product2));

        // Act
        List<Product> foundProducts = productService.findAll();

        // Assert
        assertNotNull(foundProducts);
        assertEquals(2, foundProducts.size());
        assertEquals(product1, foundProducts.get(0));
        assertEquals(product2, foundProducts.get(1));
    }

    @Test
    public void testFindAllProductsByName() {
        // Arrange
        String name = "Product";
        Product product1 = new Product("1", "Product 1", 10.0, 5, 1, 19, null, null);
        Product product2 = new Product("2", "Product 2", 15.0, 7, 2, 19, null, null);
        when(productRepositoryMock.findProductEntities()).thenReturn(List.of(product1, product2));

        // Act
        List<Product> foundProducts = productService.findAllProductsByName(name);

        // Assert
        assertNotNull(foundProducts);
        assertEquals(2, foundProducts.size());
        assertEquals(product1, foundProducts.get(0));
        assertEquals(product2, foundProducts.get(1));
    }
    @Test
    public void testFindProductEnabledByCode() {
        // Arrange
        String code = "123456789012345"; // Código del producto como String
        Product expectedProduct = new Product(code, "Product to Delete", 10.0, 5, 1, 19, null, null);
        when(productRepositoryMock.findProductEnabledByCode(code)).thenReturn(expectedProduct);

        // Act
        Product foundProduct = productService.findProductEnabledByCode(code);

        // Assert
        assertNotNull(foundProduct);
        assertEquals(expectedProduct, foundProduct);
    }
    @Test
    public void testDisableProductByCode() throws NonexistentEntityException {
        // Arrange
        String code = "123456789012345"; // Código del producto como String
        Product productToDisable = new Product(code, "Product to Disable", 10.0, 5, 1, 19, null, null);
        when(productRepositoryMock.findProductEnabledByCode(code)).thenReturn(productToDisable);

        // Act
        Product disabledProduct = productService.disableProductByCode(code);

        // Assert
        assertNotNull(disabledProduct);
        assertEquals(productToDisable, disabledProduct);
        verify(productRepositoryMock).disableAccountByCode(code);
    }
    @Test
    public void testSaveProductWithExistingCode() {
        // Arrange
        String existingCode = "1234567890";
        ProductCategory category = new ProductCategory("Electronics");
        Supplier supplier = new Supplier("12345678901", "Proveedor prueba", "Calle prueba 123", "123456789", "proveedor@example.com");
        Product existingProduct = new Product(existingCode, "Existing Product", 20.0, 8, 2, 19, category, supplier);
        when(productRepositoryMock.findProductEnabledByCode(existingCode)).thenReturn(existingProduct);

        // Act
        Product newProductWithExistingCode = new Product(existingCode, "New Product with Existing Code", 30.0, 10, 3, 19, category, supplier);
        Product savedProduct = productService.save(newProductWithExistingCode);

        // Assert
        assertNull(savedProduct);
        verify(productRepositoryMock, never()).create(any(Product.class));
    }
    @Test
    public void testDeleteProduct() throws NonexistentEntityException {
        // Arrange
        String code = "1";
        Product productToDelete = new Product(code, "Product to Delete", 10.0, 5, 1, 19, null, null);
        when(productRepositoryMock.findProductEnabledByCode(code)).thenReturn(productToDelete);

        // Act
        productService.delete(code);

        // Assert
        if (productToDelete != null && productToDelete.getId() != null) {
            verify(productRepositoryMock).destroy(productToDelete.getId());
        }
    }


    @Test
    public void testUpdateNonExistingProduct() throws NonexistentEntityException, Exception {
        // Arrange
        String nonExistingCode = "999";
        Product nonExistingProduct = new Product(nonExistingCode, "Non Existing Product", 30.0, 15, 3, 19, null, null);
        when(productRepositoryMock.findProduct(nonExistingProduct.getId())).thenReturn(null);

        // Act
        Product updatedProduct = productService.upDate(nonExistingProduct);

        // Assert
        assertNull(updatedProduct);
    }

    @Test
    public void testFindProductEnabledByNonexistentCode() {
        // Arrange
        String nonExistingCode = "999";
        when(productRepositoryMock.findProductEnabledByCode(nonExistingCode)).thenReturn(null);

        // Act
        Product foundProduct = productService.findProductEnabledByCode(nonExistingCode);

        // Assert
        assertNull(foundProduct);
    }

    @Test
    public void testFindOneByIdWithExistingId() {
        // Arrange
        Long existingId = 1L;
        Product expectedProduct = new Product("1", "Existing Product", 20.0, 8, 2, 19, null, null);
        when(productRepositoryMock.findProduct(existingId)).thenReturn(expectedProduct);

        // Act
        Product foundProduct = productService.findOneById(existingId);

        // Assert
        assertNotNull(foundProduct);
        assertEquals(expectedProduct, foundProduct);
    }

    @Test
    public void testFindOneByIdWithNonexistentId() {
        // Arrange
        Long nonexistentId = -9223372036854775808L; // Long.MIN_VALUE
        when(productRepositoryMock.findProduct(nonexistentId)).thenReturn(null);

        // Act
        Product foundProduct = productService.findOneById(nonexistentId);

        // Assert
        assertNull(foundProduct);
    }
    @Test
    public void testFindAllEnabledProducts() {
        // Arrange
        Product product1 = new Product("1", "Product 1", 10.0, 5, 1, 19, null, null);
        product1.setStatus(Status.ENABLED);
        Product product2 = new Product("2", "Product 2", 15.0, 7, 2, 19, null, null);
        product2.setStatus(Status.DISABLED);
        Product product3 = new Product("3", "Product 3", 20.0, 8, 3, 19, null, null);
        product3.setStatus(Status.ENABLED);
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);

        // Mockear el comportamiento del repository
        when(productRepositoryMock.findProductEntities()).thenReturn(allProducts);

        // Act
        List<Product> enabledProducts = productService.findAllEnabledProducts();

        // Assert
        assertEquals(2, enabledProducts.size());
        assertEquals(product1, enabledProducts.get(0));
        assertEquals(product3, enabledProducts.get(1));
    }




}



