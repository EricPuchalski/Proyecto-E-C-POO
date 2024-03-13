/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.example.controller.SupplierController;
import org.example.controller.ViewController;
import org.example.model.Supplier;

/**
 *
 * @author facundo
 */
public class PanelSupplierEdit extends javax.swing.JPanel {

    private String cuit;
    private SupplierController supplierController;
    private Supplier supplierEdit;

    /**
     * Creates new form PanelSupplierEdit
     */
    public PanelSupplierEdit(String cuit) {
        this.supplierController = new SupplierController();
        supplierEdit = supplierController.findOne(cuit); // Cargar datos del proveedor
        this.cuit = cuit;
        initComponents();
        this.setSize(800, 700);
        loadData(cuit); // Llamar al método loadData para mostrar los datos
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblComplement = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblCuit = new javax.swing.JLabel();
        txtCuit = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        bttnModif = new javax.swing.JButton();
        bttnCancel = new javax.swing.JButton();

        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblWelcome.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lblWelcome.setText("MODIFICAR PROVEEDOR");

        lblComplement.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        lblComplement.setText("Por favor ingrese los nuevos datos");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblName.setText("Nombre");

        txtName.setVerifyInputWhenFocusTarget(false);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setVerifyInputWhenFocusTarget(false);

        lblAdress.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblAdress.setText("Dirección");

        txtAdress.setVerifyInputWhenFocusTarget(false);

        lblCuit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCuit.setText("Cuit");

        txtCuit.setVerifyInputWhenFocusTarget(false);

        lblTel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTel.setText("Telefono");

        txtTel.setVerifyInputWhenFocusTarget(false);

        bttnModif.setBackground(new java.awt.Color(0, 102, 255));
        bttnModif.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnModif.setForeground(new java.awt.Color(255, 255, 255));
        bttnModif.setText("Modificar");
        bttnModif.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModifActionPerformed(evt);
            }
        });

        bttnCancel.setBackground(new java.awt.Color(204, 0, 0));
        bttnCancel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnCancel.setForeground(new java.awt.Color(255, 255, 255));
        bttnCancel.setText("Cancelar");
        bttnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(171, 171, 171)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblEmail)
                                    .addComponent(lblAdress)
                                    .addComponent(lblCuit)
                                    .addComponent(lblTel))
                                .addGap(375, 375, 375))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblWelcome)
                                    .addComponent(lblComplement))
                                .addGap(20, 20, 20)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(172, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(lblWelcome)
                    .addGap(18, 18, 18)
                    .addComponent(lblComplement)
                    .addGap(18, 18, 18)
                    .addComponent(lblName)
                    .addGap(53, 53, 53)
                    .addComponent(lblEmail)
                    .addGap(70, 70, 70)
                    .addComponent(lblAdress)
                    .addGap(53, 53, 53)
                    .addComponent(lblCuit)
                    .addGap(53, 53, 53)
                    .addComponent(lblTel)
                    .addGap(74, 74, 74)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModifActionPerformed
        if (!(txtName.getText().isEmpty() || txtEmail.getText().isEmpty() || txtAdress.getText().isEmpty() || txtTel.getText().isEmpty() || txtCuit.getText().isEmpty())) {
            supplierEdit.setName(txtName.getText());
            supplierEdit.setEmail(txtEmail.getText());
            supplierEdit.setCuit(txtCuit.getText());
            supplierEdit.setAdress(txtAdress.getText());
            supplierEdit.setPhone(txtTel.getText());
            try {
                Supplier supplierByCuit = supplierController.findSupplierEnabledByCuit(txtCuit.getText());
                if (!supplierByCuit.equals(txtCuit.getText())) {
                    supplierController.upDate(supplierEdit);
                    JOptionPane.showMessageDialog(null, "Proveedor modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    ViewController.panelChange(this, new PanelSupplierConsult(), this);

                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor ya existe", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception SQLException) {
                JOptionPane.showMessageDialog(null, "Dato único duplicado", "Error", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Un campo no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bttnModifActionPerformed

    private void bttnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelActionPerformed
        ViewController.panelChange(this, new PanelSupplierConsult(), this);
    }//GEN-LAST:event_bttnCancelActionPerformed

    private void jPanel1formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1formAncestorAdded
        this.loadData(cuit);
    }//GEN-LAST:event_jPanel1formAncestorAdded
    public void loadData(String cuit) {
        if (supplierController != null) {
            supplierEdit = supplierController.findOne(cuit);

            if (supplierEdit != null) {
                txtCuit.setText(supplierEdit.getCuit());
                txtName.setText(supplierEdit.getName());
                txtEmail.setText(supplierEdit.getEmail());
                txtAdress.setText(supplierEdit.getAdress());
                txtTel.setText(supplierEdit.getPhone());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún proveedor con el CUIT proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un problema interno. Por favor, inténtalo de nuevo más tarde", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCancel;
    private javax.swing.JButton bttnModif;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
