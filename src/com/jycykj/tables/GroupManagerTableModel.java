/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.gui.GroupManagerPanel;
import com.jycykj.managers.GroupManager;
import com.jycykj.model.Group;
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
public class GroupManagerTableModel extends AbstractTableModel {
    GroupManagerPanel groupManagerPanel=null;
    private JTable table;
    
    private Map<String,Group> modifiedGroups = new HashMap<String,Group>();   //修改的groups
    
    private String [] headers = new String [] {"班组","备注"};
    
    private boolean [] canEdit = {true,true};
    private boolean isAdd = false;      //如果正在添加，则禁止其他数据同时修改
    
    private Class [] types = {String.class,String.class};
    private GroupManager groupManager = null;
    private List<Group> groupList = null;
    
    public GroupManagerTableModel(GroupManagerPanel groupManagerPanel,JTable table) {
        this.groupManagerPanel = groupManagerPanel;
        this.table = table;
        groupManager = GroupManager.getInstance();
        System.out.println("initialized");
        groupList = groupManager.getGroups();
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
        return groupList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Group group = groupList.get(rowIndex);
        if(columnIndex==0) {
            return group.getGroupName();
        } else {
           return (group.getInfo()==null ? "" : group.getInfo());
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
            Group group = groupList.get(rowIndex);
            if(columnIndex==0) {
                group.setGroupName((String)value);
            } else {
               group.setInfo((String)value);
            } 
            
            groupList.set(rowIndex, group);
            fireTableCellUpdated(rowIndex, columnIndex);
            
            if(!modifiedGroups.containsKey(group.getGroupId())) {
                modifiedGroups.put(String.valueOf(group.getGroupId()), group);
            } else {
                modifiedGroups.remove(group.getGroupId());
                modifiedGroups.put(String.valueOf(group.getGroupId()), group);
            }
            groupManagerPanel.getSaveButton().setEnabled(true);
        }
        
      //  print(workerList);
        print(modifiedGroups);
    }

    private void print(List<Group> groupList) {
        for(Group group : groupList) {
            System.out.println(group);
        }
    }

    private void print(Map<String, Group> modifiedGroups) {
       Set<String> keys = modifiedGroups.keySet();
       for(String key : keys) {
           System.out.print(key + ": ");
           System.out.println(modifiedGroups.get(key));
       } 
    }

    public Map<String, Group> getModifiedGroups() {
        return modifiedGroups;
    }

    public void setModifiedGroups(Map<String, Group> modifiedGroups) {
        this.modifiedGroups = modifiedGroups;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
    
    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }
    
}
