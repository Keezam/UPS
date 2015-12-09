/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.views;

import com.ups.edu.conexion.ConexionBD;
import com.ups.edu.ventas.model.GarantiasModel;
import com.ups.edu.ventas.model.Validacion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmVta_Garantias extends javax.swing.JInternalFrame {

    GarantiasModel garantiaModel = new GarantiasModel();
    DefaultTableModel model;
    Connection cn = ConexionBD.GetConnection();
    private Statement st;
    private  ResultSet rs;
    /**
     * Creates new form FrmVta_Garantias
     */
    public FrmVta_Garantias() {
        initComponents();
        cargarCodigo();
        cargarFactura();
        cargarTabla();
        
    }

    public void cargarCodigo(){
        lblcodigo.setText(""+garantiaModel.secuenciaGarantia());
    }
    
    public void cargarFactura(){
        List<String> facturas = garantiaModel.cargarFaturas();
        cmbFactura.removeAllItems();
        for (String factura : facturas) {
            cmbFactura.addItem(factura);
        }
    }
    
    public void cargarProducto(){
        if(cmbFactura.getSelectedItem()!=null){
            List<String> productos = garantiaModel.cargarComboProducto(cmbFactura.getSelectedItem().toString());
            cmbProducto.removeAllItems();
            for (String producto : productos) {
                cmbProducto.addItem(producto);
            }
        }
    }
    
    public void cargarDetalleFactura(){
        if(cmbProducto!=null){
            if(cmbProducto.getSelectedItem()!=null){
                String producto = cmbProducto.getSelectedItem().toString();
                if(producto != null){
                    producto = producto.substring(0, producto.indexOf("-"));            
                    lblDetalleFactura.setText(garantiaModel.codigDetallVenta(cmbFactura.getSelectedItem().toString(), producto));
                }
            }
        }   
    }
    
    public void limpiar(){
        txtBuscar.setText("");
        txtDescripcion.setText("");
        txtFechaFin.setText("");
        txtFechaInicio.setText("");
        lblDetalleFactura.setText("");
        cmbProducto.removeAllItems();
    }
    
    public void cargarTabla(){
        String sqlBuscar = "SELECT * FROM vta_garantia ";
        String[] campos = {"Codigo", "Descripcion", "Detalle venta","Venta","Producto","Fecha ingreso","Inicio","Fin"};
        String[] registros = new String[8];
        
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
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(7);
                registros[7] = rs.getString(8);
                model.addRow(registros);
            }
            tbtGarantia.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVta_Ofertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar(String comision){
        String sqlBuscar = "SELECT * FROM vta_garantia where codgarantia = "+comision+"";
        String[] campos = {"Codigo", "Descripcion", "Detalle venta","Venta","Producto","Fecha ingreso","Inicio","Fin"};
        String[] registros = new String[8];
        
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
                registros[5] = rs.getString(6);
                registros[6] = rs.getString(7);
                registros[7] = rs.getString(8);
                model.addRow(registros);
            }
            lblcodigo.setText(registros[0]);
            txtDescripcion.setText(registros[1]);
            lblDetalleFactura.setText(registros[2]);
            cmbFactura.setSelectedItem(registros[3]);
            cmbProducto.setSelectedItem(registros[4]);
            txtFechaInicio.setText(registros[6]);
            txtFechaFin.setText(registros[7]);
            tbtGarantia.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void validar(KeyEvent evt, String limite) {
        System.out.println(""+limite);
        System.out.println(""+String.valueOf(evt.getKeyChar()).matches(limite));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        cmbFactura = new javax.swing.JComboBox();
        lblDetalleFactura = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtGarantia = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Garantias");
        setToolTipText("");

        jLabel1.setText("Codigo Garantia");

        jLabel2.setText("Codigo Factura");

        jLabel3.setText("Codigo Producto");

        jLabel4.setText("Fecha inicio");

        jLabel5.setText("Fecha Fin");

        jLabel6.setText("Codigo  Detalle Factura");

        lblcodigo.setText(" ");

        cmbFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacturaActionPerformed(evt);
            }
        });

        lblDetalleFactura.setText(" ");

        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        txtFechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaInicioKeyTyped(evt);
            }
        });

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

        tbtGarantia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtGarantia);

        jLabel9.setText("Para ingresar, llenar todos los campos.");

        jLabel10.setText("Descripcion");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaInicio)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(txtDescripcion)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDetalleFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblcodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblDetalleFactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        /*if(modificar){
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else */if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descripci�n Vacio");
        } else if (txtFechaFin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Valor Vacio");
        } else {
            String descripcion = txtDescripcion.getText();
            int detVenta = Integer.parseInt(lblDetalleFactura.getText());
            int venta = Integer.parseInt(cmbFactura.getSelectedItem().toString());
            String producto = cmbProducto.getSelectedItem().toString();
            if(producto != null){
                producto = producto.substring(0, producto.indexOf("-"));
            }
            int codProducto = Integer.parseInt(producto);
            String inicio = txtFechaInicio.getText();
            String fin = txtFechaFin.getText();

            int insert = garantiaModel.insertGarantia(descripcion, detVenta, venta, codProducto, inicio, fin);
            if (insert > 0){
                JOptionPane.showMessageDialog(null, "Se guarda Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
         //       modificar = false;
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        /*if(!modificar){
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else*/ if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descripci�n Vacio");
        } else if (txtFechaInicio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Valor Vacio");
        } else {
            int codigo = Integer.parseInt(lblcodigo.getText());
            String inicio = txtFechaInicio.getText();
            String fin = txtFechaFin.getText();

            int update = garantiaModel.updateGarantia(codigo, inicio, fin);
            if (update > 0){
                JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
                //modificar = false;
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        /*if (!modificar) {
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else {*/
            int codigo = Integer.parseInt(lblcodigo.getText());
            int delete = garantiaModel.deleteGarantia(codigo);
            if (delete > 0){
                JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
                limpiar();
                cargarCodigo();
                cargarTabla();
                //modificar = false;
           }
        /*}*/
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacturaActionPerformed
       // System.out.println("Producto");
        cargarProducto();       
    }//GEN-LAST:event_cmbFacturaActionPerformed

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
       // System.out.println("Factura");
        cargarDetalleFactura();
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicioKeyTyped
        validar(evt, Validacion.FECHA);
    }//GEN-LAST:event_txtFechaInicioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbFactura;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDetalleFactura;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JTable tbtGarantia;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
