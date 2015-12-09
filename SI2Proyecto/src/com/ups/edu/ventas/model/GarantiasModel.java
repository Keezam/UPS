/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.model;

import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GarantiasModel {
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public GarantiasModel(){
        con = ConexionBD.GetConnection();
    }
    
    public int secuenciaGarantia(){
        String sqlBuscar = "SELECT IFNULL( MAX( codgarantia ) , 0 ) +1 FROM vta_garantia ";
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
    
    public List<String> cargarFaturas(){
        
        List<String> facturas = new ArrayList();
        
        String sql = "SELECT codventa FROM vta_ventas";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                facturas.add(""+rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }

        return facturas;
    }
    
    public List<String> cargarComboProducto(String Factura){
        List<String> productos = new ArrayList<>();
        String sqlBuscar = "SELECT p.id_producto , tp.nombre tipo , ma.nombre  marca, mo.nombre modelo " +
                            " FROM vta_ventasdetalle vd, inv_Producto p , inv_Tipo_Producto tp , inv_Marca_Producto ma ,inv_Modelo_Producto mo" +
                            " WHERE vd.codventa = "+Factura+
                            " AND vd.id_producto= p.id_producto " +
                            " AND tp.id_tipo= p.id_tipo " +
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
    
    public String codigDetallVenta(String factura,String prodcuto){
        String sqlBuscar = "SELECT codventadet FROM vta_ventasdetalle where codventa = "+factura+" and id_producto = "+prodcuto;
        System.out.println(""+sqlBuscar);
        String codDetallVenta=null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()) {
                codDetallVenta = ""+rs.getInt(1);
            }
        } catch (SQLException ex) {
            codDetallVenta = null;
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return codDetallVenta;
    }
    
    public int insertGarantia(String descripcion,int detVenta,int venta,int producto,String inicio,String fin){
        String sqlBuscar = "INSERT INTO vta_garantia (descripcion,codventadet,codventa,id_producto,fechaingreso,iniciogarantia,fingarantia) " +
                           " VALUES (?,?,?,?,sysdate(),?,?)";
        int n=0;
        
        java.sql.Date inicioD = new java.sql.Date(DeStringADate(inicio).getTime());
        java.sql.Date finD = new java.sql.Date(DeStringADate(fin).getTime());
        
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, descripcion);
            ps.setInt(2, detVenta);
            ps.setInt(3, venta);
            ps.setInt(4, producto);
            ps.setDate(5, inicioD);
            ps.setDate(6, finD);
            
            n = ps.executeUpdate();
           // con.commit();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(ps != null)ps.close();
           }catch(Exception e){}
        }
        return n;
    }
    
    public int updateGarantia(int codigo,String inicio,String fin){
        String sqlBuscar = "UPDATE vta_garantia "+
                           " SET iniciogarantia = ?, " + 
                           "  fingarantia = ?, " + 
                           " WHERE codgarantia = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, inicio);
            ps.setString(2, fin);
            ps.setInt(3, codigo);
            
            n = ps.executeUpdate();
           // con.commit();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(ps != null)ps.close();
           }catch(Exception e){}
        }
        return n;
    }
    
    public int deleteGarantia(int codigo ){
        String sqlBuscar = "DELETE FROM vta_garantia "+
                           " WHERE codgarantia = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setInt(1, codigo);
            
            n = ps.executeUpdate();
           //con.commit();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(ps != null)ps.close();
           }catch(Exception e){}
        }
        return n;
    }
    
    public Date DeStringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        
        try {
            fechaDate = formato.parse(strFecha);
                        System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }
    
}
