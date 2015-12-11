/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Otros_codigos.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JeanPierre
 */
public class Panel_Fecha extends javax.swing.JInternalFrame {
Connection conn = (Connection) ConexionBD.GetConnection();
    /**
    /**
     * Creates new form Panel_Proveedor
     */
    public Panel_Fecha() {
          ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
                }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DESDE:  ");

        date1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                date1InputMethodTextChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("HASTA:  ");

        date2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("BUSCAR");
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
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
        if(date1.getCalendar().after(date2.getCalendar()) || date2.getCalendar() == null){
           JOptionPane.showMessageDialog(null, "VERIFICAR CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
     }else{
        String dia = Integer.toString(date1.getCalendar().get(Calendar.DAY_OF_MONTH));
String mes = Integer.toString(date1.getCalendar().get(Calendar.MONTH) + 1);
String year = Integer.toString(date1.getCalendar().get(Calendar.YEAR));
String fecha = (year + "-" + mes+ "-" + dia);
        String dia2 = Integer.toString(date2.getCalendar().get(Calendar.DAY_OF_MONTH));
String mes2 = Integer.toString(date2.getCalendar().get(Calendar.MONTH) + 1);
String year2 = Integer.toString(date2.getCalendar().get(Calendar.YEAR));
String fecha2 = (year2 + "-" + mes2+ "-" + dia2);
             int a2 = Principal1.combo_ciudad_direccion.getSelectedIndex();
               if(Principal1.rb_ingresos.isSelected()){
                    buscar_por_fecha_ingreso(fecha, fecha2, a2);
               }
            if(Principal1.rb_egresos.isSelected()){
                    buscar_por_fecha_egreso(fecha, fecha2, a2);
               }
             
        } 
       }catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "VERIFICAR CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void date1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_date1InputMethodTextChanged
       
    }//GEN-LAST:event_date1InputMethodTextChanged

    public void buscar_por_fecha_ingreso(String dato,String dato2, int id ){
          try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Principal1.tabla.setModel(modelo);
       
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("select tp.Nombre as Producto, mp.Nombre as Marca, mop.Nombre as Modelo, prov.nombre as Proveedor, sum(ing.Cantidad) as Cantidad_Total_ing "
                    + "from inv_Producto p, inv_Tipo_Producto tp, inv_Marca_Producto mp, inv_Modelo_Producto mop, cmprv_provedores prov, inv_Ingreso ing "
                    + "where ing.id_producto=p.id_producto and p.id_tipo=tp.id_tipo and p.id_marca=mp.id_marca and p.id_modelo=mop.id_modelo and p.id_proveedor=prov.id_provedor and  ing.id_sucursal= "+id+" "
                    + "and ing.Fecha_ingreso >= '"+dato+"' and ing.Fecha_ingreso <= '"+dato2+"' "
                    + "group by tp.Nombre, mp.Nombre, mop.Nombre,prov.nombre "
                    + "ORDER BY `ing`.`id_producto` ASC");

            ResultSetMetaData rsMd = rs.getMetaData();

            int cantidadColumnas = rsMd.getColumnCount();

            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
        
        } catch (Exception ex) {
            System.out.println("ERROR CARGAR TABLA "+ex);
        }
    }

    
     public void buscar_por_fecha_egreso(String dato,String dato2, int id ){
          try {
            DefaultTableModel modelo = new DefaultTableModel();
            
            Principal1.tabla.setModel(modelo);
       
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("select tp.Nombre as Producto, mp.Nombre as Marca, mop.Nombre as Modelo, prov.nombre as Proveedor, sum(eg.Cantidad) as Cantidad_Total_eg "
                    + "from inv_Producto p, inv_Tipo_Producto tp, inv_Marca_Producto mp, inv_Modelo_Producto mop, cmprv_provedores prov,inv_Egreso eg "
                    + "where eg.id_producto=p.id_producto and p.id_tipo=tp.id_tipo and p.id_marca=mp.id_marca and p.id_modelo=mop.id_modelo and p.id_proveedor=prov.id_provedor and  eg.id_sucursal="+id+" "
                    + "and eg.Fecha_ingreso >= '"+dato+"' and eg.Fecha_ingreso <= '"+dato2+"' "
                    + "group by tp.Nombre, mp.Nombre, mop.Nombre,prov.nombre "
                    + "ORDER BY `eg`.`id_producto` ASC");

            ResultSetMetaData rsMd = rs.getMetaData();

            int cantidadColumnas = rsMd.getColumnCount();

            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
        
        } catch (Exception ex) {
            System.out.println("ERROR CARGAR TABLA "+ex);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}