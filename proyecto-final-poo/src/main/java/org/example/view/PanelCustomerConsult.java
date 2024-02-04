/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import org.example.dao.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.example.controller.CustomerController;
import org.example.controller.ViewController;
import org.example.model.Customer;

/**
 *
 * @author ericp
 */
public class PanelCustomerConsult extends javax.swing.JPanel {
    private CustomerController customerController;
    private ViewController viewController;

    /**
     * Creates new form PanelCustomerConsult
     */
    public PanelCustomerConsult() {
        this.customerController = new CustomerController();
        this.viewController = new ViewController();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        bttnDestroy = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();
        bttnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCuitCustomerFindOne = new javax.swing.JTextField();
        bttnDestroy1 = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblWelcome.setText("Consulta de Clientes");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane2.setViewportView(tblCustomers);

        bttnDestroy.setText("ELIMINAR");
        bttnDestroy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnDestroy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDestroyActionPerformed(evt);
            }
        });

        bttnBack.setText("SALIR");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        bttnEdit.setText("MODIFICAR");
        bttnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditActionPerformed(evt);
            }
        });

        jLabel1.setText("CUIT CLIENTE");

        bttnDestroy1.setText("BUSCAR");
        bttnDestroy1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnDestroy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDestroy1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(txtCuitCustomerFindOne, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttnDestroy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bttnDestroy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnDestroy, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCuitCustomerFindOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnDestroy1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(bttnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcome)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnDestroyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDestroyActionPerformed
       if(tblCustomers.getRowCount() > 0){
        if(tblCustomers.getSelectedRow()!=-1){
            String customerCuit = String.valueOf(tblCustomers.getValueAt(tblCustomers.getSelectedRow(),1));
            try {
                customerController.delete(customerCuit);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelCustomerConsult.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTabla();
        }//
    }
    }

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelCustomer(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditActionPerformed

        if(tblCustomers.getRowCount() > 0){
            if(tblCustomers.getSelectedRow()!=-1){
                String cuit = String.valueOf(tblCustomers.getValueAt(tblCustomers.getSelectedRow(),1));
                
                ViewController.panelChange(this, new PanelCustomerEdit(cuit), this);
            }
        }
    }//GEN-LAST:event_bttnEditActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        this.cargarTabla();
    }//GEN-LAST:event_formAncestorAdded

    private void bttnDestroy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDestroy1ActionPerformed
        tblCustomers.setModel(viewController.modelTableCustomersByCuit(txtCuitCustomerFindOne.getText()));
    }//GEN-LAST:event_bttnDestroy1ActionPerformed
    private void cargarTabla(){
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String titulos[] = {"Id", "Cuit", "Nombre", "Apellido", "Estado","Direccion","Teléfono"};
        modeloTabla.setColumnIdentifiers(titulos);
        List<Customer> listCustomers = customerController.findAll();

        if(!listCustomers.isEmpty()){
            for (Customer cl: listCustomers){
                Object[] obj = {cl.getId(), cl.getCuit(),cl.getName(), cl.getSurname(), cl.getEstado(),cl.getAdress(),cl.getPhone()};
                modeloTabla.addRow(obj);
            }
        }

        tblCustomers.setModel(modeloTabla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnDestroy;
    private javax.swing.JButton bttnDestroy1;
    private javax.swing.JButton bttnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtCuitCustomerFindOne;
    // End of variables declaration//GEN-END:variables
}
