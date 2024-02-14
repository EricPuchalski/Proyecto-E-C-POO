package org.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CARRIERS")
public class Carrier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cuit;
    private String name;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private CarrierType type;
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public enum Status {
        ENABLED,
        DISABLED
    }
        public enum CarrierType {
        MARITIME,
        LAND,
        AIR
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
    public Carrier(String cuit, String name, String phone, String email) {
        this.cuit = cuit;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = null; //para el test
        this.status = Status.ENABLED; //
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

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CarrierType getType() {
        return type;
    }

    public void setType(CarrierType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Carrier{" + "id=" + id + ", cuit=" + cuit + ", name=" + name + ", phone=" + phone + ", email=" + email + ", type=" + type + ", status=" + status + '}';
    }

    
    
}
