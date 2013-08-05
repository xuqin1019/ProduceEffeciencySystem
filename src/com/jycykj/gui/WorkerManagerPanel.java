/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.jycykj.dao.ComponentDao;
import com.jycykj.helper.ImageIconUtil;
import com.jycykj.helper.Util;
import com.jycykj.model.Group;
import com.jycykj.model.Worker;
import com.jycykj.tables.WorkerManagerTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JOptionPane; 

/**
 *
 * @author lenovo
 */
public class WorkerManagerPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserManagerPanel
     */
    private boolean isAdd = false;
    private int deleteRowIndex=-1;
    
    public WorkerManagerPanel() {
        initComponents();
        addButton.setEnabled(true);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        workerManagerTable = new javax.swing.JTable();

        addButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        addButton.setText("添加");
        addButton.setIcon(ImageIconUtil.getIcon("pics/add.png"));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        deleteButton.setText("删除");
        deleteButton.setIcon(ImageIconUtil.getIcon("pics/delete.png"));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        saveButton.setText("保存");
        saveButton.setIcon(ImageIconUtil.getIcon("pics/save.png"));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addGap(50, 50, 50)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        workerManagerTable.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        workerManagerTable.setModel(new WorkerManagerTableModel(this,workerManagerTable));
        workerManagerTable.setRowHeight(20);
        workerManagerTable.addMouseListener(new MyMouseAdapter());
        jScrollPane3.setViewportView(workerManagerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        Map<String,Worker> workers = ((WorkerManagerTableModel)workerManagerTable.getModel()).getModifiedWorkers();
        Set<String> workerIds = workers.keySet();
        StringBuilder sb = new StringBuilder();
        Worker worker = null;
        for(String workerId : workerIds) {
            if(sb.length()!=0) {
                sb.append(";");
            }
            worker = workers.get(workerId);
            if(!workerId.equals("")) {
                if(worker==null || !worker.valid()) {
                    Util.showMessageDialogWithTitle(this,"警告", "数据不完整！！！请补全数据再保存");
                    return;
                }
                sb.append("update worker set name = '" +worker.getWorkerName()+ "',info='"+(worker.getInfo()==null ? "" : worker.getInfo())+"',group_id="+worker.getGroup().getGroupId()+ " where worker_id="+ Integer.parseInt(workerId));
            } else {
                if(worker==null || !worker.valid()) {
                    Util.showMessageDialogWithTitle(this,"警告", "数据不完整！！！请补全数据再保存");
                    return;
                }
                sb.append("insert into worker(name,info,group_id) values('" +  worker.getWorkerName() +"','"+(worker.getInfo()==null ? "" : worker.getInfo())+ "'," + worker.getGroup().getGroupId() + ")");
            }
        }
       // System.out.println(sb.toString());
        boolean success =  ComponentDao.getInstance().executeUpdate(sb.toString().split(";"));
        if(success) {           //保存成功
            
            //-------------------------------------修改员工信息日志----------------------------
            LoginWindow.logger.info("修改员工信息成功！ : ");
            //-------------------------------------修改员工信息日志----------------------------
            
            Util.showMessageDialog(this,"保存成功！！！");
            ((WorkerManagerTableModel)workerManagerTable.getModel()).getModifiedWorkers().clear();
             saveButton.setEnabled(false);
             addButton.setEnabled(true);
             isAdd=false;
             
            List<Worker> work_list = ((WorkerManagerTableModel)workerManagerTable.getModel()).getWorkerList();
            //assign id to the saved worker
            work_list.get(work_list.size()-1).setWorkerId(String.valueOf(ComponentDao.getInstance().getWorkerId(work_list.get(work_list.size()-1).getWorkerName())));
           
        } else {               //保存失败
            
            //-------------------------------------修改员工信息日志----------------------------
            LoginWindow.logger.error("修改员工信息失败！ : " + ComponentDao.getInstance().getErrorMessage());
            //-------------------------------------修改员工信息日志----------------------------
            
           Util.showMessageDialogWithTitle(this,"警告", "发生未知错误，无法保存！！请联系系统管理员");
        }
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
         isAdd = true;
         
         Worker newWorker = new Worker();  // the new line added
         newWorker.setWorkerId(ComponentDao.getInstance().getNextWorkerId());
         newWorker.setGroup(new Group());
         WorkerManagerTableModel workerManagerTableModel = (WorkerManagerTableModel)(workerManagerTable.getModel());
        
         workerManagerTableModel.getModifiedWorkers().put(newWorker.getWorkerId(),newWorker);     //add one line to the table
         workerManagerTableModel.getWorkerList().add(newWorker);
         
         workerManagerTableModel.fireTableRowsInserted(workerManagerTableModel.getRowCount()-1, workerManagerTableModel.getRowCount()-1);   //refresh
         workerManagerTableModel.setIsAdd(isAdd);
         
          //跳转到最后一行并且选中
         workerManagerTable.scrollRectToVisible(workerManagerTable.getCellRect(workerManagerTable.getRowCount()-1, 0, true));
         int lastRow = workerManagerTable.convertRowIndexToView(workerManagerTable.getRowCount()-1);
         workerManagerTable.changeSelection(lastRow, 0, false, false);
         
         deleteRowIndex = lastRow;
         
         addButton.setEnabled(false);
         deleteButton.setEnabled(true);
         saveButton.setEnabled(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        WorkerManagerTableModel workerManagerTableModel = (WorkerManagerTableModel)(workerManagerTable.getModel());
        String worker_id = workerManagerTableModel.getWorkerList().get(deleteRowIndex).getWorkerId();
        
        if(worker_id.equals("")) {
            workerManagerTableModel.getWorkerList().remove(deleteRowIndex);
            workerManagerTableModel.fireTableRowsDeleted(deleteRowIndex, deleteRowIndex);
            addButton.setEnabled(true);
            deleteButton.setEnabled(false);
            saveButton.setEnabled(false);
            return;
        }
        
        int choice = JOptionPane.showConfirmDialog(this,"你确定要删除此条记录吗","警告",JOptionPane.WARNING_MESSAGE);
        System.out.println("worker_id : " + worker_id);
        if(choice==JOptionPane.YES_OPTION) {
            System.out.println(deleteRowIndex);
            
            String [] cleanTables = new String [] {"produce_work","worker"};
            List<String> sqls = new ArrayList<String>(); 
            for(String table : cleanTables) {
                sqls.add("delete from " + table + " where worker_id = " + Integer.valueOf(worker_id));
            }
            
            boolean success =  ComponentDao.getInstance().executeTransaction(sqls);   //执行事务
            
            if(success) {
                workerManagerTableModel.getWorkerList().remove(deleteRowIndex);
                workerManagerTableModel.fireTableRowsDeleted(deleteRowIndex, deleteRowIndex);
                addButton.setEnabled(true);
                deleteButton.setEnabled(false);
                
                //-------------------------------------删除员工信息日志----------------------------
                LoginWindow.logger.info("删除员工信息成功！ : ");
                //-------------------------------------删除员工信息日志----------------------------
                
                Util.showMessageDialog(this,"删除成功！！！");
            } else {
                
                //-------------------------------------删除员工信息日志----------------------------
                LoginWindow.logger.error("删除员工信息失败！ : " + ComponentDao.getInstance().getErrorMessage());
                //-------------------------------------删除员工信息日志----------------------------
               
                Util.showMessageDialog(this,"发生未知错误，无法删除！！请联系系统管理员");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
      private class MyMouseAdapter extends MouseAdapter {      //listen for the componentProcedureTable click event 
        public void mousePressed(MouseEvent e) {  
            if (workerManagerTable.equals(e.getSource())) {  
                deleteRowIndex = workerManagerTable.rowAtPoint(e.getPoint());  
                deleteButton.setEnabled(true);
            }  
        }  
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable workerManagerTable;
    // End of variables declaration//GEN-END:variables
}
