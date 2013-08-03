/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.managers.ReportManager;
import com.jycykj.model.FinishedComponent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class FinishComponentTableModel extends AbstractTableModel{
    
    private  ReportManager reportManager=null;
    private Class [] types = {String.class , Integer.class, Integer.class,Float.class};
    private String [] headers = {"零件名称","完工数量","冲次总数","平均冲次数"};
    private List<FinishedComponent> datas = null;
    private  JTable table;
    
    
    public FinishComponentTableModel(JTable reportTable, int year, int month) {
        reportManager = ReportManager.newInstance();
        datas = reportManager.getComponentWorkLoad(year,month);
        this.table=table;
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
       FinishedComponent finishedComponent = datas.get(rowIndex);
       if(columnIndex==0) {
           return finishedComponent.getComponentName();
       } else if(columnIndex==1) {
           return finishedComponent.getFinishedNum();
       } else if(columnIndex==2) {
           return finishedComponent.getWorkLoad();
       } else if(columnIndex==3) {
           return finishedComponent.getAvgWorkLoad();
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
     
    public String[] getHeaders() {
        return headers;
    }
    
    public List<FinishedComponent> getDatas() {
        return datas;
    }
}
