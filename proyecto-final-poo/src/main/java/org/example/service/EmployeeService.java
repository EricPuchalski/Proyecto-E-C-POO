package org.example.service;


import java.util.ArrayList;
import org.example.dao.EmployeeRepository;
import org.example.dao.exceptions.NonexistentEntityException;

import org.example.model.Employee;

import java.util.List;
import java.util.stream.Collectors;
public class EmployeeService implements CRUD<Employee> {
     private EmployeeRepository employeeRepository;
       public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }


    @Override
    public void save(Employee employee) {
        if (!employeeRepository.findEmployeeEntities().contains(employee.getCuit())) {
        employeeRepository.create(employee);
        }
    }

    @Override
     public void upDate(Employee employee) throws Exception {
        if (employeeRepository.findEmployee(employee.getId()) != null) {
            employeeRepository.edit(employee);
        }
    }

    @Override
     public Employee findOne(String CUIT) { 
         if (CUIT == null) {
        return null; // Manejar el caso de un CUIT nulo
    }
    
    for (Employee employee : employeeRepository.findEmployeeEntities()) {
        if (CUIT.equals(employee.getCuit())) {
            return employee;
        }
    }
    return null;
   }

    

    @Override
     public List<Employee> findAll() {
        return employeeRepository.findEmployeeEntities();
    }

    @Override
     public void delete(String CUIT) throws NonexistentEntityException {
        Employee deleteEmployee = findOne(CUIT);
        if (deleteEmployee != null) {
            employeeRepository.destroy(deleteEmployee.getId());
        }
    }
    
     public List<Employee> findAllEmployeesByCuit(String cuit){
         if (cuit == null || cuit.isEmpty()) {
            return new ArrayList<>(); // Si el nombre es nulo o vacío, retornar una lista vacía
        }

        String lowercaseCuit = cuit.toLowerCase(); // Convertir el nombre de búsqueda a minúsculas

        List<Employee> employeesFound = this.findAll()
                .stream()
                .filter(tr -> tr.getCuit().toLowerCase().startsWith(lowercaseCuit))
                .collect(Collectors.toList());
        
        return employeesFound;

     }

}
//
//import org.example.model.Employee;
//import org.example.repository.EmpleadoRepository;
//
//import java.util.List;
//
//public class EmployeeService implements CRUD<Employee>{
//    private EmpleadoRepository empleadoRepository;
//
//    public EmployeeService(EmpleadoRepository empleadoRepository) {
//        this.empleadoRepository = new EmpleadoRepository();
//    }
//
//
//    @Override
//    public void save(Employee employee) {
//        if (findOne(employee.getCUIT())!=null) {
//            empleadoRepository.save(employee);
//        }
//    }
//
//    @Override
//    public void upDate(Employee employee) {
//        if(findOne(employee.getCUIT()) != null){
//            empleadoRepository.upDate(employee);
//        }
//    }
//
//    @Override
//    public Employee findOne(String cuit) {
//        Employee employee = null;
//        if (empleadoRepository.findOne(cuit)!= null) {
//           employee = empleadoRepository.findOne(cuit);
//
//        }
//        return employee;
//    }
//
//
//    @Override
//    public List<Employee> findAll() {
//        return empleadoRepository.findAll();
//    }
//
//
//    @Override
//    public void delete(String cuit) {
//        if (findOne(cuit)!= null){
//            empleadoRepository.delete(cuit);
//        }
//    }
//}
