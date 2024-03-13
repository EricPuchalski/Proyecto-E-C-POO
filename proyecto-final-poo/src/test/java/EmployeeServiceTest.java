/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.CustomerRepository;
import org.example.dao.EmployeeRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Customer;
import org.example.model.Employee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.example.model.Position;
import org.example.model.Warehouse;
import org.example.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author ericp
 */
@RunWith(MockitoJUnitRunner.class)

public class EmployeeServiceTest {
        @Mock
    public EmployeeRepository employeeRepository;
    @InjectMocks
    public EmployeeService employeeService;

    public Warehouse lodWarehouse(){

        Warehouse deposito1 = new Warehouse("12321","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Position(39.900853,116.399813));
        return deposito1;
    }



    @Test
    public void crearEmpleadoExitosamente() {
        // Arrange
        Employee employee = new Employee("15101qwewq1", "Eric", "Puch", "Josesito 232", "3243242", this.lodWarehouse());

        // Configurar el comportamiento esperado del mock de EmployeeRepository
        when(employeeRepository.create(employee)).thenReturn(employee);

        // Act
        Employee savedEmployee = employeeService.save(employee);

        // Assert
        assertEquals(employee.getCuit(), savedEmployee.getCuit());
        assertEquals(employee.getNombre(), savedEmployee.getNombre());
        assertEquals(employee.getApellido(), savedEmployee.getApellido());
        assertEquals(employee.getDireccion(), savedEmployee.getDireccion());
        assertEquals(employee.getTelefono(), savedEmployee.getTelefono());
        assertEquals(employee.getDeposit().getEmail(), savedEmployee.getDeposit().getEmail());

    }
    @Test
    public void crearEmpleadoYaExistente() {
        // Arrange
        Employee employee = new Employee("15101qwewq1", "Eric", "Puch", "Josesito 232", "3243242", this.lodWarehouse());
        Employee employeeExist = new Employee("15101qwewq1", "Eric", "Puch", "Josesito 232", "3243242", this.lodWarehouse());
        // Configurar el comportamiento esperado del mock de EmployeeRepository
        when(employeeService.findEmployeeEnabledByCuit(employeeExist.getCuit())).thenReturn(employeeExist);

        // Act
        Employee savedEmployee = employeeService.save(employee);

        // Assert
        assertNull(savedEmployee);

    }
    @Test
    public void crearEmpleadoConCuitYaExistente() {

        Employee newEmployee = new Employee("1510", "Juan", "Puch", "Asd 232", "3243242", this.lodWarehouse());


        when(employeeRepository.create(newEmployee)).thenReturn(null); // Simular que el cliente no se puede crear debido al CUIT duplicado


        Employee savedEmployee = employeeService.save(newEmployee);


        assertNull(savedEmployee);
        verify(employeeRepository, times(1)).create(newEmployee);
    }


    @Test
    public void testFindOneWithExistingCuit() {
        // Arrange
        String existingCuit = "151011";
        Employee newEmployee = new Employee(existingCuit, "Eric", "Puch", "Josesito 232", "3243242", this.lodWarehouse());
        when(employeeRepository.findEmployeeEntities()).thenReturn(Collections.singletonList(newEmployee));

        // Act
        Employee foundEmployee = employeeService.findOne(existingCuit);

        // Assert
        assertNotNull(foundEmployee);
        assertEquals(newEmployee, foundEmployee);
    }
    @Test
    public void testFindOneWithNonExistingCuit() {
        String nonExistingCuit = "999999";
        when(employeeRepository.findEmployeeEntities()).thenReturn(Collections.emptyList());

        Employee foundEmployee = employeeService.findOne(nonExistingCuit);

        assertNull(foundEmployee);
    }
    @Test
    public void testFindOneWithNullCuit() {

        Employee foundEmployee = employeeService.findEmployeeEnabledByCuit(null);



        assertNull(foundEmployee);
    }

    @Test
    public void testUpdateNonExistingCustomer() throws Exception {

        String cuit = "123";
        Employee nonExistingEmployee = new Employee(cuit, "John", "Doe", "123 Main St", "555-1234",this.lodWarehouse());


        Employee updatedEmployee = employeeService.upDate(nonExistingEmployee);

        assertNull(updatedEmployee);
    }
    @Test
    public void testFindAllEnabledCustomers() {

        Employee employee1 = new Employee("1", "John", "Doe", "123 Main St", "555-1234",this.lodWarehouse());
        employee1.setEstado(Employee.Status.ENABLED);
        Employee employee2 = new Employee("2", "Jane", "Smith", "456 Oak St", "555-5678",this.lodWarehouse());
        employee2.setEstado(Employee.Status.DISABLED);
        Employee employee3 = new Employee("3", "Bob", "Jones", "789 Elm St", "555-9012",this.lodWarehouse());
        employee3.setEstado(Employee.Status.ENABLED);

        List<Employee> allEmployees = Arrays.asList(employee1, employee2, employee3);


        when(employeeRepository.findEmployeeEntities()).thenReturn(allEmployees);


        List<Employee> enabledEmployees = employeeService.findAllEnabledEmployees();


        List<Employee> expectedEnabledCustomers = allEmployees.stream()
                .filter(employee -> employee.getEstado().equals(Employee.Status.ENABLED))
                .collect(Collectors.toList());

        assertEquals(expectedEnabledCustomers.size(), enabledEmployees.size());
        for (int i = 0; i < expectedEnabledCustomers.size(); i++) {
            assertEquals(expectedEnabledCustomers.get(i), enabledEmployees.get(i));
        }
    }

    @Test
    public void testDisableAccountByCuit() throws NonexistentEntityException {

        Employee enabledEmployee = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        Employee disabledEmployee = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        disabledEmployee.setEstado(Employee.Status.DISABLED);

        when(employeeRepository.findEmployeeEnabledByCuit("232")).thenReturn(enabledEmployee);
        when(employeeRepository.disableAccountByCuit("232")).thenReturn(disabledEmployee);

        Employee updatedEmployee = employeeService.disableAccountByCuit("232");


        assertNotNull(updatedEmployee);
        assertEquals(disabledEmployee, updatedEmployee);
        assertEquals(Employee.Status.DISABLED, updatedEmployee.getEstado());
    }
    @Test
    public void testFindEmployeeEnabledByCuit_EnabledEmployeeFound() {

        Employee existingEmployee = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        when(employeeRepository.findEmployeeEnabledByCuit(existingEmployee.getCuit())).thenReturn(existingEmployee);


        String searchCuit = existingEmployee.getCuit();
        Employee foundEmployee = employeeService.findEmployeeEnabledByCuit(searchCuit);


        assertEquals(existingEmployee.getNombre(), foundEmployee.getNombre());


    }

    @Test
    public void testDisableAccountByCuitWithCuitNoExist() throws NonexistentEntityException {

        Employee enabledEmployee = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        Employee disabledEmployee = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        disabledEmployee.setEstado(Employee.Status.DISABLED);

        when(employeeRepository.findEmployeeEnabledByCuit("232232323")).thenReturn(null);


        Employee updatedEmpl = employeeService.disableAccountByCuit("232232323");

        assertNull(updatedEmpl);

    }

    @Test
    public void testFindAllEnabledEmployeesByCuit() {

        Employee emp1 = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        emp1.setEstado(Employee.Status.ENABLED);
        Employee emp2 = new Employee("542", "Asd", "Jua", "165 Main St", "545-1234");
        emp1.setEstado(Employee.Status.DISABLED);
        Employee emp3 = new Employee("244", "John", "Das", "653 Main St", "235-1234");
        emp1.setEstado(Employee.Status.ENABLED);

        List<Employee> allEmploy = Arrays.asList(emp1, emp2, emp3);


        when(employeeRepository.findEmployeeEntities()).thenReturn(allEmploy);


        List<Employee> enabledEmpl = employeeService.findAllEmployeesByCuit("2");



        assertEquals(enabledEmpl.size(),2);

    }
    @Test
    public void testFindAllEnabledEmployeesByCuitWithEmptyCuit() {
        // Arrange
        Employee emp1 = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        emp1.setEstado(Employee.Status.ENABLED);
        Employee emp2 = new Employee("542", "Asd", "Jua", "165 Main St", "545-1234");
        emp1.setEstado(Employee.Status.DISABLED);
        Employee emp3 = new Employee("244", "John", "Das", "653 Main St", "235-1234");
        emp1.setEstado(Employee.Status.ENABLED);

        List<Employee> allEmploy = Arrays.asList(emp1, emp2, emp3);

        List<Employee> enabledEmpl = employeeService.findAllEmployeesByCuit("");



        assertEquals(enabledEmpl.size(),0);

    }


    //findall sin importar los estados

    @Test
    public void testFindAllCustomers() {
        Employee emp1 = new Employee("232", "John", "Doe", "123 Main St", "555-1234");
        emp1.setEstado(Employee.Status.ENABLED);
        Employee emp2 = new Employee("542", "Asd", "Jua", "165 Main St", "545-1234");
        emp1.setEstado(Employee.Status.DISABLED);


        List<Employee> allEmploy = Arrays.asList(emp1, emp2);

        when(employeeRepository.findEmployeeEntities()).thenReturn(allEmploy);


        List<Employee> retrievedEmp = employeeService.findAll();


        assertEquals(2, retrievedEmp.size());
        assertEquals("John", retrievedEmp.get(0).getNombre()); // Assuming Customer has a getName() method
        assertEquals("Asd", retrievedEmp.get(1).getNombre());
    }

    //findone sin importar los estados
    @Test
    public void shouldReturnEmploteeWhenCuitIsNull() {

        Employee foundEmployee = employeeService.findOne(null);

        assertNull(foundEmployee);
    }
}
