package org.example.model;


import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trackings")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateAndTime;
    private double latitude;
    private double longitude;
    @OneToOne
    private Order order;
    @OneToOne
    private Sector sector;
    private String trackingNumber;

    public Tracking(LocalDate dateAndTime, double latitude, double longitude, Order order, Sector sector) {
        this.dateAndTime = dateAndTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.order = order;
        this.sector = sector;
    }
    public Tracking(LocalDate dateAndTime, double latitude, double longitude) {
        this.dateAndTime = dateAndTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Tracking() {
    }

    
    public Tracking(Order order) {
        this.order = order;
    }
    public String generarNumeroRastreo() {
        // genera un identificador unical
        return UUID.randomUUID().toString();
    }

    public LocalDate getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDate dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
}
