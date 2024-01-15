package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrierType {

    private String description;

    public CarrierType(String description) {
        this.description = description;
    }

    public CarrierType() {
    }
}
