/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class FormaPagoModel {
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public int secuenciaComision(){
        String sqlBuscar = "SELECT IFNULL( MAX( codventa ) , 0 ) +1 FROM vta_comisionBanco ";
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
