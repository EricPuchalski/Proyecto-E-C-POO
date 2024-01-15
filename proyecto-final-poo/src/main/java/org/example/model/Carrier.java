package org.example.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carrier {
    private String cuit;
    private String name;
    private String phone;
    private String email;
    private Order order;
    private CarrierType type;
    private Status status;
    public enum Status {
        ENABLED,
        DISABLED
    }
    public Carrier() {
    }

    public Carrier(String cuit, String name, String phone, String email, CarrierType type) {
        this.cuit = cuit;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.status = Status.ENABLED;
    }

    @Override
    public String toString() {
        return "Transportista{" +
                "cuit='" + cuit + '\'' +
                ", nombre='" + name + '\'' +
                ", telefono='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", tipo='" + getType().getDescription() + '\'' +

                '}';
    }
}
