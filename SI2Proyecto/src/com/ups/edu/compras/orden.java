
package com.ups.edu.compras;

import java.sql.Connection;
import com.ups.edu.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class orden extends javax.swing.JFrame {

    DefaultTableModel listado_prod;
    
    public orden() {
        initComponents();
        
        String columnas[] = {"PRODUCTO", "MARCA", "MODELO", "CANTIDAD", "PRECIO_UNITARIO", "Total"};
        listado_prod = new DefaultTableModel(columnas, 0);
        dialogAgregarProducto.setSize(410, 350);
        conn = ConexionBD.GetConnection();
        id_orden.setEnabled(false);
        id_orden.setText(String.valueOf(getNumero_Orden_Compra()));
        fecha.setText(fechaActual());
        try {
            llenarCB();
        } catch (SQLException ex) {
            Logger.getLogger(orden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 Connection conn;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogAgregarProducto = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        precio_uni = new javax.swing.JTextField();
        id_producto = new javax.swing.JTextField();
        txt_cant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        proveedor = new javax.swing.JTextField();
        agregarTabla = new javax.swing.JButton();
        cmb_tipo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        fecha = new javax.swing.JTextField();
        cmbProveedor = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtsubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_orden = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detalle = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("INFORMACION");

        jLabel10.setText("CANTIDAD");

        jLabel11.setText("DESCRIPCION");

        jLabel12.setText("PRECIO UNITARIO");

        jLabel13.setText("ID PRODUCTO");

        jLabel14.setText("PROVEEDOR");

        agregarTabla.setText("AGREGAR");
        agregarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTablaActionPerformed(evt);
            }
        });

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipoItemStateChanged(evt);
            }
        });
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogAgregarProductoLayout = new javax.swing.GroupLayout(dialogAgregarProducto.getContentPane());
        dialogAgregarProducto.getContentPane().setLayout(dialogAgregarProductoLayout);
        dialogAgregarProductoLayout.setHorizontalGroup(
            dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                        .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio_uni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                        .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(agregarTabla)
                                .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        dialogAgregarProductoLayout.setVerticalGroup(
            dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio_uni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregarTabla)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("FECHA");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        fecha.setFocusable(false);

        jLabel7.setText("SUB-TOTAL");

        txtsubTotal.setFocusable(false);

        txtImpuesto.setFocusable(false);

        jLabel8.setText("IMPUESTOS");

        jLabel1.setText("ID ORDEN");

        id_orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_ordenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DETALLE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("INFORMACION");

        total.setFocusable(false);

        jLabel3.setText("TOTAL");

        tbl_detalle.setModel(listado_prod);
        jScrollPane1.setViewportView(tbl_detalle);

        jLabel5.setText("PROVEEDOR");

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/boton-guardar.jpg"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(guardar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(21, 21, 21)
                                        .addComponent(txtsubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(id_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtsubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        dialogAgregarProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void id_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_ordenActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

    }//GEN-LAST:event_guardarActionPerformed

    private void cmb_tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipoItemStateChanged
      
    }//GEN-LAST:event_cmb_tipoItemStateChanged
        String [] dataProdString;
        Integer [] dataProdInt;
        Double [] dataProdDouble;
        Integer cantidad;
        
    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        dataProdString = new String[5];
        dataProdInt = new Integer[5];
        dataProdDouble = new Double[1];
        int texto = cmb_tipo.getSelectedIndex() + 1;
        conn = ConexionBD.GetConnection();
        String consultaProd = 
                "SELECT  P.id_producto , P.id_tipo ,Marca.nombre, Mod.Nombre, Prov.nombre, P.Precio_unitario "
                + "FROM  `inv_Producto` AS `P`, `cmprv_provedores` AS `Prov`, `inv_Marca_Producto` AS `Marca`, `inv_Modelo_Producto` AS `Mod`"
                +" where P.id_tipo = "+texto+" AND P.id_proveedor = Prov.id_provedor AND P.id_marca = Marca.id_marca AND P.id_modelo = Mod.id_modelo";
        
        try{
            //tableProductos.setModel(modelo);
            CallableStatement cs = conn.prepareCall(consultaProd);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                dataProdInt[0] = rs.getInt("P.id_producto");
                dataProdInt[1] = rs.getInt("P.id_tipo");
                dataProdDouble[0] = rs.getDouble("P.Precio_unitario");
                dataProdString[0] = rs.getString("Marca.nombre");
                dataProdString[1] = rs.getString("Mod.Nombre");
                dataProdString[2] = rs.getString("Prov.nombre");
                System.out.println(dataProdString[0] + " - " + dataProdString[1]);
            }
            cs.close();
            rs.close();
        id_producto.setText(String.valueOf(dataProdInt[0]));
        if (dataProdInt[0]==null) {
            agregarTabla.setEnabled(false);
        }else {
            agregarTabla.setEnabled(true);
        }
        proveedor.setText(dataProdString[2]);
        precio_uni.setText(String.valueOf(dataProdDouble[0]));
        
        }catch(Exception e){
            System.out.println("error PRODUCTO");
        }
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void agregarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTablaActionPerformed
        cantidad = Integer.valueOf(txt_cant.getText());
        dialogAgregarProducto.setVisible(false);
        Double total;
        total = cantidad * Double.valueOf(precio_uni.getText());
        cargarTbl(cantidad, total);
        
        id_producto.setText("");
        cmb_tipo.setSelectedIndex(0);
        proveedor.setText("");
        precio_uni.setText("");
        txt_cant.setText("");
    }//GEN-LAST:event_agregarTablaActionPerformed

    private void cargarTbl(Integer cant, Double tot){
        tbl_detalle.setModel(listado_prod);
        Object[] obj = new Object[6];
        obj[0] = String.valueOf(dataProdInt[1]);
        obj[1] = dataProdString[0];
        obj[2] = dataProdString[1];
        obj[3] = cant;
        obj[4] = String.valueOf(dataProdDouble[0]);
        obj[5] = tot;
        listado_prod.addRow(obj);
        tbl_detalle.updateUI();
    }
    
    private static String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd"); 
        return sdf.format(fecha);
    }
    
    private int getNumero_Orden_Compra(){
        int numero_orden = 0;
        String query = "";
        
        try{
            query = "SELECT MAX(`id_orden_compra`) FROM `cmprv_orden_compra`";
            CallableStatement cs = conn.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            while (rs.next())
            {
                numero_orden = rs.getInt(1) + 1;
            }
        }catch(Exception e){
            System.out.println("Error en consulta: "+e.getMessage());
        }
        return numero_orden;
    }
    
    private void llenarCB() throws SQLException{
        cmbProveedor.removeAllItems();
        cmb_tipo.removeAllItems();
        ArrayList<String> resultado;
        ArrayList<String> resultado1;
        resultado = getProveedores();
        resultado1 = getDescripcion();
        
        for (int i = 0; i < resultado.size(); i++) {
            cmbProveedor.addItem(resultado.get(i));
        }
        for (int i = 0; i < resultado1.size(); i++) {
            cmb_tipo.addItem(resultado1.get(i));
        }
    }
    
    private ArrayList<String> getProveedores() throws SQLException {
        String seleccion = "select `nombre` from `cmprv_provedores`";
        CallableStatement ps = conn.prepareCall(seleccion);
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ls.add(rs.getString("nombre"));
        }
        return ls;
    }
    
    private ArrayList<String> getDescripcion() throws SQLException {
        String seleccion = "select `nombre` from `inv_Tipo_Producto`";
        CallableStatement ps = conn.prepareCall(seleccion);
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ls.add(rs.getString("nombre"));
        }
        return ls;
    }
    
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
            java.util.logging.Logger.getLogger(orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarTabla;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox cmb_tipo;
    private javax.swing.JDialog dialogAgregarProducto;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField id_orden;
    private javax.swing.JTextField id_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JTextField precio_uni;
    private javax.swing.JTextField proveedor;
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txtsubTotal;
    // End of variables declaration//GEN-END:variables
}
