package org.example.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "warehouses")

public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    private String adress;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    private String continent;
    @OneToOne
    private Position position;
    @Enumerated(EnumType.STRING)
    private Estado status;
    @OneToMany
    private List<Sector> sectors;
    public enum Estado{
        ENABLED,
        DISABLED
    }

    public Warehouse(String code, String name, String adress, String telefono, String email, String continent, Position position) {
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

    public Warehouse() {
        this.sectors = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Estado getStatus() {
        return status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    
}
