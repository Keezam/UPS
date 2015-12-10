/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros_codigos;

/**
 *
 * @author JeanPierre
 */
public class Combo {
    private int codigo;
    private String texto;
    
 public Combo(int c){
        codigo = c;
    }
    public Combo(int c,String t){
        codigo = c;
        texto  = t;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }   
    @Override
    public String toString(){
        return texto;
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(!(o instanceof Combo)){
            return false;
        }
        Combo cmb = (Combo)o;
        if(codigo != cmb.codigo){
            return false;
        }
        if(texto != null ? !texto.equals(cmb.texto) : cmb.texto!=null){
            return false;
        }
        return true;
    }
}
    