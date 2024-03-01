import org.example.dao.SupplierRepository;
import org.example.model.Supplier;
import org.example.service.SupplierService;
import org.junit.Test;
import org.junit.Before;

import org.mockito.Mock;

import java.util.Collections;

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
}

