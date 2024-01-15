package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String code;
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private ProductCategory category;
    private boolean enabled;
    private Supplier supplier;
    private Status status;
    public enum Status {
        ENABLED,
        DISABLED
    }


    public Product(String code, String name, double width, double height, double length, double weight, ProductCategory category, Supplier supplier) {
        this.code = code;
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.category = category;
        this.supplier = supplier;
        this.enabled = isEnabled();
        this.status = Status.ENABLED;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Product() {
    }


    @Override
    public String toString() {
        return "Producto "+
                "codigo='" + code + '\'' +
                ", nombre='" + name + '\'' +
                ", ancho=" + width +
                ", altura=" + height +
                ", largo=" + length +
                ", peso=" + weight +
                ", categoria=" + category +
                ", proveedor=" + supplier +
                '}';
    }

}
