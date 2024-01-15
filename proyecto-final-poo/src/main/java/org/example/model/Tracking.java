package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Tracking {
    private LocalDate dateAndTime;
    private double latitude;
    private double longitude;
    private Order order;
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

    public Tracking(Order order) {
        this.order = order;
    }
    public String generarNumeroRastreo() {
        // genera un identificador unical
        return UUID.randomUUID().toString();
    }


}
