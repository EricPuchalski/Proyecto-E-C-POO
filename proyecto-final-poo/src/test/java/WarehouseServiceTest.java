import org.example.dao.EmployeeRepository;
import org.example.dao.WarehouseRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Customer;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.model.Warehouse;
import org.example.service.WarehouseService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class WarehouseServiceTest {

    @Mock
    public WarehouseRepository warehouseRepository;
    @InjectMocks
    public WarehouseService warehouseService;

    public Warehouse lodWarehouse(){

        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        return deposito1;
    }



        @Test
    public void crearDepositoExitosamente() {
        // Arrange
            Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(warehouseRepository.create(deposito1)).thenReturn(deposito1);

        // Act
            Warehouse savedWarehouse = warehouseService.save(deposito1);

        // Assert
        assertEquals(deposito1.getCode(), savedWarehouse.getCode());
        assertEquals(deposito1.getName(), savedWarehouse.getName());
        assertEquals(deposito1.getAdress(), savedWarehouse.getAdress());
        assertEquals(deposito1.getPhone(), savedWarehouse.getPhone());
        assertEquals(deposito1.getEmail(), savedWarehouse.getEmail());
        assertEquals(deposito1.getContinent(), savedWarehouse.getContinent());

    }

    @Test
    public void createWarehouseWithEmptyFields() {
        // Arrange
        Warehouse deposito1 = new Warehouse("","","","","", "",new Position(39.900853,116.399813));

        // Act
        Warehouse savedWarehouse = warehouseService.save(deposito1);

        // Assert
        assertNull(savedWarehouse);

    }

    //Sin importar los estados
    @Test
    public void findWarehouseById() {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        // Act
        when(warehouseService.findOneById(3L)).thenReturn(deposito1);
        Warehouse savedWarehouse = warehouseService.findOneById(3L);

        // Assert
        assertNotNull(savedWarehouse);
        assertEquals(deposito1.getName(),savedWarehouse.getName());

    }
    @Test
    public void crearWarehouseConCodeYaExistente() {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(warehouseRepository.create(deposito1)).thenReturn(null); // Simular que el cliente no se puede crear debido al CUIT duplicado

        // Act
        Warehouse savedWarehouse = warehouseService.save(deposito1);

        // Assert
        assertNull(savedWarehouse); // Verificar que el cliente devuelto es null

        // Verificar que se llamó al método create() de customerRepository
        verify(warehouseRepository, times(1)).create(deposito1);
    }


    @Test
    public void testFindOneWithExistingCode() {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.singletonList(deposito1));

        // Act
        Warehouse foundWarehouse = warehouseService.findOne(deposito1.getCode());

        // Assert
        assertEquals(deposito1, foundWarehouse);
    }
    @Test
    public void testFindOneWithNoExistingCode() {
        // Arrange
        String nonExistingCode = "12321";
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.emptyList());

        // Act
        Warehouse foundWarehouse = warehouseService.findOne(nonExistingCode);

        // Assert
        assertNull(foundWarehouse);
    }
    @Test
    public void testFindOneWithExistingPhoneNumber() {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.singletonList(deposito1));

        // Act
        Warehouse foundWarehouse = warehouseService.findWarehouseEnabledByPhone(deposito1.getPhone());

        // Assert
        assertEquals(deposito1, foundWarehouse);
    }
    @Test
    public void testFindOneWithNoExistingPhoneNumber() {
        // Arrange
        String nonExistingPhoneNumber = "34543534";
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.emptyList());

        // Act
        Warehouse foundWarehouse = warehouseService.findWarehouseEnabledByPhone(nonExistingPhoneNumber);

        // Assert
        assertNull(foundWarehouse);
    }
    @Test
    public void testFindOneWithExistingEmail() {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.singletonList(deposito1));

        // Act
        Warehouse foundWarehouse = warehouseService.findWarehouseEnabledByEmail(deposito1.getEmail());

        // Assert
        assertEquals(deposito1, foundWarehouse);
    }
    @Test
    public void testFindOneWithNoExistingEmail() {
        // Arrange
        String nonExistingEmail = "depositoCH@gmail.com";
        when(warehouseRepository.findWarehouseEntities()).thenReturn(Collections.emptyList());

        // Act
        Warehouse foundWarehouse = warehouseService.findWarehouseEnabledByEmail(nonExistingEmail);

        // Assert
        assertNull(foundWarehouse);
    }

    @Test
    public void testFindOneWithNullCode() {
        // Act
        Warehouse foundWarehouse = warehouseService.findOne(null);


        // Assert
        assertNull(foundWarehouse);
    }
    @Test
    public void testUpdateExistingWarehouse() throws Exception {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        when(warehouseRepository.findWarehouseEnabledByCuit(deposito1.getEmail())).thenReturn(deposito1);
        Warehouse depositoEdit = new Warehouse("12321","Deposito China",null,null,"depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        when(warehouseRepository.edit(deposito1)).thenReturn(depositoEdit);

        // Act
        Warehouse updatedWarehouse = warehouseService.upDate(deposito1);

        // Assert
        assertNotNull(updatedWarehouse);
        assertEquals(depositoEdit.getId(), updatedWarehouse.getId());
        assertEquals(depositoEdit.getCode(), updatedWarehouse.getCode());
        assertEquals(depositoEdit.getPhone(), updatedWarehouse.getPhone());
        assertNull(updatedWarehouse.getPhone());
        assertNull(updatedWarehouse.getAdress());

    }
    @Test
    public void testUpdateNonExistingWarehouse() throws Exception {
        // Arrange
        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));


        // Act
        Warehouse updatedWarehouse = warehouseService.upDate(deposito1);

        // Assert
        assertNull(updatedWarehouse);

    }
    @Test
    public void testFindAllEnabledWarehouses() {
        // Arrange
        Warehouse deposito1 = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        deposito1.setStatus(Warehouse.Estado.ENABLED);
        Warehouse deposito2 = new Warehouse("12541","Deposito China","Calle 144","34454534","depositoCH@gmail.com", "Asia",new Position(39.123253,216.399813));
        deposito2.setStatus(Warehouse.Estado.DISABLED);
        Warehouse deposito3 = new Warehouse("1261","Deposito Argentina","Calle 3","346533534","depositoAR@gmail.com", "Asia",new Position(39.540853,116.399813));
        deposito3.setStatus(Warehouse.Estado.ENABLED);

        List<Warehouse> warehouseList = Arrays.asList(deposito1, deposito2, deposito3);

        // Configurar el comportamiento esperado del mock de WarehouseRepository
        when(warehouseRepository.findWarehouseEntities()).thenReturn(warehouseList);
        // Act
        List<Warehouse> enabledWarehouses = warehouseService.findAllEnabledWarehouses();

        // Assert
        List<Warehouse> expectedEnabledCustomers = warehouseList.stream()
                .filter(warehouse -> warehouse.getStatus().equals(Warehouse.Estado.ENABLED))
                .collect(Collectors.toList());

        assertEquals(expectedEnabledCustomers.size(), enabledWarehouses.size());
        for (int i = 0; i < expectedEnabledCustomers.size(); i++) {
            assertEquals(expectedEnabledCustomers.get(i), enabledWarehouses.get(i));
        }
    }

    @Test
    public void testDisableAccountByEmail() throws NonexistentEntityException {
        // Arrange
        Warehouse warehouseEnabled = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        Warehouse warehouseDisabled = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        warehouseDisabled.setStatus(Warehouse.Estado.DISABLED);

        // Configurar el comportamiento del mock para devolver el objeto disabledCustomer cuando se llame a testDisableAccountByEmail(email) con el CUIT correspondiente
        when(warehouseRepository.findWarehouseEnabledByCuit("depositoJP@gmail.com")).thenReturn(warehouseEnabled);
        when(warehouseRepository.disableAccountByEmail("depositoJP@gmail.com")).thenReturn(warehouseDisabled);

        // Act
        Warehouse updatedWarehouse = warehouseService.disableAccountByEmail("depositoJP@gmail.com");

        // Assert
        assertNotNull(updatedWarehouse);
        assertEquals(warehouseDisabled, updatedWarehouse);
        assertEquals(Warehouse.Estado.DISABLED, updatedWarehouse.getStatus());
    }
    @Test
    public void testDisableAccountByCuitWithEmailNoExist() throws NonexistentEntityException {
        // Arrange
        Warehouse warehouseDisabled = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        warehouseDisabled.setStatus(Warehouse.Estado.DISABLED);
        Warehouse warehouseEnabled = new Warehouse("3455","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));

        // Configurar el comportamiento del mock para devolver el objeto disabledCustomer cuando se llame a disableAccountByCuit(cuit) con el CUIT correspondiente
        when(warehouseRepository.findWarehouseEnabledByCuit("dasdas@gmail.com")).thenReturn(null);

        // Act
        Warehouse updatedWarehouse = warehouseService.disableAccountByEmail("dasdas@gmail.com");

        // Assert
        assertNull(updatedWarehouse);

    }
    //Sin importar estados
    @Test
    public void testFindAllWarehouses() {
        Warehouse warehouseDisabled = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        warehouseDisabled.setStatus(Warehouse.Estado.DISABLED);
        Warehouse warehouseEnabled = new Warehouse("3455","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));


        List<Warehouse> warehouseList = Arrays.asList(
                warehouseDisabled,
                warehouseEnabled
        );

        // Mock repository behavior
        when(warehouseRepository.findWarehouseEntities()).thenReturn(warehouseList);

        // Call the service method
        List<Warehouse> retrievedWarehouseList = warehouseService.findAll();

        // Assert results
        assertEquals(2, retrievedWarehouseList.size());
        assertEquals("3421", retrievedWarehouseList.get(0).getCode());
        assertEquals("3455", retrievedWarehouseList.get(1).getCode());
    }
    @Test
    public void testFindAllEnabledWarehousesByEmail() {
        // Arrange
        Warehouse deposito1 = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        deposito1.setStatus(Warehouse.Estado.ENABLED);
        Warehouse deposito2 = new Warehouse("12541","Deposito China","Calle 144","34454534","depositoCH@gmail.com", "Asia",new Position(39.123253,216.399813));
        deposito2.setStatus(Warehouse.Estado.DISABLED);
        Warehouse deposito3 = new Warehouse("1261","Deposito Argentina","Calle 3","346533534","depositoAR@gmail.com", "Asia",new Position(39.540853,116.399813));
        deposito3.setStatus(Warehouse.Estado.ENABLED);

        List<Warehouse> warehouseList = Arrays.asList(deposito1, deposito2, deposito3);

        // Configurar el comportamiento esperado del mock de WarehouseRepository
        when(warehouseRepository.findWarehouseEntities()).thenReturn(warehouseList);
        // Act
        List<Warehouse> enabledWarehouses = warehouseService.findAllWarehousesByEmail("depo");

        // Assert

        assertEquals(2, enabledWarehouses.size());

    }
    @Test
    public void testFindAllEnabledWarehousesByEmailWithEmptyEmail() {
        // Arrange
        Warehouse deposito1 = new Warehouse("3421","Deposito Japon","Calle 123","3432334","depositoJP@gmail.com", "Asia",new Position(39.954653,316.399813));
        deposito1.setStatus(Warehouse.Estado.ENABLED);
        Warehouse deposito2 = new Warehouse("12541","Deposito China","Calle 144","34454534","depositoCH@gmail.com", "Asia",new Position(39.123253,216.399813));
        deposito2.setStatus(Warehouse.Estado.DISABLED);
        Warehouse deposito3 = new Warehouse("1261","Deposito Argentina","Calle 3","346533534","depositoAR@gmail.com", "Asia",new Position(39.540853,116.399813));
        deposito3.setStatus(Warehouse.Estado.ENABLED);

        List<Warehouse> warehouseList = Arrays.asList(deposito1, deposito2, deposito3);

        // Configurar el comportamiento esperado del mock de WarehouseRepository
        // Act
        List<Warehouse> enabledWarehouses = warehouseService.findAllWarehousesByEmail("");

        // Assert

        assertEquals(0, enabledWarehouses.size());

    }
}
