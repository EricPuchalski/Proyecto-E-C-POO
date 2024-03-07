import org.example.dao.InformationRepository;
import org.example.service.InformationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InformationServiceTest {
    @Mock
    private InformationRepository informationRepositoryMock;

    private InformationService informationService;

    @Before
    public void setUp() {
        informationRepositoryMock = mock(InformationRepository.class);
        informationService = new InformationService(informationRepositoryMock);
    }

    @Test
    public void testGetNumberOfOrdersByBranch_Success() {
        // Arrange
        String branchCode = "branch123";
        int expectedNumberOfOrders = 5;
        when(informationRepositoryMock.getNumberOfOrdersByBranch(branchCode)).thenReturn(expectedNumberOfOrders);

        // Act
        int actualNumberOfOrders = informationService.getNumberOfOrdersByBranch(branchCode);

        // Assert
        assertEquals(expectedNumberOfOrders, actualNumberOfOrders);
    }
    @Test
    public void testCountOrdersInPendingStatus_Success() {
        // Arrange
        int expectedPendingOrders = 3;
        when(informationRepositoryMock.countOrdersInPendingStatus()).thenReturn(expectedPendingOrders);

        // Act
        int actualPendingOrders = informationService.countOrdersInPendingStatus();

        // Assert
        assertEquals(expectedPendingOrders, actualPendingOrders);
    }

    @Test
    public void testCountOrdersInPendingStatus_NoPendingOrders() {
        // Arrange
        int expectedPendingOrders = 0;
        when(informationRepositoryMock.countOrdersInPendingStatus()).thenReturn(expectedPendingOrders);

        // Act
        int actualPendingOrders = informationService.countOrdersInPendingStatus();

        // Assert
        assertEquals(expectedPendingOrders, actualPendingOrders);
    }

    @Test
    public void testGetCustomerOrderHistory_Success() {
        // Arrange
        Long customerId = 123L;
        int expectedOrderHistory = 5;
        when(informationRepositoryMock.getCustomerOrderHistory(customerId)).thenReturn(expectedOrderHistory);

        // Act
        int actualOrderHistory = informationService.getCustomerOrderHistory(customerId);

        // Assert
        assertEquals(expectedOrderHistory, actualOrderHistory);
    }

    @Test
    public void testGetCustomerOrderHistory_NoOrderHistory() {
        // Arrange
        Long customerId = 456L;
        int expectedOrderHistory = 0;
        when(informationRepositoryMock.getCustomerOrderHistory(customerId)).thenReturn(expectedOrderHistory);

        // Act
        int actualOrderHistory = informationService.getCustomerOrderHistory(customerId);

        // Assert
        assertEquals(expectedOrderHistory, actualOrderHistory);
    }
}
