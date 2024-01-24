/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.example.controller.CarrierController;
import org.example.controller.CustomerController;
import org.example.controller.OrderController;
import org.example.controller.ViewController;
import org.example.model.Customer;

/**
 *
 * @author ericp
 */
public class PanelCreateOrder1 extends javax.swing.JPanel {
    private CustomerController customerController;
    private ViewController viewController;
    private CarrierController carrierController;
    private OrderController orderController;

    /**
     * Creates new form PanelCreateOrder1
     */
    public PanelCreateOrder1() {
        this.viewController = new ViewController();
        this.customerController = new CustomerController();
        this.carrierController = new CarrierController();
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
        lblCustomer = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        bttnFindCustomer = new javax.swing.JButton();
        lblCarrier = new javax.swing.JLabel();
        txtCarrier = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCarriers = new javax.swing.JTable();
        bttnFindCarrier = new javax.swing.JButton();
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
        lblWelcome.setText("CREAR PEDIDO");

        lblCustomer.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCustomer.setForeground(new java.awt.Color(0, 0, 0));
        lblCustomer.setText("Cliente");

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblCustomers);

        bttnFindCustomer.setText("Buscar");
        bttnFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFindCustomerActionPerformed(evt);
            }
        });

        lblCarrier.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCarrier.setForeground(new java.awt.Color(0, 0, 0));
        lblCarrier.setText("Transportista");

        tblCarriers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblCarriers);

        bttnFindCarrier.setText("Buscar");
        bttnFindCarrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFindCarrierActionPerformed(evt);
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
        bttnConfirm.setText("Siguiente");
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
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCarrier)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bttnFindCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bttnFindCustomer))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomer)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnFindCustomer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarrier)
                    .addComponent(txtCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnFindCarrier))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFindCustomerActionPerformed
        tblCustomers.setModel(viewController.modelTableCustomersByCuit(txtCustomer.getText()));
    }//GEN-LAST:event_bttnFindCustomerActionPerformed

    private void bttnFindCarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFindCarrierActionPerformed
       tblCarriers.setModel(viewController.modelTableCarriersByCuit(txtCarrier.getText()));
    }//GEN-LAST:event_bttnFindCarrierActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelOrder(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        List<String> cuits = orderController.returnCuitsCustomerCarrier(tblCustomers, tblCarriers);
        ViewController.panelChange(this, new PanelCreateOrder2(cuits.get(0), cuits.get(1)), this);
//        System.out.println(cuits.get(0) + " " + cuits.get(1));
    }//GEN-LAST:event_bttnConfirmActionPerformed
    private void loadData(){
        tblCustomers.setModel(viewController.modelTableCustomers());
        tblCarriers.setModel(viewController.modelTableCarriers());
    }
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        this.loadData();
     }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JButton bttnFindCarrier;
    private javax.swing.JButton bttnFindCustomer;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCarrier;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblCarriers;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtCarrier;
    private javax.swing.JTextField txtCustomer;
    // End of variables declaration//GEN-END:variables
}
