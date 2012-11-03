/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.managers.ProduceCardManager;
import com.jycykj.model.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class ComponentInfoTableModel extends AbstractTableModel{
    private ProduceCardManager produceCardManager = null;      //used to generate data
    
    private String[] columnNames =  new String [] {              //header
               "材料" , "规格", "制造商","发料数"
            };
    
    private boolean [] canEdit = {false,false,false,true};
    
    
    Class[] types = new Class [] {      //cell type
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
    
    private Component component = null;            //component without procedures , just general info
    private List<ComponentInfoField> fColumnMapping=null;
    
    public ComponentInfoTableModel(String componentId) {
        produceCardManager = ProduceCardManager.newInstance();                //single pattern
        fColumnMapping = Arrays.asList(new ComponentInfoField [] {ComponentInfoField.Material,ComponentInfoField.Size,ComponentInfoField.Manufacturer,ComponentInfoField.Deliverer});   //
       
        component = produceCardManager.getComponent(componentId);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    
    
    
    @Override
    public int getRowCount() {
       return  component==null ?  0:1;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
   @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (rowIndex < 0 || rowIndex > getRowCount()-1) {
        throw new IllegalArgumentException("Row index is out of range: " + rowIndex);
      }
      if (columnIndex < 0 || columnIndex > getColumnCount()-1) {
        throw new IllegalArgumentException("Column index is out of range: " + columnIndex);
      }
      ComponentInfoField field = getField(columnIndex);
      return getFieldValue(component, field);
    }
    
    private ComponentInfoField getField(int columnIndex) {
        return (ComponentInfoField)fColumnMapping.get(columnIndex);
    }
     
    private Object getFieldValue(Component component , ComponentInfoField componentField) {
        Object result = null;
        
        if(componentField == ComponentInfoField.Material) {
            result = component.getMaterial();
        } else if(componentField == ComponentInfoField.Size) {
            result = component.getSize();
        } else if(componentField == ComponentInfoField.Manufacturer) {
            result = component.getManufacturer();
        } else {
            new AssertionError("Unknown field : " + componentField);
        }
        return result;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void setfColumnMapping(List<ComponentInfoField> fColumnMapping) {
        this.fColumnMapping = fColumnMapping;
    }

    public Component getComponent() {
        return component;
    }
    
    
}
