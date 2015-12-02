/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.model;

import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FacturaModel {
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    public FacturaModel(){
        this.getconection();
    }
    
    public int numeroFactura(){
        String sqlBuscar = "SELECT IFNULL( MAX( codventa ) , 0 ) +1 FROM vta_ventas ";
        int secuencia=0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()) {
                secuencia = rs.getInt(1);
            }
        } catch (SQLException ex) {
            secuencia = 0;
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return secuencia;
    }
    
    public List<String> cargarComboCliente(){
        List<String> clientes = new ArrayList<>();
        String sqlBuscar = "SELECT codcliente, CONCAT(nombre,' ', apellido) cliente FROM vta_cliente";
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            
            while(rs.next()){
                String cliente = rs.getInt(1)+"-"+rs.getString(2);
                clientes.add(cliente);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return clientes;
    }
    
    
    public String[] cliente(int codcliente){
        String sqlBuscar = "SELECT telefono , identificacion, direccion FROM vta_cliente where codcliente = "+codcliente;
        String datosCliente[] = new String[3];
        System.out.println(""+sqlBuscar);
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                datosCliente[0] = rs.getString(1);
                datosCliente[1] = rs.getString(2);
                datosCliente[2] = rs.getString(3);
            }
            
        } catch (Exception e) {
             e.printStackTrace();
            datosCliente[0] = "";
            datosCliente[1] = "";
            datosCliente[2] = "";
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return datosCliente;
    }
    
    public List<String> cargarComboProducto(){
        List<String> productos = new ArrayList<>();
        String sqlBuscar = "SELECT p.id_producto , tp.nombre tipo , ma.nombre  marca, mo.nombre modelo " +
                            " FROM inv_Producto p , inv_Tipo_Producto tp , inv_Marca_Producto ma ,inv_Modelo_Producto mo" +
                            " WHERE tp.id_tipo= p.id_tipo " +
                            " AND ma.id_marca = p.id_marca " +
                            " AND mo.id_modelo= p.id_modelo ";
        
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            
            while(rs.next()){
                String producto = rs.getInt(1)+"-Tipo: "+rs.getString(2)+" Marca:"+rs.getString(3)+" Modelo:"+rs.getString(4);
                productos.add(producto);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return productos;
    }
    
    public double existePromocion(int id_producto){
        String sqlBuscar = " SELECT pp.`valor` FROM vta_promoxproducto pp , vta_promocion p " +
                           "  WHERE p.`codpromocion` = pp.`codpromocion` " +
                           "    AND p.`estado` = 'A' " +
                           "    AND pp.`id_producto` = "+id_producto;
        
        try {
            System.out.println(""+sqlBuscar);
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        
        return 0;
    }
    
    public double existeOferta(int id_producto){
                String sqlBuscar = " SELECT valor FROM vta_ofertas WHERE id_producto = "+id_producto+" AND estado = 'A'"    ;
        System.out.println(""+sqlBuscar);
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
           try{
               if(st != null)st.close();
               if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return 0;
    }
    
    public Object[] datosProducto(int id_producto){
        String sqlBuscar="SELECT p.precio_unitario, IFNULL(i.cantidad_total,0) FROM inv_Producto  p  "
                       + " left join inv_Inventario i on i.id_producto = p.id_producto WHERE p.id_producto = "+id_producto;
        
        Object[] resultado = null;
        
        System.out.println(""+sqlBuscar);
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                resultado = new Object[2];
                resultado[0] = rs.getDouble(1);
                resultado[1] = rs.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           try{
               if(st != null)st.close();
               if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return resultado;
    }
    
    private void getconection(){
        con = ConexionBD.GetConnection();
    }
    
}
