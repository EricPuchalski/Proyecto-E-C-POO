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
public class PanelOrder extends javax.swing.JPanel {
    

    /**
     * Creates new form PanelOrder
     */
    public PanelOrder() {
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

        lblWelcome = new javax.swing.JLabel();
        lblComplement = new javax.swing.JLabel();
        bttnCreateOrder = new javax.swing.JButton();
        bttnProcessOrder = new javax.swing.JButton();
        bttnCompleteOrder = new javax.swing.JButton();
        bttnSendToDispatch = new javax.swing.JButton();
        bttnDispatchOrder = new javax.swing.JButton();
        bttnTransitOrder = new javax.swing.JButton();
        bttnSendToWarehouseDest = new javax.swing.JButton();
        bttnDeliveryOrder = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 153));

        lblWelcome.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(232, 245, 255));
        lblWelcome.setText("Gestion de Pedidos");

        lblComplement.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblComplement.setForeground(new java.awt.Color(232, 245, 255));
        lblComplement.setText("Por favor seleccione la opcion que desee");

        bttnCreateOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnCreateOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnCreateOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnCreateOrder.setText("CREAR PEDIDO");
        bttnCreateOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCreateOrderActionPerformed(evt);
            }
        });

        bttnProcessOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnProcessOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnProcessOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnProcessOrder.setText("PROCESAR PEDIDO");
        bttnProcessOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnProcessOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnProcessOrderActionPerformed(evt);
            }
        });

        bttnCompleteOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnCompleteOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnCompleteOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnCompleteOrder.setText("COMPLETAR PEDIDO");
        bttnCompleteOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCompleteOrderActionPerformed(evt);
            }
        });

        bttnSendToDispatch.setBackground(new java.awt.Color(0, 0, 102));
        bttnSendToDispatch.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnSendToDispatch.setForeground(new java.awt.Color(0, 195, 225));
        bttnSendToDispatch.setText("ENVIAR A DESPACHO");
        bttnSendToDispatch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnSendToDispatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSendToDispatchActionPerformed(evt);
            }
        });

        bttnDispatchOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnDispatchOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnDispatchOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnDispatchOrder.setText("DESPACHAR PEDIDO");
        bttnDispatchOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnDispatchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDispatchOrderActionPerformed(evt);
            }
        });

        bttnTransitOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnTransitOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnTransitOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnTransitOrder.setText("TRANSITAR PEDIDO");
        bttnTransitOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnTransitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnTransitOrderActionPerformed(evt);
            }
        });

        bttnSendToWarehouseDest.setBackground(new java.awt.Color(0, 0, 102));
        bttnSendToWarehouseDest.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnSendToWarehouseDest.setForeground(new java.awt.Color(0, 195, 225));
        bttnSendToWarehouseDest.setText("ENVIAR A DÉPOSITO DESTINO");
        bttnSendToWarehouseDest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnSendToWarehouseDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSendToWarehouseDestActionPerformed(evt);
            }
        });

        bttnDeliveryOrder.setBackground(new java.awt.Color(0, 0, 102));
        bttnDeliveryOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnDeliveryOrder.setForeground(new java.awt.Color(0, 195, 225));
        bttnDeliveryOrder.setText("ENTREGAR PEDIDO");
        bttnDeliveryOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDeliveryOrderActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(217, 74, 51));
        bttnBack.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(204, 255, 255));
        bttnBack.setText("SALIR");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblComplement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, Short.MAX_VALUE)
                        .addComponent(bttnCreateOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnProcessOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnCompleteOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnDispatchOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnSendToDispatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnTransitOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnSendToWarehouseDest, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addComponent(bttnDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGap(3, 3, 3)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttnCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnProcessOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnCompleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnSendToDispatch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnDispatchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnTransitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnSendToWarehouseDest, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCreateOrderActionPerformed
        ViewController.panelChange(this, new PanelCreateOrder1(), this);
    }//GEN-LAST:event_bttnCreateOrderActionPerformed

    private void bttnProcessOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnProcessOrderActionPerformed
                ViewController.panelChange(this, new PanelProcessOrder(), this);

    }//GEN-LAST:event_bttnProcessOrderActionPerformed

    private void bttnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCompleteOrderActionPerformed
        ViewController.panelChange(this, new PanelCompleteOrder(), this);
    }//GEN-LAST:event_bttnCompleteOrderActionPerformed

    private void bttnSendToDispatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSendToDispatchActionPerformed
        ViewController.panelChange(this, new PanelSendOrderToDispatch(), this);
    }//GEN-LAST:event_bttnSendToDispatchActionPerformed

    private void bttnDispatchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDispatchOrderActionPerformed
        ViewController.panelChange(this, new PanelDispatchOrder(), this);
    }//GEN-LAST:event_bttnDispatchOrderActionPerformed

    private void bttnTransitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnTransitOrderActionPerformed
        ViewController.panelChange(this, new PanelTransitOrder(), this);

    }//GEN-LAST:event_bttnTransitOrderActionPerformed

    private void bttnSendToWarehouseDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSendToWarehouseDestActionPerformed
        ViewController.panelChange(this, new PanelSendOrderToDelivery(), this);
    }//GEN-LAST:event_bttnSendToWarehouseDestActionPerformed

    private void bttnDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDeliveryOrderActionPerformed
        ViewController.panelChange(this, new PanelDeliveryOrder(), this);
    }//GEN-LAST:event_bttnDeliveryOrderActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelMain(), this);
    }//GEN-LAST:event_bttnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnCompleteOrder;
    private javax.swing.JButton bttnCreateOrder;
    private javax.swing.JButton bttnDeliveryOrder;
    private javax.swing.JButton bttnDispatchOrder;
    private javax.swing.JButton bttnProcessOrder;
    private javax.swing.JButton bttnSendToDispatch;
    private javax.swing.JButton bttnSendToWarehouseDest;
    private javax.swing.JButton bttnTransitOrder;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
