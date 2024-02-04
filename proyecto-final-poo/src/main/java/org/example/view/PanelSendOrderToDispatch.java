/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import javax.swing.JOptionPane;
import org.example.controller.OrderController;
import org.example.controller.ViewController;

/**
 *
 * @author ericp
 */
public class PanelSendOrderToDispatch extends javax.swing.JPanel {

        private ViewController viewController;
    private OrderController orderController;
    /**
     * Creates new form PanelSendOrderToDispatch
     */
    public PanelSendOrderToDispatch() {
        this.viewController = new ViewController();
         this.orderController = new OrderController();
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
        lblOrder = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        bttnOrder = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();
        bttnConfirm = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblWelcome.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 0));
        lblWelcome.setText("ENVIAR PEDIDO A DESPACHO");

        lblOrder.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(0, 0, 0));
        lblOrder.setText("Nro pedido");

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblOrders);

        bttnOrder.setText("Buscar");
        bttnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOrderActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(204, 0, 0));
        bttnBack.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(255, 255, 255));
        bttnBack.setText("Cancelar");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        bttnConfirm.setBackground(new java.awt.Color(0, 102, 255));
        bttnConfirm.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        bttnConfirm.setText("Confirmar");
        bttnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(bttnOrder))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrder)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnOrder))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOrderActionPerformed
        tblOrders.setModel(viewController.modelTableOrdersByNumber(txtOrder.getText()));
    }//GEN-LAST:event_bttnOrderActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelOrder(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        if(tblOrders.getRowCount() > 0){
            if(tblOrders.getSelectedRow()!=-1){
                String orderNumber = String.valueOf(tblOrders.getValueAt(tblOrders.getSelectedRow(),3));
                orderController.sendOrderToDispatch(orderNumber);
                ViewController.panelChange(this, new PanelOrder(), this);
                JOptionPane.showMessageDialog(this, "Pedido enviado a despacho", "Exito", JOptionPane.INFORMATION_MESSAGE);

            } else{ 
                 JOptionPane.showMessageDialog(this, "Por favor seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_bttnConfirmActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblOrders.setModel(viewController.modelTableOrders());
    }//GEN-LAST:event_formAncestorAdded

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JButton bttnOrder;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txtOrder;
    // End of variables declaration//GEN-END:variables
}
