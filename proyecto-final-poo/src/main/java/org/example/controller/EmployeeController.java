package org.example.controller;


import java.util.ArrayList;
import org.example.model.Employee;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;
import org.example.dao.exceptions.NonexistentEntityException;

public class EmployeeController implements CRUD<Employee> {

    EmployeeService employeeService;

    public EmployeeController() {

        this.employeeService = new EmployeeService();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeService.save(employee);
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
    public Employee upDate(Employee employee) throws Exception {
        return employeeService.upDate(employee);

    }

    @Override
    public void delete(String id) throws NonexistentEntityException {
        employeeService.delete(id);

    }

    public List<Employee> findAllEmployeesByCuit(String cuit) {
        return employeeService.findAllEmployeesByCuit(cuit);
    }

    public List<Employee> findAllEnabledCustomers() {
        return employeeService.findAllEnabledEmployees();
    }

    public Employee findCustomerEnabledByCuit(String cuit) {
        return employeeService.findEmployeeEnabledByCuit(cuit);
    }

    public Employee disableAccountByCuit(String cuit) {
        return employeeService.disableAccountByCuit(cuit);
    }
}
