package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Deposit {
    private String code;
    private String name;
    private String adress;
    private String phone;
    private String email;
    private String continent;
    private Position position;
    private Estado status;

    private List<Sector> sectors;
    public enum Estado{
        ENABLED,
        DISABLED
    }

    public Deposit(String code, String name, String adress, String telefono, String email, String continent, Position position) {
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.phone = telefono;
        this.email = email;
        this.continent = continent;
        this.sectors = new ArrayList<>();
        this.position = position;
        this.status = Estado.ENABLED;
    }

    public Deposit() {
        this.sectors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "codigo='" + code + '\'' +
                ", nombre='" + name + '\'' +
                ", direccion='" + adress + '\'' +
                ", telefono='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", continente='" + continent + '\'' +
                '}';
    }
}
