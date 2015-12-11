/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sara Zambrano
 */

public class MyRenderer extends DefaultTableCellRenderer {
Color background;
Color foreground;
Font fore;

public MyRenderer (Color background,Color foreground , Font fore) {
super();
this.background = background;
this.foreground = foreground;
this.fore = fore ;
this.setBorder(new LineBorder(new Color(0, 0, 0)));

}
public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
table.setColumnSelectionAllowed(false); 
comp.setBackground(background);
comp.setForeground(foreground);
comp.setFont(fore);
this.setBorder(new LineBorder(new Color(0, 0, 0)));

this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    if (isSelected) {
        
    }

return comp;
}
}