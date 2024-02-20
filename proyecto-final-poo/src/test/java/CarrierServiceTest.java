import org.example.dao.CarrierRepository;
import org.example.model.Carrier;
import org.example.service.CarrierService;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
//Prueba que un trans con campos vacíos no se pueda guardar en el repositorio
}
