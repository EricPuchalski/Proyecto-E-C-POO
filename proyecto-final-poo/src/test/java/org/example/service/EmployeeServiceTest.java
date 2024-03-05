/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

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

    public void loadData(){

    }
     //   public Employee(String cuit, String name, String surname, String address, String phoneNumber) {


    @Test
    public void crearEmpleadoExitosamente() {
        // Arrange
        Employee employee = new Employee("15101qwewq1", "Eric", "Puch", "Josesito 232", "3243242");

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(employeeRepository.create(employee)).thenReturn(employee);

        // Act
        Employee savedEmployee = employeeService.save(employee);

        // Assert
        assertEquals(employee.getCuit(), savedEmployee.getCuit());
        assertEquals(employee.getNombre(), savedEmployee.getNombre());
        assertEquals(employee.getApellido(), savedEmployee.getApellido());
        assertEquals(employee.getDireccion(), savedEmployee.getDireccion());
        assertEquals(employee.getTelefono(), savedEmployee.getTelefono());

        // Verificar que se llamó al método create() de customerRepository
        verify(employeeRepository, times(1)).create(employee);
    }
//    @Test
//    public void crearClienteConCuitYaExistente() {
//        // Arrange
//        Customer newCustomer = new Customer("1510", "Juan", "Puch", "Asd 232", "3243242");
//
//        // Configurar el comportamiento esperado del mock de CustomerRepository
//        when(employeeRepository.create(newCustomer)).thenReturn(null); // Simular que el cliente no se puede crear debido al CUIT duplicado
//
//        // Act
//        Customer savedCustomer = employeeService.save(newCustomer);
//
//        // Assert
//        assertNull(savedCustomer); // Verificar que el cliente devuelto es null
//
//        // Verificar que se llamó al método create() de customerRepository
//        verify(employeeRepository, times(1)).create(newCustomer);
//    }
//
//
//    @Test
//    public void testFindOneWithExistingCuit() {
//        // Arrange
//        String existingCuit = "151011";
//        Customer existingCustomer = new Customer(existingCuit, "Eric", "Puch", "Josesito 232", "3243242");
//        when(employeeRepository.findCustomerEntities()).thenReturn(Collections.singletonList(existingCustomer));
//
//        // Act
//        Customer foundCustomer = employeeService.findOne(existingCuit);
//
//        // Assert
//        assertNotNull(foundCustomer);
//        assertEquals(existingCustomer, foundCustomer);
//    }
//    @Test
//    public void testFindOneWithNonExistingCuit() {
//        // Arrange
//        String nonExistingCuit = "999999";
//        when(employeeRepository.findCustomerEntities()).thenReturn(Collections.emptyList());
//
//        // Act
//        Customer foundCustomer = employeeService.findOne(nonExistingCuit);
//
//        // Assert
//        assertNull(foundCustomer);
//    }
//    @Test
//    public void testFindOneWithNullCuit() {
//        // Act
//        Customer foundCustomer = employeeService.findOne(null);
//
//        // Assert
//        assertNull(foundCustomer);
//    }
//    @Test
//    public void testUpdateExistingCustomer() throws Exception {
//        // Arrange
//        String existingCuit = "151011";
//        Customer existingCustomer = new Customer(existingCuit, "Eric", "Puch", "Josesito 232", "3243242");
//        when(employeeRepository.findCustomer(existingCustomer.getId())).thenReturn(existingCustomer);
//        Customer customerEdit = new Customer("151011", "John", null, null, null); // Editar solo el nombre
//        when(employeeRepository.edit(customerEdit)).thenReturn(customerEdit);
//
//        // Act
//        Customer updatedCustomer = employeeService.upDate(customerEdit);
//
//        // Assert
//        assertNotNull(updatedCustomer);
//        assertEquals(existingCustomer.getId(), updatedCustomer.getId());
//        assertEquals(customerEdit.getCuit(), updatedCustomer.getCuit());
//        assertNotEquals(existingCustomer.getName(), updatedCustomer.getName());
//        assertNull(updatedCustomer.getSurname()); // Verificar que el apellido no cambió
//        assertNull(updatedCustomer.getAdress());  // Verificar que la dirección no cambió
//        assertNull(updatedCustomer.getPhone());   // Verificar que el teléfono no cambió
//        verify(employeeRepository, times(1)).edit(customerEdit);
//    }
//    @Test
//    public void testUpdateNonExistingCustomer() throws Exception {
//        // Arrange
//        String cuit = "123";
//        Customer nonExistingCustomer = new Customer(cuit, "John", "Doe", "123 Main St", "555-1234");
//        when(employeeRepository.edit(nonExistingCustomer)).thenReturn(null);
//
//        // Act
//        Customer updatedCustomer = employeeService.upDate(nonExistingCustomer);
//
//        // Assert
//        assertNull(updatedCustomer);
//        verify(employeeRepository, never()).edit(any(Customer.class)); // Verificar que el método edit() nunca se llama
//    }
//    @Test
//    public void testFindAllEnabledCustomers() {
//        // Arrange
//        Customer customer1 = new Customer("1", "John", "Doe", "123 Main St", "555-1234");
//        customer1.setEstado(Customer.Estado.ENABLED);
//        Customer customer2 = new Customer("2", "Jane", "Smith", "456 Oak St", "555-5678");
//        customer2.setEstado(Customer.Estado.DISABLED);
//        Customer customer3 = new Customer("3", "Bob", "Jones", "789 Elm St", "555-9012");
//        customer3.setEstado(Customer.Estado.ENABLED);
//
//        List<Customer> allCustomers = Arrays.asList(customer1, customer2, customer3);
//
//        // Configurar el comportamiento esperado del mock de CustomerRepository
//        when(employeeRepository.findCustomerEntities()).thenReturn(allCustomers);
//
//        // Act
//        List<Customer> enabledCustomers = employeeService.findAllEnabledCustomers();
//
//        // Assert
//        List<Customer> expectedEnabledCustomers = allCustomers.stream()
//                .filter(customer -> customer.getEstado().equals(Customer.Estado.ENABLED))
//                .collect(Collectors.toList());
//
//        assertEquals(expectedEnabledCustomers.size(), enabledCustomers.size());
//        for (int i = 0; i < expectedEnabledCustomers.size(); i++) {
//            assertEquals(expectedEnabledCustomers.get(i), enabledCustomers.get(i));
//        }
//    }
//
//    @Test
//    public void testDisableAccountByCuit() throws NonexistentEntityException {
//        // Arrange
//        Customer enabledCustomer = new Customer("232", "John", "Doe", "123 Main St", "555-1234");
//        Customer disabledCustomer = new Customer("232", "John", "Doe", "123 Main St", "555-1234");
//        disabledCustomer.setEstado(Customer.Estado.DISABLED);
//
//        // Configurar el comportamiento del mock para devolver el objeto disabledCustomer cuando se llame a disableAccountByCuit(cuit) con el CUIT correspondiente
//        when(employeeRepository.findCustomerEnabledByCuit("232")).thenReturn(enabledCustomer);
//        when(employeeRepository.disableAccountByCuit("232")).thenReturn(disabledCustomer);
//
//        // Act
//        Customer updatedCustomer = employeeService.disableAccountByCuit("232");
//
//        // Assert
//        assertNotNull(updatedCustomer);
//        assertEquals(disabledCustomer, updatedCustomer);
//        assertEquals(Customer.Estado.DISABLED, updatedCustomer.getEstado());
//    }
}
