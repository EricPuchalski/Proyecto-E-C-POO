package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Customer {
    private String cuit;
    private String name;
    private String surname;
    private List<Order> orders;
    private Estado estado;
    private String adress;
    private String phone;

    public enum Estado{
        ENABLED,
        DISABLED
    }


    public Customer() {
        this.orders = new ArrayList<>();
    }

    public Customer(String cuit, String name, String surname, String adress, String phone) {
        this.cuit = cuit;
        this.name = name;
        this.surname = surname;
        this.orders = new ArrayList<>();
        this.estado = Estado.ENABLED;
        this.adress = adress;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Cliente " +
                "cuit='" + cuit + '\'' +
                ", nombre='" + name + '\'' +
                ", apellido='" + surname + '\'' +
                ", estado=" + estado +
                ", direccion='" + adress + '\'' +
                ", telefono='" + phone + '\''
                ;
    }
}
