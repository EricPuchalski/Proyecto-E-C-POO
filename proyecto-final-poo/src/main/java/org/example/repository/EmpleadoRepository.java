package org.example.repository;

import org.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements CRUD<Employee>{
    private List<Employee> employees;
    private DepositoRepository depositoRepository;

    public EmpleadoRepository() {
        this.employees = new ArrayList<>();
        this.depositoRepository = new DepositoRepository();
        upLoad();
    }


    @Override
    public void upLoad() {
        Employee employee1 = new Employee("123", "Juan", "Perez", "Calle 23", "232323", depositoRepository.findOne("1"));
        Employee employee2 = new Employee("456", "María", "López", "Avenida 45", "454545", depositoRepository.findOne("2"));
        Employee employee3 = new Employee("789", "Pedro", "Gómez", "Calle 67", "676767", depositoRepository.findOne("3"));
        Employee employee4 = new Employee("101", "Laura", "Rodríguez", "Avenida 89", "898989", depositoRepository.findOne("4"));
        Employee employee5 = new Employee("121", "Carlos", "Sánchez", "Calle 10", "101010", depositoRepository.findOne("5"));


        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void upDate(Employee employee) {
        if (findOne(employee.getCUIT()) != null) {
            findOne(employee.getCUIT()).setNombre(employee.getNombre());
            findOne(employee.getCUIT()).setApellido(employee.getApellido());
            findOne(employee.getCUIT()).setDireccion(employee.getDireccion());
            findOne(employee.getCUIT()).setTelefono(employee.getTelefono());
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee>empleadosHabilitados = new ArrayList<>();
        for(Employee er : employees){
            if(er.getEstado() == Employee.Status.ENABLED){
                empleadosHabilitados.add(er);
            }
        }
        return empleadosHabilitados;
    }



    @Override
    public Employee findOne(String id) {
        Employee employee = null;
        for (Employee er: employees){
            if (er.getCUIT().equals(id)){
                employee = er;
            }
        }
        return employee;
    }

    @Override
    public void delete(String id) {
        if(findOne(id) != null){
            findOne(id).setEstado(Employee.Status.DISABLED);
        }
    }
}
