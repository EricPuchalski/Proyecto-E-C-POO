package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Sector {

    private String code;
    private String description;
    private Status status;
    public enum Status {
        ENABLED,
        DISABLED
    }


    public Sector(String code, String description) {
        this.code = code;
        this.description = description;
        this.status = Status.ENABLED;

    }

    public Sector() {
    }

    @Override
    public String toString() {
        return "Sector{" +
                "codigo='" + code + '\'' +
                ", descripcion='" + description + '\'' +
                '}';
    }
}
