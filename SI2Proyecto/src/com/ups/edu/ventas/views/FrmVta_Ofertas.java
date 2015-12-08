/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.views;

import com.ups.edu.conexion.ConexionBD;
import com.ups.edu.ventas.model.Validacion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmVta_Ofertas extends javax.swing.JInternalFrame {

    private Statement st;
    private  ResultSet rs;
    
    private void cargarIdArticulo() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select id_producto from inv_Producto");
            cmbCodArticulo.removeAllItems();
            while (rs.next()) {
                cmbCodArticulo.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarIdOferta() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select IFNULL(MAX(codofertas),0) from vta_ofertas");
            while (rs.next()) {
                Integer idOferta = Integer.valueOf(rs.getString(1)) + 1;
                lblCodOferta.setText(Integer.toString(idOferta));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Limpiar() {
        cmbCodArticulo.setSelectedIndex(0);
        lblCodOferta.setText("");
        txtDescripcion.setText("");
        txtDescuento.setText("");
        txtbuscar.setText("");
        txtValor.setText("");
        cargarIdOferta();
        JOptionPane.showMessageDialog(null, "Limpio");
    }

    public void validar(KeyEvent evt, String limite) {
        if (!String.valueOf(evt.getKeyChar()).matches(limite)) {
            evt.consume();
        }
    }

    DefaultTableModel model;
    Connection cn = ConexionBD.GetConnection();

    public FrmVta_Ofertas() {
        initComponents();
        this.setTitle("Ingreso y Consulta de Ofertas");
        this.setName("OFERTAS");
        this.cargarIdOferta();
        this.cargarIdArticulo();
        this.cargarTabla();
    }

    void Buscar(String valor) {
        String sqlBuscar = "SELECT * FROM vta_ofertas WHERE codofertas ='" + valor + "'";
        String[] campos = {"Codigo Ofertas", "Codigo Producto", "Descripcion", "Valor", "Descuento", "Estado"};
        String[] registros = new String[6];
        
        model = new DefaultTableModel(campos, 0);

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while (rs.next()) {
                registros[0] = rs.getString("codofertas");
                registros[1] = rs.getString("id_producto");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("valor");
                registros[4] = rs.getString("descuento");
                registros[5] = rs.getString("estado");
                model.addRow(registros);
            }
            cmbCodArticulo.setSelectedItem(registros[1]);
            txtDescripcion.setText(registros[2]);
            txtValor.setText(registros[3]);
            txtDescuento.setText(registros[4]);
            cmbEstado.setSelectedItem(registros[5]);
            tbdatos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVta_Ofertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarTabla(){
        String sqlBuscar = "SELECT * FROM vta_ofertas ";
        String[] campos = {"Codigo Ofertas", "Codigo Producto", "Descripcion", "Valor", "Descuento", "Estado"};
        String[] registros = new String[6];
        
        model = new DefaultTableModel(campos, 0);

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while (rs.next()) {
                registros[0] = rs.getString("codofertas");
                registros[1] = rs.getString("id_producto");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("valor");
                registros[4] = rs.getString("descuento");
                registros[5] = rs.getString("estado");
                model.addRow(registros);
            }
            tbdatos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVta_Ofertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<String>();
        lblCodOferta = new javax.swing.JLabel();
        cmbCodArticulo = new javax.swing.JComboBox<String>();

        setClosable(true);
        setTitle("Ofertas");

        jLabel1.setText("Codigo Oferta:");

        jLabel2.setText("Codigo Articulo:");

        jLabel3.setText("Descripción:");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tbdatos);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jLabel4.setText("Para ingresar, llenar todos los campos.");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/anadir.png"))); // NOI18N
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

        jLabel7.setText("Valor:");

        jLabel8.setText("Descuento:");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel9.setText("Estado:");

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "I" }));

        cmbCodArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCodArticuloMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmbCodArticuloMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbCodArticuloMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbCodArticuloMouseReleased(evt);
            }
        });
        cmbCodArticulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCodArticuloItemStateChanged(evt);
            }
        });
        cmbCodArticulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCodArticuloFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscar))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodOferta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar(txtbuscar.getText());
        lblCodOferta.setText(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descripci�n Vacio");
        } else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Valor Vacio");
        } else if (txtDescuento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Registrar, campo Descuento Vacio");
        } else {
            String descripcion, estado, sql, codOfertaS;
            Integer codOferta, codArticulo;
            Double valor, descuento;
            codOferta = Integer.parseInt(lblCodOferta.getText());
            codArticulo = Integer.parseInt((String) cmbCodArticulo.getSelectedItem());
            descripcion = txtDescripcion.getText();
            valor = Double.parseDouble(txtValor.getText());
            descuento = Double.parseDouble(txtDescuento.getText());
            estado = (String) cmbEstado.getSelectedItem();
            sql = "Insert Into vta_ofertas(codofertas,id_producto,descripcion,valor,descuento,estado) values (?,?,?,?,?,?)";
            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, codOferta);
                pst.setInt(2, codArticulo);
                pst.setString(3, descripcion);
                pst.setDouble(4, valor);
                pst.setDouble(5, descuento);
                pst.setString(6, estado);

                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registrado con exito");
                    Limpiar();
                    codOfertaS = String.valueOf(codOferta);
                    cargarTabla();
                }
                cargarIdArticulo();
                cargarIdOferta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Registrar");
            }
        }
//            JOptionPane.showMessageDialog(null, "Error al Registrar, todos los campos deben ser llenados");
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if ((txtbuscar.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, campo Descripci�n Vacio");
        } else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, campo Valor Vacio");
        } else if (txtDescuento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, campo Descuento Vacio");
        } else {
            String descripcion, estado, codOfertaS;
            Integer codOferta, codArticulo;
            Double valor, descuento;
            codOferta = Integer.parseInt(lblCodOferta.getText());
            codArticulo = Integer.parseInt((String) cmbCodArticulo.getSelectedItem());
            descripcion = txtDescripcion.getText();
            valor = Double.parseDouble(txtValor.getText());
            descuento = Double.parseDouble(txtDescuento.getText());
            estado = (String) cmbEstado.getSelectedItem();
            String sql = "UPDATE vta_ofertas SET id_producto = " + codArticulo + ", descripcion = '" + descripcion + "', valor =" + valor + ", descuento =" + descuento + ",estado ='" + estado + "' where codofertas =" + codOferta;
            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualizado");
                Limpiar();
                codOfertaS = String.valueOf(codOferta);
                cargarTabla();
                cargarIdArticulo();
                cargarIdOferta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if ((txtbuscar.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Error, No Existe ese Codigo");
        } else {
            String codOfertaS;
            Integer codigoOfertaEliminar;
            codigoOfertaEliminar = Integer.parseInt((String) lblCodOferta.getText());
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM vta_ofertas WHERE codofertas ='" + codigoOfertaEliminar + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                Limpiar();
                codOfertaS = String.valueOf(codigoOfertaEliminar);
                cargarTabla();
                cargarIdArticulo();
                cargarIdOferta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
        cargarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        validar(evt, Validacion.MENSAJE);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        validar(evt, Validacion.SOLONUMEROSDEC);
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        validar(evt, Validacion.SOLONUMEROSDEC);
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        validar(evt, Validacion.SOLONUMEROS);
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void cmbCodArticuloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCodArticuloMouseReleased

    }//GEN-LAST:event_cmbCodArticuloMouseReleased

    private void cmbCodArticuloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCodArticuloFocusLost
    }//GEN-LAST:event_cmbCodArticuloFocusLost

    private void cmbCodArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCodArticuloItemStateChanged
    }//GEN-LAST:event_cmbCodArticuloItemStateChanged

    private void cmbCodArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCodArticuloMouseClicked

    }//GEN-LAST:event_cmbCodArticuloMouseClicked

    private void cmbCodArticuloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCodArticuloMouseExited
    }//GEN-LAST:event_cmbCodArticuloMouseExited

    private void cmbCodArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCodArticuloMousePressed
    }//GEN-LAST:event_cmbCodArticuloMousePressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCodArticulo;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblCodOferta;
    public javax.swing.JTable tbdatos;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtDescuento;
    public javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
