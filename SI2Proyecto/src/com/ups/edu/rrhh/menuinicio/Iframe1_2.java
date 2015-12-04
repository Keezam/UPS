
package com.ups.edu.rrhh.menuinicio;
import com.ups.edu.conexion.ConexionBD;
import static com.ups.edu.rrhh.menuinicio.menuu.jMCompras;
import static com.ups.edu.rrhh.menuinicio.menuu.jMFinanciero;
import static com.ups.edu.rrhh.menuinicio.menuu.jMInventario;
import static com.ups.edu.rrhh.menuinicio.menuu.jMRecHum;
import static com.ups.edu.rrhh.menuinicio.menuu.jMVentas;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JPasswordField;

public class Iframe1_2 extends javax.swing.JInternalFrame {

    public Iframe1_2() {
        initComponents();
        this.setLocation(350, 300);
        this.requestFocus();
        
    }
    
    
    void ingresar(String cuenta, String clave)throws Exception{
        String c="";
        try{
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(Exception e){
            e.printStackTrace();
            }
            String servidor = "jdbc:mysql://sql3.freesqldatabase.com/sql396208";
            String usuarioDB = "sql396208";
            String passwordDB = "gV6!kN8!";
            Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from rrhh_usuarios where cuenta ='"+cuenta+"' and clave ='"+clave+"'");
                        
            while(rs.next()){
            c=rs.getString("id_modulo");
                System.out.println(c);
            }
            if(c.equalsIgnoreCase("1")){
                JOptionPane.showMessageDialog(null, "Bienvenido Recursos Humanos");
                this.setVisible(false);
                txtcuenta.setText("");
                jPasswordField1.setText("");
                jMRecHum.setVisible(true);
           }else if(c.equalsIgnoreCase("2")){
                JOptionPane.showMessageDialog(null, "Bienvenido Financiero" );
                 this.setVisible(false);
                 txtcuenta.setText("");
                  jPasswordField1.setText("");
                  jMFinanciero.setVisible(true);                
            } else if(c.equalsIgnoreCase("3")){
                JOptionPane.showMessageDialog(null, "Bienvenido Compras" );
                 this.setVisible(false);
                 txtcuenta.setText("");
                  jPasswordField1.setText("");
                  jMCompras.setVisible(true);
            } else if(c.equalsIgnoreCase("4")){
                JOptionPane.showMessageDialog(null, "Bienvenido Ventas" );
                 this.setVisible(false);
                 txtcuenta.setText("");
                  jPasswordField1.setText("");
                  jMVentas.setVisible(true);
            }else if(c.equalsIgnoreCase("5")){
                JOptionPane.showMessageDialog(null, "Bienvenido Inventario" );
                 this.setVisible(false);
                 txtcuenta.setText("");
                  jPasswordField1.setText("");
                  jMInventario.setVisible(true);
            } else{
            JOptionPane.showMessageDialog(null, "NO EXISTE CUENTA","Error",JOptionPane.WARNING_MESSAGE);
            txtcuenta.setText("");
            jPasswordField1.setText("");
            }
            
        }catch(Exception ex){
            System.out.println("Error sql");
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
        txtcuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Inicio de Sesion");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("ProduEntrega S.A.");

        jLabel2.setText("Cuenta:");

        txtcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcuentaActionPerformed(evt);
            }
        });

        jLabel3.setText("Clave:");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcuenta)
                                    .addComponent(jPasswordField1))))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcuentaActionPerformed
        txtcuenta.requestFocus();
    }//GEN-LAST:event_txtcuentaActionPerformed
JPasswordField password = new JPasswordField();
JPasswordField jtextField2 = new JPasswordField(10);
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String c=""; 
        String cuenta=txtcuenta.getText(); 
        String clave= jPasswordField1.getText();
        try{
            ingresar(cuenta,clave);
        }catch(Exception e){
            System.out.println("ERROR");
        }        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField txtcuenta;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
Connection cn=cc.GetConnection();

}
