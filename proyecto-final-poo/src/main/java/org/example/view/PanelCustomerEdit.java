/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.example.controller.CustomerController;
import org.example.controller.ViewController;
import org.example.model.Customer;

/**
 *
 * @author ericp
 */
public class PanelCustomerEdit extends javax.swing.JPanel {
    private final String cuit;
    private final CustomerController customerController;
    private Customer customerEdit;
 

    /**
     * Creates new form PanelEditCustomer
     * @param cuit
     */
    public PanelCustomerEdit(String cuit) {
        customerController = new CustomerController();
        customerEdit = new Customer();
        this.cuit = cuit;
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
        lblComplement = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblCuit = new javax.swing.JLabel();
        txtCuit = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        bttnModif = new javax.swing.JButton();
        bttnCancel = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblWelcome.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lblWelcome.setText("MODIFICAR CLIENTE");

        lblComplement.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        lblComplement.setText("Por favor ingrese los nuevos datos");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblName.setText("Nombre");

        txtName.setVerifyInputWhenFocusTarget(false);

        lblSurname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSurname.setText("Apellido");

        txtSurname.setVerifyInputWhenFocusTarget(false);

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
        bttnModif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModifActionPerformed(evt);
            }
        });

        bttnCancel.setBackground(new java.awt.Color(204, 0, 0));
        bttnCancel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnCancel.setForeground(new java.awt.Color(255, 255, 255));
        bttnCancel.setText("Cancelar");
        bttnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(171, 171, 171)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSurname)
                                .addComponent(lblAdress)
                                .addComponent(lblCuit)
                                .addComponent(lblTel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblWelcome)
                                    .addComponent(lblComplement))
                                .addGap(20, 20, 20)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(172, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(lblWelcome)
                    .addGap(18, 18, 18)
                    .addComponent(lblComplement)
                    .addGap(18, 18, 18)
                    .addComponent(lblName)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblSurname)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addComponent(lblAdress)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblCuit)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblTel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModifActionPerformed
        if(!(txtName.getText().isEmpty()|| txtSurname.getText().isEmpty() || txtAdress.getText().isEmpty() || txtTel.getText().isEmpty() || txtCuit.getText().isEmpty())){
            customerEdit.setName(txtName.getText());
            customerEdit.setSurname(txtSurname.getText());
            customerEdit.setCuit(txtCuit.getText());
            customerEdit.setAdress(txtAdress.getText());
            customerEdit.setPhone(txtTel.getText());
            try {
                customerController.upDate(customerEdit);
            } catch (Exception ex) {
                Logger.getLogger(PanelCustomerEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Cliente modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            ViewController.panelChange(this, new PanelCustomerConsult(), this);
        } else{
            JOptionPane.showMessageDialog(null, "Un campo no puede estar vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bttnModifActionPerformed

    private void bttnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelActionPerformed
        ViewController.panelChange(this, new PanelCustomerConsult(), this);
    }//GEN-LAST:event_bttnCancelActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
       this.loadData(cuit);
    }//GEN-LAST:event_formAncestorAdded
    public void loadData(String cuit){
        customerEdit = customerController.findOne(cuit);
        txtCuit.setText(customerEdit.getCuit());
        txtName.setText(customerEdit.getName());
        txtSurname.setText(customerEdit.getSurname());
        txtAdress.setText(customerEdit.getAdress());
        txtTel.setText(customerEdit.getPhone());
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCancel;
    private javax.swing.JButton bttnModif;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
