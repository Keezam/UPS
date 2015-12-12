
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
    Connection conn;
    private String usuario;
    
    public orden(String empleado){
        usuario = empleado;
        System.out.println("Usuario: "+usuario);
    }
    
    public orden() {
        String columnas[] = {"PRODUCTO", "MARCA", "MODELO", "CANTIDAD", "PRECIO_UNITARIO", "Total"};
        listado_prod = new DefaultTableModel(columnas, 0);
        initComponents();
        txtEmpleado.setEnabled(false);
        txtEmpleado.setText("");
        dialogAgregarProducto.setSize(410, 350);
        conn = ConexionBD.GetConnection();
        id_orden.setEnabled(false);
        id_orden.setText(String.valueOf(getNumero_Orden_Compra()));
        fecha.setText(fechaActual());
        try {
            llenarCB();
            llenarSucursal();
        } catch (SQLException ex) {
            Logger.getLogger(orden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

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
        jLabel15 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("INFORMACION");

        jLabel10.setText("CANTIDAD");

        jLabel11.setText("DESCRIPCION");

        precio_uni.setEditable(false);

        id_producto.setEditable(false);

        jLabel12.setText("PRECIO UNITARIO");

        jLabel13.setText("ID PRODUCTO");

        agregarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/anadir.png"))); // NOI18N
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
                .addGap(44, 44, 44)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precio_uni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dialogAgregarProductoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(agregarTabla)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(precio_uni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(dialogAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregarTabla)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("FECHA");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/anadir.png"))); // NOI18N
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

        jLabel15.setText("EMPLEADO");

        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(guardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(id_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtsubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        cmb_tipo.removeAllItems();
        ArrayList<String> resultado1;
        try{
            String nombreProveedor = cmbProveedor.getSelectedItem().toString();
            System.out.println(nombreProveedor);
            int cod_proveedor = obtenerCodigo_Proveedor(nombreProveedor);
            System.out.println(cod_proveedor);
            int cod_tipo = obtenerCodigo_Producto(cod_proveedor);
            System.out.println(cod_tipo);
            if(cod_tipo != 0){
                dialogAgregarProducto.setVisible(true);
                resultado1 = getDescripcion(cod_tipo);
                for (int i = 0; i < resultado1.size(); i++) {

                    cmb_tipo.addItem(resultado1.get(i));
                }
                for (int i = 0; i < tbl_detalle.getRowCount(); i++) {
                    System.out.println("Valor: "+tbl_detalle.getValueAt(i, 5));
                    tbl_detalle.getValueAt(i, 5);
                }
            }else{
                JOptionPane.showMessageDialog(this, "No hay datos del producto","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void id_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_ordenActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try{
            int codigo = obtenerCodigo_Proveedor(usuario);
            String fecha = fechaActual();
            String fechaAtencion = fechaActual();
            String impuesto = txtImpuesto.getText().substring(0,5);
            String subtotal = txtsubTotal.getText();
            String estado = "A";
            String codigoOrden = id_orden.getText();
            String totalP = total.getText();
            boolean resultado = insertarOrdenComrpa(codigo, fecha, fechaAtencion, impuesto, subtotal, totalP ,estado, codigoOrden);
            if(resultado){
                JOptionPane.showMessageDialog(this, "Ingreso correcto","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error en insercion", "Error",JOptionPane.ERROR_MESSAGE);
        }
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
        precio_uni.setText(String.valueOf(dataProdDouble[0]));
        
        }catch(Exception e){
            System.out.println("error PRODUCTO");
        }
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void agregarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTablaActionPerformed
        try{
            cantidad = Integer.valueOf(txt_cant.getText());
            dialogAgregarProducto.setVisible(false);
            Double total;
            total = cantidad * Double.valueOf(precio_uni.getText());
            cargarTbl(cantidad, total);
            
            id_producto.setText("");
            cmb_tipo.setSelectedIndex(0);
            precio_uni.setText("");
            txt_cant.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_agregarTablaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        double subtotal = 0.00;
        for (int i = 0; i < tbl_detalle.getRowCount(); i++) {
            subtotal = subtotal + Double.parseDouble(tbl_detalle.getValueAt(i, 4).toString());
        }
        txtsubTotal.setText(String.valueOf(subtotal));
        double impuesto = (subtotal * 12)/100;
        txtImpuesto.setText(String.valueOf(impuesto));
        double totalC = subtotal + impuesto;
        total.setText(String.valueOf(totalC));
    }//GEN-LAST:event_jButton1ActionPerformed
    //insertarOrdenComrpa(codigo, fecha, fechaAtencion, impuesto, subtotal, estado, codigoOrden);
    private boolean insertarOrdenComrpa(int codigo, String fecha, String fechaAtencion, String impuesto, String subtotal,
                                        String total, String estado, String ordenCompra){
        try{
            String query = "INSERT INTO `cmprv_orden_compra`(`id_provedor`, "
                    + "`fecha_orden`, "
                    + "`fecha_atencion`, "
                    + "`impuestos`, "
                    + "`sub_total`, "
                    + "`total`, "
                    + "`estado`, "
                    + "`codigo_orden_compra`) VALUES"
                    + "(?,?,?,?,?,?,?,?)";
            CallableStatement call;
            call = conn.prepareCall(query);
            call.setInt(1, codigo);
            call.setDate(2,new java.sql.Date(new Date().getTime()) );
            call.setDate(3, new java.sql.Date(new Date().getTime()));
            call.setDouble(4, Double.parseDouble(impuesto));
            call.setDouble(5, Double.parseDouble(subtotal));
            call.setDouble(6, Double.parseDouble(total));
            call.setString(7, estado);
            call.setString(8, ordenCompra);
            call.execute();
            call.close();
            return true;
        }catch(Exception e){
            try{
                conn.rollback();
                return false;
            }catch(Exception ex){
                System.out.println("Error rollback: "+ex.getMessage());
                return false;
            }
        }
    }
    
    
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
    
    private String getNumero_Orden_Compra(){
        String numero_orden = "";
        String query = "";
        int contador;
        try{
            query = "SELECT MAX(`codigo_orden_compra`) FROM `cmprv_orden_compra`";
            CallableStatement cs = conn.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            while (rs.next())
            {
                numero_orden = rs.getString(1);
            }
            //OC-0001-15
            String aumentar = numero_orden.substring(3, 7);
            System.out.println("Aumentar: "+aumentar);
            String fecha = numero_orden.substring(0, 3);
            System.out.println("Fecha: "+fecha);
            String año = numero_orden.substring(7, 10);
            System.out.println("Año: "+año);
            contador = Integer.parseInt(aumentar);
            System.out.println("Contador: "+contador);
            ++contador;
            System.out.println("Contado + 1: "+contador);
            String codigo = String.valueOf(contador);
            if(codigo.length() == 2){
                codigo = "00"+codigo;
            }else if(codigo.length() == 3){
                codigo = "0"+codigo;
            }
            numero_orden = fecha+codigo+año;
        }catch(Exception e){
            System.out.println("Error en consulta: "+e.getMessage());
        }
        return numero_orden;
    }
    
    private void llenarCB() throws SQLException{
        cmbProveedor.removeAllItems();
        cmb_tipo.removeAllItems();
        ArrayList<String> resultado;
        resultado = getProveedores();
        for (int i = 0; i < resultado.size(); i++) {
            cmbProveedor.addItem(resultado.get(i));
        }
        
//        ArrayList<String> resultadoSucursal;
//        resultadoSucursal = llenarSucursal();
//        for (int i = 0; i < resultadoSucursal.size(); i++) {
//            combo_ciudad_direccion.addItem(resultadoSucursal.get(i));
//        }
        
    }
    
    private ArrayList<String> llenarSucursal() throws SQLException{
        String query = "SELECT `Nombre` FROM `inv_Ciudad`";
        CallableStatement ps = conn.prepareCall(query);
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ls.add(rs.getString("nombre"));
        }
        return ls;
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
    
    private ArrayList<String> getDescripcion(int tipo) throws SQLException {
        String seleccion = "select `nombre` from `inv_Tipo_Producto` where `id_tipo`= "+tipo;
        CallableStatement ps = conn.prepareCall(seleccion);
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ls.add(rs.getString("nombre"));
        }
        return ls;
    }
    
    private int obtenerCodigo_Proveedor(String nombre){
        int codigo = 0;
        try{
            String query = "SELECT `id_provedor` FROM `cmprv_provedores` WHERE `nombre`='"+nombre+"'";
            CallableStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                codigo = rs.getInt(1);
            }
            return codigo;
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            return 0;
        }
    }
    
    private int obtenerCodigo_Producto(int codigoProveedor){
        int codigo = 0;
        try{
            String query = "SELECT `id_tipo` FROM `inv_Producto` WHERE `id_proveedor` = "+codigoProveedor;
            CallableStatement ps = conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                codigo = rs.getInt(1);
            }
            return codigo;
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            return 0;
        }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txtsubTotal;
    // End of variables declaration//GEN-END:variables
}
