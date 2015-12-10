
package com.ups.edu.rrhh.menuinicio;

public class roldepagos {
    private int id_rol, id_personal, id_cargo, id_sueldo,id_banco, horas_extras,comisiones,total;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

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

    public int getHoras_extras() {
        return horas_extras;
    }

    public void setHoras_extras(int horas_extras) {
        this.horas_extras = horas_extras;
    }

    public int getComisiones() {
        return comisiones;
    }

    public void setComisiones(int comisiones) {
        this.comisiones = comisiones;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
      public roldepagos(int id_rol, int id_personal, int id_cargo, int id_sueldo,int id_banco, int horas_extras, int comisiones, int total) {
        this.id_rol = id_rol;
        this.id_personal = id_personal;
        this.id_cargo = id_cargo;
        this.id_sueldo = id_sueldo;
        this.id_banco = id_banco;
        this.horas_extras = horas_extras;
        this.comisiones = comisiones;
        this.total = total;
    }
 }
