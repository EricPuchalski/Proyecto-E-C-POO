/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.example.controller.ViewController;

/**
 *
 * @author ericp
 */
public class PanelReportOrdersByWarehouseOrig extends javax.swing.JPanel {
    private ViewController viewController;
    /**
     * Creates new form PanelReportOrdersByWarehouseOrig
     */
    public PanelReportOrdersByWarehouseOrig() {
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

        lblWelcome = new javax.swing.JLabel();
        lblWarehouse = new javax.swing.JLabel();
        txtWarehouseMail = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblWarehouses = new javax.swing.JTable();
        bttnWarehouse = new javax.swing.JButton();
        lblOrder1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblOrdersByWarehouse = new javax.swing.JTable();
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
        lblWelcome.setText("PEDIDOS POR DEPOSITO");

        lblWarehouse.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblWarehouse.setForeground(new java.awt.Color(0, 0, 0));
        lblWarehouse.setText("Email deposito");

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
        jScrollPane6.setViewportView(tblWarehouses);

        bttnWarehouse.setText("Buscar");
        bttnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnWarehouseActionPerformed(evt);
            }
        });

        lblOrder1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblOrder1.setForeground(new java.awt.Color(0, 0, 0));
        lblOrder1.setText("Pedidos del deposito: ");

        tblOrdersByWarehouse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblOrdersByWarehouse);

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
                .addGap(120, 120, 120)
                .addComponent(lblWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWarehouse)
                        .addGap(18, 18, 18)
                        .addComponent(txtWarehouseMail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnWarehouse)
                        .addGap(4, 4, 4))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWarehouse)
                    .addComponent(txtWarehouseMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnWarehouse))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lblOrder1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnWarehouseActionPerformed
        tblWarehouses.setModel(viewController.modelTableWarehousesByEmail(txtWarehouseMail.getText()));
    }//GEN-LAST:event_bttnWarehouseActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelReport(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        if (tblWarehouses.getRowCount() > 0) {
            if (tblWarehouses.getSelectedRow() != -1) {
                Long idWarehouse =Long.parseLong(String.valueOf(tblWarehouses.getValueAt(tblWarehouses.getSelectedRow(), 0)));
                tblOrdersByWarehouse.setModel(viewController.modelTableOrdersByWarehouseOrig(idWarehouse));
            }
        }
    }//GEN-LAST:event_bttnConfirmActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblWarehouses.setModel(viewController.modelTableWarehouses());
        this.tblOrdersByWarehouse.setModel(this.loadTitles());
    }//GEN-LAST:event_formAncestorAdded
    private TableModel loadTitles(){
                DefaultTableModel newModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Id", "Cliente", "Transportista", "Numero"};
        newModel.setColumnIdentifiers(titulos);
        return newModel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JButton bttnWarehouse;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblOrder1;
    private javax.swing.JLabel lblWarehouse;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblOrdersByWarehouse;
    private javax.swing.JTable tblWarehouses;
    private javax.swing.JTextField txtWarehouseMail;
    // End of variables declaration//GEN-END:variables
}
