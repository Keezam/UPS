/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.financiero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Steve Ruiz
 */
public class PRESUPUESTO extends javax.swing.JInternalFrame {

     public static int val = 1;
    public PRESUPUESTO() {
        initComponents();
        cargar_banco(combo);
        combo.setSelectedItem(null);
        error_txt.setVisible(false);
        error_txt1.setVisible(false);
    }
public static void cargar_banco(JComboBox box) {
        
        conexionBD con;
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
               
                
               String sql = "SELECT nombre from rrhh_banco ";

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    modeloCombo.addElement(rs.getString("nombre"));
                }
                box.setModel(modeloCombo);
                
                st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(PRESUPUESTO.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

public static void cargar_centrosxoficina(JComboBox box) {
        
        conexionBD con;
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
               
                
               String sql = "SELECT nombre from rrhh_banco ";

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    modeloCombo.addElement(rs.getString("nombre"));
                }
                box.setModel(modeloCombo);
                
                st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(PRESUPUESTO.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

public int cargar_Banco(String nombre) {
        int valor = 0;
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
               
                
               String sql = "SELECT id_banco from rrhh_banco where nombre = '"+nombre+"' ";

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                 valor = rs.getInt("id_banco");
                }
              st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(PRESUPUESTO.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        return valor ;
    }

private Boolean campo_validaciones(String campo, JLabel error, String mensaje) {
        Boolean d = true;
        if (campo.equals("") == true) {
            error.setVisible(true);
            error.setToolTipText(mensaje);
            d = false;
        }
        return d;
    }

 private int validacion() {
     

        if (campo_validaciones(txt.getText().trim(), error_txt, "DEBE INGRESAR UNA DESCRIPCION BREVE") == false) {
            val = 0;
        }   
        if (campo_validaciones(txt1.getText().trim(), error_txt1, "DEBE INGRESAR EL MONTO DEL PRESUPUESTO") == false) {
            val = 0;
        } 
        
        return val;
    }
 
  private int campo_validacion_Key_Released(String campo, JLabel error) {
        int val = 0;
        if (campo.equals("") != true) {
            error.setVisible(false);
            error.setToolTipText(null);
            val = 1;
        }
        return val;
    }
  private int ingresar_pre(double monto,int codigo,String descripcion ) {

        int n = 0;
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
                String sql3 = "INSERT INTO financiero_presupuestos"
                        + "(monto,id_banco,tipo) VALUES (?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sql3);
                psd.setDouble(1, monto);
                 psd.setInt(2, codigo);
                psd.setString(3, descripcion);
             
              
                n = psd.executeUpdate();
                psd.close();
                cn.close();
                psd = null;
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(PRESUPUESTO.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        return n;
    }
    
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        txt = new javax.swing.JTextField();
        txt1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        error_txt = new javax.swing.JLabel();
        error_txt1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PRESUPUESTO");

        jLabel2.setText("SELECCIONE EL BANCO:");

        jLabel3.setText("MONTO:");

        jLabel4.setText("DESCRIPCION DEL PRESUPUESTO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt1KeyReleased(evt);
            }
        });

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        error_txt.setBackground(new java.awt.Color(255, 0, 0));
        error_txt.setName(""); // NOI18N
        error_txt.setOpaque(true);

        error_txt1.setBackground(new java.awt.Color(255, 0, 0));
        error_txt1.setName(""); // NOI18N
        error_txt1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt)
                            .addComponent(combo, 0, 176, Short.MAX_VALUE)
                            .addComponent(txt1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 87, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(76, 76, 76))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(152, 152, 152))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(error_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error_txt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if (validacion() == 1){
          String sele = (String) combo.getSelectedItem();
       int idbanco =  cargar_Banco(sele);
     double total = Double.parseDouble(txt1.getText());
          ingresar_pre(total, idbanco, txt.getText());
       dispose();
      } else { //errores por campos faltantes
                JOptionPane.showMessageDialog(this, "error en ingrsar presupuesto por favor llene campos obligatorios", "", JOptionPane.ERROR_MESSAGE);
               
            }
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyReleased
         val = campo_validacion_Key_Released(txt.getText().trim(), error_txt);   
    }//GEN-LAST:event_txt1KeyReleased

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
       val = campo_validacion_Key_Released(txt1.getText().trim(), error_txt1);   
    }//GEN-LAST:event_txtKeyReleased

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel error_txt;
    private javax.swing.JLabel error_txt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt;
    private javax.swing.JFormattedTextField txt1;
    // End of variables declaration//GEN-END:variables
}
