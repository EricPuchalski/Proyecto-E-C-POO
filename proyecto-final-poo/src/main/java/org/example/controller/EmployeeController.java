package org.example.controller;

import org.example.model.Employee;
import org.example.service.EmployeeService;

import java.util.List;

public class EmployeeController implements  CRUD<Employee> {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
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
    public void upDate(Employee employee) {
        employeeService.upDate(employee);

    }

    @Override
    public void delete(String id) {
        employeeService.delete(id);

    }
}
