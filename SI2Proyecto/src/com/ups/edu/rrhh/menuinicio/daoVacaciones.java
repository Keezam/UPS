
package com.ups.edu.rrhh.menuinicio;
import java.util.Date;
import java.sql.*;
import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class daoVacaciones {
    public void Insertar(vacaciones obj){
        try {
                //Conectar a mysql
                Connection con = ConexionBD.GetConnection();
                String sql="INSERT INTO rrhh_reg_vacaciones(id_vacaciones,id_personal,dias,fecha_inicio,fecha_fin) VALUES(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement permite trabajar con sent. SQL
              
                ps.setInt(1, obj.getId_vacaciones());
                ps.setInt(2, obj.getId_personal());
                ps.setInt(3, obj.getDias());
                ps.setDate(4, obj.getFecha_inicio());
                ps.setDate(5, obj.getFecha_fin());
                
                int id = ps.executeUpdate();// Insert, Delete, Update trabajo con esecuteUpdate, Select solo trabajo con execute
                JOptionPane.showMessageDialog(null, "Guardado"+id);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
}
