/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.edu.ventas.views;

import com.ups.edu.ventas.model.DetalleVentas;
import com.ups.edu.ventas.model.FacturaModel;
import com.ups.edu.ventas.model.FormaPago;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Admin
 */
public class FrmVta_Factura extends javax.swing.JInternalFrame {

    private final FacturaModel facturaModel;
    private double promocion;
    private double oferta;
    private double precio;
    private int idPromocion;
    private int idOferta;
    private int cantidadInventario;
    private double subtotalFactura = 0;
    private double descuentoFactura = 0;
    private double ivafactura = 0;
    private double totalfactura = 0;
    private JDesktopPane escritorioFac;
    private FrmVta_FormaPagoDetalle frmFormaPago;
    private FormaPago formaPago;
    private List<DetalleVentas> listDetalleVta = new ArrayList<>();
    private final String[] nombreColumna = new String[]{"Codigo","Produto","Cantida","Precio","Descuento","Promocion","Oferta","Subtotal","IVA","Total",""};
    private final Class[] claseColumna = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class, java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,JButton.class};
    /**
     * Creates new form NewJInternalFrame
     */
    public FrmVta_Factura(JDesktopPane escritorio) {
        initComponents();
        facturaModel = new FacturaModel();
        secuencia();
        this.cargarComboCliente();
        this.cargarComboProducto();
        this.dibujarBotonTabla();
        this.tamanioTabla();
        this.cargarComboSucursal();
        escritorioFac = escritorio;
        formaPago = new FormaPago();
        formaPago.setFactura(Integer.parseInt(lblSecuenciaFactura.getText()));
        //frmFormaPago = new FrmVta_FormPago(formaPago);
    }
    
    public void secuencia(){
        this.lblSecuenciaFactura.setText(""+facturaModel.numeroFactura());
    }
    
    private void cargarComboCliente(){
        List<String> clientes = facturaModel.cargarComboCliente();
        this.cmbCliente.removeAllItems();
        this.cmbCliente.addItem("Selecionar Cliente");
        for (String cliente : clientes) {
             this.cmbCliente.addItem(cliente);
        }
    }
    
    private void cargarComboSucursal(){
        List<String> sucursales = facturaModel.cargarSucurcual();
        this.cmbSucursal.removeAllItems();
        this.cmbSucursal.addItem("Selecionar Sucursal");
        if(sucursales != null){
            for (String sucursal : sucursales) {
                this.cmbSucursal.addItem(sucursal);
            }
        }
    }
    
    private void cargarComboProducto(){
        List<String> productos = facturaModel.cargarComboProducto();
        this.cmbProducto.removeAllItems();
        this.cmbProducto.addItem("Selecionar Producto");
        for (String producto : productos) {
             this.cmbProducto.addItem(producto);
        }
    }
    
    private void dibujarBotonTabla(){
        this.tbArticulo.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });
    }
    
    private void tamanioTabla(){
        int anchos[] = {5,200,20,20,20,20,20,20,5};
        int i=0;
        for (int ancho : anchos) {
            
            tbArticulo.getColumnModel().getColumn(i).setPreferredWidth(ancho);
            i++;
        }
        
    }
    
    public void limpiar(){
        secuencia();
        this.cargarComboCliente();
        this.cargarComboProducto();
        this.cargarComboSucursal();
        txtCantidad.setText("");
        txtDescuento.setText("");
        txtObservacion.setText("");
        lblDescuento.setText("0.0");
        lblDireccion.setText("");
        lblIVA.setText("0.0");
        lblIdentificacion.setText("");
        lblSubTotal.setText("0.0");
        lblTelefono.setText("");
        lblTotal.setText("0.0");
        tbArticulo.removeAll();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSecuenciaFactura = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticulo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        chboxPromocion = new javax.swing.JCheckBox();
        chboxOferta = new javax.swing.JCheckBox();
        lblSubTotal = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Facturas");
        setToolTipText("");

        jLabel12.setText("Iva : ");

        btnCliente.setText("Opciones Cliente");

        jLabel13.setText("Descuento :");

        jLabel14.setText("Total : ");

        jLabel15.setText("Observacion : ");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/boton-guardar.jpg"))); // NOI18N
        jButton4.setText("Guardar ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Forma de pago : ");

        jLabel7.setText("Telefono : ");

        lblSecuenciaFactura.setText(" ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Producto");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/anadir.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText(" Producto");

        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        jLabel10.setText("Cantidad : ");

        jLabel1.setText("Factura Nº : ");

        tbArticulo.setModel(new DefaultTableModel(nombreColumna,0){
            Class[] types = claseColumna;
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });
        tbArticulo.setColumnSelectionAllowed(true);
        tbArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArticuloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbArticulo);
        tbArticulo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Datos Cliente");

        jLabel3.setText("Cliente");

        cmbCliente.setToolTipText("");
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Identificacion : ");

        lblTelefono.setText("    ");

        jLabel21.setText("Direccion : ");

        jLabel11.setText("Subtotal : ");

        lblDireccion.setText("    ");

        lblIdentificacion.setText("  ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Promociones :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Ofertas :");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Descuento :");

        jLabel24.setText("Valor :");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane3.setViewportView(txtObservacion);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/anadir.png"))); // NOI18N
        jButton6.setText("Pagos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        chboxPromocion.setText("Aplicar Promocion");
        chboxPromocion.setEnabled(false);

        chboxOferta.setText("Aplicar Oferta");
        chboxOferta.setEnabled(false);

        lblSubTotal.setText("0.0");

        lblIVA.setText("0.0");

        lblDescuento.setText("0.0");

        lblTotal.setText("0.0");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/cancelar_1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Sucursal :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSecuenciaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(268, 268, 268)
                                .addComponent(jLabel22)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(cmbProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(btnCliente)))
                                .addGap(10, 10, 10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(34, 34, 34)
                                        .addComponent(lblIVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jButton6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(chboxPromocion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chboxOferta)
                                .addGap(326, 326, 326)
                                .addComponent(jButton2)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSecuenciaFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTelefono)
                    .addComponent(jLabel4)
                    .addComponent(lblIdentificacion)
                    .addComponent(jLabel5)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(10, 10, 10)
                .addComponent(jLabel23)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(chboxPromocion)
                    .addComponent(chboxOferta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblSubTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(lblIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblDescuento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblTotal)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigoArticulo;
        String producto;
        DefaultTableModel model;
        Object []listaArticulo = new Object[11];
        
        codigoArticulo = (String) cmbProducto.getSelectedItem();
        if (codigoArticulo.equals("Selecionar Producto")){
            JOptionPane.showMessageDialog(null, "Seleccionar un Producto");
        }else{    
        codigoArticulo = codigoArticulo.substring(0,codigoArticulo.indexOf("-"));
        producto = (String) cmbProducto.getSelectedItem();
  
        if(tbArticulo.getModel()!=null){
            model = (DefaultTableModel) tbArticulo.getModel();
        }else{
            model = new DefaultTableModel(nombreColumna,0){
            Class[] types = claseColumna;
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            };
        }       
        
        int cantidad = Integer.parseInt((txtCantidad.getText().equals(""))?"0":txtCantidad.getText());
        if (cantidad != 0){
            DetalleVentas detalle = new DetalleVentas();
            double descuento =  Integer.parseInt((txtDescuento.getText().equals(""))?"0":txtDescuento.getText());
            double subtotal = (cantidad * precio);
            double total = (cantidad * precio) - (descuento+((chboxPromocion.isSelected())?promocion:0)+((chboxOferta.isSelected())?oferta:0));
            double iva = total * 0.12;
            total = total + iva;
            detalle.setId(listDetalleVta.size()+1);
            detalle.setCodoferta(((chboxOferta.isSelected())?idOferta:0));
            detalle.setCodpromocion(((chboxPromocion.isSelected())?idPromocion:0));
            detalle.setCodproducto(Integer.parseInt(codigoArticulo));
            detalle.setDescripcion(producto);
            detalle.setDescuento((descuento+((chboxPromocion.isSelected())?promocion:0)+((chboxOferta.isSelected())?oferta:0)));
            detalle.setIva(iva);
            detalle.setSubtotal(subtotal);
            detalle.setTotal(total);
            detalle.setCantidad(cantidad);
            
            subtotalFactura = subtotalFactura + subtotal;
            descuentoFactura = descuentoFactura+(descuento+((chboxPromocion.isSelected())?promocion:0)+((chboxOferta.isSelected())?oferta:0));
            double totalfact = subtotalFactura -descuentoFactura;
            ivafactura = ivafactura+(totalfact)*0.12;
            totalfact = totalfact +ivafactura;
            totalfactura = totalfactura + totalfact;
        
            lblSubTotal.setText(String.valueOf(subtotalFactura));
            lblDescuento.setText(String.valueOf(descuentoFactura));
            lblIVA.setText(String.valueOf(ivafactura));
            lblTotal.setText(String.valueOf(totalfactura));
        
            listaArticulo[0]=codigoArticulo;
            listaArticulo[1]=producto;
            listaArticulo[2]=cantidad;
            listaArticulo[3]=precio;
            listaArticulo[4]=descuento;
            listaArticulo[5]=((chboxPromocion.isSelected())?promocion:0);
            listaArticulo[6]=((chboxOferta.isSelected())?oferta:0);
            listaArticulo[7]=subtotal;
            listaArticulo[8]=iva;
            listaArticulo[9]=total;
            listaArticulo[10]=new JButton(new javax.swing.ImageIcon(getClass().getResource("/com/ups/edu/compras/resources/borrar.png")));
            listDetalleVta.add(detalle);
            model.addRow(listaArticulo);
            tbArticulo.setModel(model);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad");
        }
            
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArticuloMouseClicked
        int fila = tbArticulo.rowAtPoint(evt.getPoint());
        int columna = tbArticulo.columnAtPoint(evt.getPoint());
        if (tbArticulo.getModel().getColumnClass(columna).equals(JButton.class)) {
            int cantidad = (int) tbArticulo.getModel().getValueAt(fila, 2);
            double precio  = (double) tbArticulo.getModel().getValueAt(fila, 3);
            double descuento  = (double) tbArticulo.getModel().getValueAt(fila, 4);
            double promocion = (double) tbArticulo.getModel().getValueAt(fila, 5);
            double oferta  = (double) tbArticulo.getModel().getValueAt(fila, 6);
            double iva = ((cantidad*precio)-(descuento+promocion+oferta))*0.12;
            
            subtotalFactura -= (cantidad*precio);
            descuentoFactura -= descuento+promocion+oferta;
            double total = subtotalFactura -descuentoFactura;
            ivafactura = (total)*0.12;
            totalfactura = total + ivafactura;
            
            lblSubTotal.setText(String.valueOf(subtotalFactura));
            lblDescuento.setText(String.valueOf(descuentoFactura));
            lblIVA.setText(String.valueOf(ivafactura));
            lblTotal.setText(String.valueOf(totalfactura));
            
            JOptionPane.showMessageDialog(null, "Ha Borrado este producto de la fila "+fila);
            DefaultTableModel model = (DefaultTableModel) tbArticulo.getModel();
            model.removeRow(fila);
            listDetalleVta.remove(fila);
            tbArticulo.setModel(model);
        }
    }//GEN-LAST:event_tbArticuloMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        formaPago.setValor(Double.parseDouble(lblTotal.getText()));
        formaPago.setFactura(Integer.parseInt(lblSecuenciaFactura.getText()));
        if(frmFormaPago==null){
            frmFormaPago = new FrmVta_FormaPagoDetalle(formaPago);
        }
        if(!frmFormaPago.isShowing()){
            escritorioFac.add(frmFormaPago);
            frmFormaPago.setLocation(280, 10);
            frmFormaPago.show();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        String cdocliente = (String) cmbCliente.getSelectedItem();
        int dato=0;
        if(cdocliente==null){
            lblIdentificacion.setText("");
            lblTelefono.setText("");
            lblDireccion.setText("");
            return;
        }
        if (!cdocliente.equals("Selecionar Cliente")&&!cdocliente.equals("")){
            cdocliente = cdocliente.substring(0,cdocliente.indexOf("-"));
            dato = Integer.parseInt(cdocliente);
            String[] cliente=facturaModel.cliente(dato);
            
            if (!cliente[0].equals("")){
                lblIdentificacion.setText(cliente[1]);
                lblTelefono.setText(cliente[0]);
                lblDireccion.setText(cliente[2]);
            }
        }else{
            lblIdentificacion.setText("");
            lblTelefono.setText("");
            lblDireccion.setText("");
        }
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        String codigoArticulo = (String) cmbProducto.getSelectedItem();
        int dato=0;
        Object[] resultado;
        if(codigoArticulo==null){
            chboxPromocion.setEnabled(false);
            chboxPromocion.setSelected(false);
            chboxOferta.setEnabled(false);
            chboxOferta.setSelected(false);
            return;
        }
        if (!codigoArticulo.equals("Selecionar Producto")&&!codigoArticulo.equals("")){
            codigoArticulo = codigoArticulo.substring(0,codigoArticulo.indexOf("-"));
            dato = Integer.parseInt(codigoArticulo);
            Object promociones[] = facturaModel.existePromocion(dato);
            System.out.println(""+promocion);
            if (promociones!=null){
                promocion = (double) promociones[0];
                idPromocion = (int) promociones[1];
                chboxPromocion.setEnabled(true);
            }else{
                promocion = 0;
                idPromocion = 0;
                chboxPromocion.setEnabled(false);
                chboxPromocion.setSelected(false);
            }
            Object[] ofertas = facturaModel.existeOferta(dato);
            if (ofertas!=null){
                oferta = (double) ofertas[0];
                idOferta = (int) ofertas[1];
                chboxOferta.setEnabled(true);
                System.out.println(""+chboxOferta.isEnabled());
            }else{
                chboxOferta.setEnabled(false);
                chboxOferta.setSelected(false);
                oferta = 0;
                idOferta = 0;
            }
            resultado = facturaModel.datosProducto(dato);
            
            System.out.println(""+resultado);
            if(resultado!=null){
                precio =  (double) resultado[0];
                cantidadInventario = (int) resultado[1];
            }
        }else{
            chboxPromocion.setEnabled(false);
            chboxPromocion.setSelected(false);
            chboxOferta.setEnabled(false);
            chboxOferta.setSelected(false);
        }
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       String sucursal = cmbSucursal.getSelectedItem().toString();
       if(frmFormaPago != null){
            formaPago = frmFormaPago.getFormaPago();
       }
       int cdsucursal = 0;
       if(!sucursal.equals("Selecionar Sucursal")){
           sucursal= sucursal.substring(0, sucursal.indexOf("-"));
           cdsucursal = Integer.parseInt(sucursal);
       }else{
           JOptionPane.showMessageDialog(null, "Selecionar una sucursal", "Sucursal", JOptionPane.ERROR_MESSAGE);
           return;
       }
       DefaultTableModel model = (DefaultTableModel)  tbArticulo.getModel();
       if(model.getRowCount()==0){
           JOptionPane.showMessageDialog(null, "Ingrese un producto ", "Tabla de producto", JOptionPane.ERROR_MESSAGE);
           return;
       }
       String cdocliente = (String) cmbCliente.getSelectedItem();
       if (cdocliente.equals("Selecionar Cliente")){
           JOptionPane.showMessageDialog(null, "Selecionar un cliente", "Cliente", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if(formaPago.getTipoPago()==null){
           JOptionPane.showMessageDialog(null, "Seleccionar Forma Pago", "Forma Pago", JOptionPane.ERROR_MESSAGE);
           return;
       }
       int dato=0;
       int personal = 0; 
       
       
       cdocliente = cdocliente.substring(0,cdocliente.indexOf("-"));
       dato = Integer.parseInt(cdocliente);
       int ins1 = facturaModel.guardarFactura(Integer.parseInt(lblSecuenciaFactura.getText()), "FAC",1, dato,txtObservacion.getText(), subtotalFactura, descuentoFactura, ivafactura, totalfactura, facturaModel.buscarFormaPago(formaPago.getTipoPago()));
       facturaModel.insterDetalleVenta(listDetalleVta, Integer.parseInt(lblSecuenciaFactura.getText()),cdsucursal,1);
       facturaModel.detallepago(formaPago);
       System.out.println("aqui" + ins1);
       limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        /*DefaultTableModel model = (DefaultTableModel)  tbArticulo.getModel();
        if(model.getRowCount()>0){
            for (int i = 0; i <= model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
        formaPago = null;
        txtCantidad.setText("");
        txtDescuento.setText("");*/
        limpiar();
        frmFormaPago.dispose();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JCheckBox chboxOferta;
    private javax.swing.JCheckBox chboxPromocion;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblSecuenciaFactura;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbArticulo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
