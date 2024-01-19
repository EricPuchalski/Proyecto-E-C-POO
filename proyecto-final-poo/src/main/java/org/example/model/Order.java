package org.example.model;


import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String orderNumber;
    private LocalDate orderStart ;
    private LocalDate orderFinish;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Warehouse warehouseOrig;
    @OneToOne
    private Warehouse warehouseDest;
    @OneToOne
    private Tracking tracking;
    @Column(columnDefinition = "CHAR(5)")
    private boolean onTransit;
    @ManyToOne
    private Carrier carrier;
    @OneToMany
    private List<OrderLine> orderLines;
    private String orderStatus;
    @OneToOne
    private DespatchNote despatchNote;

    public Order(String numeroPedido, Customer customer, Warehouse depositOrigen, Warehouse depositDestino, Carrier carrier, String estadoPedido, LocalDate orderStart) {
        this.orderNumber = numeroPedido;
        this.customer = customer;
        this.warehouseOrig = depositOrigen;
        this.warehouseDest = depositDestino;
        this.carrier = carrier;
        this.orderLines = new ArrayList<>();
        this.orderStatus = estadoPedido;
        this.orderStart = orderStart;
//        this.tracking = tracking;

    }
    

    public Order() {
        this.orderLines = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderStart() {
        return orderStart;
    }

    public void setOrderStart(LocalDate orderStart) {
        this.orderStart = orderStart;
    }

    public LocalDate getOrderFinish() {
        return orderFinish;
    }

    public void setOrderFinish(LocalDate orderFinish) {
        this.orderFinish = orderFinish;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Warehouse getWarehouseOrig() {
        return warehouseOrig;
    }

    public void setWarehouseOrig(Warehouse warehouseOrig) {
        this.warehouseOrig = warehouseOrig;
    }

    public Warehouse getWarehouseDest() {
        return warehouseDest;
    }

    public void setWarehouseDest(Warehouse warehouseDest) {
        this.warehouseDest = warehouseDest;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    public boolean isOnTransit() {
        return onTransit;
    }

    public void setOnTransit(boolean onTransit) {
        this.onTransit = onTransit;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public DespatchNote getDespatchNote() {
        return despatchNote;
    }

    public void setDespatchNote(DespatchNote despatchNote) {
        this.despatchNote = despatchNote;
    }

    
}
