//package org.example.service;
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
