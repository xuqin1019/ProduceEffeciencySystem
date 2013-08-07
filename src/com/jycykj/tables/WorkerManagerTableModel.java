/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.gui.WorkerManagerPanel;
import com.jycykj.managers.WorkerManager;
import com.jycykj.model.Group;
import com.jycykj.model.Worker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author lenovo
 */
public class WorkerManagerTableModel extends AbstractTableModel {
    WorkerManagerPanel workerManagerPanel;
    private JTable table;
    
    private Map<String,Worker> modifiedWorkers = new HashMap<String,Worker>();
    
    private String [] headers = new String [] {"姓名","班组归属","备注"};
    
    private boolean [] canEdit = {true,true,true};
    private boolean isAdd = false;      //如果正在添加，则禁止其他数据同时修改
    
    private Class [] types = {String.class,String.class,String.class};
    
    private WorkerManager workerManager = null;
    
    private List<Worker> workerList = null;
    
    private JComboBox jComboBox = new JComboBox();
    private  Map<String,Integer> groups = null;
    
    public WorkerManagerTableModel(WorkerManagerPanel workerManagerPanel,JTable table) {
        this.workerManagerPanel = workerManagerPanel;
        this.table = table;
        workerManager = WorkerManager.getInstance();
        System.out.println("initialized");
        groups = workerManager.getGroups();
        workerList = workerManager.getWorkers();
        Set<String> group_names = groups.keySet();
        for(String g : group_names) {
            jComboBox.addItem(g);
        }
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
        return workerList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Worker worker = workerList.get(rowIndex);
        if(columnIndex==0) {
            return worker.getWorkerName()==null ? "" : worker.getWorkerName();
        } else if(columnIndex==1) {
            table.getColumnModel().getColumn(columnIndex).setCellEditor(new DefaultCellEditor(jComboBox));
            return worker.getGroup()==null ? "" : worker.getGroup().getGroupName();
        } else {
            return worker.getInfo()==null ? "" : worker.getInfo();
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
            Worker worker = workerList.get(rowIndex);
            if(columnIndex==0) {
                worker.setWorkerName((String)value);
            } else if(columnIndex==1) {
                Group g = worker.getGroup();
                g.setGroupName((String)value);
                g.setGroupId(groups.get(g.getGroupName()));
                worker.setGroup(g);
            } else if(columnIndex==2) {
                if(value==null || ((String)value).trim().length()==0) {
                    worker.setInfo("");
                } else {
                    worker.setInfo((String)value);
                }
            }
            workerList.set(rowIndex, worker);
            fireTableCellUpdated(rowIndex, columnIndex);
            
            if(!modifiedWorkers.containsKey(worker.getWorkerId())) {
                modifiedWorkers.put(worker.getWorkerId(), worker);
            } else {
                modifiedWorkers.remove(worker.getWorkerId());
                modifiedWorkers.put(worker.getWorkerId(), worker);
            }
            workerManagerPanel.getSaveButton().setEnabled(true);
        }
        
      //  print(workerList);
        print(modifiedWorkers);
    }

    private void print(List<Worker> workerList) {
        for(Worker worker : workerList) {
            System.out.println(worker);
        }
    }

    private void print(Map<String, Worker> modifiedWorkers) {
       Set<String> keys = modifiedWorkers.keySet();
       for(String key : keys) {
           System.out.print(key + ": ");
           System.out.println(modifiedWorkers.get(key));
       } 
    }

    public void setModifiedWorkers(Map<String, Worker> modifiedWorkers) {
        this.modifiedWorkers = modifiedWorkers;
    }
    
    public Map<String, Worker> getModifiedWorkers() {
        return modifiedWorkers;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }
 
}
