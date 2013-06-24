/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.qt.datapicker.DatePicker;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author xuqin
 */
public class DatePikcerCellRenderer extends DatePickerPanel implements TableCellRenderer {

    public DatePikcerCellRenderer(DateTextField dateTextField, JButton jButton) {
        super(dateTextField, jButton);
        addListenerToDatePickerButton(jButton,dateTextField);    //关联datePicker按钮和dateTextField
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
    
    private void  addListenerToDatePickerButton(JButton button , final DateTextField dateTextField) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 DatePicker dp = new DatePicker(dateTextField, Locale.CHINA);
                 Date selectedDate = dp.parseDate(dateTextField.getText());
                 dp.setSelectedDate(selectedDate);
                 dp.start(dateTextField);
            }
        });
    } 
}
