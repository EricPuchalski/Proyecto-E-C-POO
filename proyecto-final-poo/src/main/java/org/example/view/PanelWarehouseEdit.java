/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import javax.swing.JOptionPane;
import org.example.controller.EmployeeController;
import org.example.controller.ViewController;
import org.example.controller.WarehouseController;
import org.example.model.Employee;
import org.example.model.Warehouse;

/**
 *
 * @author ericp
 */
public class PanelWarehouseEdit extends javax.swing.JPanel {

    private ViewController viewController;
    private EmployeeController employeeController;
    private WarehouseController warehouseController;
    private Warehouse warehouseEdit;
    private final String code;

    /**
     * Creates new form PanelWarehouseEdit
     * @param code
     */
    public PanelWarehouseEdit(String code) {

        this.setSize(800, 700);
        
        this.viewController = new ViewController();
        this.employeeController = new EmployeeController();
        this.warehouseController = new WarehouseController();
        this.code = code;
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
        lblComplement = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCont = new javax.swing.JLabel();
        cbContinente = new javax.swing.JComboBox<>();
        lblLat = new javax.swing.JLabel();
        txtLat = new javax.swing.JTextField();
        lblLong = new javax.swing.JLabel();
        txtLon = new javax.swing.JTextField();
        lblEmployee = new javax.swing.JLabel();
        txtEmployee = new javax.swing.JTextField();
        bttnEmployee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        bttnConfirm = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(34, 131, 210));
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
        lblWelc.setText("MODIFICAR DEPOSITO");

        lblComplement.setFont(new java.awt.Font("Roboto Medium", 2, 24)); // NOI18N
        lblComplement.setForeground(new java.awt.Color(153, 204, 255));
        lblComplement.setText("Por favor ingrese los datos requeridos");

        lblName.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setText("Nombre");

        txtCode.setBackground(new java.awt.Color(34, 131, 210));
        txtCode.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCode.setForeground(new java.awt.Color(0, 0, 0));
        txtCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCode.setVerifyInputWhenFocusTarget(false);

        lblCode.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblCode.setForeground(new java.awt.Color(0, 0, 0));
        lblCode.setText("Codigo");

        txtName.setBackground(new java.awt.Color(34, 131, 210));
        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtName.setVerifyInputWhenFocusTarget(false);

        lblAdress.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblAdress.setForeground(new java.awt.Color(0, 0, 0));
        lblAdress.setText("Dirección");

        txtAdress.setBackground(new java.awt.Color(34, 131, 210));
        txtAdress.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAdress.setForeground(new java.awt.Color(0, 0, 0));
        txtAdress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtAdress.setVerifyInputWhenFocusTarget(false);

        lblPhone.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblPhone.setText("Teléfono");

        txtPhone.setBackground(new java.awt.Color(34, 131, 210));
        txtPhone.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(0, 0, 0));
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPhone.setVerifyInputWhenFocusTarget(false);

        lblEmail.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Email");

        txtEmail.setBackground(new java.awt.Color(34, 131, 210));
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtEmail.setVerifyInputWhenFocusTarget(false);

        lblCont.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblCont.setForeground(new java.awt.Color(0, 0, 0));
        lblCont.setText("Continente");

        cbContinente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "América", "Asia", "Africa", "Europa", "Oceania" }));

        lblLat.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblLat.setForeground(new java.awt.Color(0, 0, 0));
        lblLat.setText("Latitud");

        txtLat.setBackground(new java.awt.Color(34, 131, 210));
        txtLat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLat.setForeground(new java.awt.Color(0, 0, 0));
        txtLat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLat.setVerifyInputWhenFocusTarget(false);

        lblLong.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblLong.setForeground(new java.awt.Color(0, 0, 0));
        lblLong.setText("Longitud");

        txtLon.setBackground(new java.awt.Color(34, 131, 210));
        txtLon.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLon.setForeground(new java.awt.Color(0, 0, 0));
        txtLon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLon.setVerifyInputWhenFocusTarget(false);

        lblEmployee.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblEmployee.setForeground(new java.awt.Color(0, 0, 0));
        lblEmployee.setText("Empleado");

        txtEmployee.setBackground(new java.awt.Color(34, 131, 210));
        txtEmployee.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEmployee.setForeground(new java.awt.Color(0, 0, 0));
        txtEmployee.setText("Por favor ingrese el cuit");
        txtEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtEmployee.setVerifyInputWhenFocusTarget(false);
        txtEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmployeeMouseClicked(evt);
            }
        });
        txtEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeenone(evt);
            }
        });

        bttnEmployee.setBackground(new java.awt.Color(51, 51, 255));
        bttnEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttnEmployee.setForeground(new java.awt.Color(204, 255, 255));
        bttnEmployee.setText("Buscar");
        bttnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEmployeeActionPerformed(evt);
            }
        });

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmployees);

        bttnConfirm.setBackground(new java.awt.Color(0, 51, 255));
        bttnConfirm.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        bttnConfirm.setForeground(new java.awt.Color(232, 245, 255));
        bttnConfirm.setText("Registrar");
        bttnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(153, 0, 0));
        bttnBack.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(232, 245, 255));
        bttnBack.setText("Cancelar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCode)
                            .addComponent(lblAdress)
                            .addComponent(lblPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblName)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAdress)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblComplement))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblWelc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCont)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLat)
                                    .addComponent(cbContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmployee)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(bttnEmployee)
                                    .addGap(8, 8, 8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblWelc)
                .addGap(18, 18, 18)
                .addComponent(lblComplement)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCont)
                    .addComponent(cbContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLat)
                    .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee)
                    .addComponent(bttnEmployee))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmployeeMouseClicked
        txtEmployee.setText("");
    }//GEN-LAST:event_txtEmployeeMouseClicked

    private void txtEmployeenone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeenone

    }//GEN-LAST:event_txtEmployeenone

    private void bttnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEmployeeActionPerformed
        tblEmployees.setModel(viewController.modelTableEmployeesByCuit(txtEmployee.getText()));
    }//GEN-LAST:event_bttnEmployeeActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        try {
            if (!(txtName.getText().isEmpty() || txtEmail.getText().isEmpty() || txtAdress.getText().isEmpty() || txtPhone.getText().isEmpty() || txtCode.getText().isEmpty() || txtLon.getText().isEmpty() || txtLat.getText().isEmpty())) {
                if (tblEmployees.getRowCount() > 0) {
                    if (tblEmployees.getSelectedRow() != -1) {
                        String cuitEmpleado = String.valueOf(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 1));
                        Employee emp = employeeController.findOne(cuitEmpleado);
                        warehouseEdit.setName(txtName.getText());
                        warehouseEdit.setCode(txtCode.getText());
                        warehouseEdit.setAdress(txtAdress.getText());
                        warehouseEdit.setPhone(txtPhone.getText());
                        warehouseEdit.setEmail(txtEmail.getText());
                        warehouseEdit.setContinent(cbContinente.getSelectedItem().toString());
                        warehouseEdit.getPosition().setLatitude(Double.parseDouble(txtLat.getText()));
                        warehouseEdit.getPosition().setLongitude(Double.parseDouble(txtLon.getText()));
                        warehouseEdit.setEmployee(emp);
                        try {
                            Warehouse existingWarehouse = warehouseController.findWarehouseEnabledByCode(txtCode.getText());//KODIGO NUEVOOOOOO
                            if (existingWarehouse != null && !existingWarehouse.getCode().equals(code)) {
                                JOptionPane.showMessageDialog(null, "El codigo ya está en uso por otro deposito", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                existingWarehouse = warehouseController.findWarehouseEnabledByEmail(txtEmail.getText());
                                if (existingWarehouse != null && !existingWarehouse.getCode().equals(code)) {
                                    JOptionPane.showMessageDialog(null, "El correo electrónico ya está en uso por otro proveedor", "Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    existingWarehouse = warehouseController.findWarehouseEnabledByPhone(txtPhone.getText());
                                    if (existingWarehouse != null && !existingWarehouse.getCode().equals(code)) {
                                        JOptionPane.showMessageDialog(null, "El número de teléfono ya está en uso por otro proveedor", "Error", JOptionPane.WARNING_MESSAGE);
                                    } else {

                                        warehouseController.upDate(warehouseEdit);
                                        JOptionPane.showMessageDialog(null, "Depósito modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                        ViewController.panelChange(this, new PanelWarehouseConsult(), this);
                                    
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar modificar el Depósito", "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_bttnConfirmActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelWarehouseConsult(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblEmployees.setModel(viewController.modelTableEmployees());
        this.loadDataWarehouse(code);
    }//GEN-LAST:event_formAncestorAdded

    private void loadDataWarehouse(String code) {
       
       warehouseEdit = warehouseController.findOne(code);
        System.out.println(code);
        System.out.println(warehouseEdit.getEmail());
        txtAdress.setText(warehouseEdit.getAdress());
        txtName.setText(warehouseEdit.getName());
        txtCode.setText(warehouseEdit.getCode());
        txtPhone.setText(warehouseEdit.getPhone());
        txtEmail.setText(warehouseEdit.getEmail());
        cbContinente.setSelectedItem(warehouseEdit.getContinent());
        txtLon.setText(String.valueOf(warehouseEdit.getPosition().getLongitude()));
        txtLat.setText(String.valueOf(warehouseEdit.getPosition().getLatitude()));

       

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JButton bttnEmployee;
    private javax.swing.JComboBox<String> cbContinente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblCont;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblLat;
    private javax.swing.JLabel lblLong;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblWelc;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployee;
    private javax.swing.JTextField txtLat;
    private javax.swing.JTextField txtLon;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
