import org.example.dao.CarrierRepository;
import org.example.model.Carrier;
import org.example.service.CarrierService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarrierService2Test {
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
