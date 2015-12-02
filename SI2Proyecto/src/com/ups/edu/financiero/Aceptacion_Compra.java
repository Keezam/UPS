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
import com.ups.edu.conexion.ConexionBD;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        llenar_orden_de_compra(jTable1, title);
    }
    
 public static String obtener_proveedor(int codigo) {
        String idperfil = "";
        ConexionBD con;
        con = new ConexionBD();
        Connection cn = con.GetConnection();
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
        ConexionBD con;
        con = new ConexionBD();
        Connection cn = con.GetConnection();
        if (cn != null) {
            try {
                String[] registros = new String[9];
              
                    String[] titulos = {"ido", "PROVEEDORES", "FECHA ORDEN", "IMPUESTO", "SUB_TOTAL", "TOTAL","ESTADO","ACEPTAR"};
                    model = new DefaultTableModel(null, titulos) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            if (column == 5) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    };
                
String sql = "SELECT id_orden_compra , id_provedor ,fecha_orden, impuestos , sub_total,total,estado from cmprv_orden_compra  ";
                /*String sql = "SELECT id_orden_compra , id_provedor ,fecha_orden, impuestos , sub_total,total,estado from cmprv_orden_compra  WHERE estado ='" + estado
                        + "'";*/
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
              while (rs.next()) {
                 
                        registros[0] = ""+rs.getInt("id_orden_compra");
                        registros[1] = obtener_proveedor(rs.getInt("id_provedor"));
                        registros[2] = rs.getString("fecha_orden");
                        registros[3] = ""+rs.getDouble("impuestos");
                        registros[4] = ""+rs.getDouble("sub_total");
                        registros[5] = ""+rs.getDouble("total");
                        registros[6] = rs.getString("estado");
                 
                    model.addRow(registros);
               }
                tabla.setModel(model);
                st.close();
                cn.close();
                st = null;
                rs = null;
                cn = null;
                tabla.getColumn("ido").setMaxWidth(90);
                tabla.getColumn("ido").setMinWidth(90);
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
                tabla.getColumn("ESTADO").setMaxWidth(150);
                tabla.getColumn("ESTADO").setMinWidth(150);
                tabla.getColumn("ACEPTAR").setMaxWidth(80);
                tabla.getColumn("ACEPTAR").setMinWidth(80);
                
                
                 tabla.getColumnModel().getColumn(1).setHeaderRenderer(new MyRenderer(new java.awt.Color(255, 204, 0), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(2).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                tabla.getColumnModel().getColumn(3).setHeaderRenderer(new MyRenderer(new java.awt.Color(51, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Font("Tahoma", Font.BOLD, 12)));
                
                TableColumn column = tabla.getColumnModel().getColumn(7);
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
                        Object guia = table.getModel().getValueAt(row, 0);// aquii obtengo el numero de columna
                        Object tipo = table.getModel().getValueAt(row, 4);
                        String numero = guia.toString();
                        String tipoM = tipo.toString();
                      /*  if (tipoM.equals("MENSAJERO")) {
                            Frame f = JOptionPane.getFrameForComponent(table);// llamar ventana de informacion
                            detalle_mensajero dialog = new detalle_mensajero(f, true, numero);
                            dialog.setVisible(true);
                            dialog = null;
                        } else {
                            Frame f = JOptionPane.getFrameForComponent(table);// llamar ventana de informacion
                            detalle_courier dialog = new detalle_courier(f, true, numero);
                            dialog.setVisible(true);
                            dialog = null;
                        }*/

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        jButton1.setText("ACEPTAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
