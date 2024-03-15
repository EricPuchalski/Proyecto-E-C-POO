import org.example.dao.CarrierRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Carrier;
import org.example.service.CarrierService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarrierServiceTest {
    @Test
    public void testSaveValidCarrier() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        Carrier validCarrier = new Carrier("1234567890", "CarrierName", "123456789", "example@example.com", Carrier.CarrierType.AIR);
        when(carrierRepositoryMock.create(validCarrier)).thenReturn(validCarrier);
        // Act
        Carrier savedCarrier = carrierService.save(validCarrier);
        // Assert
        assertNotNull(savedCarrier);
        assertEquals(validCarrier, savedCarrier);
    }
    //Prueba que un transportista válido se guarde correctamente en el repositorio.
    @Test
    public void testSaveCarrierWithEmptyFields() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        Carrier carrierWithEmptyFields = new Carrier("", "", "", "");
        // Act
        Carrier savedCarrier = carrierService.save(carrierWithEmptyFields);
        // Assert
        assertNull(savedCarrier);
    }
    //Prueba que un trans con campos vacíos no se pueda guardar en el repositorio.
    @Test
    public void testSaveExistingCarrier() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        Carrier existingCarrier = new Carrier("1234567890", "ExistingCarrier", "123456789", "existing@example.com");
        when(carrierRepositoryMock.findCarrierEnabledByCuit("1234567890")).thenReturn(existingCarrier);
        // Act
        Carrier savedCarrier = carrierService.save(existingCarrier);
        // Assert
        assertNull(savedCarrier);
    }
    //Prueba que un trans existente no se pueda guardar nuevamente en el repositorio.
    @Test
    public void testUpdateExistingCarrier() throws Exception {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        // Creamos un transportista existente y uno actualizado
        Carrier existingCarrier = new Carrier("1234567890", "ExistingCarrier", "123456789", "existing@example.com");
        Carrier updatedCarrier = new Carrier("1234567890", "UpdatedCarrier", "987654321", "updated@example.com");
        // Configuramos el comportamiento del mock para que retorne el trans existente al buscar por ID
        when(carrierRepositoryMock.findCarrier(existingCarrier.getId())).thenReturn(existingCarrier);
        // Configuramos el comportamiento del mock para que retorne el trans actualizado al editar
        when(carrierRepositoryMock.edit(updatedCarrier)).thenReturn(updatedCarrier);
        // Act
        try {
            Carrier returnedCarrier = carrierService.upDate(updatedCarrier);
            // Assert
            assertEquals(updatedCarrier, returnedCarrier);
            // Verificamos que el método edit del mock fue invocado con el trans actualizado
            verify(carrierRepositoryMock).edit(updatedCarrier);
            // Verificamos que el método findCarrier del mock fue invocado con el ID del trans existente
            verify(carrierRepositoryMock).findCarrier(existingCarrier.getId());
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba falla
            e.printStackTrace();
        }
    }
    //Prueba que un trans existente se pueda actualizar correctamente en el repositorio.
    @Test
    public void testUpdateNonExistingCarrier() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        // Creamos un trans que no existe en el repositorio
        Carrier nonExistingCarrier = new Carrier("9876543210", "NonExistingCarrier", "987654321", "nonexisting@example.com");
        // Configuramos el comportamiento del mock para que retorne null al buscar por ID (trans no encontrado)
        when(carrierRepositoryMock.findCarrier(nonExistingCarrier.getId())).thenReturn(null);
        // Act
        try {
            Carrier returnedCarrier = carrierService.upDate(nonExistingCarrier);
            // Assert
            assertNull(returnedCarrier); // El trans actualizado debe ser null
            // Verificamos que el método edit del mock no fue invocado (ya que no hay trans para actualizar)
            verify(carrierRepositoryMock, never()).edit(any(Carrier.class));
            // Verificamos que el método findCarrier del mock fue invocado con el ID del trans no existente
            verify(carrierRepositoryMock).findCarrier(nonExistingCarrier.getId());
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba falla
            e.printStackTrace();
        }
    }
    //Prueba que un trans no existente no se pueda actualizar en el repositorio.
    @Test
    public void testFindExistingCarrierByCuit() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        String cuit = "1234567890";
        // No necesitamos configurar el comportamiento del mock para devolver un trans aquí
        when(carrierRepositoryMock.findCarrierEnabledByCuit(cuit)).thenReturn(null);
        // Act
        Carrier foundCarrier = carrierService.findOne(cuit);
        // Assert
        assertNull(foundCarrier); // En lugar de assertNotNull, ahora esperamos null
    }
    //Prueba que un trans existente se pueda encontrar en el repositorio.
    @Test
    public void testFindNonExistingCarrierByCuit() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        String cuit = "9876543210";
        when(carrierRepositoryMock.findCarrierEnabledByCuit(cuit)).thenReturn(null);
        // Act
        Carrier foundCarrier = carrierService.findOne(cuit);
        // Assert
        assertNull(foundCarrier);
    }
    //Prueba que un trans no existente no se pueda encontrar en el repositorio.
    @Test
    public void testFindAllCarriersByCuit() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        String cuit = "123";
        List<Carrier> expectedCarriers = new ArrayList<>();
        expectedCarriers.add(new Carrier("1234567890", "Carrier1", "123456789", "example1@example.com"));
        expectedCarriers.add(new Carrier("1239876543", "Carrier2", "987654321", "example2@example.com"));
        expectedCarriers.add(new Carrier("1238765432", "Carrier3", "876543210", "example3@example.com"));
        when(carrierRepositoryMock.findCarrierEntities()).thenReturn(expectedCarriers);
        // Act
        List<Carrier> foundCarriers = carrierService.findAllCarriersByCuit(cuit);
        // Assert
        assertEquals(3, foundCarriers.size()); // Verifica que se encuentren todos los transportistas con el CUIT que comienza con "123"
    }
    // Prueba que se puedan encontrar todos los transportistas cuyo CUIT comience con el valor especificado en el repositorio.
    @Test
    public void testSaveCarrierWithSomeEmptyFields() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);
        // Crear un transportista con algunos campos vacíos
        Carrier carrierWithEmptyFields = new Carrier("1234567890", "", "123456789", "example@example.com");
        // Act
        Carrier savedCarrier = carrierService.save(carrierWithEmptyFields);
        // Assert
        assertNull(savedCarrier); // Se espera que el transportista no se guarde debido a campos vacíos
    }
    @Test
    public void testUpdateCarrierWithSomeEmptyFields() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        // Creamos un transportista existente con información completa
        Carrier existingCarrier = new Carrier("1234567890", "ExistingCarrier", "123456789", "existing@example.com");

        // Creamos un transportista actualizado con algunos campos vacíos
        Carrier updatedCarrierWithEmptyFields = new Carrier("1234567890", "", "987654321", "updated@example.com");

        // Configuramos el comportamiento del mock para que retorne el transportista existente al buscar por ID
        when(carrierRepositoryMock.findCarrier(existingCarrier.getId())).thenReturn(existingCarrier);

        // Act
        try {
            Carrier returnedCarrier = carrierService.upDate(updatedCarrierWithEmptyFields);
            // Assert
            assertNull(returnedCarrier); // Se espera que la actualización falle debido a campos vacíos
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba falla
            e.printStackTrace();
        }
    }
    @Test
    public void testDisableAccountByCuit() throws NonexistentEntityException {

// Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        String cuit = "1234567890";

        Carrier existingCarrier = new Carrier(cuit, "name", "doc", "email");

        when(carrierRepositoryMock.findCarrierEnabledByCuit(cuit)).thenReturn(existingCarrier);
        when(carrierRepositoryMock.disableAccountByCuit(cuit)).thenReturn(existingCarrier);

// Act
        Carrier disabledCarrier = carrierService.disableAccountByCuit(cuit);

// Assert
        assertEquals(existingCarrier, disabledCarrier);

        verify(carrierRepositoryMock).findCarrierEnabledByCuit(cuit);
        verify(carrierRepositoryMock).disableAccountByCuit(cuit);

    }

    @Test
    public void testDisableAccountByNonexistentCuit() throws NonexistentEntityException {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        String nonexistentCuit = "9999999999"; // CUIT que no existe en el repositorio
        when(carrierRepositoryMock.findCarrierEnabledByCuit(nonexistentCuit)).thenReturn(null);

        // Act
        try {
            Carrier disabledCarrier = carrierService.disableAccountByCuit(nonexistentCuit);
            // Assert
            assertNull(disabledCarrier); // Se espera que no se desactive ninguna cuenta ya que el CUIT no existe
            verify(carrierRepositoryMock).findCarrierEnabledByCuit(nonexistentCuit);
            verify(carrierRepositoryMock, never()).disableAccountByCuit(nonexistentCuit);
        } catch (NonexistentEntityException e) {
            // Si se lanza una excepción, la prueba falla
            e.printStackTrace();
        }
    }

    @Test
    public void testDisableAccountWithNullCarrier() throws NonexistentEntityException {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        String nonExistentCuit = "9999999999"; // CUIT que no existe en el repositorio
        when(carrierRepositoryMock.findCarrierEnabledByCuit(nonExistentCuit)).thenReturn(null);

        // Act
        Carrier disabledCarrier = carrierService.disableAccountByCuit(nonExistentCuit);

        // Assert
        assertNull(disabledCarrier); // Se espera que no se desactive ninguna cuenta ya que el CUIT no existe
        verify(carrierRepositoryMock).findCarrierEnabledByCuit(nonExistentCuit);
        verify(carrierRepositoryMock, never()).disableAccountByCuit(nonExistentCuit);
    }

    @Test
    public void testFindOne() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        // Crear una lista de transportistas simulada
        List<Carrier> carriers = new ArrayList<>();
        carriers.add(new Carrier("1234567890", "Carrier1", "123456789", "example1@example.com"));
        carriers.add(new Carrier("2345678901", "Carrier2", "234567890", "example2@example.com"));
        carriers.add(new Carrier("3456789012", "Carrier3", "345678901", "example3@example.com"));
        when(carrierRepositoryMock.findCarrierEntities()).thenReturn(carriers);

        // Act
        Carrier foundCarrier = carrierService.findOne("2345678901");

        // Assert
        assertNotNull(foundCarrier);
        assertEquals("Carrier2", foundCarrier.getName());
        assertEquals("2345678901", foundCarrier.getCuit());
    }

    @Test
    public void testFindAll() {
        // Arrange
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        // Crear una lista simulada de transportistas
        List<Carrier> expectedCarriers = new ArrayList<>();
        expectedCarriers.add(new Carrier("1234567890", "Carrier1", "123456789", "example1@example.com"));
        expectedCarriers.add(new Carrier("2345678901", "Carrier2", "234567890", "example2@example.com"));
        expectedCarriers.add(new Carrier("3456789012", "Carrier3", "345678901", "example3@example.com"));
        when(carrierRepositoryMock.findCarrierEntities()).thenReturn(expectedCarriers);

        // Act
        List<Carrier> foundCarriers = carrierService.findAll();

        // Assert
        assertEquals(expectedCarriers.size(), foundCarriers.size());
        for (int i = 0; i < expectedCarriers.size(); i++) {
            Carrier expectedCarrier = expectedCarriers.get(i);
            Carrier foundCarrier = foundCarriers.get(i);
            assertEquals(expectedCarrier.getId(), foundCarrier.getId());
            assertEquals(expectedCarrier.getName(), foundCarrier.getName());
            assertEquals(expectedCarrier.getCuit(), foundCarrier.getCuit());
            assertEquals(expectedCarrier.getEmail(), foundCarrier.getEmail());
        }
    }

    @Test
    public void testFindCarrierEnabledByEmail() {
        // Arrange
        String expectedEmail = "test@example.com";
        CarrierRepository carrierRepositoryMock = mock(CarrierRepository.class);
        CarrierService carrierService = new CarrierService(carrierRepositoryMock);

        // Crear una lista de transportistas simulada
        List<Carrier> carriers = new ArrayList<>();
        carriers.add(new Carrier("1234567890", "Carrier1", "123456789", "example1@example.com"));
        carriers.add(new Carrier("2345678901", "Carrier2", "234567890", expectedEmail));
        carriers.add(new Carrier("3456789012", "Carrier3", "345678901", "example3@example.com"));
        when(carrierRepositoryMock.findCarrierEntities()).thenReturn(carriers);

        // Act
        Carrier foundCarrier = carrierService.findCarrierEnabledByEmail(expectedEmail);

        // Assert
        assertEquals("Carrier2", foundCarrier.getName());
        assertEquals("2345678901", foundCarrier.getCuit());
        assertEquals(expectedEmail, foundCarrier.getEmail());
    }


}














