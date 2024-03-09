/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import javax.swing.JOptionPane;
import org.example.controller.OrderController;
import org.example.controller.ViewController;
import org.example.model.Order;

/**
 *
 * @author ericp
 */
public class PanelTransitOrder extends javax.swing.JPanel {
    private ViewController viewController;
    private OrderController orderController;
    /**
     * Creates new form PanelTransitOrder
     */
    public PanelTransitOrder() {
        this.viewController = new ViewController();
        this.orderController = new OrderController();
        initComponents();
        this.setSize(800,700);
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
        txtOrder = new javax.swing.JTextField();
        lblOrder = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        bttnBack = new javax.swing.JButton();
        bttnConfirm = new javax.swing.JButton();
        bttnOrder = new javax.swing.JButton();

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
        lblWelcome.setText("TRANSITAR PEDIDO");

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

        bttnBack.setBackground(new java.awt.Color(204, 0, 0));
        bttnBack.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(255, 255, 255));
        bttnBack.setText("Cancelar");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        bttnConfirm.setBackground(new java.awt.Color(0, 102, 255));
        bttnConfirm.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        bttnConfirm.setText("Confirmar");
        bttnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmActionPerformed(evt);
            }
        });

        bttnOrder.setText("Buscar");
        bttnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(lblWelcome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bttnOrder)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)
                            .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(167, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnOrder))
                .addContainerGap(523, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(196, 196, 196)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelOrder(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        if(tblOrders.getRowCount() > 0){
            if(tblOrders.getSelectedRow()!=-1){
                String orderNumber = String.valueOf(tblOrders.getValueAt(tblOrders.getSelectedRow(),3));
                Order orderFound = orderController.findOneByOrderNumber(orderNumber);
                if (orderFound.getOrderStatus().equals("Despacho")) {
                    orderController.orderTransit(orderNumber);
                    JOptionPane.showMessageDialog(this, "Pedido enviado a transito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    ViewController.panelChange(this, new PanelOrder(), this);

                } else {
                    JOptionPane.showMessageDialog(this, "El pedido no está despachado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(orderFound.getOrderStatus());
                }

            }
            else{
                JOptionPane.showMessageDialog(this, "Por favor seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_bttnConfirmActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblOrders.setModel(viewController.modelTableOrders());
    }//GEN-LAST:event_formAncestorAdded

    private void bttnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOrderActionPerformed
        tblOrders.setModel(viewController.modelTableOrdersByNumber(txtOrder.getText()));
    }//GEN-LAST:event_bttnOrderActionPerformed


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
