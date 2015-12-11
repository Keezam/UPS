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
 * @author Admin
 */
public class FacturaModel {
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
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
    
    public Object[] existePromocion(int id_producto){
        String sqlBuscar = " SELECT pp.`valor` , p.`codpromocion` FROM vta_promoxproducto pp , vta_promocion p " +
                           "  WHERE p.`codpromocion` = pp.`codpromocion` " +
                           "    AND p.`estado` = 'A' " +
                           "    AND pp.`id_producto` = "+id_producto;
        
        Object [] promocion = null;
        
        try {
            System.out.println(""+sqlBuscar);
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                promocion = new Object[2];
                promocion[0] = rs.getDouble(1);
                promocion[1] = rs.getInt(2);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        
        return promocion;
    }
    
    public Object[] existeOferta(int id_producto){
                String sqlBuscar = " SELECT valor , codofertas FROM vta_ofertas WHERE id_producto = "+id_producto+" AND estado = 'A'"    ;
        System.out.println(""+sqlBuscar);
        
        Object [] oferta = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                oferta = new Object[2];
                oferta[0] = rs.getDouble(1);
                oferta[1] = rs.getInt(2);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
           try{
               if(st != null)st.close();
               if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return oferta;
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
    
    public List<String> cargarSucurcual(){
        String sqlBuscar = "SELECT su.`id_sucursal`,ci.`Nombre`,se.`Nombre`,su.`Direccion` FROM inv_Sucursal su JOIN inv_Sector se ON se.`id_sector` = su.`id_sector` JOIN inv_Ciudad ci ON ci.`id_ciudad` = su.`id_ciudad`";
        List<String> surcursales = null;
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            surcursales = new ArrayList<>();
            while(rs.next()){
                String cliente = rs.getInt(1)+"-"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4);
                surcursales.add(cliente);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return surcursales; 
    }
    
    public int buscarFormaPago(String formapago){
        String sqlBuscar = "SELECT codformapago FROM vta_formapago WHERE tipopago = '"+formapago+"'";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);
            if(rs.next()){
                return rs.getInt(1);
            } 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
            if(st != null)st.close();
            if(rs != null)rs.close();   
           }catch(Exception e){}
        }
        return 0;
    }
    
    public int guardarFactura(int codventa,String tipoventa,int id_personal,int codcliente,
                String obsevacion,double subtotal,double descuento,double iva,double total,int codfrompago){
        String sql = "insert into vta_ventas " +
                     "  (codventa,tipoventa,id_personal,codcliente,obsevacion,subtotal,descuento,iva,total,codfrompago) " +
                     " values (?,?,?,?,?,?,?,?,?,?)";
        int result = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, codventa);
            pst.setString(2, tipoventa);
            pst.setInt(3, id_personal);
            pst.setInt(4, codcliente);
            pst.setString(5, obsevacion);
            pst.setDouble(6, subtotal);
            pst.setDouble(7, descuento);
            pst.setDouble(8, iva);
            pst.setDouble(9, total);
            pst.setInt(10, codfrompago);
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(pst!=null)try {
                pst.close();
            } catch (SQLException ex) {
                
            }
        }
        
        return result;
    }
    
    public void insterDetalleVenta(List<DetalleVentas> lista,int codVenta,int sucursal,int id_personal){
        String sql = " INSERT INTO vta_ventasdetalle(codventa,id_producto,secuencia,descripcion,codoferta,codpromocion,subtotal,descuento,iva,total) " +
                     " VALUES (?,?,?,?,?,?,?,?,?,?)";
        int seuencia = 1;
        
        for (DetalleVentas list : lista) {
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, codVenta);
                pst.setInt(2, list.getCodproducto());
                pst.setInt(3, seuencia);
                pst.setString(4, list.getDescripcion());
                pst.setInt(5, list.getCodoferta());
                pst.setInt(6, list.getCodpromocion());
                pst.setDouble(7, list.getSubtotal());
                pst.setDouble(8, list.getDescuento());
                pst.setDouble(9, list.getIva());
                pst.setDouble(10, list.getTotal());
                
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(pst!=null)
                    try {
                        pst.close();
                    } catch (SQLException ex) {}
            }
            int egreso = registarEgreso(sucursal, codVenta, list.getCodproducto(), id_personal, list.getCantidad());
        }
   }     
       
    
    public int detallepago(FormaPago fp){
        
        String sql = "insert into vta_pagodetalle(codformapago,secuencia,codventa,valor,numerocheque,nombrebanco,fecha,bono) values (?,?,?,?,?,?,?,?)";
        double valor = 0 ;
        int resul = 0;
        for (int i = 0; i < (fp.getCouta()==0?1:fp.getCouta()); i++) {
            if (i==0){
                valor = fp.getValor()/fp.getCouta();
            }
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, buscarFormaPago(fp.getTipoPago()));
                pst.setInt(2, i+1);
                pst.setInt(3, fp.getFactura());
                pst.setDouble(4, valor);
                pst.setString(5, fp.getNumeroCheque());
                pst.setString(6, fp.getBanco());
                pst.setString(7, fp.getFecha());
                pst.setDouble(8, fp.getBono());
                resul = pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
            if(pst!=null)try {
                pst.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }
        return resul;
    }
    
    
    //Egreso
    public int registarEgreso(int surcusal,int producto,int factura,int personal,int cantidad){
        
        String sql = "insert into inv_Egreso " +
                     "  (id_sucursal,id_producto,id_fatura_venta,id_personal,Cantidad,Fecha_egreso) " +
                     " values (?,?,?,?,?,sysdate())";
        int result = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, surcusal);
            pst.setInt(2, producto);
            pst.setInt(3, factura);
            pst.setInt(4, personal);
            pst.setInt(5, cantidad);
            
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(pst!=null)try {
                pst.close();
            } catch (SQLException ex) {
                
            }
        }
        
        return result;
    }
    
}
