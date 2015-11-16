/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConexionBD {

    public static Connection GetConnection() {
        Connection conexion;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://sql3.freesqldatabase.com/sql396208";
            String usuarioDB = "sql396208";
            String passwordDB = "gV6!kN8!";
            conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
        } catch (ClassNotFoundException ex) {
            conexion = null;
        } catch (SQLException ex) {
            conexion = null;
        } catch (Exception ex) {
            conexion = null;
        }
        return conexion;
    }

}
