/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.rrhh.menuinicio;

import com.ups.edu.ventas.views.FrmVta_Cliente;
import com.ups.edu.ventas.views.FrmVta_Factura;
import com.ups.edu.ventas.views.FrmVta_Ofertas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVIDOR
 */
public class menuu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    
    private FrmVta_Ofertas frmVtaOferta = new FrmVta_Ofertas();
    private FrmVta_Factura frmVtaFactura = new FrmVta_Factura();
    private FrmVta_Cliente frmVtaCliente = new FrmVta_Cliente();
    
    public menuu() {
        initComponents();
                jMFinanciero.setVisible(false);
                jMRecHum.setVisible(false);
                jMCompras.setVisible(false);
                jMVentas.setVisible(false);
                jMInventario.setVisible(false);
    }
Iframe1_2 objIFrame1=new Iframe1_2();




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMRecHum = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMFinanciero = new javax.swing.JMenu();
        jMCompras = new javax.swing.JMenu();
        jMVentas = new javax.swing.JMenu();
        jMVta_Cliente = new javax.swing.JMenuItem();
        jMVta_Oferta = new javax.swing.JMenuItem();
        jMVta_Promocion = new javax.swing.JMenuItem();
        jMVta_Factura = new javax.swing.JMenuItem();
        jMInventario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(102, 255, 102));
        Escritorio.setToolTipText("");

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 102));
        jMenu2.setText("ProduEntrega S.A.");
        jMenu2.setBorderPainted(true);
        jMenu2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Inicio de Sesión");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        jMRecHum.setForeground(new java.awt.Color(0, 0, 102));
        jMRecHum.setText("RRHH");
        jMRecHum.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Agregar Personal");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMRecHum.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMRecHum);

        jMFinanciero.setForeground(new java.awt.Color(0, 0, 102));
        jMFinanciero.setText("Financiero");
        jMFinanciero.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jMenuBar1.add(jMFinanciero);

        jMCompras.setForeground(new java.awt.Color(0, 0, 102));
        jMCompras.setText("Compras");
        jMCompras.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jMenuBar1.add(jMCompras);

        jMVentas.setForeground(new java.awt.Color(0, 0, 102));
        jMVentas.setText("Ventas");
        jMVentas.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N

        jMVta_Cliente.setText("Cliente");
        jMVta_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVta_ClienteActionPerformed(evt);
            }
        });
        jMVentas.add(jMVta_Cliente);

        jMVta_Oferta.setText("Oferta");
        jMVta_Oferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVta_OfertaActionPerformed(evt);
            }
        });
        jMVentas.add(jMVta_Oferta);

        jMVta_Promocion.setText("Promocion");
        jMVentas.add(jMVta_Promocion);

        jMVta_Factura.setText("Factura");
        jMVta_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVta_FacturaActionPerformed(evt);
            }
        });
        jMVentas.add(jMVta_Factura);

        jMenuBar1.add(jMVentas);

        jMInventario.setForeground(new java.awt.Color(0, 0, 102));
        jMInventario.setText("Inventario");
        jMInventario.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jMenuBar1.add(jMInventario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
//        iframe1 ses = new iframe1();
//        this.Escritorio.add(ses);
//        ses.show();
       if(objIFrame1.isShowing())
	{
	    JOptionPane.showMessageDialog(null,"LA VENTANA YA ESTA ABIERTA");
        }
	else
	{
	Escritorio.add(objIFrame1);
        objIFrame1.setLocation(500, 80);
	objIFrame1.show();
   }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        try {
            Iframe2_2 objIFrame2=new Iframe2_2();
            Escritorio.add(objIFrame2);
            objIFrame2.setLocation(280, 10);
            objIFrame2.show();
        } catch (SQLException ex) {
            Logger.getLogger(menuu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jMVta_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVta_ClienteActionPerformed
        if(!frmVtaCliente.isShowing()){
            Escritorio.add(frmVtaCliente);
            frmVtaCliente.setLocation(280, 10);;
            frmVtaCliente.show();
        }
    }//GEN-LAST:event_jMVta_ClienteActionPerformed

    private void jMVta_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVta_FacturaActionPerformed
        if(!frmVtaFactura.isShowing()){
            Escritorio.add(frmVtaFactura);
            frmVtaFactura.setLocation(280, 10);;
            frmVtaFactura.show();
        }
    }//GEN-LAST:event_jMVta_FacturaActionPerformed

    private void jMVta_OfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVta_OfertaActionPerformed
        if(!frmVtaOferta.isShowing()){
            Escritorio.add(frmVtaOferta);
            frmVtaOferta.setLocation(280, 10);;
            frmVtaOferta.show();
        }
    }//GEN-LAST:event_jMVta_OfertaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new menuu().setVisible(true);
                menuu men = new menuu();
                men.setExtendedState(MAXIMIZED_BOTH);
                
                men.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    public static javax.swing.JMenu jMCompras;
    public static javax.swing.JMenu jMFinanciero;
    public static javax.swing.JMenu jMInventario;
    public static javax.swing.JMenu jMRecHum;
    public static javax.swing.JMenu jMVentas;
    private javax.swing.JMenuItem jMVta_Cliente;
    private javax.swing.JMenuItem jMVta_Factura;
    private javax.swing.JMenuItem jMVta_Oferta;
    private javax.swing.JMenuItem jMVta_Promocion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
