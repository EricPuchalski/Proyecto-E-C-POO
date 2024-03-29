package org.example.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WAREHOUSES")

public class Warehouse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Embedded
    private Position position;
    @Enumerated(EnumType.STRING)
    private Estado status;
    @OneToOne
    private Employee employee;
    @ManyToMany
    @JoinColumn(name = "warehouse_id")
    private List<Sector> sectors;
    public enum Estado{
        ENABLED,
        DISABLED
    }


    public Warehouse(String code, String name, String adress, String phone, String email, String continent, Position position) {
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.continent = continent;
        this.position = position;
        this.status = Estado.ENABLED;
        this.sectors = new ArrayList<>();

    }

        public Warehouse(String code, String name, String adress, String phone, String email, String continent, Position position, Employee employee) {
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.continent = continent;
        this.position = position;
        this.status = Estado.ENABLED;
        this.employee = employee;
        this.sectors = new ArrayList<>();

    }
        public Warehouse(String code) {
    this.code = code;
    this.sectors = new ArrayList<>(); // Inicializa la lista de sectores
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    
}
//        @JoinTable(
//        name = "depositoS_sectores",
//        joinColumns = @JoinColumn(name = "sector_id"),
//        inverseJoinColumns = @JoinColumn(name = "deposito_id")
//    )