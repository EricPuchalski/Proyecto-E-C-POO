import org.example.dao.CustomerRepository;
import org.example.dao.ProductCategoryRepository;
import org.example.model.Customer;
import org.example.model.ProductCategory;
import org.example.service.CustomerService;
import org.example.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)

public class ProductCategoryRepositoryTest {
    @Mock
    public ProductCategoryRepository productCategoryRepository;
    @InjectMocks
    public ProductCategoryService productCategoryService;

    @Test
    public void findAllProductCategories(){
        ProductCategory computing = new ProductCategory("Computing");
        ProductCategory clean = new ProductCategory("Clean");
        ProductCategory home = new ProductCategory("Home");

        List<ProductCategory> productCategories = Arrays.asList(
                computing, clean, home

        );

        // Mock repository behavior
        when(productCategoryRepository.findProductCategoryEntities()).thenReturn(productCategories);

        // Call the service method
        List<ProductCategory> retrievedProductCategory= productCategoryService.findAll();

        // Assert results
        assertEquals(3, retrievedProductCategory.size());
        assertEquals("Computing", retrievedProductCategory.get(0).getNombre());
        assertEquals("Clean", retrievedProductCategory.get(1).getNombre());
        assertEquals("Home", retrievedProductCategory.get(2).getNombre());
    }
}
