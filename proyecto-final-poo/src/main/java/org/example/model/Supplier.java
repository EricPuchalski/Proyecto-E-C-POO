package org.example.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Supplier {
    private String cuit;
    private String name;
    private String adress;
    private String phone;
    private String email;
    private Status status;


    public enum Status {
        ENABLED,
        DISABLED
    }

    public Supplier(String cuit, String name, String adress, String phone, String email) {
        this.cuit = cuit;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.status = Status.ENABLED;
    }

    @Override
    public String toString() {
        return "cuit: " + cuit + '\'' +
                ", nombre: " + name + '\'' +
                ", direccion: " + adress + '\'' +
                ", telefono: " + phone + '\'' +
                ", email: " + email + '\'' +
                ", estado: " + status;
    }
}
