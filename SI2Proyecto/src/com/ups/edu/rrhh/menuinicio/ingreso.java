/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.rrhh.menuinicio;


public class ingreso {
    private int id_reg_ing_egr,id_personal, id_horarios, hora_ingreso,hora_egreso;
    private String causa_egreso;

    public int getId_reg_ing_egr() {
        return id_reg_ing_egr;
    }

    public void setId_reg_ing_egr(int id_reg_ing_egr) {
        this.id_reg_ing_egr = id_reg_ing_egr;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public int getId_horarios() {
        return id_horarios;
    }

    public void setId_horarios(int id_horarios) {
        this.id_horarios = id_horarios;
    }

    public int getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(int hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public int getHora_egreso() {
        return hora_egreso;
    }

    public void setHora_egreso(int hora_egreso) {
        this.hora_egreso = hora_egreso;
    }

    public String getCausa_egreso() {
        return causa_egreso;
    }

    public void setCausa_egreso(String causa_egreso) {
        this.causa_egreso = causa_egreso;
    }
    public ingreso(int id_reg_ing_egr, int id_personal,int id_horarios,int hora_ingreso,int hora_egreso, String causa_egreso) {
        this.id_reg_ing_egr = id_reg_ing_egr;
        this.id_personal = id_personal;
        this.id_horarios = id_horarios;
        this.hora_ingreso = hora_ingreso;
        this.hora_egreso = hora_egreso;
        this.causa_egreso = causa_egreso;
    }
}
