    import org.example.dao.OrderRepository;
    import org.example.dao.exceptions.NonexistentEntityException;
    import org.example.model.*;
    import org.example.service.OrderService;
    import org.junit.Before;
    import org.junit.Test;
    import org.mockito.Mock;
    import org.mockito.Mockito;

    import java.time.LocalDate;
    import java.util.Arrays;
    import java.util.List;

    import static org.junit.Assert.*;
    import static org.mockito.Mockito.*;
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


        @Test
        public void deliverOrder_NonExistingOrder() {
            // Datos de prueba
            String orderNumber = "1234";

            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(null);

            // Ejecutar el método que se está probando
            Order deliveredOrder = orderService.deliverOrder(orderNumber);

            // Verificaciones
            assertNull(deliveredOrder);
            verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
            verify(orderRepositoryMock, never()).deliverOrder(orderNumber);
        }
        @Test
        public void deliverOrder_EmptyOrderNumber() {
            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber("")).thenReturn(null);

            // Ejecutar el método que se está probando
            Order deliveredOrder = orderService.deliverOrder("");

            // Verificaciones
            assertNull(deliveredOrder);
            verify(orderRepositoryMock).findOrderByOrderNumber("");
            verify(orderRepositoryMock, never()).deliverOrder("");
        }
        @Test
        public void findAllUndeliveredOrders_Success() {
            // Datos de prueba
            List<Order> allOrders = Arrays.asList(
                    new Order("1", null, null, null, null, "Pendiente", LocalDate.now()),
                    new Order("2", null, null, null, null, "Completo", LocalDate.now()),
                    new Order("3", null, null, null, null, "En transito", LocalDate.now()),
                    new Order("4", null, null, null, null, "Entrega", LocalDate.now()),
                    new Order("5", null, null, null, null, "Pendiente", LocalDate.now())
            );

            // Mockear el comportamiento del orderRepository
            OrderRepository orderRepositoryMock = Mockito.mock(OrderRepository.class);
            when(orderRepositoryMock.findOrderEntities()).thenReturn(allOrders);

            // Crear el servicio de órdenes con el mock del repository
            OrderService orderService = new OrderService(orderRepositoryMock);

            // Ejecutar el método que se está probando
            List<Order> undeliveredOrders = orderService.findAllUndeliveredOrders();

            // Verificaciones
            assertNotNull(undeliveredOrders);
            assertEquals(4, undeliveredOrders.size()); // Deberían haber 4 órdenes no entregadas
            for (Order order : undeliveredOrders) {
                assertNotEquals("Entrega", order.getOrderStatus()); // Ninguna orden debe tener estado "Entrega"
            }
        }
        @Test
        public void findAllOrdersByNumber_Success() {
            // Datos de prueba
            List<Order> allOrders = Arrays.asList(
                    new Order("12345", null, null, null, null, "Pendiente", LocalDate.now()),
                    new Order("12346", null, null, null, null, "Completo", LocalDate.now()),
                    new Order("22345", null, null, null, null, "En tránsito", LocalDate.now()),
                    new Order("22346", null, null, null, null, "Entrega", LocalDate.now()),
                    new Order("32345", null, null, null, null, "Pendiente", LocalDate.now())
            );

            // Mockear el comportamiento del orderRepository
            OrderRepository orderRepositoryMock = Mockito.mock(OrderRepository.class);
            when(orderRepositoryMock.findOrderEntities()).thenReturn(allOrders);

            // Crear el servicio de órdenes con el mock del repository
            OrderService orderService = new OrderService(orderRepositoryMock);

            // Ejecutar el método que se está probando
            List<Order> foundOrders = orderService.findAllOrdersByNumber("123");

            // Verificaciones
            assertNotNull(foundOrders);
            assertEquals(2, foundOrders.size()); // Deberían haber 2 órdenes cuyo número comienza con "123"
            for (Order order : foundOrders) {
                assertTrue(order.getOrderNumber().startsWith("123")); // Todas las órdenes deben tener un número que comience con "123"
            }
        }


        @Test
        public void saveTest() {
            // Datos de prueba
            Order order = new Order(/* Datos de la orden */);

            // Configuración del comportamiento del mock del repositorio
            when(orderRepositoryMock.save(order)).thenReturn(null);

            // Ejecutar el método que se está probando
            Order savedOrder = orderService.save(order);

            // Verificaciones
            assertNull(savedOrder); // Verificar que el resultado es null
            verify(orderRepositoryMock).save(order); // Verificar que el método save del repositorio es llamado correctamente con el argumento adecuado
        }


        @Test
        public void upDate_ExistingOrder_Success() throws Exception {
            // Datos de prueba
            Order existingOrder = new Order(); // Supongamos que ya existe una orden con este ID
            existingOrder.setId(1L);

            // Configuración del comportamiento del mock del repositorio
            when(orderRepositoryMock.findOrder(existingOrder.getId())).thenReturn(existingOrder);
            when(orderRepositoryMock.edit(existingOrder)).thenReturn(existingOrder); // Simula que la edición de la orden tiene éxito

            // Ejecutar el método que se está probando
            Order updatedOrder = orderService.upDate(existingOrder);

            // Verificaciones
            assertNotNull(updatedOrder); // Verificar que la orden actualizada no sea nula
            assertEquals(existingOrder, updatedOrder); // Verificar que la orden actualizada sea la misma que la original
            verify(orderRepositoryMock).findOrder(existingOrder.getId()); // Verificar que se llamó al método findOrder del repositorio con el ID de la orden
            verify(orderRepositoryMock).edit(existingOrder); // Verificar que se llamó al método edit del repositorio con la orden actualizada
        }

        @Test
        public void upDate_NonExistingOrder_ReturnsNull() throws Exception {
            // Datos de prueba
            Order nonExistingOrder = new Order(); // Supongamos que no existe ninguna orden con este ID
            nonExistingOrder.setId(999L);

            // Configuración del comportamiento del mock del repositorio
            when(orderRepositoryMock.findOrder(nonExistingOrder.getId())).thenReturn(null); // Simula que la orden no existe en el repositorio

            // Ejecutar el método que se está probando
            Order updatedOrder = orderService.upDate(nonExistingOrder);

            // Verificaciones
            assertNull(updatedOrder); // Verificar que la orden actualizada sea nula
            verify(orderRepositoryMock).findOrder(nonExistingOrder.getId()); // Verificar que se llamó al método findOrder del repositorio con el ID de la orden
            verify(orderRepositoryMock, never()).edit(any(Order.class)); // Verificar que no se llamó al método edit del repositorio
        }


        @Test
        public void sendToDelivery_NullOrderFound_ReturnsNull() throws Exception {
            // Datos de prueba
            String orderNumber = "1234";
            String cuitEmployeeReceiv = "987654321";

            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(null); // Simula que la orden no se encuentra en el repositorio

            // Ejecutar el método que se está probando
            Order deliveredOrder = orderService.sendToDelivery(orderNumber, cuitEmployeeReceiv);

            // Verificaciones
            assertNull(deliveredOrder); // Verificar que la orden entregada sea nula
            verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber); // Verificar que se llamó al método findOrderByOrderNumber del repositorio con el número de orden
            verify(orderRepositoryMock, never()).sendToDelivery(anyString(), anyString()); // Verificar que no se llamó al método sendToDelivery del repositorio
        }

        @Test
        public void dispatchOrder_NoOrderFound_ReturnsNull() {
            // Datos de prueba
            String orderNumber = "1234";

            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(null);

            // Ejecutar el método que se está probando
            Order dispatchedOrder = orderService.dispatchOrder(orderNumber);

            // Verificaciones
            assertNull(dispatchedOrder); // Verificar que la orden despachada sea nula
            verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber); // Verificar que se llamó al método findOrderByOrderNumber del repositorio con el número de orden
            verify(orderRepositoryMock, never()).dispatchOrder(orderNumber); // Verificar que no se llamó al método dispatchOrder del repositorio
        }

        @Test
        public void testFindAllOrdersByCustomers() {
            // Datos de prueba
            Long idCustomer = 123L;

            // Crear órdenes de prueba
            Customer customer1 = mock(Customer.class);
            when(customer1.getId()).thenReturn(123L);

            Customer customer2 = mock(Customer.class);
            when(customer2.getId()).thenReturn(456L);

            Order order1 = new Order("1", customer1);
            Order order2 = new Order("2", customer1);
            Order order3 = new Order("3", customer2);

            // Configurar comportamiento del mock
            List<Order> allOrders = Arrays.asList(order1, order2, order3);
            when(orderRepositoryMock.findOrderEntities()).thenReturn(allOrders);

            // Ejecutar el método que se está probando
            List<Order> customerOrders = orderService.findAllOrdersByCustomers(idCustomer);

            // Verificaciones
            assertEquals(2, customerOrders.size()); // Verificar que se devuelvan las órdenes correctas para el cliente proporcionado
            for (Order order : customerOrders) {
                assertEquals(idCustomer, order.getCustomer().getId()); // Verificar que todas las órdenes sean del cliente con el id proporcionado
            }
        }

        @Test
        public void testFindAllOrdersByWarehouseOrig() {
            // Datos de prueba
            Long idWarehouse = 123L;

            // Crear almacenes de prueba
            Warehouse warehouse1 = mock(Warehouse.class);
            when(warehouse1.getId()).thenReturn(123L);

            Warehouse warehouse2 = mock(Warehouse.class);
            when(warehouse2.getId()).thenReturn(456L);

            // Crear órdenes de prueba
            Order order1 = new Order("1", null, warehouse1, null, null, null, null);
            Order order2 = new Order("2", null, warehouse1, null, null, null, null);
            Order order3 = new Order("3", null, warehouse2, null, null, null, null);

            // Configurar comportamiento del mock
            List<Order> allOrders = Arrays.asList(order1, order2, order3);
            when(orderRepositoryMock.findOrderEntities()).thenReturn(allOrders);

            // Ejecutar el método que se está probando
            List<Order> warehouseOrders = orderService.findAllOrdersByWarehouseOrig(idWarehouse);

            // Verificaciones
            assertEquals(2, warehouseOrders.size()); // Verificar que se devuelvan las órdenes correctas para el almacén proporcionado
            for (Order order : warehouseOrders) {
                assertEquals(idWarehouse, order.getWarehouseOrig().getId()); // Verificar que todas las órdenes sean del almacén con el id proporcionado
            }
        }



        @Test
        public void findOne_OrderNotExistWithMatchingOrderNumber_ReturnsNull() {
            // Datos de prueba
            String orderNumber = "123";

            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(null);

            // Ejecutar el método que se está probando
            Order foundOrder = orderService.findOne(orderNumber);

            // Verificaciones
            assertNull(foundOrder); // Verificar que no se encuentre ninguna orden
        }

        @Test
        public void findOne_OrderExistWithDifferentOrderNumber_ReturnsNull() {
            // Datos de prueba
            String orderNumberToFind = "123";
            String orderNumberExist = "456";
            Order orderExist = new Order(orderNumberExist); // Crear una orden con un número diferente al que se está buscando

            // Configurar comportamiento del mock
            when(orderRepositoryMock.findOrderByOrderNumber(orderNumberToFind)).thenReturn(orderExist);

            // Ejecutar el método que se está probando
            Order foundOrder = orderService.findOne(orderNumberToFind);

            // Verificaciones
            assertNull(foundOrder); // Verificar que no se encuentre ninguna orden
        }



        @Test
        public void delete_ExistingOrder_Success() throws NonexistentEntityException {
            // Arrange
            String orderNumber = "123";
            Order existingOrder = new Order(orderNumber);
            existingOrder.setId(1L);

            when(orderRepositoryMock.findOrderByOrderNumber(orderNumber)).thenReturn(existingOrder);

            // Act
            orderService.delete(orderNumber);

            // Assert
            verify(orderRepositoryMock).findOrderByOrderNumber(orderNumber);
            verify(orderRepositoryMock).destroy(existingOrder.getId());
        }








    }





