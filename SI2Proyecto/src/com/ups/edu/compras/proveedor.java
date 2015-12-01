/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.compras;

import com.ups.edu.conexion.ConexionBD;
import com.ups.edu.ventas.model.Validacion;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Bravo
 */
public class proveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form proveedor
     */
    
    Connection conn;
    DefaultTableModel modelo;
    ImageIcon imagen;
    public proveedor() {
        initComponents();
        conn = ConexionBD.GetConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        estado2 = new javax.swing.JRadioButton();
        estado1 = new javax.swing.JRadioButton();
        id_proveedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        telefono1 = new javax.swing.JTextField();
        telefono2 = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnNuevoGuardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();

        setTitle("Proveedores");

        jLabel1.setText("ID PROVEEDOR");

        buttonGroup1.add(estado2);
        estado2.setText("Inactivo");

        buttonGroup1.add(estado1);
        estado1.setText("Activo");
        estado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado1ActionPerformed(evt);
            }
        });

        id_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_proveedorActionPerformed(evt);
            }
        });
        id_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_proveedorKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("INFORMACION");

        jLabel3.setText("ESTADO");

        jLabel5.setText("NOMBRE");

        nombre.setFocusable(false);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
        });

        jLabel6.setText("DIRECCION");

        direccion.setFocusable(false);
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                direccionKeyPressed(evt);
            }
        });

        jLabel7.setText("TELEFONO");

        telefono1.setFocusable(false);
        telefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefono1KeyPressed(evt);
            }
        });

        telefono2.setFocusable(false);
        telefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefono2KeyPressed(evt);
            }
        });

        correo.setFocusable(false);
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                correoKeyPressed(evt);
            }
        });

        jLabel8.setText("CORREO");

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/search.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel4.setText("CIUDAD");

        txtCiudad.setFocusable(false);
        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiudadKeyPressed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/actualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setEnabled(false);

        btnNuevoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/nuevousuario.png"))); // NOI18N
        btnNuevoGuardar.setText("NUEVO PROVEEDOR");
        btnNuevoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoGuardarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/borrar.png"))); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.setEnabled(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/cancelar_1.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/añadir.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(151, 151, 151))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("PRODUCTOS");

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Marca", "Modelo", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tableProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(id_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel8))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(telefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(id_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estado1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estado2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estado1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        try{
            getProveedor(id_proveedor.getText());
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void id_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_proveedorKeyPressed
        // TODO add your handling code here:
        try{
            validar(evt, Validacion.SOLONUMEROS);
            if(evt.getKeyCode() == 10){
                getProveedor(id_proveedor.getText());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor en la caja de texto", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_id_proveedorKeyPressed

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.SOLOLETRAS);
    }//GEN-LAST:event_nombreKeyPressed

    private void direccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.NUMEROSLETRAS);
    }//GEN-LAST:event_direccionKeyPressed

    private void telefono1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono1KeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.SOLONUMEROS);
    }//GEN-LAST:event_telefono1KeyPressed

    private void telefono2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono2KeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.SOLONUMEROS);
    }//GEN-LAST:event_telefono2KeyPressed

    private void txtCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.SOLOLETRAS);
    }//GEN-LAST:event_txtCiudadKeyPressed

    private void correoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyPressed
        // TODO add your handling code here:
        validar(evt, Validacion.CORREO);
    }//GEN-LAST:event_correoKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        modelo = new DefaultTableModel();
        id_proveedor.setText("");
        nombre.setFocusable(false);nombre.setText("");
        direccion.setFocusable(false);direccion.setText("");
        telefono1.setFocusable(false);telefono1.setText("");
        telefono2.setFocusable(false);telefono2.setText("");
        txtCiudad.setFocusable(false);txtCiudad.setText("");
        correo.setFocusable(false);correo.setText("");
        estado1.setEnabled(false);
        estado2.setEnabled(false);
        
        
        btnNuevoGuardar.setEnabled(true);
        eliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void id_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_proveedorActionPerformed

    private void btnNuevoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoGuardarActionPerformed
        // TODO add your handling code here:
        buscar.setEnabled(false);
        if(btnNuevoGuardar.getText().equals("NUEVO PROVEEDOR")){
            imagen = new ImageIcon("UPS/SI2Proyecto/src/com/ups/edu/compras/resources/boton-guardar.png");
            btnNuevoGuardar.setText("GUARDAR");
            btnNuevoGuardar.setIcon(imagen);
        }else if(btnNuevoGuardar.getText().equals("GUARDAR")){
            imagen = new ImageIcon("UPS/SI2Proyecto/src/com/ups/edu/compras/resources/nuevousuario.png");
            btnNuevoGuardar.setText("NUEVO PROVEEDOR");
            btnNuevoGuardar.setIcon(imagen);
        }
    }//GEN-LAST:event_btnNuevoGuardarActionPerformed

    
    private void getProveedor(String cedula_proveedor){
        modelo = new DefaultTableModel();
        //Cambio en los botones cuando se trata de busquedas
        btnNuevoGuardar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(true);
        eliminar.setEnabled(true);
        btnActualizar.setEnabled(true);
        
        //Cambio en las cajas de textos cuando se trata de busquedas
        nombre.setFocusable(false);
        direccion.setFocusable(false);
        telefono1.setFocusable(false);
        telefono2.setFocusable(false);
        txtCiudad.setFocusable(false);
        correo.setFocusable(false);
        tableProductos.setEnabled(false);
        estado1.setEnabled(false);
        estado2.setEnabled(false);
        
        int i = 0;
        
        String consultaProveedor = "SELECT `id_producto`, `id_ciudad`, `nombre`, `direccion`, `telefono1`, "
                + "`telefono2`, `correo`, `estado` FROM `cmprv_provedores` where `cedula_proveedor` = '"+cedula_proveedor+"'";
        String consultaCiudad = "SELECT `descripcion` FROM `cmprv_ciudad` WHERE `id_ciudad` = ";
        String [] dataProveedorString = new String[5];
        Integer [] dataProveedorInt = new Integer[4];
        try{
            tableProductos.setModel(modelo);
            CallableStatement cs = conn.prepareCall(consultaProveedor);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                dataProveedorInt[0] = rs.getInt("id_producto");
                dataProveedorInt[1] = rs.getInt("id_ciudad");
                dataProveedorString[0] = rs.getString("nombre");
                dataProveedorString[1] = rs.getString("direccion");
                dataProveedorInt[2] = rs.getInt("telefono1");
                dataProveedorInt[3] = rs.getInt("telefono2");
                dataProveedorString[2] = rs.getString("correo");
                dataProveedorString[3] = rs.getString("estado");
            }
            
            consultaCiudad = consultaCiudad + dataProveedorInt[1];
            cs = conn.prepareCall(consultaCiudad);
            rs = cs.executeQuery();
            while(rs.next()){
                dataProveedorString[4] = rs.getString("descripcion");
            }
           
            String obtenerData = "SELECT invProducto.id_modelo, invProducto.id_marca, invProducto.id_tipo, invProducto_Precio_unitario" +
                                    " FROM `inv_Producto` AS `invProducto`" +
                                    " WHERE invProducto.id_producto ="+dataProveedorInt[0];   
            
            cs = conn.prepareCall(obtenerData);
            rs = cs.executeQuery();
            Integer data[] = new Integer[3];
            Double precio[] = new Double[1];
            while(rs.next()){
                
                i++;
                
                data[0] = rs.getInt("id_modelo");
                data[1] = rs.getInt("id_marca");
                data[2] = rs.getInt("id_tipo");
                precio[0] = rs.getDouble("Precio_unitario");
                
                String consultaTipo = "select `nombre` from `inv_Tipo_Producto` where `id_tipo`="+data[2];
                String consultaModelo = "select `nombre` from `inv_Marca_Producto` where `id_marca`="+data[1];
                String consultaMarca = "select `nombre` from `inv_Modelo_Producto` where `id_modelo`="+data[0];

                cs = conn.prepareCall(consultaTipo);
                rs = cs.executeQuery();
                Object tipoP[] = new Object[1];
                while(rs.next()){
                    tipoP[0] = rs.getObject("nombre");
                    modelo.setValueAt(tipoP[0], i, 1);
                }

                cs = conn.prepareCall(consultaModelo);
                rs = cs.executeQuery();
                Object modeloP[] = new Object[1];
                while(rs.next()){
                    modeloP[0] = rs.getObject("nombre");
                    modelo.setValueAt(tipoP[0], i, 2);
                }

                cs = conn.prepareCall(consultaMarca);
                rs = cs.executeQuery();
                Object marcaP[] = new Object[1];
                while(rs.next()){
                    marcaP[0] = rs.getObject("nombre");
                    modelo.setValueAt(tipoP[0], i, 3);
                }
                
                modelo.setValueAt(precio[0], i, 4);
            }
            
            
            
            cs.close();
            rs.close();
            
            
            
            nombre.setText(dataProveedorString[0]);
            direccion.setText(dataProveedorString[1]);
            telefono1.setText(String.valueOf(dataProveedorInt[2]));
            telefono2.setText(String.valueOf(dataProveedorInt[3]));
            txtCiudad.setText(dataProveedorString[4]);
            correo.setText(dataProveedorString[2]);
            if(dataProveedorString[3].equals("A")){
                estado1.setSelected(true);
                estado2.setSelected(false);
            }else if(dataProveedorString[3].equals("I")){
                estado1.setSelected(false);
                estado2.setSelected(true);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "El proveedor a consultar no se encuentra registrado o el valor ingresado es nulo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void validar(KeyEvent evt, String limite) {
        if (!String.valueOf(evt.getKeyChar()).matches(limite)) {
            evt.consume();
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevoGuardar;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JRadioButton estado1;
    private javax.swing.JRadioButton estado2;
    private javax.swing.JTextField id_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField telefono1;
    private javax.swing.JTextField telefono2;
    private javax.swing.JTextField txtCiudad;
    // End of variables declaration//GEN-END:variables
}
