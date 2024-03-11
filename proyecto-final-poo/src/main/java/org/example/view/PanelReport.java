/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import org.example.controller.ViewController;

/**
 *
 * @author ericp
 */
public class PanelReport extends javax.swing.JPanel {

    /**
     * Creates new form PanelReport
     */
    public PanelReport() {
        this.setSize(800,700);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPresent = new javax.swing.JLabel();
        bttnComplement = new javax.swing.JLabel();
        bttnOrderLines = new javax.swing.JButton();
        bttnConsultCustomer = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();
        bttnCreateCustomer1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 255));

        lblPresent.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        lblPresent.setForeground(new java.awt.Color(232, 245, 255));
        lblPresent.setText("Gestion de informes");

        bttnComplement.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bttnComplement.setForeground(new java.awt.Color(232, 245, 255));
        bttnComplement.setText("Por favor seleccione la opcion que desee");

        bttnOrderLines.setBackground(new java.awt.Color(0, 0, 102));
        bttnOrderLines.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnOrderLines.setForeground(new java.awt.Color(0, 195, 225));
        bttnOrderLines.setText("VER LINEAS DE PEDIDO");
        bttnOrderLines.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnOrderLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOrderLinesActionPerformed(evt);
            }
        });

        bttnConsultCustomer.setBackground(new java.awt.Color(0, 0, 102));
        bttnConsultCustomer.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnConsultCustomer.setForeground(new java.awt.Color(0, 195, 225));
        bttnConsultCustomer.setText("PEDIDOS POR DEPOSITO DE ORIGEN");
        bttnConsultCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnConsultCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConsultCustomerActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(217, 74, 51));
        bttnBack.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(204, 255, 255));
        bttnBack.setText("SALIR");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        bttnCreateCustomer1.setBackground(new java.awt.Color(0, 0, 102));
        bttnCreateCustomer1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnCreateCustomer1.setForeground(new java.awt.Color(0, 195, 225));
        bttnCreateCustomer1.setText("VER PEDIDOS DE UN CLIENTE");
        bttnCreateCustomer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnCreateCustomer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCreateCustomer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPresent)
                    .addComponent(bttnComplement))
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnOrderLines, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnCreateCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConsultCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblPresent)
                .addGap(87, 87, 87)
                .addComponent(bttnComplement)
                .addGap(52, 52, 52)
                .addComponent(bttnCreateCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttnConsultCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttnOrderLines, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnOrderLinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOrderLinesActionPerformed
        ViewController.panelChange(this, new PanelSeeOrderLines(), this);
    }//GEN-LAST:event_bttnOrderLinesActionPerformed

    private void bttnConsultCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConsultCustomerActionPerformed
        ViewController.panelChange(this, new PanelReportOrdersByWarehouseOrig(), this);
    }//GEN-LAST:event_bttnConsultCustomerActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelMain(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnCreateCustomer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCreateCustomer1ActionPerformed
        ViewController.panelChange(this, new PanelReportOrdersByCustomer(), this);
    }//GEN-LAST:event_bttnCreateCustomer1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JLabel bttnComplement;
    private javax.swing.JButton bttnConsultCustomer;
    private javax.swing.JButton bttnCreateCustomer1;
    private javax.swing.JButton bttnOrderLines;
    private javax.swing.JLabel lblPresent;
    // End of variables declaration//GEN-END:variables
}
