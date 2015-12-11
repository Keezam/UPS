/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.rrhh.menuinicio;

import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author SERVIDOR
 */
public class daoIngreso {
    public void Insertar(ingreso obj){
        try {
                //Conectar a mysql
                Connection con = ConexionBD.GetConnection();
                String sql="INSERT INTO rrhh_reg_ing_egr(id_reg_ing_egr,id_personal, id_horarios, hora_ingreso,hora_egreso,causa_egreso) VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement permite trabajar con sent. SQL
              
                ps.setInt(1, obj.getId_reg_ing_egr());
                ps.setInt(2, obj.getId_personal());
                ps.setInt(3, obj.getId_horarios());
                ps.setInt(4, obj.getHora_ingreso());
                ps.setInt(5, obj.getHora_egreso());
                ps.setString(6, obj.getCausa_egreso());
                
                int id = ps.executeUpdate();// Insert, Delete, Update trabajo con esecuteUpdate, Select solo trabajo con execute
                JOptionPane.showMessageDialog(null, "Guardado"+id);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
}
