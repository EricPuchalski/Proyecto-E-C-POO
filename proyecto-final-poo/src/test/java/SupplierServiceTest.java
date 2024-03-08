import org.example.dao.SupplierRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Supplier;
import org.example.service.SupplierService;
import org.junit.Test;
import org.junit.Before;

import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;

public class SupplierServiceTest {
    @Mock
    private SupplierRepository supplierRepositoryMock;

    private SupplierService supplierService;

    @Before
    public void setUp() {
        supplierRepositoryMock = mock(SupplierRepository.class);
        supplierService = new SupplierService(supplierRepositoryMock);
    }


    @Test
    public void testSaveValidSupplier() {
        // Arrange
        SupplierRepository supplierRepositoryMock = mock(SupplierRepository.class);
        SupplierService supplierService = new SupplierService(supplierRepositoryMock);
        Supplier validSupplier = new Supplier("12345678901", "Proveedor prueba", "Calle prueba 123", "123456789", "proveedor@example.com");
        when(supplierRepositoryMock.create(validSupplier)).thenReturn(validSupplier);
        // Act
        Supplier savedSupplier = supplierService.save(validSupplier);
        // Assert
        assertNotNull(savedSupplier);
        assertEquals(validSupplier, savedSupplier);
    }
    @Test
    public void testSaveSupplierWithEmptyFields() {
        // Arrange
        Supplier supplierWithEmptyFields = new Supplier("", "", "", "", "");

        // Act
        Supplier savedSupplier = supplierService.save(supplierWithEmptyFields);

        // Assert
        assertNull(savedSupplier);
    }

    @Test
    public void testSaveSupplierWithNullValues() {
        // Arrange
        Supplier supplierWithNullValues = new Supplier(null, null, null, null, null);

        // Act
        Supplier savedSupplier = supplierService.save(supplierWithNullValues);

        // Assert
        assertNull(savedSupplier);
    }

    @Test
    public void testSaveSupplierWithDuplicateCuit() {
        // Arrange
        Supplier existingSupplier = new Supplier("12345678901", "Existing Supplier", "Existing Address", "Existing Phone", "existing@example.com");
        when(supplierRepositoryMock.findSupplierEnabledByCuit(existingSupplier.getCuit())).thenReturn(existingSupplier);

        Supplier newSupplierWithDuplicateCuit = new Supplier("12345678901", "New Supplier", "New Address", "New Phone", "new@example.com");

        // Act
        Supplier savedSupplier = supplierService.save(newSupplierWithDuplicateCuit);

        // Assert
        assertNull(savedSupplier);
    }

    @Test
    public void testFindSupplierByCuit() {
        // Arrange
        String cuit = "12345678901";
        Supplier existingSupplier = new Supplier(cuit, "Existing Supplier", "Existing Address", "Existing Phone", "existing@example.com");

        // Configuración del mock para que devuelva el proveedor existente cuando se llame a findSupplierEnabledByCuit con el CUIT adecuado
        when(supplierRepositoryMock.findSupplierEnabledByCuit(cuit)).thenReturn(existingSupplier);

        // Act
        Supplier foundSupplier = supplierService.findSupplierEnabledByCuit(cuit);

        // Assert
        assertNotNull(foundSupplier);
        assertEquals(existingSupplier, foundSupplier);
    }

    @Test
    public void testFindSupplierByPhoneNumber() {
        // Arrange
        String phoneNumber = "Existing Phone";
        Supplier existingSupplier = new Supplier("12345678901", "Existing Supplier", "Existing Address", phoneNumber, "existing@example.com");
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.singletonList(existingSupplier));

        // Act
        Supplier foundSupplier = supplierService.findSupplierEnabledByPhone(phoneNumber);

        // Assert
        assertNotNull(foundSupplier);
        assertEquals(existingSupplier, foundSupplier);
    }
    @Test
    public void testDisableAccountByCuit() throws NonexistentEntityException {
        // Arrange
        String cuit = "12345678901";
        Supplier supplierToDisable = new Supplier(cuit, "Supplier to Disable", "Address", "123456789", "supplier@example.com");
        when(supplierRepositoryMock.findSupplierEnabledByCuit(cuit)).thenReturn(supplierToDisable);

        // Configurar el proveedor deshabilitado
        Supplier disabledSupplier = new Supplier(cuit, "Supplier to Disable", "Address", "123456789", "supplier@example.com");
        disabledSupplier.setStatus(Supplier.Status.DISABLED);
        when(supplierRepositoryMock.disableAccountByCuit(cuit)).thenReturn(disabledSupplier);

        // Act
        Supplier resultSupplier = supplierService.disableAccountByCuit(cuit);

        // Assert
        assertNotNull(resultSupplier);
        assertEquals(Supplier.Status.DISABLED, resultSupplier.getStatus());
        verify(supplierRepositoryMock).disableAccountByCuit(cuit);
    }




    @Test
    public void testFindOneByPhoneNumberNotFound() {
        // Arrange
        String phoneNumber = "987654321"; // un numero que no existe en erl repo
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.emptyList());

        // Act
        Supplier resultSupplier = supplierService.findOneByPhoneNumber(phoneNumber);

        // Assert
        assertNull(resultSupplier);
    }
    @Test
    public void testFindOneByPhoneNumber() {
        // Arrange
        String phoneNumber = "123456789";
        Supplier supplier = new Supplier("12345678901", "Supplier", "Address", phoneNumber, "supplier@example.com");
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.singletonList(supplier));

        // Act
        Supplier resultSupplier = supplierService.findOneByPhoneNumber(phoneNumber);

        // Assert
        assertNotNull(resultSupplier);
        assertEquals(supplier, resultSupplier);
    }
    @Test
    public void testFindAllSuppliersByCuit() {
        // Arrange
        String cuit = "123";
        List<Supplier> suppliers = Arrays.asList(
                new Supplier("12345678901", "Supplier1", "Address1", "123456789", "supplier1@example.com"),
                new Supplier("12345678902", "Supplier2", "Address2", "123456789", "supplier2@example.com"),
                new Supplier("12345678903", "Supplier3", "Address3", "123456789", "supplier3@example.com")
        );
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(suppliers);

        // Act
        List<Supplier> resultSuppliers = supplierService.findAllSuppliersByCuit(cuit);

        // Assert
        assertNotNull(resultSuppliers);
        assertEquals(3, resultSuppliers.size());
    }

    @Test
    public void testFindAllSuppliersByCuitEmpty() {
        // Arrange
        String cuit = ""; // CUIT vacío
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.emptyList());

        // Act
        List<Supplier> resultSuppliers = supplierService.findAllSuppliersByCuit(cuit);

        // Assert
        assertNotNull(resultSuppliers);
        assertTrue(resultSuppliers.isEmpty());
    }
    @Test
    public void testFindOneByCuit() {
        // Arrange
        String cuit = "12345678901";
        Supplier supplier = new Supplier("12345678901", "Supplier", "Address", "123456789", "supplier@example.com");
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.singletonList(supplier));

        // Act
        Supplier resultSupplier = supplierService.findOne(cuit);

        // Assert
        assertNotNull(resultSupplier);
        assertEquals(supplier, resultSupplier);
    }

    @Test
    public void testFindOneByCuitNotFound() {
        // Arrange
        String cuit = "987654321"; // Un CUIT que no existe en el repositorio
        when(supplierRepositoryMock.findSupplierEntities()).thenReturn(Collections.emptyList());

        // Act
        Supplier resultSupplier = supplierService.findOne(cuit);

        // Assert
        assertNull(resultSupplier);
    }

}



