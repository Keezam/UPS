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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zambrano
 */
public class ClienteModel {

    ResultSet rs;
    Statement st;
    Connection con = ConexionBD.GetConnection();
    String[] nombreColumna = new String[]{"Codigo","Nombre","Apellido","direccion","Tipo Identificacion","identidicacion","Estado"};
    
    public DefaultTableModel cargarTabla(){
        String sqlBuscar = "SELECT * FROM  vta_cliente ";
        Object[] clientes = new Object[8];
        DefaultTableModel tablaCliente = new DefaultTableModel(nombreColumna, 0);
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while(rs.next()){
                clientes[0] = rs.getInt(1);
                clientes[1] = rs.getString(2);
                clientes[2] = rs.getString(3);
                clientes[3] = rs.getString(4);
                clientes[4] = rs.getString(5);
                clientes[5] = rs.getString(6);
                clientes[6] = rs.getString(7);
                clientes[7] = rs.getString(8);
                
                tablaCliente.addRow(clientes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        
        return tablaCliente;
    }
    
    public List<String> buscarCiudad(){
        String sqlBuscar = "select * from inv_Ciudad";
        List<String> ciudad = new ArrayList<>();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            while(rs.next()){
                ciudad.add(rs.getInt(1)+"-"+rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
           try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        
        return ciudad;
    }
    
}
