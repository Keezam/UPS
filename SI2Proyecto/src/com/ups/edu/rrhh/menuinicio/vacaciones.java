package com.ups.edu.rrhh.menuinicio;

import java.sql.Date;

public class vacaciones {
    private int id_vacaciones, id_personal, dias;
    private Date fecha_inicio, fecha_fin;

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    public int getId_vacaciones() {
        return id_vacaciones;
    }

    public void setId_vacaciones(int id_vacaciones) {
        this.id_vacaciones = id_vacaciones;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public vacaciones(int id_vacaciones, int id_personal, int dias, Date fecha_inicio, Date fecha_fin) {
        this.id_vacaciones = id_vacaciones;
        this.id_personal = id_personal;
        this.dias = dias;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }


}
