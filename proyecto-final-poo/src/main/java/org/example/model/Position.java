package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Position {
    private double latitude;
    private double longitude;


    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "latidud=" + latitude +
                ", longitud=" + longitude +
                '}';
    }
}
