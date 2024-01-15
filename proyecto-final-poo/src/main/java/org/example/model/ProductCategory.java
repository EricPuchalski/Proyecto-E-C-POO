package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCategory {
    private String nombre;

    public ProductCategory(String nombre) {
        this.nombre = nombre;
    }

    public ProductCategory() {
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
