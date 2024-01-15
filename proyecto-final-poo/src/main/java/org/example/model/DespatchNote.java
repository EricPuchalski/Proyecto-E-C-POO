package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DespatchNote {

    private LocalDate issuance;
    private Carrier carrier;
    private Employee employeeSender;
    private Employee employeeReceiver;
    private int calificacionTransportista;


    public DespatchNote(LocalDate issuance, Carrier carrier, Employee employeeSender, Employee employeeReceiver) {

        this.issuance = issuance;
        this.carrier = carrier;
        this.employeeSender = employeeSender;
        this.employeeReceiver = employeeReceiver;
    }
}
