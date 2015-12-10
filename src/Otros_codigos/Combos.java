/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros_codigos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JeanPierre
 */
public class Combos {
     public Connection conn = null;
     
     public DefaultComboBoxModel Llenar_Combo_Ciudad_Direccion() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
            
            String sql = "select su.id_sucursal,ci.Nombre,su.Direccion from inv_Sucursal su, inv_Ciudad ci where su.id_ciudad=ci.id_ciudad order by su.id_sucursal" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            //lleno el combo
             dcbm.addElement("");  
            while (rs.next()) {
               
                int id = rs.getInt("su.id_sucursal");
                String name = rs.getString("ci.Nombre");
                String name2 = rs.getString("su.Direccion");
                dcbm.addElement(new Combo(id, name +" / "+name2));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error producto: " + e);
        }
        return dcbm;
    }
     
     
        public DefaultComboBoxModel Llenar_Combo_Ciudad() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
            
            String sql = "select * from inv_Ciudad";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            //lleno el combo
           
            while (rs.next()) {
               
                int id = rs.getInt("id_ciudad");
                String name = rs.getString("nombre");
                dcbm.addElement(new Combo(id, name));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error producto: " + e);
        }
        return dcbm;
    }
     
         public DefaultComboBoxModel Llenar_Combo_Proveedor() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
            
            String sql = "select * from base_datos_3_otpl.Proveedores";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            //lleno el combo
           
            while (rs.next()) {
               
                int id = rs.getInt("id_proveedor");
                String name = rs.getString("proveedor");
                dcbm.addElement(new Combo(id, name));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error producto: " + e);
        }
        return dcbm;
    }
         
               public DefaultComboBoxModel Llenar_Combo_Sucursal() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
               
          String sql = "select s.id_sucursal, concat(concat(ci.nombre, ' - '), s.direccion) as Nombre, telefono, correo from base_datos_3_otpl.sucursal s, base_datos_3_otpl.sector se, base_datos_3_otpl.ciudad ci where s.id_sector=se.id_sector and s.id_ciudad=ci.id_ciudad order by s.id_sucursal";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            //lleno el combo
           
            while (rs.next()) {
                int id = rs.getInt("ID_SUCURSAL");
                String name = rs.getString("Nombre");
              
               
                dcbm.addElement(new Combo(id, name));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return dcbm;
    }
               
                        
               public DefaultComboBoxModel Llenar_Combo_Producto(int id) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
               
          String sql = "select p.id_producto, concat(concat(tp.nombre,' - '), mp.nombre) nombre, p.PRECIO_UNITARIO from base_datos_3_otpl.productos p, base_datos_3_otpl.tipo_producto tp, base_datos_3_otpl.marca_producto mp where p.id_tipo=tp.id_tipo and p.id_marca=mp.id_marca and p.id_proveedor= '"+id+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            //lleno el combo
           
            while (rs.next()) {
                int precio = rs.getInt("precio_unitario");
                String name = rs.getString("Nombre");
              
                dcbm.addElement(new Combo(precio, name));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return dcbm;
    }
         
         public DefaultComboBoxModel llenar_combo_tipo_pago(){
              DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
            
            String sql = "select * from base_datos_3_otpl.tipo_pago";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            //lleno el combo
           
            while (rs.next()) {
               
                int id = rs.getInt("id_tipo_pago");
                String name = rs.getString("nombre");
                dcbm.addElement(new Combo(id, name));  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error producto: " + e);
        }
        return dcbm;
         }
}

