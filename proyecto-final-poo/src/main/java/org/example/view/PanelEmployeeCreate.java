/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.controller.EmployeeController;
import org.example.controller.ViewController;
import org.example.controller.WarehouseController;
import org.example.model.Employee;
import org.example.model.Warehouse;

/**
 *
 * @author facundo
 */
public class PanelEmployeeCreate extends javax.swing.JPanel {
    private EmployeeController employeeController;
        private JComboBox<String> warehouseCombobox;
            private ViewController viewController;
      private WarehouseController warehouseController;


    /**
     * Creates new form PanelEmployeeCreate
     */
    public PanelEmployeeCreate() {
        this.employeeController = new EmployeeController();
    this.viewController = new ViewController();
    this.warehouseController = new WarehouseController();

    initComponents();
    this.setSize(800, 700);
    
    // Inicializamos la lista desplegable de almacenes
    warehouseCombobox = new JComboBox<>(); // Cambio realizado aquí
    warehouseCombobox.setBounds(200, 450, 250, 30);
    jPanel1.add(warehouseCombobox);
    
    // Llenamos la lista desplegable con los almacenes disponibles
    fillWarehouseComboBox();
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
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblCuit = new javax.swing.JLabel();
        txtCuit = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblSur = new javax.swing.JLabel();
        txtSur = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        lblWelcome.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(232, 245, 255));
        lblWelcome.setText("REGISTRAR EMPLEADO");

        lblComplement.setFont(new java.awt.Font("Roboto Medium", 2, 24)); // NOI18N
        lblComplement.setForeground(new java.awt.Color(153, 204, 255));
        lblComplement.setText("Por favor ingrese los datos requeridos");

        lblName.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 255, 255));
        lblName.setText("Nombre");

        txtName.setBackground(new java.awt.Color(34, 131, 210));
        txtName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtName.setVerifyInputWhenFocusTarget(false);

        lblAdress.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblAdress.setForeground(new java.awt.Color(204, 255, 255));
        lblAdress.setText("Dirección");

        txtAdress.setBackground(new java.awt.Color(34, 131, 210));
        txtAdress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtAdress.setVerifyInputWhenFocusTarget(false);

        lblCuit.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCuit.setForeground(new java.awt.Color(204, 255, 255));
        lblCuit.setText("Cuit");

        txtCuit.setBackground(new java.awt.Color(34, 131, 210));
        txtCuit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCuit.setVerifyInputWhenFocusTarget(false);

        lblTel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblTel.setForeground(new java.awt.Color(204, 255, 255));
        lblTel.setText("Telefono");

        txtTel.setBackground(new java.awt.Color(34, 131, 210));
        txtTel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTel.setVerifyInputWhenFocusTarget(false);

        btnRegister.setBackground(new java.awt.Color(0, 102, 255));
        btnRegister.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Registrar");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
        btnCancel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblSur.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblSur.setForeground(new java.awt.Color(204, 255, 255));
        lblSur.setText("Apellido");

        txtSur.setBackground(new java.awt.Color(34, 131, 210));
        txtSur.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSur.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSur)
                            .addComponent(txtSur, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComplement)
                            .addComponent(lblWelcome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName)
                                    .addComponent(lblAdress)
                                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCuit)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnRegister)
                        .addGap(354, 354, 354)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComplement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSur, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnCancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnRegister)))
                .addContainerGap(470, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            // Verificar que todos los campos estén completos
            if (txtName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtCuit.getText().isEmpty() || txtTel.getText().isEmpty() || txtSur.getText().isEmpty()) {
                throw new Exception("Debe completar todos los campos.");
            }

            // Crea un objeto Employee con los datos del empleado y el almacén
            Employee employee = new Employee(
                    txtCuit.getText(),
                    txtName.getText(),
                    txtSur.getText(),
                    txtAdress.getText(),
                    txtTel.getText()
            );

            // Obtén el nombre del almacén seleccionado del JComboBox
            String selectedWarehouseName = (String) warehouseCombobox.getSelectedItem();

            // Utiliza el controlador de almacenes para encontrar todos los almacenes
            List<Warehouse> warehouses = warehouseController.findAll();

            // Encuentra el almacén con el nombre seleccionado
            Warehouse selectedWarehouse = null;
            for (Warehouse warehouse : warehouses) {
                if (warehouse.getName().equals(selectedWarehouseName)) {
                    selectedWarehouse = warehouse;
                    break;
                }
            }

            // Verifica si se encontró el almacén
            if (selectedWarehouse == null) {
                throw new Exception("No se encontró el almacén con el nombre seleccionado");
            }

            // Asocia el almacén seleccionado al empleado
            employee.setDeposit(selectedWarehouse);

            // Llama al método create() del controlador de empleados para crear el empleado
            employeeController.create(employee);
            JOptionPane.showMessageDialog(this, "El Empleado fue creado con éxito");

            // Cambia la vista
            ViewController.panelChange(this, new PanelEmployee(), this);
        } catch (Exception e) {
            if (e.getMessage().contains("cuit pertenece a otro empleado")) {
                JOptionPane.showMessageDialog(this, "Error al crear empleado: El CUIT pertenece a otro empleado");
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear empleado: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ViewController.panelChange(this, new PanelEmployee(), this);
    }//GEN-LAST:event_btnCancelActionPerformed
 // Método para llenar la lista desplegable con los almacenes disponibles
    private void fillWarehouseComboBox() {
        ViewController viewController = new ViewController();
        DefaultTableModel warehouseModel = viewController.modelTableWarehousess();

        for (int i = 0; i < warehouseModel.getRowCount(); i++) {
            String warehouseName = (String) warehouseModel.getValueAt(i, 1); // Nombre del almacén
            warehouseCombobox.addItem(warehouseName);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSur;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSur;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
