/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.util;

import java.util.Random;

/**
 *
 * @author ericp
 */
public class GenerateOrderNumber {
    
    public String generateRandomOrderNumber() {
    // Implementación para generar un número de pedido aleatorio
    // Puedes ajustar la longitud o el formato según tus necesidades
    int orderNumberLength = 8;
    Random random = new Random();
    
    StringBuilder orderNumber = new StringBuilder();
    for (int i = 0; i < orderNumberLength; i++) {
        orderNumber.append(random.nextInt(10));
    }

    return orderNumber.toString();
}
}
