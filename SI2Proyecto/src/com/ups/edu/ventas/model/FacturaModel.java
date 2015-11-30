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
    
    public DefaultTableModel cargarComboCliente(){
        DefaultTableModel model = null;
        String sqlBuscar = "SELECT codcliente,nombre || apellido cliente , identificacion, dirreccion, telefono FROM vta_cliente";
        try{
            
        }catch(Exception e){
            
        }
        return model;
    }
    
    
    private void getconection(){
        con = ConexionBD.GetConnection();
    }
    
}
