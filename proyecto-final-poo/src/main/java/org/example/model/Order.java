package org.example.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Order {


    private String numeroPedido;
    private LocalDate inicioPedido ;
    private LocalDate finPedido;
    private Customer customer;
    private Deposit depositOrigen;
    private Deposit depositDestino;
    private Tracking tracking;
    private boolean enTransito;
    private Carrier carrier;
    private List<OrderLine> lineasPedidos;
    private String estadoPedido;
    private Employee employee;
    private DespatchNote despatchNote;

    public Order(String numeroPedido, Customer customer, Deposit depositOrigen, Deposit depositDestino, Carrier carrier, String estadoPedido, Tracking tracking) {
        this.numeroPedido = numeroPedido;
        this.customer = customer;
        this.depositOrigen = depositOrigen;
        this.depositDestino = depositDestino;
        this.carrier = carrier;
        this.lineasPedidos = new ArrayList<>();
        this.estadoPedido = estadoPedido;
        this.tracking = tracking;

    }

    public Order() {
        this.lineasPedidos = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", inicioPedido=" + inicioPedido +
                ", finPedido=" + finPedido +
                ", cliente=" + customer +
                ", depositoOrigen=" + depositOrigen +
                ", depositoDestino=" + depositDestino +
                ", seguimiento=" + tracking +
                ", enTransito=" + enTransito +
                ", transportista=" + carrier +
                ", lineasPedidos=" + lineasPedidos +
                ", estadoPedido='" + estadoPedido + '\'' +
                ", empleado=" + employee +
                '}';
    }
}
