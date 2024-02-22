
import org.example.dao.ProductRepository;
        import org.example.dao.exceptions.NonexistentEntityException;
        import org.example.model.Product;
        import org.example.model.ProductCategory;
        import org.example.model.Supplier;
        import org.example.service.ProductService;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertNotNull;
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
}