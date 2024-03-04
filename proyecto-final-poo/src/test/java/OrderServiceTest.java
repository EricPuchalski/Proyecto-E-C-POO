import org.example.dao.OrderRepository;
import org.example.model.*;
import org.example.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepositoryMock;

    private OrderService orderService;

    @Before
    public void setUp() {
        orderRepositoryMock = mock(OrderRepository.class);
        orderService = new OrderService(orderRepositoryMock);

    }
    @Test
    public void createOrder_Success() {
        // Datos de prueba
        Customer customer=new Customer("123","Juan","Perez","XXXXXXXXXXXXXX","123");
        Warehouse warehouseOrig = new Warehouse("002","wareorg","direog","333","email","Europa",new Position(132,12));
        Warehouse warehouseDest = new Warehouse("003","wareodest","diredest","444","correo","Asia",new Position(123,13));
        Carrier carrier=new Carrier("123", "Juan", "Perez", "email@email", Carrier.CarrierType.AIR);
        LocalDate orderStart = LocalDate.now(); // Utiliza la fecha actual

        Order newOrder = new Order("12",customer,warehouseOrig,warehouseDest,carrier,"HABILITADO",orderStart); // Inicializas una orden con sus datos

        String cuitCustomer = "12345";
        String cuitCarrier = "67890";

        // Configurar comportamiento del mock
        when(orderRepositoryMock.findOrderByOrderNumber(anyString())).thenReturn(null); // Si no existe orderNumber
        when(orderRepositoryMock.createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString()))
                .thenReturn(newOrder); // Retornar la orden creada

        // Ejecutar el método que se está probando
        Order createdOrder = orderService.createOrder(newOrder, warehouseOrig, warehouseDest, cuitCustomer, cuitCarrier);

        // Verificaciones
        assertNotNull(createdOrder); //  La orden creada no debe ser nula
        verify(orderRepositoryMock).findOrderByOrderNumber(newOrder.getOrderNumber());
        verify(orderRepositoryMock).createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString());
    }




}

/*
    @Test
    public void testCreateOrder_Success() {
        // Arrange
        Order order = new Order(); // Crear una instancia de Order con los datos necesarios
        Warehouse warehouseOrig = new Warehouse(); // Instanciar Warehouse
        Warehouse warehouseDest = new Warehouse(); // Instanciar Warehouse
        String cuitCustomer = "123456789"; // Ejemplo de un número de CUIT válido
        String cuitCarrier = "987654321"; // Ejemplo de un número de CUIT válido

        // Configuración del mock para el método findOrderByOrderNumber
        when(orderRepositoryMock.findOrderByOrderNumber(anyString())).thenReturn(null);

        // Configuración del mock para el método createOrder
        when(orderRepositoryMock.createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString())).thenReturn(order);

        // Act
        Order createdOrder = orderService.createOrder(order, warehouseOrig, warehouseDest, cuitCustomer, cuitCarrier);

        // Assert
        assertNotNull(createdOrder); // Verificar que la orden creada no sea nula
        // Aquí puedes agregar más aserciones si hay otros datos que quieres verificar en la orden creada
        verify(orderRepositoryMock, times(1)).findOrderByOrderNumber(anyString()); // Verificar que se llamó al método findOrderByOrderNumber una vez
        verify(orderRepositoryMock, times(1)).createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString()); // Verificar que se llamó al método createOrder una vez
    }
 */
