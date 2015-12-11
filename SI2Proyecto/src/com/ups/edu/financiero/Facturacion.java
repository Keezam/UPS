/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.financiero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication2.Java2sAutoComboBox;
import javax.swing.ButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Steve Ruiz
 */
public class Facturacion extends javax.swing.JInternalFrame {

   
 public static  String fron = "facturacion1"  ;   
 public static Java2sAutoComboBox combo1;
    public Facturacion() {
        initComponents();
        cargartabla();
        
    }
 
    public static void cargartabla() {
        limpiarTabla(tabla);
         llenar_tabla( 1, "");
        tabla.clearSelection();

    }
     public static void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }

        } catch (ArrayIndexOutOfBoundsException ec) {
            System.out.println("asdasdasdsad");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
public static double redondear(double numero) {
        return (Math.round(numero * Math.pow(10, 2))) / Math.pow(10, 2);
    }
  
// public static void llenar_tabla(String fechacomparacion1, String fechacomparacion2, int tipo, String sql1) {
    public static void llenar_tabla( int tipo, String sql1) {
        DefaultTableModel modelo = null;
        String sql = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            

            try {
                /*Date fecha1 = new Date();
                DateFormat fecha3 = new SimpleDateFormat("yyyy-MM-dd");
                fecha = fecha3.format(fecha1);*/

                //  Double[] titulos = {25.2, 154.4, 45.6, 85.5, 96.2, 89.5, 4504.0, 5.25, 63.2};
               // Object[] titulos = {"ID", "#", "FECHA", "REEMPLAZO", "ESTADO", "CLIENTE", "SUBTOTAL(12% IVA)", "SUBTOTAL(0% IVA)", "CREDITO", "CUENTA", "TOTAL", "SALDO", "ATRASO", "tempo", "tempo1", "iva", "renta", "pago1", "pago2", "pago3", "pago4", "comentario", "PAGO EN", "PAGOS"};
             Object[] titulos = {"ID", "#", "CODIGO VENTA", "FECHA", "REEMPLAZO", "ESTADO", "CLIENTE", "SUBTOTAL(12% IVA)", "SUBTOTAL(0% IVA)", "CREDITO", "DESCUENTO", "CUENTA", "IVA", "TOTAL", "SALDO", "ATRASO", "BANDERA", "PRESUPUESTO","FACTURAR"};
               modelo = new DefaultTableModel(null, titulos) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        
                            if (column == 3 || column == 11 || column == 12) {
                                return true;
                            } else {
                                return true;
                            }
                       

                    }

                    public Class getColumnClass(int columna) {
                        if (columna == 7) {
                            return Double.class;
                        }
                        if (columna == 8) {
                            return Double.class;
                        }
                        if (columna == 4) {
                            return String.class;
                        }
                        if (columna == 3) {
                            return Object.class;
                        }
                        return Object.class;
                    }
                };
                //DefaultTableModel modelo = ((DefaultTableModel) tabla.getModel());
                //  if (filtro.equals("") == true) {
                if (tipo == 1) {
                //    sql = "SELECT id,numeracion,servicio,fecha,reemplazo,estado,cliente,subtotal,subtotal0,credito,cuenta,total,saldo,atraso,temporal_total,temporal_atraso,ivar,rentar,valorp1,valorp2,valorp3,valorp4,tiene_comentario,paga_en from facturacion where fecha between '" + fechacomparacion1 + "' and '" + fechacomparacion2 + "' or fecha is null order by numeracion ";
sql = "SELECT id,numeracion,cod_venta,fecha,reemplazo,estado,clientes,subtotal12,subtotal0,credito,descuento,cuenta,iva,total,saldo,atraso,id_ciudad,id_oficina,estado_final from "+fron+" where  fecha is null or fecha is not null order by numeracion ";
                } else if (tipo == 2) {
                    sql = sql1;
                } 
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                //  DecimalFormat formatea = new DecimalFormat("$###,###.###");
                DecimalFormat formatea = new DecimalFormat("###,###.00");
                Date fecha11 = new Date();
                DateFormat fecha31 = new SimpleDateFormat("yyyy-MM-dd");
                while (rs.next()) {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    //#0.00 
                    // path = path.replaceAll('\', '/');
                    //  System.out.println(formatter.format(rs.getDouble("subtotal")) +" subtotal pilas este es el formato");
                    // modelo.addRow(new Object[]{rs.getInt("id"), rs.getString("numeracion"), rs.getString("fecha"), rs.getString("reemplazo"), rs.getString("estado"), rs.getString("cliente"), rs.getString("subtotal")});
                    // Object ahora ;
                    //  Object ahora1 ;
                    // String path = formatter.format(rs.getDouble("subtotal")) ;
                    // String path1 = path.replaceAll("," , ".");
                    //    System.out.println(path +" path");
                    //  ahora =Double.parseDouble(path1);
                    //  ahora = formatter.format(rs.getDouble("subtotal")) ;
 modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("numeracion"), rs.getObject("cod_venta"), rs.getObject("fecha"), rs.getObject("reemplazo"), rs.getObject("estado"), rs.getString("clientes"), rs.getDouble("subtotal12"), rs.getDouble("subtotal0"), rs.getInt("credito"), rs.getInt("descuento"), rs.getString("cuenta"), redondear(rs.getDouble("iva")), redondear(rs.getDouble("total")), redondear(rs.getDouble("saldo")), rs.getObject("atraso"), rs.getObject("estado_final")});
                    // registros[2]=formatea.format(rs.getInt("PRECIO"));

//modelo.addRow(new Object[]{JDateChooser.class,JDateChooser.class,JDateChooser.class});                    
//  modelo.addColumn(getColumnClass);
                    // modelo.setValueAt(JDateChooser.class, 0, 0);.
                    //modelo.addColumn(JDateChooser.class);
                    //    modelo.addColumn(JDateChooser.class, );
                }
              tabla.setModel(modelo);
                st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
                tabla.getColumnModel().getColumn(1).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(1).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(2).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));                tabla.getColumnModel().getColumn(2).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(3).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(4).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(5).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(6).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(7).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(8).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(9).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(10).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(11).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(12).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(13).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(14).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
               tabla.getColumnModel().getColumn(15).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
//                 tabla.getColumnModel().getColumn(5).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255),new java.awt.Color(102,102,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
//                 tabla.getColumnModel().getColumn(6).setHeaderRenderer(new MyRenderer(new java.awt.Color(102,102,255),new java.awt.Color(255,255,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
//                 tabla.getColumnModel().getColumn(7).setHeaderRenderer(new MyRenderer(new java.awt.Color(51,204,255),new java.awt.Color(102,102,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
//                 tabla.getColumnModel().getColumn(4).setHeaderRenderer(new MyRenderer(new java.awt.Color(102,102,255),new java.awt.Color(255,255,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
//                 tabla.getColumnModel().getColumn(5).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255),new java.awt.Color(102,102,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
//                 tabla.getColumnModel().getColumn(6).setHeaderRenderer(new MyRenderer(new java.awt.Color(102,102,255),new java.awt.Color(255,255,255) ,new java.awt.Font("Tahoma", Font.BOLD, 14)));
                tabla.setShowHorizontalLines(true);
                tabla.setShowVerticalLines(true);
                tabla.getTableHeader().setReorderingAllowed(false);
                tabla.getTableHeader().setReorderingAllowed(false);
                TableColumn column = tabla.getColumnModel().getColumn(3);
                column.setCellEditor(new DateCellEditor());
                TableColumn colu = tabla.getColumnModel().getColumn(18);
                colu.setCellRenderer(new ButtonsRenderer2());
                colu.setCellEditor(new ButtonsEditor2(tabla));
                /*    //  TableColumn column1 = tableVehiclePermit.getColumnModel().getColumn(1);
                 column1.setCellRenderer(new JDateChooserRenderer());
                 column1.setCellEditor(new JDateChooserCellEditor());*/
                // listado.setDefaultEditor(Integer.class, new IntegerEditor(1));
                // TableColumn column1 = tabla.getColumnModel().getColumn(4);
                //column1.setCellRenderer(new RenderCelda());
                
                /* tabla.getColumn("ID").setMinWidth(50);
                 tabla.getColumn("ID").setMaxWidth(50);
                 //                tabla.getColumn("NUMERACION").setMinWidth(100);
                 //  tabla.getColumn("NUMERACION").setMaxWidth(100);
                 tabla.getColumn("FECHA").setMinWidth(150);
                 tabla.getColumn("FECHA").setMaxWidth(150);
                 tabla.getColumn("REEMPLAZO").setMinWidth(100);
                 tabla.getColumn("REEMPLAZO").setMaxWidth(100);
                 tabla.getColumn("ESTADO").setMinWidth(150);
                 tabla.getColumn("ESTADO").setMaxWidth(150);
                 tabla.getColumn("CLIENTE").setMinWidth(230);
                 tabla.getColumn("CLIENTE").setMaxWidth(230);
                 tabla.getColumn("SUBTOTAL(12% IVA)").setMinWidth(160);
                 tabla.getColumn("SUBTOTAL(12% IVA)").setMaxWidth(160);*/
              
                //ojo. tabla.getTableHeader().setReorderingAllowed(false); /// ojoawda
                // tabla.getColumnModel().getColumn(6).setCellEditor((new ComboBoxCellEditor(combo)));
                //
 //desca                 setUpSportColumn(tabla, tabla.getColumnModel().getColumn(5)); // estado
                setUpSportColumn1(tabla, tabla.getColumnModel().getColumn(6)); //cliente
                setUpSportColumn2(tabla, tabla.getColumnModel().getColumn(2)); //producto
                setUpSportColumn3(tabla, tabla.getColumnModel().getColumn(5));
                setUpSportColumn5(tabla, tabla.getColumnModel().getColumn(17));
    //desca            setUpSportColumn4(tabla, tabla.getColumnModel().getColumn(10));//cuenta

               // TableColumn column1 = tabla.getColumnModel().getColumn(3);
                //   column1.setCellRenderer(new RenderCelda_factura());
                //    TableColumn co = tabla.getColumnModel().getColumn(4);
                //     co.setCellRenderer(new RenderCelda_factura());

                /* TableColumn o = tabla.getColumnModel().getColumn(12);
                 o.setCellRenderer(new RenderCelda_factura1());*/
                //   TableColumn co = tabla.getColumnModel().getColumn(3);
                // TableColumn co1 = tabla.getColumnModel().getColumn(4);
                //  TableColumn co2 = tabla.getColumnModel().getColumn(12);
         //desca  RenderCelda_factura1 ft = new RenderCelda_factura1(13);
            //desca      tabla.getColumnModel().getColumn(4).setCellRenderer(ft);
           //desca       RenderCelda_factura1 ft2 = new RenderCelda_factura1(13);
             //desca     tabla.getColumnModel().getColumn(5).setCellRenderer(ft2);
            //desca      RenderCelda_factura1 ft3 = new RenderCelda_factura1(13);
            //desca      tabla.getColumnModel().getColumn(13).setCellRenderer(ft3);
                //   TableColumn columnpa = tabla.getColumnModel().getColumn(13);
                //  columnpa.setCellRenderer(new RenderCelda());
 //desca               TableColumn columnmenor = tabla.getColumnModel().getColumn(23);
 //desca                columnmenor.setCellRenderer(new RenderCelda1());
                //TableColumn o = tabla.getColumnModel().getColumn(12);
                //o.setCellRenderer(new RenderCelda_factura1());
//  tabla.setDefaultRenderer(Object.class, new MiRender1());
      //desca            tabla.setDefaultEditor(String.class, new StringEditor(4));
     //desca         tabla.setDefaultEditor(Integer.class, new IntegerEditor(1));
    //desca        tabla.setDefaultEditor(Double.class, new DoubleEditor(0.01));
               // tabla.setDefaultEditor(Double.class, new DoubleEditor(-1));
                

                

                // column.setCellRenderer(new JDateChooserRenderer());
             
    //desca              TableColumn colu = tabla.getColumnModel().getColumn(24);
    //desca              colu.setCellRenderer(new ButtonsRenderer2());
     //desca             colu.setCellEditor(new ButtonsEditor2(tabla));
                // "#", "PRO/SER", "FECHA", "REEMPLAZO", "ESTADO", "CLIENTE", "SUBTOTAL(12% IVA)", "SUBTOTAL(0% IVA)", "CREDITO", "CUENTA", "TOTAL", "SALDO", "ATRASO", "tempo", "tempo1", "iva", "renta", "pago1", "pago2", "pago3", "pago4", "comentario", "PAGO EN", "PAGOS"};              
//"ID", "#", "CODIGO VENTA", "FECHA", "REEMPLAZO", "ESTADO", "CLIENTE", "SUBTOTAL(12% IVA)", "SUBTOTAL(0% IVA)", "CREDITO", "DESCUENTO", "CUENTA", "IVA", "TOTAL", "SALDO", "ATRASO"
                tabla.getColumn("ID").setMaxWidth(0);
                tabla.getColumn("ID").setMinWidth(0);
                tabla.getColumn("ID").setPreferredWidth(0);
                tabla.getColumn("#").setMaxWidth(55);
                tabla.getColumn("#").setMinWidth(55);
                tabla.getColumn("CODIGO VENTA").setMaxWidth(145);
                tabla.getColumn("CODIGO VENTA").setMinWidth(145);
                tabla.getColumn("FECHA").setMaxWidth(120);
                tabla.getColumn("FECHA").setMinWidth(120);
                tabla.getColumn("REEMPLAZO").setMaxWidth(105);
                tabla.getColumn("REEMPLAZO").setMinWidth(105);
                tabla.getColumn("ESTADO").setMaxWidth(89);
                tabla.getColumn("ESTADO").setMinWidth(89);
                tabla.getColumn("CLIENTE").setMaxWidth(400);
                tabla.getColumn("CLIENTE").setMinWidth(400);
                tabla.getColumn("CREDITO").setMaxWidth(65);
                tabla.getColumn("CREDITO").setMinWidth(65);
                tabla.getColumn("CUENTA").setMaxWidth(210);
                tabla.getColumn("CUENTA").setMinWidth(210);
                tabla.getColumn("SUBTOTAL(12% IVA)").setMaxWidth(138);
                tabla.getColumn("SUBTOTAL(12% IVA)").setMinWidth(138);
                tabla.getColumn("SUBTOTAL(0% IVA)").setMaxWidth(135);
                tabla.getColumn("SUBTOTAL(0% IVA)").setMinWidth(135);
                tabla.getColumn("TOTAL").setMaxWidth(87);
                tabla.getColumn("TOTAL").setMinWidth(87);
                tabla.getColumn("SALDO").setMaxWidth(87);
                tabla.getColumn("SALDO").setMinWidth(87);
                tabla.getColumn("ATRASO").setMaxWidth(65);
                tabla.getColumn("ATRASO").setMinWidth(65);
                tabla.getColumn("DESCUENTO").setMaxWidth(65);
                tabla.getColumn("DESCUENTO").setMinWidth(65);
                tabla.getColumn("IVA").setMaxWidth(65);
                tabla.getColumn("IVA").setMinWidth(65);
                tabla.getColumn("FACTURAR").setMaxWidth(105);
                tabla.getColumn("FACTURAR").setMinWidth(105);
                tabla.getColumn("BANDERA").setMaxWidth(0);
                tabla.getColumn("BANDERA").setMinWidth(0);
                tabla.getColumn("BANDERA").setPreferredWidth(0);
                tabla.getColumn("PRESUPUESTO").setMaxWidth(105);
                tabla.getColumn("PRESUPUESTO").setMinWidth(105);
                
                tabla.setAutoResizeMode(AUTO_RESIZE_OFF);
               
             /* TableColumn column = tabla.getColumnModel().getColumn(2);
                 column.setCellRenderer(new JDateChooserRenderer2());
                 column.setCellEditor(new JDateChooserEditor2(tabla));*/
                // tabla.setDefaultRenderer(JDateChooser.class, new MiRender());
                //   tabla.setDefaultEditor( JDateChooser.class, new MiEditor());
//                 lista_contacto.getColumn("RESPONSABLE").setMinWidth(230);
//                 lista_contacto.getColumn("# GUIA COURIER").setMaxWidth(150);
//                 lista_contacto.getColumn("# GUIA COURIER").setMinWidth(150);
            } catch (SQLException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, ex);

            } catch (ArrayIndexOutOfBoundsException er) {
                   Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, er);
            } catch (Exception e) {
                   Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, e);
            }
        }
    }
    


 public static void setUpSportColumn1(JTable table,
            TableColumn sportColumn) {

        //  final JComboBox comboBox = new JComboBox();
        try {

            // String sql = "";
            conexionBD con;
            //  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            con = new conexionBD();
            Connection cn = con.conexion();
          
            List<String> myWords = new ArrayList<String>();
            String sql = "SELECT clientes FROM "+fron+"   ORDER BY clientes";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            myWords.add("");
            while (rs.next()) {
                System.out.println("no entro pilas ayudame a entrar");
                if (!rs.getString("clientes").equals("")) {
                    myWords.add(rs.getString("clientes"));
                }
                
            }
            
            //  StringSearchable searchable = new StringSearchable(myWords);
            combo1 = new Java2sAutoComboBox(myWords);
            sportColumn.setCellEditor(new DefaultCellEditor(combo1));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Hacer clic para modificar el cliente de esta factura");
            sportColumn.setCellRenderer(renderer);

        } catch (Exception ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        combo1.addActionListener(new ActionListener() {  //boton MODIFICAR
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = tabla.getEditingRow();
                
                    
               
                if (row != -1) {
                    try {
                        int id = Integer.valueOf(tabla.getValueAt(row, 0).toString());
                        String estado = tabla.getModel().getValueAt(row, 16).toString(); // placa
                     if (!estado.equals("FACTURADA")) {
                     
                     String seleccion_ub = (String) combo1.getSelectedItem();
                     
                     actualizar("clientes",seleccion_ub,id);
                     }else{
                         JOptionPane.showMessageDialog(null, "LA FACTURA SE ENCUENTRA FACTURADA", "NO SE PUEDE REALIZAR", JOptionPane.WARNING_MESSAGE); 
                     }
           } catch (Exception ex) {
                        // Logger.getLogger(Ventana_Principal.class.getName()).log(Level.SEVERE, null, ex);
                        //cargartabla();
                        JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA FECHA ANTES DE REALIZAR ESTE PROCESO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

                    }
                     cargartabla();
                }
                
                 
            }
        });
    
    }
 
 /*  private int ingresar_acepta(int pre,int id_orden,double total,double iva ,String fecha) {

        int n = 0;
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
                String sql3 = "INSERT INTO financiero_aceptar_orden"
                        + "(id_presupuesto,id_orden_compra,total,iva_por_cobrar,fecha) VALUES (?,?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sql3);
                psd.setDouble(1, monto);
                 psd.setInt(2, codigo);
                psd.setString(3, descripcion);
             
              
                n = psd.executeUpdate();
                psd.close();
                cn.close();
                psd = null;
                cn = null;
            } catch (SQLException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        return n;
    }
 */
 
 static class ButtonsPanel2 extends JPanel {

        public final java.util.List<JButton> buttons = java.util.Arrays.asList(new JButton(""));

        public ButtonsPanel2() {
            super();
            setOpaque(true);
            for (JButton b : buttons) {
                b.setFocusable(false);
                b.setRolloverEnabled(false);
                add(b);

//                ImageIcon fot1 = new ImageIcon(getClass().getResource("/imagenes/b_guardar.png"));
        //        buttons.get(0).setIcon(fot1);
                buttons.get(0).setToolTipText("INGRESAR STOCK");
                 buttons.get(0).setPreferredSize(new Dimension(25, 18));
            }
        }
    }

    static class ButtonsRenderer2 extends ButtonsPanel2 implements TableCellRenderer {

        public ButtonsRenderer2() {
            super();
            setName("Table.cellRenderer");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            this.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return this;
        }
    }

    static class ButtonsEditor2 extends ButtonsPanel2 implements TableCellEditor {

        public ButtonsEditor2(final JTable table) {
            super();
            //---->
            //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
            MouseListener ml = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ButtonModel m = ((JButton) e.getSource()).getModel();
                    if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                        //setBackground(table.getBackground());
                    }
                }
            };
            buttons.get(0).addMouseListener(ml);
            //<----

            buttons.get(0).addActionListener(new ActionListener() {  //boton INFORMACION
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    if (row >= 0) {
                        int numeracion = Integer.valueOf(table.getModel().getValueAt(row, 0).toString()); // numeracion
                         String estado = table.getModel().getValueAt(row, 16).toString(); // placa
                         System.out.println(estado+"  estasasdasdasdasdasdasdasdasd");
                        if (!estado.equals("FACTURADA")) {
                            actualizar("estado_final", "FACTURADA", numeracion);
                        }else{
                         JOptionPane.showMessageDialog(null, "LA FACTURA SE ENCUENTRA FACTURADA", "NO SE PUEDE REALIZAR", JOptionPane.ERROR_MESSAGE); 
                     }
                    }
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            Color color = new Color(249, 249, 249);
            this.setBackground(color);
            return this;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }

        transient protected ChangeEvent changeEvent = null;

        @Override
        public boolean isCellEditable(java.util.EventObject e) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(java.util.EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            fireEditingStopped();
            return true;
        }

        @Override
        public void cancelCellEditing() {
            fireEditingCanceled();
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            listenerList.add(CellEditorListener.class, l);
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            listenerList.remove(CellEditorListener.class, l);
        }

        public CellEditorListener[] getCellEditorListeners() {
            return listenerList.getListeners(CellEditorListener.class);
        }

        protected void fireEditingStopped() {

        }

        protected void fireEditingCanceled() {

        }

    }
 
 
    
      public static void setUpSportColumn5(JTable table,
            TableColumn sportColumn) {
        final JComboBox comboBox = new JComboBox();
        try {
            
        
 
        conexionBD con;
            //  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
           con = new conexionBD();
            Connection cn = con.conexion();
          
           
            String sql = "SELECT tipo FROM financiero_presupuestos  ORDER BY tipo";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
               comboBox.addItem(rs.getString("tipo"));
                }
     sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Hacer clic para modificar el cliente de esta factura");
            sportColumn.setCellRenderer(renderer);  
            comboBox.setSelectedItem(null);
      } catch (Exception e) {
          Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, e);
        }      
        
        comboBox.addActionListener(new ActionListener() {  //boton MODIFICAR
 
             
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //comboBox.setSelectedItem(null);
                try {
                    
               
 
                int row = tabla.getEditingRow();
                if (row != -1) {

                  int id = Integer.valueOf(tabla.getValueAt(row, 0).toString());
                    
                    String seleccion_ub = (String) comboBox.getSelectedItem();
                    String estado = tabla.getModel().getValueAt(row, 16).toString(); // placa
                         System.out.println(estado+"  estasasdasdasdasdasdasdasdasd");
                        if (!estado.equals("FACTURADA")) {
                            actualizar("presupuesto", seleccion_ub, id);
                             cargartabla();
                        }else{
                         JOptionPane.showMessageDialog(null, "LA FACTURA SE ENCUENTRA FACTURADA", "NO SE PUEDE REALIZAR", JOptionPane.ERROR_MESSAGE); 
                     }
                   
                     //actualizar("estado",seleccion_ub,id);
                   //  System.out.println(id+" hola mundo");
                   //   System.out.println(seleccion_ub+" hola mundo");
                   cargartabla();
                }
                
                 } catch (Exception ex) {
                        Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, ex); 
                }
                
            }
        });
    }
 
    
    
    


    
    
    
    public static void setUpSportColumn2(JTable table,
            TableColumn sportColumn) {
        final JComboBox comboBox = new JComboBox();
        try {
            
        
 
        conexionBD con;
            //  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
           con = new conexionBD();
            Connection cn = con.conexion();
          
           
            String sql = "SELECT v.codventa FROM vta_ventas v where v.codventa not in(select cod_venta from "+fron+") ORDER BY codventa";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
               comboBox.addItem(rs.getString("v.codventa"));
                }
     sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Hacer clic para modificar el cliente de esta factura");
            sportColumn.setCellRenderer(renderer);  
            comboBox.setSelectedItem(null);
      } catch (Exception e) {
          Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, e);
        }      
        
        comboBox.addActionListener(new ActionListener() {  //boton MODIFICAR
 
             
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //comboBox.setSelectedItem(null);
                try {
                    
               
 
                int row = tabla.getEditingRow();
                if (row != -1) {

                  int id = Integer.valueOf(tabla.getValueAt(row, 0).toString());
                    
                    String seleccion_ub = (String) comboBox.getSelectedItem();
                    String estado = tabla.getModel().getValueAt(row, 16).toString(); // placa
                        if (!estado.equals("FACTURADA")) {
         conexionBD con;
            //  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
           con = new conexionBD();
            Connection cn = con.conexion();
          
           
            String sql = "SELECT v.codventa,c.nombre,c.apellido,v.subtotal,v.iva,v.total,d.descuento FROM vta_ventas v inner join vta_ventasdetalle d on d.codventa ="+seleccion_ub+" inner join vta_cliente c on c.codcliente = v.codcliente where v.codventa = "+seleccion_ub+" ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(seleccion_ub+" hola mundo este es lalal no puedo");       
            if (rs.next()) {
                        
                        System.out.println(seleccion_ub+" hola mundo este es lalal no puedo");
                        if (rs.getDouble("v.iva") == 0) {
                            System.out.println("ivva es igual a 0");
                            actualizar1(seleccion_ub, "ACTIVA",rs.getString("c.nombre")+" "+rs.getString("c.apellido"), 0, rs.getDouble("v.subtotal"),0,rs.getInt("d.descuento"), rs.getDouble("v.iva"), rs.getDouble("v.total"),rs.getDouble("v.total"), "ACTIVA", id); 
                        }else{
                            System.out.println("ivva no es igual a 0");
                    
                            actualizar1(seleccion_ub, "ACTIVA",rs.getString("c.nombre")+" "+rs.getString("c.apellido"), rs.getDouble("v.subtotal"), 0,0,rs.getInt("d.descuento"), rs.getDouble("v.iva"), rs.getDouble("v.total"),rs.getDouble("v.total"), "ACTIVA", id);   
                        }
                        System.out.println(rs.getString("v.codventa"));
                         System.out.println(rs.getString("d.descuento")+" esta es mi det");
                        System.out.println(rs.getString("c.nombre")+" "+rs.getString("c.apellido"));
                        
                       
                    }
             }else{
                         JOptionPane.showMessageDialog(null, "LA FACTURA SE ENCUENTRA FACTURADA", "NO SE PUEDE REALIZAR", JOptionPane.ERROR_MESSAGE); 
                     } 
                   
                     //actualizar("estado",seleccion_ub,id);
                   //  System.out.println(id+" hola mundo");
                   //   System.out.println(seleccion_ub+" hola mundo");
                   cargartabla();
                }
                
                 } catch (SQLException ex) {
                        Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE,
                        null, ex); 
                }
                
            }
        });
    }
    
public static void setUpSportColumn3(JTable table,
            TableColumn sportColumn) {
        final JComboBox comboBox = new JComboBox();
        comboBox.setForeground(Color.red);
        comboBox.setOpaque(true);
        comboBox.addItem("ACTIVA");
        comboBox.addItem("ANULADA");
        comboBox.setSelectedItem(null);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Hacer clic para seleccionar (ACTIVA / ANULADA)");
        sportColumn.setCellRenderer(renderer);
        comboBox.setSelectedItem(null);
        comboBox.addActionListener(new ActionListener() {  //boton MODIFICAR

            @Override
            public void actionPerformed(ActionEvent e) {
                //comboBox.setSelectedItem(null);
                int row = tabla.getEditingRow();
                if (row != -1) {

                  int id = Integer.valueOf(tabla.getValueAt(row, 0).toString());
                   String estado = tabla.getModel().getValueAt(row, 16).toString(); // placa
                        
                     String seleccion_ub = (String) comboBox.getSelectedItem();
                     actualizar("estado",seleccion_ub,id);
                     System.out.println(id+" hola mundo");
                      System.out.println(seleccion_ub+" hola mundo");
                            cargartabla();
                        }
            
            }
        });
    } 


 public static void actualizar1(String codigo,String estado,String clientes,double subtotal12,double subtotal0,int credito , int descuento ,double iva , double total,double saldo,String atraso ,int id) {
        String sql = "";
        String sql3 = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();

        if (cn != null) {
            try {

                
                    sql = "update "+fron+" set cod_venta =? , estado =? ,clientes =?,subtotal12=?,subtotal0=?,credito=?,descuento=?,iva=?,total=?,saldo=?,atraso=?  where id = ?";
                    PreparedStatement psd = cn.prepareStatement(sql);
                    psd.setObject(1, codigo);
                     psd.setObject(2, estado);
                      psd.setObject(3, clientes);
                      psd.setObject(4, subtotal12);
                     psd.setObject(5, subtotal0);
                      psd.setObject(6, credito);
                      psd.setObject(7, descuento);
                      psd.setObject(8, iva);
                      psd.setObject(9, total);
                     psd.setObject(10, saldo);
                      psd.setObject(11, atraso);
                    psd.setObject(12, id);
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



    
    
     public static void actualizar(String sele ,String estado,int id) {
        String sql = "";
        String sql3 = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();

        if (cn != null) {
            try {

                
                    sql = "update "+fron+" set "+sele+"=? where id = ?";
                    PreparedStatement psd = cn.prepareStatement(sql);
                    psd.setObject(1, estado);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"asd", "asd", null, "asd"},
                {"asd", null, null, "sad"},
                {"asd", null, null, "sadsa"},
                {"asd", null, null, "29/11/2015"}
            },
            new String [] {
                "id", "numeracion", "codigo fecha", "fecha"
            }
        ));
        tabla.setRowHeight(24);
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("FACTURACION");

        jButton1.setText("ACTUALIZAR");

        jButton2.setText("SALIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(jButton1)
                                .addGap(248, 248, 248)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
