/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.qt.datapicker.DatePicker;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

/**
 *
 * @author xuqin
 */

//used in the ReportPanel for association date picker button and textField if using com.qt.datapicker.DatePicker
public class DateTextField extends JTextField implements Observer{
    @Override
    public void update(Observable o, Object arg) {
       Calendar calendar = (Calendar)arg;
       DatePicker dp = (DatePicker)o;
       setText(dp.formatDate(calendar,"yyyy-MM-dd"));
    }
}
