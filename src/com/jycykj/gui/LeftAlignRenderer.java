/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author xuqin
 */
public class LeftAlignRenderer extends DefaultTableCellRenderer {    //使得table cell左对齐的renderer
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
            this.setHorizontalAlignment(SwingConstants.LEFT);
            return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column) ;
    }
}
