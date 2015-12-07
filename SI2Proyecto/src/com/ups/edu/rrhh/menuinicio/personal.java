
package com.ups.edu.rrhh.menuinicio;

import java.sql.Date;

public class personal {
   private int id_personal,id_cargo,id_departamento,id_sueldo,id_banco,telefono;
   private String nombre,apellido,cedula,ciudad,direccion,e_mail,estado_civil,genero; 
   private Date fecha_nac; 
   
    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_sueldo() {
        return id_sueldo;
    }

    public void setId_sueldo(int id_sueldo) {
        this.id_sueldo = id_sueldo;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
public personal(int id_personal,int id_cargo,int id_departamento,int id_sueldo,int id_banco, String nombre, String apellido, String cedula, String ciudad, String direccion,int telefono,String e_mail, String estado_civil,String genero,Date fecha_fin) {
        this.id_personal = id_personal;
        this.id_cargo = id_cargo;
        this.id_departamento = id_departamento;
        this.id_sueldo = id_sueldo;
        this.id_banco = id_banco;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.e_mail = e_mail;
        this.estado_civil = estado_civil;
        this.genero = genero;
        this.fecha_nac = fecha_nac;
    }

}