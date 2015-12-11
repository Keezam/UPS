/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.financiero;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static javaapplication2.Facturacion.llenar_tabla;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Steve Ruiz
 */
public class Aceptacion_Compra extends javax.swing.JInternalFrame {

    /**
     * Creates new form Aceptacion_Compra
     */
    public Aceptacion_Compra() {
        initComponents();
                
        llenar_orden_de_compra(jTable1, "E");
         jScrollPane1.getViewport().setBackground(Color.white);
    }
    
    
     public static void cargartabla() {
        limpiarTabla(jTable1);
         llenar_orden_de_compra( jTable1, "E");
        jTable1.clearSelection();

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
    
 public static String obtener_proveedor(int codigo) {
        String idperfil = "";
        /*ConexionBD con;
        con = new ConexionBD();
        Connection cn = con.GetConnection();*/
        javaapplication2.conexionBD con;
        con = new javaapplication2.conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
                String sqla = "SELECT nombre FROM cmprv_provedores WHERE id_provedor ='" + codigo + "' ";
                Statement st2 = cn.createStatement();
                ResultSet rs2 = st2.executeQuery(sqla);
                if (rs2.next() == true) {
                    idperfil = rs2.getString("nombre");
                }
                st2.close();
                cn.close();
                st2 = null;
                rs2 = null;
                cn = null;

            } catch (SQLException ex) {
                Logger.getLogger(Aceptacion_Compra.class.getName()).log(Level.SEVERE,
                        null, ex);
            }

        }

        return idperfil;
    }

    public static void llenar_orden_de_compra(JTable tabla, String estado) {
        DefaultTableModel model = null;
      /*  ConexionBD con;
        con = new ConexionBD();
        Connection cn = con.GetConnection();*/
      javaapplication2.conexionBD con;
        con = new javaapplication2.conexionBD();
        Connection cn = con.conexion();
        if (cn != null) {
            try {
                String[] registros = new String[9];
              
                    String[] titulos = {"ido","ORDEN DE COMPRA", "PROVEEDORES", "FECHA ORDEN", "IMPUESTO", "SUB_TOTAL", "TOTAL","ESTADO","ACEPTAR"};
                    model = new DefaultTableModel(null, titulos) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            if (column == 8) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };
                
String sql = "SELECT id_orden_compra,codigo_orden_compra, id_provedor ,fecha_orden, impuestos , sub_total,total,estado from cmprv_orden_compra where estado = '"+estado+"' ";
                /*String sql = "SELECT id_orden_compra , id_provedor ,fecha_orden, impuestos , sub_total,total,estado from cmprv_orden_compra  WHERE estado ='" + estado
                        + "'";*/
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
              while (rs.next()) {
                 
                        registros[0] = ""+rs.getInt("id_orden_compra");
                        registros[1] = rs.getString("codigo_orden_compra");
                        registros[2] = obtener_proveedor(rs.getInt("id_provedor"));
                        registros[3] = rs.getString("fecha_orden");
                        registros[4] = ""+rs.getDouble("impuestos");
                        registros[5] = ""+rs.getDouble("sub_total");
                        registros[6] = ""+rs.getDouble("total");
                        registros[7] = rs.getString("estado");
                 
                    model.addRow(registros);
               }
                tabla.setModel(model);
                st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
                
                
                
                tabla.getColumnModel().getColumn(0).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255), new java.awt.Color(255, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(1).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,0,0), new java.awt.Color(255,255,255), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(2).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255), new java.awt.Color(255, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(3).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,0,0), new java.awt.Color(255,255,255), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(4).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255), new java.awt.Color(255, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(5).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,0,0), new java.awt.Color(255,255,255), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(6).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255), new java.awt.Color(255, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(7).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,0,0), new java.awt.Color(255,255,255), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(8).setHeaderRenderer(new MyRenderer(new java.awt.Color(255,255,255), new java.awt.Color(255, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                
                tabla.getColumn("ido").setMaxWidth(0);
                tabla.getColumn("ido").setMinWidth(0);
                tabla.getColumn("ido").setPreferredWidth(0);
                 tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                tabla.getColumn("PROVEEDORES").setMaxWidth(170);
                tabla.getColumn("PROVEEDORES").setMinWidth(170);
                tabla.getColumn("FECHA ORDEN").setMaxWidth(120);
                tabla.getColumn("FECHA ORDEN").setMinWidth(120);
                tabla.getColumn("IMPUESTO").setMaxWidth(100);
                tabla.getColumn("IMPUESTO").setMinWidth(100);
                tabla.getColumn("SUB_TOTAL").setMaxWidth(100);
                tabla.getColumn("SUB_TOTAL").setMinWidth(100);
                tabla.getColumn("TOTAL").setMaxWidth(100);
                tabla.getColumn("TOTAL").setMinWidth(100);
                tabla.getColumn("ESTADO").setMaxWidth(60);
                tabla.getColumn("ESTADO").setMinWidth(60);
                tabla.getColumn("ACEPTAR").setMaxWidth(80);
                tabla.getColumn("ACEPTAR").setMinWidth(80);
                tabla.getColumn("ORDEN DE COMPRA").setMaxWidth(140);
                tabla.getColumn("ORDEN DE COMPRA").setMinWidth(140);
                
                tabla.setShowVerticalLines(true);
                tabla.setShowHorizontalLines(true);
                tabla.getTableHeader().setReorderingAllowed(false);
               
                
                
                
                TableColumn column = tabla.getColumnModel().getColumn(8);
                column.setCellRenderer(new ButtonsRenderer());
                column.setCellEditor(new ButtonsEditor(tabla));
                 } catch (SQLException ex) {
                Logger.getLogger(Aceptacion_Compra.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }
    
    static class ButtonsPanel extends JPanel {

        public final java.util.List<JButton> buttons = java.util.Arrays.asList(new JButton(""));

        public ButtonsPanel() {
            super();
            setOpaque(true);

            for (JButton b : buttons) {
                b.setFocusable(false);
                b.setRolloverEnabled(false);
                add(b);
                b.setBackground(Color.white);
                //b.setBounds(0, 0, 16, 16);
//                ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/info1.jpg"));
            //    buttons.get(0).setIcon(fot);

            }
        }
    }
    
    public static void actualizar(String estado,int id) {
        String sql = "";
        String sql3 = "";
        conexionBD con;
        con = new conexionBD();
        Connection cn = con.conexion();

        if (cn != null) {
            try {

                sql = "update cmprv_orden_compra set estado =? where id_orden_compra = ?";
                    PreparedStatement psd = cn.prepareStatement(sql);
                    psd.setObject(1, estado);
                    psd.setObject(2, id);
                    psd.executeUpdate();
                    psd.close();
                    cn.close();
                    psd = null;
                    cn = null;
                

            } catch (SQLException ex) {
                Logger.getLogger(Aceptacion_Compra.class
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
    
     private int ingresar_acepta(double monto,int codigo,String descripcion ) {

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
                Logger.getLogger(PRESUPUESTO.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        return n;
    }

    static class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {

        public ButtonsRenderer() {
            super();
            setName("Table.cellRenderer");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            this.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());

            return this;
        }
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    static class ButtonsEditor extends ButtonsPanel implements TableCellEditor {

        public ButtonsEditor(final JTable table) {
            super();
            //---->
            //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
            MouseListener ml = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ButtonModel m = ((JButton) e.getSource()).getModel();
                    if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                        setBackground(table.getBackground());
                        // setBackground(Color.black);
                        // setBackground(Color.BLACK);
                    }
                }
            };
            buttons.get(0).addMouseListener(ml);
            //<----

            buttons.get(0).addActionListener(new ActionListener() {  //boton ver
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    if (row >= 0) {
                        int numeracion = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
                      int n = JOptionPane.showConfirmDialog(
            null,
            "DESEA APROBAR ESTA ORDEN DE COMPRA?",
            "APROBAR",
            JOptionPane.YES_NO_OPTION);
          
        if(n == 0){
            JOptionPane.showMessageDialog(null, "APROBADO");
            
                      actualizar("A", numeracion);
                      cargartabla();
        }
        else {
            JOptionPane.showMessageDialog(null, "NEGADO");
            cargartabla();
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
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
       {
            // this.setBackground(table.getSelectionBackground());
            Color color = new Color(180, 240, 255);
            setBackground(color);

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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("ACEPTACION DE ORDEN DE COMPRA");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("ACEPTACION DE ORDEN DE COMPRA");

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(106, 106, 106)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargartabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
