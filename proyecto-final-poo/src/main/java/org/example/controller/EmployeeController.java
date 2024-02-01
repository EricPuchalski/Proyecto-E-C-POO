package org.example.controller;

import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import org.example.model.Employee;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController implements  CRUD<Employee> {
    EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    @Override
    public void create(Employee employee) {
        employeeService.save(employee);
    }

    @Override
    public Employee findOne(String id) {
        return employeeService.findOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    @Override
    public void upDate(Employee employee) throws Exception {
        employeeService.upDate(employee);

    }

    @Override
    public void delete(String id) throws NonexistentEntityException {
        employeeService.delete(id);

    }
    
        public List<Employee> findAllEmployeesByCuit(String cuit) {
        if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }

        String lowercaseCuit = cuit.toLowerCase(); // Convertir el nombre de búsqueda a minúsculas

        List<Employee> employeesFound = this.findAll()
                .stream()
                .filter(tr -> tr.getCUIT().toLowerCase().startsWith(lowercaseCuit))
                .collect(Collectors.toList());

        return employeesFound;
    }
}
