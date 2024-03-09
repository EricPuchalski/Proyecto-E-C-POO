/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.controller.EmployeeController;
import org.example.controller.ViewController;
import org.example.dao.WarehouseRepository;
import org.example.model.Employee;
import org.example.model.Warehouse;

/**
 *
 * @author facundo
 */
public class PanelEmployeeEdit extends javax.swing.JPanel {
    private String cuit;
    private EmployeeController employeeController;
    private Employee employeeEdit;
    private WarehouseRepository warehouseRepository;
    private ViewController viewController;

    /**
     * Creates new form PanelEmployeeEdit
     */
    public PanelEmployeeEdit(String cuit) {
        this.employeeController= new EmployeeController();
        this.viewController = new ViewController();
        this.warehouseRepository=new WarehouseRepository();
        employeeEdit=employeeController.findOne(cuit);
        this.cuit=cuit;
        initComponents();
        this.setSize(800, 700);
        loadAllWarehouses();



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
        bttnModif = new javax.swing.JButton();
        bttnCancel = new javax.swing.JButton();
        txtWarehouse = new javax.swing.JTextField();
        bttnWarehouse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWarehouses = new javax.swing.JTable();
        lblWarehouse = new javax.swing.JLabel();
        lblSur = new javax.swing.JLabel();
        txtSur = new javax.swing.JTextField();

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
        lblWelcome.setText("MODIFICAR EMPLEADO");

        lblComplement.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        lblComplement.setText("Por favor ingrese los nuevos datos");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblName.setText("Nombre");

        txtName.setVerifyInputWhenFocusTarget(false);

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

        txtWarehouse.setBackground(new java.awt.Color(34, 131, 210));
        txtWarehouse.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtWarehouse.setForeground(new java.awt.Color(0, 0, 0));
        txtWarehouse.setText("Ingresa un codigo del 1 al 5 y selecciona");
        txtWarehouse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtWarehouse.setVerifyInputWhenFocusTarget(false);
        txtWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWarehouseActionPerformed(evt);
            }
        });

        bttnWarehouse.setBackground(new java.awt.Color(51, 51, 255));
        bttnWarehouse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttnWarehouse.setForeground(new java.awt.Color(204, 255, 255));
        bttnWarehouse.setText("Buscar");
        bttnWarehouse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnWarehouseActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblWarehouses);

        lblWarehouse.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        lblWarehouse.setForeground(new java.awt.Color(204, 255, 255));
        lblWarehouse.setText("Deposito");

        lblSur.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSur.setText("Apellido");

        txtSur.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblName)
                                    .addGap(387, 387, 387))
                                .addComponent(lblWelcome)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(lblComplement)))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSur)
                            .addComponent(txtSur, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdress)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCuit)
                            .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblWarehouse)
                        .addGap(18, 18, 18)
                        .addComponent(bttnWarehouse)
                        .addGap(54, 54, 54)
                        .addComponent(txtWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(465, Short.MAX_VALUE))
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
                .addComponent(lblSur, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSur, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnWarehouse)
                    .addComponent(lblWarehouse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(193, 193, 193))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1formAncestorAdded
        this.loadData(cuit);
    }//GEN-LAST:event_jPanel1formAncestorAdded

    private void bttnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelActionPerformed
        ViewController.panelChange(this, new PanelEmployeeConsult(), this);
    }//GEN-LAST:event_bttnCancelActionPerformed

    private void bttnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModifActionPerformed
        if (!(txtName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtTel.getText().isEmpty() || txtSur.getText().isEmpty())) {
            String newCuit = txtCuit.getText();

            // Verificar si el nuevo CUIT es diferente al actual
//            if (!newCuit.equals(employeeEdit.getCuit())) {
                // Verificar si el nuevo CUIT ya existe en la base de datos para otro empleado
                Employee existingEmployeeWithCuit = employeeController.findOne(newCuit);
                if (existingEmployeeWithCuit != null && !existingEmployeeWithCuit.getId().equals(employeeEdit.getId())) {
                    JOptionPane.showMessageDialog(null, "El CUIT ingresado ya pertenece a otro empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Salir del método si el CUIT ya existe para otro empleado
                }
            //}

            // Continuar con la actualización del empleado en la base de datos
            employeeEdit.setNombre(txtName.getText());
            employeeEdit.setApellido(txtSur.getText()); // Actualizar el apellido
            employeeEdit.setCuit(newCuit); // Se actualiza el CUIT solo si es diferente
            employeeEdit.setDireccion(txtAdress.getText());
            employeeEdit.setTelefono(txtTel.getText());

            // Obtener el código del almacén seleccionado en la tabla
            int selectedRow = tblWarehouses.getSelectedRow();
            if (selectedRow != -1) { // Verificar si se seleccionó una fila
                String warehouseCode = (String) tblWarehouses.getValueAt(selectedRow, 0);
                try {
                    Long warehouseId = Long.parseLong(warehouseCode); // Convertir el código a Long
                    Warehouse selectedWarehouse = warehouseRepository.findWarehouse(warehouseId);
                    employeeEdit.setDeposit(selectedWarehouse);
                } catch (NumberFormatException ex) {
                    // Manejar la excepción si el código no es un número válido
                    JOptionPane.showMessageDialog(null, "El código de almacén no es válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Salir del método si hay un error
                }
            }

            // Actualizar el empleado en la base de datos
            try {
                employeeController.upDate(employeeEdit);
                JOptionPane.showMessageDialog(null, "Empleado modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                ViewController.panelChange(this, new PanelEmployeeConsult(), this);
            } catch (Exception ex) {
                Logger.getLogger(PanelEmployeeEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un campo no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }//ultimamod
    }//GEN-LAST:event_bttnModifActionPerformed

    private void txtWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWarehouseActionPerformed

        // Obtener el código ingresado en el campo de búsqueda
        String warehouseCode = txtWarehouse.getText();

        if (!warehouseCode.isEmpty()) {
            // Obtener la lista de todos los almacenes
            List<Warehouse> allWarehouses = warehouseRepository.findWarehouseEntities();

            // Buscar manualmente el almacén por su código
            List<Warehouse> matchingWarehouses = new ArrayList<>();
            for (Warehouse warehouse : allWarehouses) {
                if (warehouse.getCode().equals(warehouseCode)) {
                    matchingWarehouses.add(warehouse);
                }
            }

            if (!matchingWarehouses.isEmpty()) {
                // Creamos un modelo de tabla para los almacenes encontrados
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Código");
                model.addColumn("Nombre");
                model.addColumn("Dirección");
                model.addColumn("Teléfono");
                model.addColumn("Email");
                model.addColumn("Continente");

                // Limpiamos la tabla
                DefaultTableModel tableModel = (DefaultTableModel) tblWarehouses.getModel();
                tableModel.setRowCount(0);

                // Agregamos las filas de los almacenes encontrados al modelo de la tabla
                for (Warehouse warehouse : matchingWarehouses) {
                    model.addRow(new Object[]{warehouse.getCode(), warehouse.getName(), warehouse.getAdress(), warehouse.getPhone(), warehouse.getEmail(), warehouse.getContinent()});
                }

                // Actualizamos la tabla con el nuevo modelo
                tblWarehouses.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron depósitos para el código ingresado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Por favor ingrese un código de depósito.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtWarehouseActionPerformed

    private void bttnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnWarehouseActionPerformed
        txtWarehouseActionPerformed(evt);

    }//GEN-LAST:event_bttnWarehouseActionPerformed
    public void loadData(String cuit){
        employeeEdit = employeeController.findOne(cuit);
        txtCuit.setText(employeeEdit.getCuit());
        txtName.setText(employeeEdit.getNombre());
        txtAdress.setText(employeeEdit.getDireccion());
        txtTel.setText(employeeEdit.getTelefono());
        txtSur.setText(employeeEdit.getApellido());
    }

    private void loadAllWarehouses() {
        // Obtener el modelo de tabla de depósitos desde ViewController
        DefaultTableModel model = viewController.modelTableWarehousess();

        // Establecer el modelo en la tabla
        tblWarehouses.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCancel;
    private javax.swing.JButton bttnModif;
    private javax.swing.JButton bttnWarehouse;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSur;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblWarehouse;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblWarehouses;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCuit;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSur;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtWarehouse;
    // End of variables declaration//GEN-END:variables
}
