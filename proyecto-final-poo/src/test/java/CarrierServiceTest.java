import org.example.dao.CarrierRepository;
import org.example.model.Carrier;
import org.example.service.CarrierService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
}
