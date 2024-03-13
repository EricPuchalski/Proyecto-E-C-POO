/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.example.controller.CarrierController;
import org.example.controller.OrderController;
import org.example.controller.ViewController;
import org.example.dao.CarrierRepository;
import org.example.dao.OrderRepository;
import org.example.model.Order;
import org.example.service.CarrierService;

/**
 *
 * @author ericp
 */
public class PanelCarrierTrackingOrder extends javax.swing.JPanel {
    private ViewController viewController;
    private OrderController orderController;
    private CarrierController carrierController;
    /**
     * Creates new form PanelCarrierTrackingOrder
     */
    public PanelCarrierTrackingOrder() {
        this.viewController = new ViewController();
        this.orderController = new OrderController();
        this.carrierController = new CarrierController();
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
        bttnOrder = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        lblCarrier = new javax.swing.JLabel();
        txtCarrier = new javax.swing.JTextField();
        lblLong = new javax.swing.JLabel();
        lblLat = new javax.swing.JLabel();
        txtLat = new javax.swing.JTextField();
        txtLong = new javax.swing.JTextField();
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
        lblWelcome.setText("ACTUALIZAR UBICACIÓN");

        lblOrder.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(0, 0, 0));
        lblOrder.setText("Nro pedido");

        bttnOrder.setText("Buscar");
        bttnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOrderActionPerformed(evt);
            }
        });

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

        lblCarrier.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCarrier.setForeground(new java.awt.Color(0, 0, 0));
        lblCarrier.setText("Cuit transportista");

        lblLong.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblLong.setForeground(new java.awt.Color(0, 0, 0));
        lblLong.setText("Longitud");

        lblLat.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblLat.setForeground(new java.awt.Color(0, 0, 0));
        lblLat.setText("Latitud");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblLong, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(bttnOrder))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblWelcome)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnOrder)
                    .addComponent(lblOrder)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarrier)
                    .addComponent(txtCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLong)
                    .addComponent(lblLat)
                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOrderActionPerformed
        tblOrders.setModel(viewController.modelTableOrdersByNumber(txtOrder.getText()));
    }//GEN-LAST:event_bttnOrderActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelCarrier(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        if (tblOrders.getRowCount() > 0) {
            if (tblOrders.getSelectedRow() != -1) {
               
                try {
                    String orderNumber = String.valueOf(tblOrders.getValueAt(tblOrders.getSelectedRow(), 3)) ;
                    Order order = orderController.findOneByOrderNumber(orderNumber);
                    if(order.getTracking()!=null){
                        if(orderController.informOrderPosition(txtCarrier.getText(), orderNumber, Double.parseDouble(txtLat.getText()), Double.parseDouble(txtLong.getText()))){
                            JOptionPane.showMessageDialog(this, "Se informó la nueva posición", "Exito", JOptionPane.INFORMATION_MESSAGE);
                            ViewController.panelChange(this, new PanelCarrier(), this);
                        } else{
                            JOptionPane.showMessageDialog(this, "El transportista no coincide!", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    } else{
                        JOptionPane.showMessageDialog(this, "El pedido no está despachado", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (Exception ex) {
                    Logger.getLogger(PanelCarrierTrackingOrder.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Verifique sus datos", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                } 
    }//GEN-LAST:event_bttnConfirmActionPerformed
}
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        this.tblOrders.setModel(viewController.modelTableOrders());
    }//GEN-LAST:event_formAncestorAdded
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JButton bttnOrder;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCarrier;
    private javax.swing.JLabel lblLat;
    private javax.swing.JLabel lblLong;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txtCarrier;
    private javax.swing.JTextField txtLat;
    private javax.swing.JTextField txtLong;
    private javax.swing.JTextField txtOrder;
    // End of variables declaration//GEN-END:variables
}
