/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.view;

import javax.swing.JOptionPane;
import org.example.controller.ProductCategoryController;
import org.example.controller.ProductController;
import org.example.controller.SupplierController;
import org.example.controller.ViewController;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Supplier;

/**
 *
 * @author ericp
 */
public class PanelProductEdit extends javax.swing.JPanel {

    private Product product;
    private String productCod;
    private ProductController productController;
    private ProductCategoryController productCategoryController;
    private SupplierController supplierController;

    /**
     * Creates new form PanelProductEdit
     */
    public PanelProductEdit(String productCode) {
        this.setSize(800, 700);
        this.productController = new ProductController();
        this.productCategoryController = new ProductCategoryController();
        this.supplierController = new SupplierController();
        this.productCod = productCode;
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
        lblSupplier = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cmbSupplier = new javax.swing.JComboBox<>();
        lblCategoryProduct = new javax.swing.JLabel();
        cmbCategories = new javax.swing.JComboBox<>();
        lblWeight = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtLong = new javax.swing.JTextField();
        lblLong = new javax.swing.JLabel();
        txtHigh = new javax.swing.JTextField();
        lblHeight = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        lblWidht = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        bttnModify = new javax.swing.JButton();
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
        lblWelc.setForeground(new java.awt.Color(232, 245, 255));
        lblWelc.setText("MODIFICAR PRODUCTO");

        lblComplement.setFont(new java.awt.Font("Roboto Medium", 2, 24)); // NOI18N
        lblComplement.setForeground(new java.awt.Color(153, 204, 255));
        lblComplement.setText("Por favor ingrese los datos requeridos");

        lblSupplier.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(204, 255, 255));
        lblSupplier.setText("Proveedor");

        lblName.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 255, 255));
        lblName.setText("Nombre");

        txtName.setBackground(new java.awt.Color(34, 131, 210));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtName.setVerifyInputWhenFocusTarget(false);

        cmbSupplier.setBackground(new java.awt.Color(34, 131, 210));
        cmbSupplier.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cmbSupplier.setForeground(new java.awt.Color(0, 0, 0));
        cmbSupplier.setBorder(null);
        cmbSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCategoryProduct.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCategoryProduct.setForeground(new java.awt.Color(204, 255, 255));
        lblCategoryProduct.setText("Categoria");

        cmbCategories.setBackground(new java.awt.Color(34, 131, 210));
        cmbCategories.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cmbCategories.setForeground(new java.awt.Color(0, 0, 0));
        cmbCategories.setBorder(null);
        cmbCategories.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblWeight.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblWeight.setForeground(new java.awt.Color(204, 255, 255));
        lblWeight.setText("Peso");

        txtWeight.setBackground(new java.awt.Color(34, 131, 210));
        txtWeight.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtWeight.setVerifyInputWhenFocusTarget(false);

        txtLong.setBackground(new java.awt.Color(34, 131, 210));
        txtLong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLong.setVerifyInputWhenFocusTarget(false);

        lblLong.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblLong.setForeground(new java.awt.Color(204, 255, 255));
        lblLong.setText("Largo");

        txtHigh.setBackground(new java.awt.Color(34, 131, 210));
        txtHigh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtHigh.setVerifyInputWhenFocusTarget(false);

        lblHeight.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblHeight.setForeground(new java.awt.Color(204, 255, 255));
        lblHeight.setText("Alto");

        txtWidth.setBackground(new java.awt.Color(34, 131, 210));
        txtWidth.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtWidth.setVerifyInputWhenFocusTarget(false);

        lblWidht.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblWidht.setForeground(new java.awt.Color(204, 255, 255));
        lblWidht.setText("Ancho");

        lblCode.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lblCode.setForeground(new java.awt.Color(204, 255, 255));
        lblCode.setText("Codigo");

        txtCod.setBackground(new java.awt.Color(34, 131, 210));
        txtCod.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCod.setVerifyInputWhenFocusTarget(false);

        bttnModify.setBackground(new java.awt.Color(0, 102, 255));
        bttnModify.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnModify.setForeground(new java.awt.Color(255, 255, 255));
        bttnModify.setText("Modificar");
        bttnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModifyActionPerformed(evt);
            }
        });

        bttnBack.setBackground(new java.awt.Color(204, 0, 0));
        bttnBack.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        bttnBack.setForeground(new java.awt.Color(255, 255, 255));
        bttnBack.setText("Cancelar");
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
                        .addGap(106, 106, 106)
                        .addComponent(lblWelc, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bttnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(bttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(18, 18, 18)
                                .addComponent(txtName)
                                .addGap(36, 36, 36)
                                .addComponent(lblWeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblCategoryProduct)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblWidht)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(lblHeight)
                                .addGap(30, 30, 30)
                                .addComponent(txtHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLong)
                                .addGap(24, 24, 24)
                                .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblComplement))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(lblCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblWelc)
                .addGap(80, 80, 80)
                .addComponent(lblComplement)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryProduct)
                    .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblWeight)
                        .addComponent(txtWeight)))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWidht)
                            .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeight)
                            .addComponent(txtHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLong)
                        .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCode)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModifyActionPerformed
       ProductCategory pC = productCategoryController.findByName(cmbCategories.getSelectedItem().toString());
    Supplier sp = null;
    for (Supplier p : supplierController.findAll()) {
        if (p.getName().equals(cmbSupplier.getSelectedItem())) {
            sp = p;
        }
    }
    try {
        // Verificar si el código del producto está siendo utilizado por otro producto existente
        if (productController.findOne(txtCod.getText()) != null && !productController.findOne(txtCod.getText()).getId().equals(product.getId())) {
            JOptionPane.showMessageDialog(this, "El código ya pertenece a otro producto", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            product.setHeight(Double.valueOf(txtHigh.getText()));
            product.setWeight(Double.valueOf(txtWeight.getText()));
            product.setWidth(Double.valueOf(txtWidth.getText()));
            product.setLength(Double.valueOf(txtLong.getText()));
            product.setCode(txtCod.getText());
            product.setName(txtName.getText());
            product.setSupplier(sp);
            product.setCategory(pC);

            productController.upDate(product);
            JOptionPane.showMessageDialog(this, "Producto modificado con éxito", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
            ViewController.panelChange(this, new PanelConsultProduct(), this);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_bttnModifyActionPerformed

    private void bttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnBackActionPerformed
        ViewController.panelChange(this, new PanelConsultProduct(), this);
    }//GEN-LAST:event_bttnBackActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        this.loadData();        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void loadData() {
        //Cargar datos del producto
        product = productController.findOne(productCod);
        cmbSupplier.setSelectedItem(product.getSupplier().getName());
        cmbCategories.setSelectedItem(product.getCategory().getNombre());
        txtName.setText(product.getName());
        txtWeight.setText(String.valueOf(product.getWeight()));
        txtWidth.setText(String.valueOf(product.getWidth()));
        txtHigh.setText(String.valueOf(product.getHeight()));
        txtLong.setText(String.valueOf(product.getLength()));
        txtCod.setText(product.getCode());

        //Cargar combos
        for (ProductCategory pC : productCategoryController.findAll()) {
            cmbCategories.addItem(pC.getNombre());
        }
        for (Supplier sp : supplierController.findAll()) {
            cmbSupplier.addItem(sp.getName());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnBack;
    private javax.swing.JButton bttnModify;
    private javax.swing.JComboBox<String> cmbCategories;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel lblCategoryProduct;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblComplement;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLong;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWelc;
    private javax.swing.JLabel lblWidht;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtHigh;
    private javax.swing.JTextField txtLong;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
}
