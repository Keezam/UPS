/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.rrhh.menuinicio;

/**
 *
 * @author SERVIDOR
 */
public class horario {
    private Integer id_horarios,dias_laborables,horas_laborables;
    private String tipo;

    @Override
    public String toString() {
        return tipo ;
    }

    public Integer getId_horarios() {
        return id_horarios;
    }

    public void setId_horarios(Integer id_horarios) {
        this.id_horarios = id_horarios;
    }

    public Integer getDias_laborables() {
        return dias_laborables;
    }

    public void setDias_laborables(Integer dias_laborables) {
        this.dias_laborables = dias_laborables;
    }

    public Integer getHoras_laborables() {
        return horas_laborables;
    }

    public void setHoras_laborables(Integer horas_laborables) {
        this.horas_laborables = horas_laborables;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
