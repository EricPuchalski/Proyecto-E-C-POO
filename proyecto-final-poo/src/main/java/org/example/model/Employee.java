package org.example.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")

public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cuit;
    private String name;
    private String surname;
    private String address;
    @Column(unique = true)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    private Warehouse warehouse;
    public enum Status{
        DISABLED,
        ENABLED

    }

    public Employee(String cuit, String nombre, String apellido, String direccion, String telefono, Warehouse deposit) {
        this.cuit = cuit;
        this.name = nombre;
        this.surname = apellido;
        this.address = direccion;
        this.phoneNumber = telefono;
        status = Status.ENABLED;
        this.warehouse = deposit;
    }

    public Employee(String cuit, String name, String surname, String address, String phoneNumber) {
        this.cuit = cuit;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        status = Status.ENABLED;

    }

    
    public Employee() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    

    public void setCuit(String CUIT) {
        this.cuit = CUIT;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getApellido() {
        return surname;
    }

    public void setApellido(String apellido) {
        this.surname = apellido;
    }

    public String getDireccion() {
        return address;
    }

    public void setDireccion(String direccion) {
        this.address = direccion;
    }

    public String getTelefono() {
        return phoneNumber;
    }

    public void setTelefono(String telefono) {
        this.phoneNumber = telefono;
    }

    public Status getEstado() {
        return status;
    }

    public void setEstado(Status estado) {
        this.status = estado;
    }

    public Warehouse getDeposit() {
        return warehouse;
    }

    public void setDeposit(Warehouse deposit) {
        this.warehouse = deposit;
    }

    
}
