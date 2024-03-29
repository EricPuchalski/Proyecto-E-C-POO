/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.controller.ViewController;
import org.example.controller.WarehouseController;
import org.example.dao.exceptions.NonexistentEntityException;

/**
 *
 * @author ericp
 */
public class PanelWarehouseConsult extends javax.swing.JPanel {
    private WarehouseController warehouseController;
    private ViewController viewController;
    /**
     * Creates new form PanelWarehouseConsult
     */
    public PanelWarehouseConsult() {
        this.warehouseController = new WarehouseController();
        this.viewController = new ViewController();
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

        lblWelc = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bttnDestroy = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();
        bttnModif = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblWarehouses = new javax.swing.JTable();
        lblEmail = new javax.swing.JLabel();
        txtEmailWarehouse = new javax.swing.JTextField();
        bttnFindOneWarehouse = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblWelc.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        lblWelc.setForeground(new java.awt.Color(0, 0, 0));
        lblWelc.setText("Consulta de Depositos");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        bttnDestroy.setBackground(new java.awt.Color(0, 51, 255));
        bttnDestroy.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttnDestroy.setForeground(new java.awt.Color(255, 255, 255));
        bttnDestroy.setText("ELIMINAR");
        bttnDestroy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnDestroy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDestroyActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(153, 0, 0));
        bttnBack.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(255, 255, 255));
        bttnBack.setText("SALIR");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        bttnModif.setBackground(new java.awt.Color(204, 0, 0));
        bttnModif.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttnModif.setForeground(new java.awt.Color(255, 255, 255));
        bttnModif.setText("MODIFICAR");
        bttnModif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModifActionPerformed(evt);
            }
        });

        tblWarehouses.setBackground(new java.awt.Color(255, 255, 255));
        tblWarehouses.setModel(new javax.swing.table.DefaultTableModel(
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
        tblWarehouses.setSelectionBackground(new java.awt.Color(51, 204, 255));
        tblWarehouses.setSelectionForeground(new java.awt.Color(51, 51, 0));
        tblWarehouses.setShowGrid(false);
        jScrollPane5.setViewportView(tblWarehouses);

        lblEmail.setText("EMAIL DEPOSITO");

        bttnFindOneWarehouse.setText("BUSCAR");
        bttnFindOneWarehouse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnFindOneWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFindOneWarehouseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmailWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttnFindOneWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnDestroy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEmail)
                                .addComponent(txtEmailWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bttnFindOneWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bttnDestroy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(lblWelc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblWelc)
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnDestroyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDestroyActionPerformed

        if(tblWarehouses.getRowCount() > 0){
            if(tblWarehouses.getSelectedRow()!=-1){
                String email = String.valueOf(tblWarehouses.getValueAt(tblWarehouses.getSelectedRow(),4));
                warehouseController.disableAccountByCuit(email);
                System.out.println(email);
            }
        }
        tblWarehouses.setModel(viewController.modelTableWarehousess());
    }//GEN-LAST:event_bttnDestroyActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelWarehouse(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModifActionPerformed
        if(tblWarehouses.getRowCount() > 0){
            if(tblWarehouses.getSelectedRow()!=-1){
                String code = String.valueOf(tblWarehouses.getValueAt(tblWarehouses.getSelectedRow(),0));
                ViewController.panelChange(this, new PanelWarehouseEdit(code), this);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bttnModifActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblWarehouses.setModel(viewController.modelTableWarehousess());
    }//GEN-LAST:event_formAncestorAdded

    private void bttnFindOneWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFindOneWarehouseActionPerformed
        tblWarehouses.setModel(viewController.modelTableWarehousesByEmail(txtEmailWarehouse.getText()));
    }//GEN-LAST:event_bttnFindOneWarehouseActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnDestroy;
    private javax.swing.JButton bttnFindOneWarehouse;
    private javax.swing.JButton bttnModif;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblWelc;
    private javax.swing.JTable tblWarehouses;
    private javax.swing.JTextField txtEmailWarehouse;
    // End of variables declaration//GEN-END:variables
}
