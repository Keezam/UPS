/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.rrhh.menuinicio;
import com.ups.edu.conexion.ConexionBD;
import com.ups.edu.ventas.model.Validacion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
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
 * @author SERVIDOR
 */
public class Iframe2_2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form iframe2
     */
    public Iframe2_2() throws SQLException {
        initComponents();
        this.setVisible(true);
        this.setLocation(350, 300);
        dameCargo();
        dameDepartamento();
        dameSueldo();
        dameBanco();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtciudad = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtestadocivil = new javax.swing.JTextField();
        txtfechanac = new javax.swing.JTextField();
        txtgenero = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cmbCargo = new javax.swing.JComboBox<>();
        cmbDep = new javax.swing.JComboBox<>();
        cmbSueldo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cmbBanco = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Datos Personales");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("ProduEntrega S.A.");

        jLabel2.setText("Cargo:");

        jLabel3.setText("Departamento:");

        jLabel4.setText("Sueldo:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Apellido:");

        jLabel7.setText("Ciudad:");

        jLabel8.setText("Direccion:");

        jLabel9.setText("Email:");

        jLabel10.setText("Estado Civil:");

        jLabel11.setText("Fecha de Nacimiento:");

        jLabel12.setText("Genero:");

        jLabel13.setText("Teléfono:");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Cedula:");

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Banco:");

        jLabel16.setText("Codigo Empleado:");

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                                .addComponent(txtnombre)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(59, 59, 59)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtcedula)
                                        .addComponent(txtfechanac)
                                        .addComponent(txtestadocivil)
                                        .addComponent(txtemail)
                                        .addComponent(txtdireccion)
                                        .addComponent(txtciudad)
                                        .addComponent(txtgenero, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel15)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSueldo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cmbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel8)
                                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10))
                                            .addComponent(txtestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtciudad.setText("");
        txtdireccion.setText("");
        txtemail.setText("");
        txtestadocivil.setText("");
        txtfechanac.setText("");
        txtgenero.setText("");
        txttelefono.setText("");
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        char car = evt.getKeyChar();
        if(txtcedula.getText().length()>=10 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                      
        if (txtnombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE NOMBRE","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtapellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE APELLIDO","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtcedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE CEDULA","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtciudad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE CIUDAD","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtdireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE DIRECCION","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE EMAIL","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtestadocivil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE ESTADO CIVIL","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtfechanac.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE FECHA DE NACIMIENTO","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtgenero.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE GENERO","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txttelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE TELEFONO","Error",JOptionPane.WARNING_MESSAGE);
        }else if (txtcodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE CODIGO","Error",JOptionPane.WARNING_MESSAGE);
        }else{{
        daoPersonal obj = new daoPersonal();
//        Combo cb1 = (Combo) jComboBox1.getSelectedItem();
//        int idcargo = cb1.getCodigo();
//        Combo cb2 = (Combo) jComboBox2.getSelectedItem();
//        int iddep = cb2.getCodigo();
//        Combo cb3 = (Combo) jComboBox3.getSelectedItem();
//        int idsueldo = cb3.getCodigo();
//        Combo cb4 = (Combo) jComboBox4.getSelectedItem();
//        int idbanco = cb4.getCodigo();
        int catCargo = (int) cmbCargo.getSelectedIndex();
        int catDep = (int) cmbDep.getSelectedIndex();
        int catSueldo = (int) cmbSueldo.getSelectedIndex();
        int catBanco = (int) cmbBanco.getSelectedIndex();
        int a = Integer.parseInt(txtcodigo.getText());
        int b = Integer.parseInt(txttelefono.getText());
        //Date c = Date.valueOf(txtfechanac.getText());
        obj.Insertar(new personal(a,catCargo,catDep,catSueldo,catBanco,txtnombre.getText(),txtapellido.getText(),txtcedula.getText(),txtciudad.getText(),txtdireccion.getText(),b,txtemail.getText(),txtestadocivil.getText(),txtgenero.getText(),txtfechanac.getText()));
//        try {
//            PreparedStatement pst = cn.prepareStatement("INSERT INTO rrhh_datos_personales("
//                    + "id_personal,id_cargo,id_departamento,id_sueldo,id_banco,"
//                    + "nombre,apellido,cedula,ciudad,direccion,telefono,e_mail,"
//                    + "estado_civil,genero,fecha_nac) "
//                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //PreparedStatement permite trabajar con sent. SQL            
//            pst.setString(1, txtcodigo.getText());
//            pst.setInt(2, idcargo);
//            pst.setInt(3, iddep);
//            pst.setInt(4, idsueldo);
//            pst.setInt(5, idbanco);
//            pst.setString(6, txtnombre.getText());
//            pst.setString(7, txtapellido.getText());
//            pst.setString(8, txtcedula.getText());
//            pst.setString(9, txtciudad.getText());
//            pst.setString(10, txtdireccion.getText());
//            pst.setString(11, txttelefono.getText());
//            pst.setString(12, txtemail.getText());
//            pst.setString(13, txtestadocivil.getText());
//            pst.setString(14, txtgenero.getText());
//            pst.setString(15, txtfechanac.getText());
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Grabación Exitosa");
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Iframe2_2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtciudad.setText("");
        txtdireccion.setText("");
        txtemail.setText("");
        txtestadocivil.setText("");
        txtfechanac.setText("");
        txtgenero.setText("");
        txttelefono.setText("");
        txtcodigo.setText("");
        
        }        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
    char car = evt.getKeyChar();
        if(txtcodigo.getText().length()>=10 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
       char car = evt.getKeyChar();
        if(txttelefono.getText().length()>=10 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txttelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBanco;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbDep;
    private javax.swing.JComboBox<String> cmbSueldo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtestadocivil;
    private javax.swing.JTextField txtfechanac;
    private javax.swing.JTextField txtgenero;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
        
    private void dameCargo() throws SQLException {
        ConexionBD cn = new ConexionBD();
        Connection conn = cn.GetConnection();
        ResultSet rs;
        String sql = "SELECT nombre FROM rrhh_cargo";
        PreparedStatement sqls = conn.prepareStatement(sql);
        rs = sqls.executeQuery();
        while(rs.next()){
            cargo ca = new cargo();
            ca.setNombre(rs.getString("nombre"));
            cmbCargo.addItem(ca+"");
        }
    }
    private void dameDepartamento() throws SQLException {
        ConexionBD cn = new ConexionBD();
        Connection conn = cn.GetConnection();
        ResultSet rs;
        String sql = "SELECT nombre FROM rrhh_departamento";
        PreparedStatement sqls = conn.prepareStatement(sql);
        rs = sqls.executeQuery();
        while(rs.next()){
            depa de = new depa();
            de.setNombre(rs.getString("nombre"));
            cmbDep.addItem(de+"");
        }
    }
    private void dameSueldo() throws SQLException {
        ConexionBD cn = new ConexionBD();
        Connection conn = cn.GetConnection();
        ResultSet rs;
        String sql = "SELECT cantidad FROM rrhh_sueldo";
        PreparedStatement sqls = conn.prepareStatement(sql);
        rs = sqls.executeQuery();
        while(rs.next()){
            sueldo su = new sueldo();
           su.setCantidad(rs.getInt("cantidad"));
            cmbSueldo.addItem(rs.getInt("cantidad")+"");
        }
    }   
    private void dameBanco() throws SQLException {
        ConexionBD cn = new ConexionBD();
        Connection conn = cn.GetConnection();
        ResultSet rs;
        String sql = "SELECT nombre FROM rrhh_banco";
        PreparedStatement sqls = conn.prepareStatement(sql);
        rs = sqls.executeQuery();
        while(rs.next()){
            banco b = new banco();
            b.setNombre(rs.getString("nombre"));
            cmbBanco.addItem(b+"");
        }
    } 
 ConexionBD cc = new ConexionBD();
 Connection cn= cc.GetConnection();
 
}