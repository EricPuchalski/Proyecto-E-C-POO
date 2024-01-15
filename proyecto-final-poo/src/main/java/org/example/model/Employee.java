package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employee {
    private String CUIT;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private Estado estado;
    private Deposit deposit;
    public enum Estado{
        DISABLED,
        ENABLED

    }

    public Employee(String CUIT, String nombre, String apellido, String direccion, String telefono, Deposit deposit) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        estado = Estado.ENABLED;
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "CUIT='" + CUIT + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado=" + estado +
                ", deposito=" + deposit +
                '}';
    }
}
