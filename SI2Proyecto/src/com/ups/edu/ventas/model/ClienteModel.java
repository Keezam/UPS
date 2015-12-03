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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zambrano
 */
public class ClienteModel {

    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    Connection con = ConexionBD.GetConnection();
    String[] nombreColumna = new String[]{"Codigo","Nombre","Apellido","direccion","Telefono","Tipo Identificacion","identidicacion","Estado","Ciudad"};
    
    public DefaultTableModel cargarTabla(){
        String sqlBuscar = "SELECT cl.codcliente,cl.nombre,cl.apellido,cl.direccion,cl.telefono,cl.tipoidentificacion,cl.identificacion,cl.estado,IFNULL(c.Nombre,'') ciudad FROM  vta_cliente cl LEFT JOIN inv_Ciudad c ON c.id_ciudad = cl.id_ciudad ";
        Object[] clientes = new Object[10];
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
                clientes[8] = rs.getString(9);
                clientes[9] = rs.getString("ciudad");
                
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
    
        public String buscarCiudad(int codciudad){
        String sqlBuscar = "select Nombre from inv_Ciudad where id_ciudad = "+codciudad;
        String ciudad = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                ciudad= rs.getString(1);
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
    
    public int secuenciaCliente(){
        String sqlBuscar = "select ifnull(max(codcliente),0)+1 from vta_cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int insertCliente(String nombre,String apellido,String direccion,String telefono,String tipoidentificacion,String identificacion,String estado,int id_ciudad){
        String sqlBuscar = "INSERT INTO vta_cliente " +
                           "            (nombre, apellido, direccion, telefono, tipoidentificacion, identificacion, estado, id_ciudad)" +
                            "VALUES (?,?,?,?,?,?,?,?);";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, direccion);
            ps.setString(4, telefono);
            ps.setString(5, tipoidentificacion);
            ps.setString(6, identificacion);
            ps.setString(7, estado);
            ps.setInt(8, id_ciudad);
            
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
    
    public int actualizarCliente(int codcliente,String nombre,String apellido,String direccion,String telefono,String tipoidentificacion,String identificacion,String estado,int id_ciudad){
        String sqlBuscar = "UPDATE vta_cliente " +
                           "SET nombre = ?, " +
                           "  apellido = ?, " +
                           "  direccion = ?, " +
                           "  telefono = ?, " +
                           "  tipoidentificacion = ?, " +
                           "  identificacion = ?, " +
                           "  estado = ?, " + 
                           "  id_ciudad = ? " +
                           "WHERE codcliente = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, direccion);
            ps.setString(4, telefono);
            ps.setString(5, tipoidentificacion);
            ps.setString(6, identificacion);
            ps.setString(7, estado);
            ps.setInt(8, id_ciudad);
            ps.setInt(9, codcliente);
            
            n = ps.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
           
        }finally{
           try{
            if(ps != null)ps.close();
           }catch(Exception e){}
        }
        return n;
    }
    
    public int eliminarCliente(int codcliente){
        String sqlBuscar = "Delete from vta_cliente " +
                           "WHERE codcliente = ?";
        int n=0;
        try{
            ps = con.prepareCall(sqlBuscar);

            ps.setInt(1, codcliente);
            
            n = ps.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }finally{
           try{
            if(ps != null)ps.close();
           }catch(Exception e){}
        }
        return n;
    }
    
    public String[] buscarDatos(int codigo){
        
        String sqlBuscar = "SELECT * FROM  vta_cliente where codcliente = "+codigo;
        String [] cliente = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            
            if(rs.next()){
                cliente = new String[9];
                cliente[0] = String.valueOf(rs.getInt(1));
                cliente[1] = rs.getString(2);
                cliente[2] = rs.getString(3);
                cliente[3] = rs.getString(4);
                cliente[4] = rs.getString(5);
                cliente[5] = rs.getString(6);
                cliente[6] = rs.getString(7);
                cliente[7] = rs.getString(8);
                cliente[8] = String.valueOf(rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cliente;
    }
    
}
/*
UPDATE vta_cliente
SET codcliente = ?,
  nombre = ?,
  apellido = ?,
  direccion = ?,
  telefono = ?,
  tipoidentificacion = ?,
  identificacion = ?,
  estado = ?,
  id_ciudad = ?
WHERE codcliente = ?*/