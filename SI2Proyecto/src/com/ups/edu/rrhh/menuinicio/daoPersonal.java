
package com.ups.edu.rrhh.menuinicio;

import com.ups.edu.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class daoPersonal {
    public void Insertar(personal obj){
        try {
                //Conectar a mysql
                Connection con = ConexionBD.GetConnection();
                String sql="INSERT INTO rrhh_datos_personales(id_personal,id_cargo,id_departamento,id_sueldo,id_banco,"
                        + "nombre,apellido,cedula,ciudad,direccion,telefono,"
                        + "e_mail,estado_civil,genero,fecha_nac) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement permite trabajar con sent. SQL            
                ps.setInt(1, obj.getId_personal());
                ps.setInt(2, obj.getId_cargo());
                ps.setInt(3, obj.getId_departamento());
                ps.setInt(4, obj.getId_sueldo());
                ps.setInt(5, obj.getId_banco());
                ps.setString(6, obj.getNombre());
                ps.setString(7, obj.getApellido());
                ps.setString(8, obj.getCedula());
                ps.setString(9, obj.getCiudad());
                ps.setString(10, obj.getDireccion());
                ps.setInt(11, obj.getTelefono());
                ps.setString(12, obj.getE_mail());
                ps.setString(13, obj.getEstado_civil());
                ps.setString(14, obj.getGenero());
                ps.setString(15, obj.getFecha_nac());
                int id = ps.executeUpdate();// Insert, Delete, Update trabajo con esecuteUpdate, Select solo trabajo con execute
                JOptionPane.showMessageDialog(null, "Guardado"+id);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
//    public void llenarTablaBusqueda(DefaultTableModel tabla, String texto, String c) {
//        try {
//            Connection conex = Conexion.conectarMysql();
//            String sql = "SELECT com_id, com_computador, com_descripcion , com_modelo, ope_Nombre, mar_descripcion FROM tbl_computador, tbl_operador, tbl_marca WHERE ope_idOperador= com_operador, mar_idMarca=com_marca AND "+c+" LIKE '%" + texto + "%' ";
//            PreparedStatement ps = conex.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            tabla.getDataVector().clear();
//
//                while(rs.next()){
//               Object[] obj = new Object[5];
//                obj[0] = rs.getString("com_id");
//                obj[1] = rs.getString("com_computador");
//                obj[2] = rs.getString("com_descripcion");
//                obj[3] = rs.getString("com_modelo");
//                obj[4] = rs.getString("ope_Nombre");
//                obj[5] = rs.getString("mar_descripcion");
//                tabla.addRow(obj);
//
//            }
//            conex.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
}
