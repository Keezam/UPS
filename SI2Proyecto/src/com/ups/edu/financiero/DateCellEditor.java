/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.financiero;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.ups.edu.financiero.Facturacion.cargartabla;
import javax.swing.JOptionPane;

/**
 *
 * @author Sara Zambrano
 */
class DateCellEditor extends AbstractCellEditor implements
        TableCellEditor {

    private JDateChooser dateChooser = new JDateChooser();

    private Date fechasalida;
    private SimpleDateFormat formatoDelTexto;
    private int indic;
    private int numero;
    private String estado;
    private int credito;
    private double subtotal0;
    private double subtotal12;
    private long total;
    private String bandera;
    private double pago1;
    private double pago2;
    private double pago3;
    private double pago4;
    private double iva;
    private double renta;
    private double saldocomparar;
    private String ss;
    private double tempo_total;
    private String fecha2servidor ;
    public String fecha_actual ;
 public String fecha_nueva ;
     private int id;
    private SimpleDateFormat sformat = new SimpleDateFormat("YYYY-MM-dd");

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
           id  = Integer.valueOf(table.getValueAt(row, 0).toString());
            
       /* try {
            Date fecha11 = new Date();
            DateFormat fecha31 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaA1 = fecha31.format(fecha11);
            String[] z = fechaA1.split("-");
            indic = Integer.valueOf(table.getValueAt(row, 0).toString());
            numero = Integer.valueOf(table.getValueAt(row, 1).toString());
            estado = table.getValueAt(row, 5).toString();
            credito = Integer.valueOf(table.getValueAt(row, 9).toString());
            bandera = table.getValueAt(row, 5).toString();
            //Double.parseDouble(aString);
            subtotal12 = Double.parseDouble(table.getValueAt(row, 7).toString());
            subtotal0 = Double.parseDouble(table.getValueAt(row, 8).toString());
            pago1 = (Double) table.getValueAt(row, 18);
            pago2 = (Double) table.getValueAt(row, 19);
            pago3 = (Double) table.getValueAt(row, 20);
            pago4 = (Double) table.getValueAt(row, 21);
            iva = (Double) table.getValueAt(row, 16);
            renta = (Double) table.getValueAt(row, 17);
            tempo_total = (Double) table.getValueAt(row, 14);

            fechaimcoparable = obtener_datos(indic);*/

            //cliente = table.getValueAt(row,6).toString();
            
       /* } catch (ArrayIndexOutOfBoundsException ec) {

        } catch (Exception e) {

        }

        if (bandera == null) {
            return null;
        } else if (bandera.equals("ACTIVA") == true) {
            return dateChooser;
        } else {
            return null;
        }*/
       
       ss = table.getValueAt(row, 5).toString();
             System.out.println(ss +"mi s es ");
       try {
           fecha_nueva = obtener_datos2(id);
           
            System.out.println("mi nueva es lalalal");
        } catch (SQLException ex) {
            Logger.getLogger(DateCellEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
          if (value instanceof Date) {
             dateChooser.setDate((Date) value);
            } else if (value instanceof Calendar) {
                dateChooser.setCalendar((Calendar) value);
            }
          
   
         dateChooser.setDateFormatString("yyyy-MM-dd");
        if (ss == null) {
            return null;
        }   
       else if (ss.equals("ACTIVA") == true) {
            return dateChooser;
        } else {
            return null;
        }
    }
    
  

    @Override
    public Object getCellEditorValue() {
        try {
             if (fecha_nueva == null) {
                 fecha_nueva = "" ;
             }
         
         sformat.format(dateChooser.getDate());
        System.out.println("mi fecha pilas....!!  "+fecha_nueva);
       }  
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA VALIDAD", "ERROR_SQL"
                    + e, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DateCellEditor.class.getName()).log(Level.SEVERE,
                    null, e);
            
        }
        if (fecha_nueva.equals(sformat.format(dateChooser.getDate()))) {
            System.out.println("hola mundo1111111111  "+fecha_nueva);
            actualizar(fecha_nueva,id);
            cargartabla();
             return fecha_nueva;
        }else{
             
             System.out.println("hola mundo22222222222  "+fecha_nueva);
           actualizar(sformat.format(dateChooser.getDate()),id);
           cargartabla();
             return sformat.format(dateChooser.getDate());
        }
      
     
          
   }

    public String obtener_datos(int a) throws SQLException {
        String fechaincomparable = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();

        String sql = "SELECT NOW() AS Hora_Fecha , fecha_comparacion from facturacion WHERE id ='" + a + "'";
        

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            fechaincomparable = rs.getString("fecha_comparacion");
            String x2[] = rs.getString("Hora_Fecha").split(" ");
                    String x1[] = x2[0].split("-");
                    fecha2servidor = x1[0] + "-" + x1[1] + "-" + x1[2];
        }

        st.close();
        cn.close();
        st = null;
        rs = null;
        cn = null;
        return fechaincomparable;
    }
    
      public String obtener_datos2(int a) throws SQLException {
         
              
   
          String fechaincomparable = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
//"SELECT id,numeracion,cod_venta,fecha,reemplazo,estado,clientes,subtotal0,subtotal0,credito,descuento,cuenta,iva,total,saldo,atraso,id_ciudad,id_oficina from "+fron+" where  fecha is null or fecha is not null order by numeracion ";
        String sql = "SELECT fecha from facturacion1 WHERE id ='" + a + "'";
        

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            fechaincomparable = rs.getString("fecha");
            System.out.println(fechaincomparable+" fecha asdasdkljsdsdakl");
        }

        st.close();
        cn.close();
        st = null;
        rs = null;
        cn = null;
          
          
        return fechaincomparable;
    }

    /*  if (rs.getObject("estado").equals("ACTIVA")) {
     System.out.println("no debe entrar");

     String fechaA1 = fecha31.format(fecha11);
     String[] z = fechaA1.split("-"); //fecha actual
     Calendar H2 = new GregorianCalendar(Integer.parseInt(z[0]), Integer.parseInt(z[1]) - 1, Integer.parseInt(z[2]));
     if (rs.getObject("credito").equals("")) {
     String fecha_compara = rs.getString("fecha");
     String[] a = fecha_compara.split("-");
     Calendar H1 = new GregorianCalendar(Integer.parseInt(a[0]), Integer.parseInt(a[1]) - 1, Integer.parseInt(a[2]));
     final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
     java.util.Date hoy = new Date();
     java.sql.Date fechanu = new java.sql.Date(H1.getTimeInMillis());//fecha anterior

     long diferencia = (hoy.getTime() - fechanu.getTime()) / MILLSECS_PER_DAY;

     if (diferencia < 0) {
     long total = diferencia - 1;
     atraso = rs.getObject("atraso");
     atraso = total;
     System.out.println("entre");
     System.out.println(atraso);
     } else if (diferencia > 0) {
     atraso = rs.getObject("atraso");
     atraso = diferencia;
     System.out.println("entre");
     System.out.println(atraso);
     } else {
     System.out.println(hoy.equals(fechanu.getTime()) + " resultado ultimo");
     System.out.println(hoy.compareTo(fechanu) + " resultado ultimo1");
     System.out.println(hoy.equals(fechanu) + " resultado ultimo2");
     if (H2.getTime().equals(H1.getTime())) {
     System.out.println("0 pilas 000000000000");
     atraso = rs.getObject("atraso");
     atraso = diferencia;
     System.out.println("entre");
     System.out.println(atraso);
     } else {
     long total = diferencia - 1;
     atraso = rs.getObject("atraso");
     atraso = total;
     System.out.println("entre");
     System.out.println(atraso);
     System.out.println("estoy en else cja");
     }

     }
     atraso(atraso, rs.getInt("id"));
     }
     } else {
     atraso = rs.getObject("atraso");
     }*/
    public void actualizar(String fecha,int id) {
        String sql = "";
        String sql3 = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();

        if (cn != null) {
            try {

                
                    sql = "update facturacion1 set fecha=? where id = ?";
                    PreparedStatement psd = cn.prepareStatement(sql);
                    psd.setObject(1, fecha);
                    psd.setObject(2, id);
                    psd.executeUpdate();
                    psd.close();
                    cn.close();
                    psd = null;
                    cn = null;
                

            } catch (SQLException ex) {
                Logger.getLogger(DateCellEditor.class
                        .getName()).log(Level.SEVERE,
                                null, ex);
            } catch (ArrayIndexOutOfBoundsException er) {
                /* Logger.getLogger(Ventana_Principal.class.getName()).log(Level.SEVERE,
                 null, ex);*/
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA VALIDAD", "ERROR_SQL"
                        + e, JOptionPane.ERROR_MESSAGE);
                /*     Logger.getLogger(DateCellEditor.class.getName()).log(Level.SEVERE,
                 null, e);*/
            }

        }
    }

    // JDateChooser chooser = new JDateChooser();
/*dateChooser.getDateEditor().addPropertyChangeListener(
     new PropertyChangeListener() {
     @Override
     public void propertyChange(PropertyChangeEvent e) {
     if ("date".equals(e.getPropertyName())) {
     System.out.println(e.getPropertyName()
     + ": " + (Date) e.getNewValue());
     }
     }
     });
     this.add(dateChooser);*/
}
