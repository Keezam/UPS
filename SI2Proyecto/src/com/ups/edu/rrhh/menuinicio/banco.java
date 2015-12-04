
package com.ups.edu.rrhh.menuinicio;


public class banco {
    private Integer id_banco;
    private String nombre;
    private String tipo_cuenta;
    private Integer n_cuenta;

    @Override
    public String toString() {
        return tipo_cuenta;
    }

    public Integer getId_banco() {
        return id_banco;
    }

    public void setId_banco(Integer id_banco) {
        this.id_banco = id_banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Integer getN_cuenta() {
        return n_cuenta;
    }

    public void setN_cuenta(Integer n_cuenta) {
        this.n_cuenta = n_cuenta;
    }
}
