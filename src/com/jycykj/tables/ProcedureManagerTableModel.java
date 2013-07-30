/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.gui.ProcedureManagerPanel;
import com.jycykj.managers.ProcedureManager;
import com.jycykj.model.Procedure;
import com.jycykj.model.Worker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author xuqin
 */
public class ProcedureManagerTableModel extends AbstractTableModel {
    ProcedureManagerPanel procedureManagerPanel=null;
    private JTable table;
    
    private Map<String,Procedure> modifiedProcedures = new HashMap<String,Procedure>();   //修改的procedure
    
    private String [] headers = new String [] {"工序","系数"};
    
    private boolean [] canEdit = {true,true};
    private boolean isAdd = false;      //如果正在添加，则禁止其他数据同时修改
    
    private Class [] types = {String.class,String.class};
    private ProcedureManager procedureManager = null;
    private List<Procedure> procedureList = null;
    
    public ProcedureManagerTableModel(ProcedureManagerPanel procedureManagerPanel,JTable table) {
        this.procedureManagerPanel = procedureManagerPanel;
        this.table = table;
        procedureManager = ProcedureManager.getInstance();
        System.out.println("initialized");
        procedureList = procedureManager.getProcedures();
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
    public int getRowCount() {
        return procedureList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Procedure procedure = procedureList.get(rowIndex);
        if(columnIndex==0) {
            return procedure.getProcedureName();
        } else {
           return procedure.getFactor();
        } 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(isAdd) {
            if(rowIndex<this.getRowCount()-1) {
                return false;
            }
        }
        return canEdit[columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if(value!=null) {
            Procedure procedure = procedureList.get(rowIndex);
            if(columnIndex==0) {
                procedure.setProcedureName((String)value);
            } else {
               procedure.setFactor(Float.valueOf((String)value));
            } 
            
            procedureList.set(rowIndex, procedure);
            fireTableCellUpdated(rowIndex, columnIndex);
            
            if(!modifiedProcedures.containsKey(procedure.getProcedureId())) {
                modifiedProcedures.put(procedure.getProcedureId(), procedure);
            } else {
                modifiedProcedures.remove(procedure.getProcedureId());
                modifiedProcedures.put(procedure.getProcedureId(), procedure);
            }
            procedureManagerPanel.getSaveButton().setEnabled(true);
        }
        
      //  print(workerList);
        print(modifiedProcedures);
    }

    private void print(List<Procedure> procedureList) {
        for(Procedure procedure : procedureList) {
            System.out.println(procedure);
        }
    }

    private void print(Map<String, Procedure> modifiedProcedures) {
       Set<String> keys = modifiedProcedures.keySet();
       for(String key : keys) {
           System.out.print(key + ": ");
           System.out.println(modifiedProcedures.get(key));
       } 
    }

    public Map<String, Procedure> getModifiedProcedures() {
        return modifiedProcedures;
    }

    public void setModifiedProcedures(Map<String, Procedure> modifiedProcedures) {
        this.modifiedProcedures = modifiedProcedures;
    }

    public List<Procedure> getProcedureList() {
        return procedureList;
    }

    public void setProcedureList(List<Procedure> procedureList) {
        this.procedureList = procedureList;
    }
    
    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }
    
}
