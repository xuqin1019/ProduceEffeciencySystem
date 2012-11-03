/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.managers.ReportManager;
import com.jycykj.model.WorkLoad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class WorkLoadTableModel extends AbstractTableModel {
    protected ReportManager reportManager=null;
    protected Class [] types = {Integer.class , String.class, Integer.class};
    protected String [] headers;
    protected List<WorkLoad> datas;
    
    public WorkLoadTableModel(int year , int month) {
        reportManager = ReportManager.newInstance();
    }
    
    @Override
    public int getRowCount() {
        return datas.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       WorkLoad workLoad = datas.get(rowIndex);
       if(columnIndex==0) {
           return workLoad.getRank();
       } else if(columnIndex==1) {
           return workLoad.getName();
       } else if(columnIndex==2) {
           return workLoad.getWorkLoad();
       } else if(columnIndex==3) {
           return workLoad.getAvgWorkLoad();
       }
       return null;
    }

    @Override
    public String getColumnName(int column) {
       return headers[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
