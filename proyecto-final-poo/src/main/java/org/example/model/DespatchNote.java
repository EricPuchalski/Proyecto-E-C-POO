package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "DESPATCH_NOTES")
public class DespatchNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate issuance;
    @OneToOne
    private Carrier carrier;
    @OneToOne
    private Employee employeeSender;
    @OneToOne
    private Employee employeeReceiver;
    private int calificacionTransportista;


    public DespatchNote(LocalDate issuance, Carrier carrier, Employee employeeSender, Employee employeeReceiver) {

        this.issuance = issuance;
        this.carrier = carrier;
        this.employeeSender = employeeSender;
        this.employeeReceiver = employeeReceiver;
    }

    public DespatchNote() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIssuance() {
        return issuance;
    }

    public void setIssuance(LocalDate issuance) {
        this.issuance = issuance;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Employee getEmployeeSender() {
        return employeeSender;
    }

    public void setEmployeeSender(Employee employeeSender) {
        this.employeeSender = employeeSender;
    }

    public Employee getEmployeeReceiver() {
        return employeeReceiver;
    }

    public void setEmployeeReceiver(Employee employeeReceiver) {
        this.employeeReceiver = employeeReceiver;
    }

    public int getCalificacionTransportista() {
        return calificacionTransportista;
    }

    public void setCalificacionTransportista(int calificacionTransportista) {
        this.calificacionTransportista = calificacionTransportista;
    }
    
    
}
