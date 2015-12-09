/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.model;

import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FormaPagoModel {
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public FormaPagoModel(){
        con = ConexionBD.GetConnection();
    }
    
    public int secuenciaFormaPago(){
        String sqlBuscar = "SELECT IFNULL( MAX( codformapago ) , 0 ) +1 FROM vta_formapago ";
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
    
    public int insertFormapago(String descripcion,String sigla,double intereses,int comision){
        String sqlBuscar = "INSERT INTO vta_formapago (descripcion,tipopago,intereses,codcomisionbanco) " +
                           " VALUES (?,?,?,?)";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, descripcion);
            ps.setString(2, sigla);
            ps.setDouble(3, intereses);
            ps.setInt(4, comision);
            
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
    
    public int updateFormaPago(int codigo,String descripcion,String sigla,double intereses,int comision){
        String sqlBuscar = "UPDATE vta_formapago "+
                           " SET descripcion = ?, " + 
                           " tipopago = ? ," +
                           " intereses = ? "  +
                           " codcomisionbanco = ? "+
                           " WHERE codformapago = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, descripcion);
            ps.setString(2, sigla);
            ps.setDouble(3, intereses);
            ps.setInt(4, comision);
            ps.setInt(5, codigo);
            
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
    
    public int deleteFormaPago(int codigo ){
        String sqlBuscar = "DELETE FROM vta_formapago "+
                           " WHERE codformapago = ?";
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
    
    
    /*Comisiones*/
    
    public List<String> cargarCmbComision(){
        
        List<String> comisiones = new ArrayList();
        
        String sql = "SELECT * FROM vta_comisionBanco";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                comisiones.add(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }

        return comisiones;
    }
    
    public String busacrComision(String comision){
        
        String comisiones = null;
        
        String sql = "SELECT * FROM vta_comisionBanco where codcomicion = "+comision;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                comisiones= rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getDouble(4);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }

        return comisiones;
    }
    
    
    public int secuenciaComision(){
        String sqlBuscar = "SELECT IFNULL( MAX( codcomicion ) , 0 ) +1 FROM vta_comisionBanco ";
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
    
    public int insertComision(String nombre,String descripcion,double valor){
        String sqlBuscar = "INSERT INTO vta_comisionBanco (nombre,descripcion,valor) " +
                           " VALUES (?,?,?)";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, valor);
            
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
    
    public int updateComision(int codigo,String nombre,String descripcion,double valor){
        String sqlBuscar = "UPDATE vta_comisionBanco "+
                           " SET nombre = ?, " + 
                           " descripcion = ? ," +
                           " valor = ? "  +
                           " WHERE codcomicion = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, valor);
            ps.setInt(4, codigo);
            
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
    
    public int deleteComision(int codigo ){
        String sqlBuscar = "DELETE FROM vta_comisionBanco "+
                           " WHERE codcomicion = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setInt(1, codigo);
            
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
    
}
