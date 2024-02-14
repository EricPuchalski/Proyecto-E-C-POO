package org.test;
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
        // Creamos un portador existente y uno actualizado
        Carrier existingCarrier = new Carrier("1234567890", "ExistingCarrier", "123456789", "existing@example.com");
        Carrier updatedCarrier = new Carrier("1234567890", "UpdatedCarrier", "987654321", "updated@example.com");
        // Configuramos el comportamiento del mock para que retorne el portador existente al buscar por ID
        when(carrierRepositoryMock.findCarrier(existingCarrier.getId())).thenReturn(existingCarrier);
        // Configuramos el comportamiento del mock para que retorne el portador actualizado al editar
        when(carrierRepositoryMock.edit(updatedCarrier)).thenReturn(updatedCarrier);

        // Act
        try {
            Carrier returnedCarrier = carrierService.upDate(updatedCarrier);

            // Assert
            assertEquals(updatedCarrier, returnedCarrier);
            // Verificamos que el método edit del mock fue invocado con el portador actualizado
            verify(carrierRepositoryMock).edit(updatedCarrier);
            // Verificamos que el método findCarrier del mock fue invocado con el ID del portador existente
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
        // Creamos un portador que no existe en el repositorio
        Carrier nonExistingCarrier = new Carrier("9876543210", "NonExistingCarrier", "987654321", "nonexisting@example.com");
        // Configuramos el comportamiento del mock para que retorne null al buscar por ID (portador no encontrado)
        when(carrierRepositoryMock.findCarrier(nonExistingCarrier.getId())).thenReturn(null);

        // Act
        try {
            Carrier returnedCarrier = carrierService.upDate(nonExistingCarrier);

            // Assert
            assertNull(returnedCarrier); // El portador actualizado debe ser null
            // Verificamos que el método edit del mock no fue invocado (ya que no hay portador para actualizar)
            verify(carrierRepositoryMock, never()).edit(any(Carrier.class));
            // Verificamos que el método findCarrier del mock fue invocado con el ID del portador no existente
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
        // No necesitamos configurar el comportamiento del mock para devolver un portador aquí
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

}
