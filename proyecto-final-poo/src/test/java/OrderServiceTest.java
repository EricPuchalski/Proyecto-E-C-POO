import org.example.dao.OrderRepository;
import org.example.model.*;
import org.example.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.Assert.assertNull;
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

    @Test
    public void createOrder_NullEntities() {
        // Datos de prueba con cliente, almacén de origen, almacén de destino o transportista nulos
        Customer nullCustomer = null;
        Warehouse nullWarehouseOrig = null;
        Warehouse nullWarehouseDest = null;
        Carrier nullCarrier = null;
        LocalDate orderStart = LocalDate.now(); // Utiliza la fecha actual

        Order newOrder = new Order("12", nullCustomer, nullWarehouseOrig, nullWarehouseDest, nullCarrier, "HABILITADO", orderStart); // Orden con entidades nulas

        String cuitCustomer = "12345";
        String cuitCarrier = "67890";

        // Configurar comportamiento del mock
        when(orderRepositoryMock.findOrderByOrderNumber(anyString())).thenReturn(null); // Si no existe orderNumber
        when(orderRepositoryMock.createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString()))
                .thenReturn(newOrder); // Retornar la orden creada

        // Ejecutar el método que se está probando
        Order createdOrder = orderService.createOrder(newOrder, nullWarehouseOrig, nullWarehouseDest, cuitCustomer, cuitCarrier);

        // Verificaciones
        assertNull(createdOrder); // La orden creada debe ser nula ya que al menos una de las entidades (cliente, almacén de origen, almacén de destino, transportista) es nula
        verify(orderRepositoryMock, never()).createOrder(any(Order.class), any(Warehouse.class), any(Warehouse.class), anyString(), anyString()); // No debe llamarse al método de creación de orden en el repositorio
    }

    @Test
    public void processOrder_Success() {
        // Datos de prueba
        String orderNumber = "12";
        String cuitEmpleado = "123456";

        // Crear un objeto Customer
        Customer customer = new Customer("123", "Nombre", "Apellido", "email@example.com", "123456");

        // Crear objetos Warehouse
        Warehouse warehouseOrig = new Warehouse("001", "Origen", "Dirección Origen", "123", "email@origen.com", "Origen", new Position(0, 0));
        Warehouse warehouseDest = new Warehouse("002", "Destino", "Dirección Destino", "456", "email@destino.com", "Destino", new Position(0, 0));

        // Crear un objeto Carrier
        Carrier carrier = new Carrier("789", "Transportista", "Apellido", "email@transportista.com", Carrier.CarrierType.AIR);

        // Fecha actual
        LocalDate orderStart = LocalDate.now();

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, customer, warehouseOrig, warehouseDest, carrier, "Pendiente", orderStart);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.processOrder(orderNumber, cuitEmpleado)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order processedOrder = orderService.processOrder(orderNumber, cuitEmpleado);

        // Verificaciones
        assertNotNull(processedOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).processOrder(orderNumber, cuitEmpleado);
    }

    @Test
    public void completeOrder_Success() {
        // Datos de prueba
        String orderNumber = "1234";

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, null, null, null, null, "En Proceso", null);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.completeOrder(orderNumber)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order completedOrder = orderService.completeOrder(orderNumber);

        // Verificaciones
        assertNotNull(completedOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).completeOrder(orderNumber);
    }

    @Test
    public void sendOrderToDispatch_Success() {
        // Datos de prueba
        String orderNumber = "1234";

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, null, null, null, null, "Completo", null);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.sendOrderToDispatch(orderNumber)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order dispatchedOrder = orderService.sendOrderToDispatch(orderNumber);

        // Verificaciones
        assertNotNull(dispatchedOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).sendOrderToDispatch(orderNumber);
    }

    @Test
    public void dispatchOrder_Success() {
        // Datos de prueba
        String orderNumber = "1234";

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, null, null, null, null, "Esperando Despacho", null);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.dispatchOrder(orderNumber)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order dispatchedOrder = orderService.dispatchOrder(orderNumber);

        // Verificaciones
        assertNotNull(dispatchedOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).dispatchOrder(orderNumber);
    }

    @Test
    public void orderTransit_Success() {
        // Datos de prueba
        String orderNumber = "1234";

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, null, null, null, null, "Despacho", null);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.orderTransit(orderNumber)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order transitOrder = orderService.orderTransit(orderNumber);

        // Verificaciones
        assertNotNull(transitOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).orderTransit(orderNumber);
    }

    @Test
    public void sendToDelivery_Success() {
        // Datos de prueba
        String orderNumber = "1234";
        String cuitEmployeeReceiv = "987654321";

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, null, null, null, null, "En transito", null);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        try {
            when(orderRepositoryMock.sendToDelivery(orderNumber, cuitEmployeeReceiv)).thenReturn(order);
        } catch (Exception ignored) {}

        // Ejecutar el método que se está probando
        Order deliveredOrder = orderService.sendToDelivery(orderNumber, cuitEmployeeReceiv);

        // Verificaciones
        assertNotNull(deliveredOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        try {
            verify(orderRepositoryMock).sendToDelivery(orderNumber, cuitEmployeeReceiv);
        } catch (Exception ignored) {}
    }
    @Test
    public void deliverOrder_Success() {
        // Datos de prueba
        String orderNumber = "1234";

        // Crear objetos relacionados
        Customer customer = new Customer("1", "John", "Doe", "john.doe@example.com", "123456789");
        Warehouse warehouseOrig = new Warehouse("1", "Warehouse Orig", "Address 1", "123", "warehouse.orig@example.com", "Europe", new Position(10, 20));
        Warehouse warehouseDest = new Warehouse("2", "Warehouse Dest", "Address 2", "456", "warehouse.dest@example.com", "Asia", new Position(30, 40));
        Carrier carrier = new Carrier("1", "Carrier", "Lastname", "carrier@example.com", Carrier.CarrierType.AIR);
        LocalDate orderStart = LocalDate.now();

        // Configurar comportamiento del mock
        Order order = new Order(orderNumber, customer, warehouseOrig, warehouseDest, carrier, "Esperando Entrega", orderStart);
        when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(order);
        when(orderRepositoryMock.deliverOrder(orderNumber)).thenReturn(order);

        // Ejecutar el método que se está probando
        Order deliveredOrder = orderService.deliverOrder(orderNumber);

        // Verificaciones
        assertNotNull(deliveredOrder);
        verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
        verify(orderRepositoryMock).deliverOrder(orderNumber);
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
