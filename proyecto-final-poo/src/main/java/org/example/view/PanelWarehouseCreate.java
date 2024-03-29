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
import org.example.model.Position;
import org.example.model.Warehouse;

/**
 *
 * @author ericp
 */
public class PanelWarehouseCreate extends javax.swing.JPanel {
    private WarehouseController warehouseController;
    private EmployeeController employeeController;
    private ViewController viewController;
    /**
     * Creates new form PanelWarehouseCreate
     */
    public PanelWarehouseCreate() {
        this.warehouseController = new WarehouseController();
        this.viewController = new ViewController();
        this.employeeController = new EmployeeController();
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
        lblCode = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblLat = new javax.swing.JLabel();
        lblCont = new javax.swing.JLabel();
        lblLong = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        txtEmployee = new javax.swing.JTextField();
        bttnEmployee = new javax.swing.JButton();
        txtLon = new javax.swing.JTextField();
        txtLat = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblComplement = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        bttnConfirm = new javax.swing.JButton();
        bttnBack = new javax.swing.JButton();
        cbContinente = new javax.swing.JComboBox<>();

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
        lblWelc.setForeground(new java.awt.Color(232, 245, 255));
        lblWelc.setText("REGISTRAR DÉPOSITO");

        lblCode.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblCode.setForeground(new java.awt.Color(204, 255, 255));
        lblCode.setText("Codigo");

        lblAdress.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblAdress.setForeground(new java.awt.Color(204, 255, 255));
        lblAdress.setText("Dirección");

        lblPhone.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(204, 255, 255));
        lblPhone.setText("Teléfono");

        lblLat.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblLat.setForeground(new java.awt.Color(204, 255, 255));
        lblLat.setText("Latitud");

        lblCont.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblCont.setForeground(new java.awt.Color(204, 255, 255));
        lblCont.setText("Continente");

        lblLong.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblLong.setForeground(new java.awt.Color(204, 255, 255));
        lblLong.setText("Longitud");

        lblEmail.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 255, 255));
        lblEmail.setText("Email");

        lblName.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 255, 255));
        lblName.setText("Nombre");

        lblEmployee.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblEmployee.setForeground(new java.awt.Color(204, 255, 255));
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
        bttnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEmployeeActionPerformed(evt);
            }
        });

        txtLon.setBackground(new java.awt.Color(34, 131, 210));
        txtLon.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLon.setForeground(new java.awt.Color(0, 0, 0));
        txtLon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLon.setVerifyInputWhenFocusTarget(false);
        txtLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLonActionPerformed(evt);
            }
        });

        txtLat.setBackground(new java.awt.Color(34, 131, 210));
        txtLat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLat.setForeground(new java.awt.Color(0, 0, 0));
        txtLat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLat.setVerifyInputWhenFocusTarget(false);
        txtLat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLatActionPerformed(evt);
            }
        });

        txtPhone.setBackground(new java.awt.Color(34, 131, 210));
        txtPhone.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(0, 0, 0));
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPhone.setVerifyInputWhenFocusTarget(false);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(34, 131, 210));
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtEmail.setVerifyInputWhenFocusTarget(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtAdress.setBackground(new java.awt.Color(34, 131, 210));
        txtAdress.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAdress.setForeground(new java.awt.Color(0, 0, 0));
        txtAdress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtAdress.setVerifyInputWhenFocusTarget(false);
        txtAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdressnone(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(34, 131, 210));
        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtName.setVerifyInputWhenFocusTarget(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblComplement.setFont(new java.awt.Font("Roboto Medium", 2, 24)); // NOI18N
        lblComplement.setForeground(new java.awt.Color(153, 204, 255));
        lblComplement.setText("Por favor ingrese los datos requeridos");

        txtCode.setBackground(new java.awt.Color(34, 131, 210));
        txtCode.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCode.setForeground(new java.awt.Color(0, 0, 0));
        txtCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCode.setVerifyInputWhenFocusTarget(false);
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
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
        bttnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(153, 0, 0));
        bttnBack.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(232, 245, 255));
        bttnBack.setText("Cancelar");
        bttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnBackActionPerformed(evt);
            }
        });

        cbContinente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "América", "Asia", "Africa", "Europa", "Oceania" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(cbContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail))
                                    .addComponent(txtAdress)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEmployee)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bttnEmployee))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(lblLong)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(159, 159, 159)
                            .addComponent(lblCont))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(lblComplement))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(lblWelc)))
                    .addGap(130, 130, 130)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(cbContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
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
                    .addGap(18, 18, 18)
                    .addComponent(lblCont)
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLat)
                        .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLong)
                        .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmployee)
                        .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnEmployee))
                    .addGap(33, 33, 33)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
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

    private void txtLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLonActionPerformed

    private void txtLatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLatActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtAdressnone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdressnone
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdressnone

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        try {
            boolean existWarehouse = warehouseController.checkIfExistUniq(txtCode.getText(), txtPhone.getText(), txtEmail.getText());
        if (!(txtCode.getText().isEmpty() || txtName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtPhone.getText().isEmpty() || txtEmail.getText().isEmpty() || txtLat.getText().isEmpty() || txtLon.getText().isEmpty())) {
            if (tblEmployees.getRowCount() > 0) {
                if (tblEmployees.getSelectedRow() != -1) {
                    String cuitEmpleado = String.valueOf(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 1));
                    Employee emp = employeeController.findOne(cuitEmpleado);
                    // Verificar si ya existe un usuario con el mismo código
                    if (existWarehouse == true) {//KODIGO NUEVO
                        JOptionPane.showMessageDialog(this, "Ya existe este deposito", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        warehouseController.create(new Warehouse(txtCode.getText(), txtName.getText(), txtAdress.getText(), txtPhone.getText(), txtEmail.getText(), String.valueOf(cbContinente.getSelectedItem()), new Position(Double.valueOf(txtLat.getText()), Double.valueOf(txtLon.getText())), employeeController.findOne(emp.getCuit())));
                        JOptionPane.showMessageDialog(this, "Depósito creado con éxito", "Creación exitosa", JOptionPane.INFORMATION_MESSAGE);
                        ViewController.panelChange(this, new PanelWarehouse(), this);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor elija un empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un campo no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
            System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Verifique los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_bttnConfirmActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelWarehouse(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        tblEmployees.setModel(viewController.modelTableEmployees());
    }//GEN-LAST:event_formAncestorAdded
    private void loadData(){
       
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
