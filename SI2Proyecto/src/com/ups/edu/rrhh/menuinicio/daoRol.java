
package com.ups.edu.rrhh.menuinicio;
import com.ups.edu.conexion.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class daoRol {
    public void Insertar(roldepagos obj){
        try {
                //Conectar a mysql
                Connection con = ConexionBD.GetConnection();
                String sql="INSERT INTO rrhh_reg_vacaciones(id_vacaciones,id_personal,dias,fecha_inicio,fecha_fin) VALUES(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement permite trabajar con sent. SQL
              
                ps.setInt(1, obj.getId_rol());
                ps.setInt(2, obj.getId_personal());
                ps.setInt(3, obj.getId_cargo());
                ps.setInt(4, obj.getId_sueldo());
                ps.setInt(5, obj.getId_banco());
                ps.setInt(6, obj.getHoras_extras());
                ps.setInt(7, obj.getComisiones());
                ps.setInt(8, obj.getTotal());
                                
                int id = ps.executeUpdate();// Insert, Delete, Update trabajo con esecuteUpdate, Select solo trabajo con execute
                JOptionPane.showMessageDialog(null, "Guardado"+id);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
}
