/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.gui.ComponentManagerPanel;
import com.jycykj.managers.ComponentManager;
import com.jycykj.model.Component;
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
public class ComponentManagerTableModel extends AbstractTableModel{
    ComponentManagerPanel componentManagerPanel;
   
    private JTable table;
    
  //  private Map<String,Component> modifiedComponents = new HashMap<String,Component>();
    
    private String [] headers = new String [] {"零件图号","零件名称","材料","规格","制造商","工序"};
    
    private boolean [] canEdit = {true,true,true,true,true,true};
    
    private boolean isAdd = false;      //如果正在添加，则禁止其他数据同时修改
    
    private Class [] types = {String.class,String.class,String.class,String.class,String.class,String.class};
    
    private ComponentManager componentManager = null;
    
    private List<Component> componentList = null;
    
    public ComponentManagerTableModel(ComponentManagerPanel componentManagerPanel,JTable table) {
        this.componentManagerPanel = componentManagerPanel;
        this.table = table;
        componentManager = ComponentManager.getInstance();
        System.out.println("initialized");
        componentList = componentManager.getComponents();
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
        return componentList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        Component component = componentList.get(rowIndex);
        String proceduresString = getProceduresString(rowIndex);   //获取工序的拼接字符串
        if(columnIndex==0) {       //图号
            return component.getComponentId()==null ? "" : component.getComponentId();
        } else if(columnIndex==1) {   //零件名称
            return component.getName()==null ? "" : component.getName();
        } else if(columnIndex==2){    //材料
            return component.getMaterial()==null ? "" : component.getMaterial();
        } else if(columnIndex==3) {   //规格
            return component.getSize()==null ? "" : component.getSize();
        } else if(columnIndex==4) {   //制造商
            return component.getManufacturer()==null ? "" : component.getManufacturer();
        } else {   //工序
            return (proceduresString==null || proceduresString.equals("")) ? "" : proceduresString;
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
            Component component = componentList.get(rowIndex);
            if(columnIndex==0) {   //零件图号
                component.setComponentId((String)value);
            } else if(columnIndex==1) {  //零件名称
                component.setName((String)value);
            } else if(columnIndex==2) {   //材料
                if(value==null || ((String)value).trim().length()==0) {
                    component.setMaterial("");
                } else {
                    component.setMaterial((String)value);
                }
            } else if(columnIndex==3) {    //规格
                if(value==null || ((String)value).trim().length()==0) {
                    component.setSize("");
                } else {
                    component.setSize((String)value);
                }
            } else if(columnIndex==4) {   //制造商
                if(value==null || ((String)value).trim().length()==0) {
                    component.setManufacturer("");
                } else {
                    component.setManufacturer((String)value);
                }
            } else if(columnIndex==5) {    //工序 TODO
                
            }
            
            componentList.set(rowIndex, component);
            fireTableCellUpdated(rowIndex, columnIndex);
            
       //     modifiedComponents.put(component.getComponentId(), component);
            componentManagerPanel.getSaveButton().setEnabled(true);
        }
        
    //    print(modifiedComponents);
    }

    private void print(List<Component> componentList) {
        for(Component component : componentList) {
            System.out.println(component);
        }
    }
    
    private String getProceduresString(int index) {
        List<String> procedures = componentList.get(index).getProcedures();
        StringBuilder result = new StringBuilder();
        for(String procedure : procedures) {
            if(result.length()>0) {
                result.append(",");
            }
            result.append(procedure);
        }
        return result.toString();
    }

    private void print(Map<String, Component> modifiedComponents) {
       Set<String> keys = modifiedComponents.keySet();
       for(String key : keys) {
           System.out.print(key + ": ");
           System.out.println(modifiedComponents.get(key));
       } 
    }

//    public Map<String, Component> getModifiedComponents() {
//        return modifiedComponents;
//    }
//
//    public void setModifiedComponents(Map<String, Component> modifiedComponents) {
//        this.modifiedComponents = modifiedComponents;
//    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

   

    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }

    
}

