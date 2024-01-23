/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ericp
 */
public class ViewController {
        public static void panelChange(JPanel panelRemove,JPanel panelNew, Component o){
        JFrame contenedor = (JFrame) SwingUtilities.getWindowAncestor(o);
        contenedor.remove(panelRemove);
        contenedor.add(panelNew);
        contenedor.validate();
        contenedor.repaint();
    }
}
