package javaapplication2;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {

    Connection conect = null;

    public Connection conexion() {

        try {
         // Class.forName("org.gjt.mm.mysql.Driver");
             Class.forName("com.mysql.jdbc.Driver");
       // conect = DriverManager.getConnection("jdbc:mysql://192.168.1.11/prueba_elicrom", "elicrom", "elicrom");
       // conect = DriverManager.getConnection("jdbc:mysql://fdb12.awardspace.net/1990454_sistemas", "1990454_sistemas", "root1994");
         conect = DriverManager.getConnection("jdbc:mysql://sql3.freesqldatabase.com/sql396208", "sql396208", "gV6!kN8!");
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
       Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, e);
        }
        return conect;
    }
    
    public static void main(String[] args) {
       conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
           try {
              // String sql = "SELECT id_orden_compra , id_provedor ,fecha_orden, impuestos , sub_total,total,estado from cmprv_orden_compra  ";
               String sql = "SELECT descripcion  from cmprv_ciudad  ";
               Statement st = cn.createStatement();
               ResultSet rs = st.executeQuery(sql);
              
              //  System.out.println(rs.getString("descripcion"));
               if (rs.next()) {
                   System.out.println(rs.getString("descripcion"));
                 
               }
           } catch (SQLException ex) {
               Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            System.out.println(" es nula la conexion");
        }
    }
}


