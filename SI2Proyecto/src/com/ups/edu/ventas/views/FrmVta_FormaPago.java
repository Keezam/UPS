/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.views;

import com.ups.edu.conexion.ConexionBD;
import com.ups.edu.ventas.model.FormaPagoModel;
import com.ups.edu.ventas.model.Validacion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmVta_FormaPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmVta_FormaPago
     */
    
     boolean modificar = false;
    FormaPagoModel fpModel = new FormaPagoModel();
    DefaultTableModel model;
    Connection cn = ConexionBD.GetConnection();
    private Statement st;
    private  ResultSet rs;
    
    public FrmVta_FormaPago() {
        initComponents();
        cargarComision();
        cargarTabla();
        cargarCodigo();
    }

    public void cargarCodigo(){
        lblCodigo.setText(""+fpModel.secuenciaFormaPago());
    }
    
    public void cargarComision(){
        List<String> comisiones = fpModel.cargarCmbComision();
        cmbComisiones.removeAllItems();
        for (String comision : comisiones) {
            cmbComisiones.addItem(comision);
        }
    }
    
    public void cargarTabla(){
        String sqlBuscar = "SELECT * FROM vta_formapago ";
        String[] campos = {"Codigo", "Forma Pago", "Sigla", "Interes", "Comision"};
        String[] registros = new String[5];
        
        model = new DefaultTableModel(campos, 0);

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                model.addRow(registros);
            }
            tbtComision.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVta_Ofertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar(String formapago){
        String sqlBuscar = "SELECT * FROM vta_formapago where codformapago = "+formapago+"";
        String[] campos = {"Codigo", "Forma Pago", "Sigla", "Interes", "Comision"};
        String[] registros = new String[5];
        
        model = new DefaultTableModel(campos, 0);

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = rs.getString(4);
                registros[4] = rs.getString(5);
                model.addRow(registros);
            }
            lblCodigo.setText(registros[0]);
            txtSigla.setText(registros[2]);
            txtDescripcion.setText(registros[1]);
            txtInteres.setText(registros[3]);
            cmbComisiones.setSelectedItem(fpModel.busacrComision(registros[4]));
            modificar = true;
            tbtComision.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void limpiar(){
        txtDescripcion.setText("");
        txtInteres.setText("");
        txtSigla.setText("");
        txtbuscar.setText("");
        cargarComision();
        cargarCodigo();
        
    }
    
    public void validar(KeyEvent evt, String limite) {
        if (!String.valueOf(evt.getKeyChar()).matches(limite)) {
            evt.consume();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        txtSigla = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtComision = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbComisiones = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Forma pago");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/nuevousuario.png"))); // NOI18N
        btnInsertar.setText("Crear");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel4.setText("Para ingresar, llenar todos los campos.");

        txtInteres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInteresKeyTyped(evt);
            }
        });

        tbtComision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbtComision);

        jLabel3.setText("Sigla :");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jLabel5.setText("Intereses :");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo :");

        jLabel2.setText("Descripcion :");

        jLabel6.setText("Comision :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDescripcion)
                                            .addComponent(txtSigla, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if(modificar){
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descripci�n Vacio");
        } else if (txtInteres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Valor Vacio");
        } else {
            String sigla = txtSigla.getText();
            String descripcion = txtDescripcion.getText();
            String comision =  cmbComisiones.getSelectedItem().toString();
            comision = comision.substring(0, comision.indexOf("-"));
            int codcomision  = Integer.parseInt(comision);
            double intereses = Double.parseDouble(txtInteres.getText());

            int insert = fpModel.insertFormapago(descripcion, sigla, intereses, codcomision);
            if (insert > 0){
                JOptionPane.showMessageDialog(null, "Se guarda Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
                modificar = false;
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(!modificar){
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descripci�n Vacio");
        } else if (txtSigla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Valor Vacio");
        } else {
            String sigla = txtSigla.getText();
            String descripcion = txtDescripcion.getText();
            String comision =  cmbComisiones.getSelectedItem().toString();
            comision = comision.substring(0, comision.indexOf("-"));
            int codcomision  = Integer.parseInt(comision);
            int codigo  = Integer.parseInt(lblCodigo.getText());
            double intereses = Double.parseDouble(txtInteres.getText());

            int update = fpModel.updateFormaPago(codigo, descripcion, sigla, intereses, codcomision);
            if (update > 0){
                JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
                modificar = false;
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!modificar) {
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else {
            int codigo = Integer.parseInt(lblCodigo.getText());
            int delete = fpModel.deleteFormaPago(codigo);
            if (delete > 0){
                JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
                modificar = false;
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtInteresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInteresKeyTyped
        validar(evt, Validacion.SOLONUMEROSDEC);
    }//GEN-LAST:event_txtInteresKeyTyped

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        validar(evt, Validacion.SOLONUMEROS);
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       buscar(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbComisiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTable tbtComision;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtSigla;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
