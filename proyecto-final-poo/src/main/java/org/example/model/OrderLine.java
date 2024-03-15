package org.example.model;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
@Entity
@Table(name = "ORDER_LINES")
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private int quantity;
    private static String ultimoId;
    private String code;


    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.code = generarId();
    }

    public OrderLine() {
    }
    
    
    private static String generarId() {
        // Aquí utilizamos la clase Random para generar un número aleatorio.
        // También se podría implementar una lógica más robusta para asegurar la unicidad.
        Random random = new Random();
        int nuevoIdInt = random.nextInt(10000); // Puedes ajustar el rango según tus necesidades.
        String nuevoId = String.valueOf(nuevoIdInt);

        // Si por algún motivo el ID generado ya existe, genera uno nuevo hasta que sea único.
        while (nuevoId.equals(ultimoId)) {
            nuevoIdInt = random.nextInt(10000);
            nuevoId = String.valueOf(nuevoIdInt);
        }

        // Actualiza el último ID generado para el siguiente producto.
        ultimoId = nuevoId;
        return nuevoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static String getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(String ultimoId) {
        OrderLine.ultimoId = ultimoId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
