package org.example.service;

import org.example.dao.CustomerRepository;
import org.example.dao.exceptions.NonexistentEntityException;
import org.example.model.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    public CustomerRepository customerRepository;
    @InjectMocks
    public CustomerService customerService;

    public void loadData(){

    }

    @Test
    public void crearClienteExitosamente() {
        // Arrange
        Customer customer = new Customer("151011", "Eric", "Puch", "Josesito 232", "3243242");

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(customerRepository.create(customer)).thenReturn(customer);

        // Act
        Customer savedCustomer = customerService.save(customer);

        // Assert
        assertEquals(customer.getCuit(), savedCustomer.getCuit());
        assertEquals(customer.getName(), savedCustomer.getName());
        assertEquals(customer.getSurname(), savedCustomer.getSurname());
        assertEquals(customer.getAdress(), savedCustomer.getAdress());
        assertEquals(customer.getPhone(), savedCustomer.getPhone());

        // Verificar que se llamó al método create() de customerRepository
        verify(customerRepository, times(1)).create(customer);
    }
    @Test
    public void crearClienteConCuitYaExistente() {
        // Arrange
        Customer newCustomer = new Customer("1510", "Juan", "Puch", "Asd 232", "3243242");

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(customerRepository.create(newCustomer)).thenReturn(null); // Simular que el cliente no se puede crear debido al CUIT duplicado

        // Act
        Customer savedCustomer = customerService.save(newCustomer);

        // Assert
        assertNull(savedCustomer); // Verificar que el cliente devuelto es null

        // Verificar que se llamó al método create() de customerRepository
        verify(customerRepository, times(1)).create(newCustomer);
    }


    @Test
    public void testFindOneWithExistingCuit() {
        // Arrange
        String existingCuit = "151011";
        Customer existingCustomer = new Customer(existingCuit, "Eric", "Puch", "Josesito 232", "3243242");
        when(customerRepository.findCustomerEntities()).thenReturn(Collections.singletonList(existingCustomer));

        // Act
        Customer foundCustomer = customerService.findCustomerEnabledByCuit(existingCuit);

        // Assert
        assertNotNull(foundCustomer);
        assertEquals(existingCustomer, foundCustomer);
    }
    @Test
    public void testFindOneWithNonExistingCuit() {
        // Arrange
        String nonExistingCuit = "999999";
        when(customerRepository.findCustomerEntities()).thenReturn(Collections.emptyList());

        // Act
        Customer foundCustomer = customerService.findCustomerEnabledByCuit(nonExistingCuit);

        // Assert
        assertNull(foundCustomer);
    }
    @Test
    public void testFindOneWithNullCuit() {
        // Act
        Customer foundCustomer = customerService.findCustomerEnabledByCuit(null);

        // Assert
        assertNull(foundCustomer);
    }
    @Test
    public void testUpdateExistingCustomer() throws Exception {
        // Arrange
        String existingCuit = "151011";
        Customer existingCustomer = new Customer(existingCuit, "Eric", "Puch", "Josesito 232", "3243242");
        when(customerRepository.findCustomer(existingCustomer.getId())).thenReturn(existingCustomer);
        Customer customerEdit = new Customer("151011", "John", null, null, null); // Editar solo el nombre
        when(customerRepository.edit(customerEdit)).thenReturn(customerEdit);

        // Act
        Customer updatedCustomer = customerService.upDate(customerEdit);

        // Assert
        assertNotNull(updatedCustomer);
        assertEquals(existingCustomer.getId(), updatedCustomer.getId());
        assertEquals(customerEdit.getCuit(), updatedCustomer.getCuit());
        assertNotEquals(existingCustomer.getName(), updatedCustomer.getName());
        assertNull(updatedCustomer.getSurname()); // Verificar que el apellido no cambió
        assertNull(updatedCustomer.getAdress());  // Verificar que la dirección no cambió
        assertNull(updatedCustomer.getPhone());   // Verificar que el teléfono no cambió
        verify(customerRepository, times(1)).edit(customerEdit);
    }
    @Test
    public void testUpdateNonExistingCustomer() throws Exception {
        // Arrange
        String cuit = "123";
        Customer nonExistingCustomer = new Customer(cuit, "John", "Doe", "123 Main St", "555-1234");
        when(customerRepository.edit(nonExistingCustomer)).thenReturn(null);

        // Act
        Customer updatedCustomer = customerService.upDate(nonExistingCustomer);

        // Assert
        assertNull(updatedCustomer);
        verify(customerRepository, never()).edit(any(Customer.class)); // Verificar que el método edit() nunca se llama
    }
    @Test
    public void testFindAllEnabledCustomers() {
        // Arrange
        Customer customer1 = new Customer("1", "John", "Doe", "123 Main St", "555-1234");
        customer1.setEstado(Customer.Estado.ENABLED);
        Customer customer2 = new Customer("2", "Jane", "Smith", "456 Oak St", "555-5678");
        customer2.setEstado(Customer.Estado.DISABLED);
        Customer customer3 = new Customer("3", "Bob", "Jones", "789 Elm St", "555-9012");
        customer3.setEstado(Customer.Estado.ENABLED);

        List<Customer> allCustomers = Arrays.asList(customer1, customer2, customer3);

        // Configurar el comportamiento esperado del mock de CustomerRepository
        when(customerRepository.findCustomerEntities()).thenReturn(allCustomers);

        // Act
        List<Customer> enabledCustomers = customerService.findAllEnabledCustomers();

        // Assert
        List<Customer> expectedEnabledCustomers = allCustomers.stream()
                .filter(customer -> customer.getEstado().equals(Customer.Estado.ENABLED))
                .collect(Collectors.toList());

        assertEquals(expectedEnabledCustomers.size(), enabledCustomers.size());
        for (int i = 0; i < expectedEnabledCustomers.size(); i++) {
            assertEquals(expectedEnabledCustomers.get(i), enabledCustomers.get(i));
        }
    }

    @Test
    public void testDisableAccountByCuit() throws NonexistentEntityException {
        // Arrange
        Customer enabledCustomer = new Customer("232", "John", "Doe", "123 Main St", "555-1234");
        Customer disabledCustomer = new Customer("232", "John", "Doe", "123 Main St", "555-1234");
        disabledCustomer.setEstado(Customer.Estado.DISABLED);

        // Configurar el comportamiento del mock para devolver el objeto disabledCustomer cuando se llame a disableAccountByCuit(cuit) con el CUIT correspondiente
        when(customerRepository.findCustomerEnabledByCuit("232")).thenReturn(enabledCustomer);
        when(customerRepository.disableAccountByCuit("232")).thenReturn(disabledCustomer);

        // Act
        Customer updatedCustomer = customerService.disableAccountByCuit("232");

        // Assert
        assertNotNull(updatedCustomer);
        assertEquals(disabledCustomer, updatedCustomer);
        assertEquals(Customer.Estado.DISABLED, updatedCustomer.getEstado());
    }

}