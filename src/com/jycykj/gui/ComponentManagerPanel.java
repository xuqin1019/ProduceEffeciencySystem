/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.jycykj.dao.ComponentDao;
import com.jycykj.dao.ProcedureDao;
import com.jycykj.helper.ImageIconUtil;
import com.jycykj.helper.Util;
import com.jycykj.model.Component;
import com.jycykj.tables.ComponentManagerTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author xuqin
 */
public class ComponentManagerPanel extends javax.swing.JPanel {
    private boolean isAdd = false;
    private int deleteRowIndex=-1;
    private int recoreNumInDb=0;
    private Map<Integer,Component> modifiedComponents = new HashMap<Integer, Component>();    //line_no ---> component
    private Map<Integer,String> modifiedProcedureIds = new HashMap<Integer, String>();     //line_no ---->del_id1 del_id2,add_id1,add_id2
    /**
     * Creates new form ComponentManagerPanel
     */
    public ComponentManagerPanel() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        componentManagerTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(761, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(addButton))
                .addContainerGap())
        );

        componentManagerTable.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        componentManagerTable.addMouseListener(new MyMouseAdapter());
        /*
        componentManagerTable.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        componentManagerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        componentManagerTable.setRowHeight(20);
        */
        ComponentManagerTableModel componentManagerTableModel = new ComponentManagerTableModel(this,componentManagerTable);
        componentManagerTable.setModel(componentManagerTableModel);
        recoreNumInDb = componentManagerTableModel.getRowCount();   //数据库里有的记录数
        componentManagerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(0)).setPreferredWidth(130);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(1)).setPreferredWidth(130);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(2)).setPreferredWidth(130);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(3)).setPreferredWidth(130);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(4)).setPreferredWidth(130);
        componentManagerTable.getColumn(componentManagerTableModel.getColumnName(5)).setPreferredWidth(433);
        jScrollPane1.setViewportView(componentManagerTable);

        saveButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        saveButton.setText("保存");
        saveButton.setIcon(ImageIconUtil.getIcon("pics/save.png"));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        isAdd = true;

        Component newComponent = new Component();  // the new line added
        newComponent.setComponentId(ComponentDao.getInstance().getNextWorkerId());   //need to be modified
       
        newComponent.setProcedures(new ArrayList<String>());
        
        ComponentManagerTableModel componentManagerTableModel = (ComponentManagerTableModel)(componentManagerTable.getModel());

       // componentManagerTableModel.getModifiedComponents().put(newComponent.getComponentId(),newComponent);     //add one line to the table
        modifiedComponents.put(recoreNumInDb+1, newComponent);
        
        componentManagerTableModel.getComponentList().add(newComponent);

        componentManagerTableModel.fireTableRowsInserted(componentManagerTableModel.getRowCount()-1, componentManagerTableModel.getRowCount()-1);   //refresh
        componentManagerTableModel.setIsAdd(isAdd);

        //跳转到最后一行并且选中
        componentManagerTable.scrollRectToVisible(componentManagerTable.getCellRect(componentManagerTable.getRowCount()-1, 0, true));
        int lastRow = componentManagerTable.convertRowIndexToView(componentManagerTable.getRowCount()-1);
        componentManagerTable.changeSelection(lastRow, 0, false, false);
        
        addButton.setEnabled(false);
        deleteButton.setEnabled(true);
        saveButton.setEnabled(true);
        
        //set deleteRowIndex is the last row and enable the edit button
       deleteRowIndex = lastRow; 
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        ComponentManagerTableModel componentManagerTableModel = (ComponentManagerTableModel)(componentManagerTable.getModel());
        String component_id = componentManagerTableModel.getComponentList().get(deleteRowIndex).getComponentId();

        if(deleteRowIndex+1>recoreNumInDb) {     //没有保存的条数
            componentManagerTableModel.getComponentList().remove(deleteRowIndex);
            componentManagerTableModel.fireTableRowsDeleted(deleteRowIndex, deleteRowIndex);
            addButton.setEnabled(true);
            deleteButton.setEnabled(false);
            saveButton.setEnabled(false);
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this,"所有与该零件相关的信息都会被删除\n\n你确定要删除此条记录吗？","警告",JOptionPane.WARNING_MESSAGE);
        System.out.println("component_id : " + component_id);
        
        if(choice==JOptionPane.YES_OPTION) {
            System.out.println(deleteRowIndex);

            String sql = "delete from `component` where component_id = '" + component_id + "'";
            System.out.println(sql);
            
            boolean success =  ComponentDao.getInstance().executeUpdate(sql);   //执行事务

            if(success) {
                componentManagerTableModel.getComponentList().remove(deleteRowIndex);
                componentManagerTableModel.fireTableRowsDeleted(deleteRowIndex, deleteRowIndex);
                addButton.setEnabled(true);
                deleteButton.setEnabled(false);

                //-------------------------------------删除零件信息日志----------------------------
                LoginWindow.logger.info("删除零件信息成功！ : ");
                //-------------------------------------删除零件信息日志----------------------------

                Util.showMessageDialog(this,"删除成功！！！");
            } else {

                //-------------------------------------删除零件信息日志----------------------------
                LoginWindow.logger.error("删除零件信息失败！ : " + ComponentDao.getInstance().getErrorMessage());
                //-------------------------------------删除员工信息日志----------------------------

                Util.showMessageDialog(this,"发生未知错误，无法删除！！请联系系统管理员");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
       // Map<String,Component> modifiedComponents = ((ComponentManagerTableModel)componentManagerTable.getModel()).getModifiedComponents();
        //Set<String> componentIds = modifiedComponents.keySet();
        Set<Integer> lineNos = modifiedComponents.keySet();
        StringBuilder sb = new StringBuilder();
        Component component = null;
        for(int lineNo : lineNos) {
            if(sb.length()!=0) {
                sb.append(";");
            }
            component = modifiedComponents.get(lineNo);
            if(lineNo <= recoreNumInDb) {    //update the exists ones
                if(component==null || !component.valid()) {
                    Util.showMessageDialogWithTitle(this,"警告", "数据不完整！！！请补全数据再保存");
                    return;
                }
                sb.append("update component set name = '" +component.getName()+ "',material='"+(component.getMaterial()==null ? "" : component.getMaterial())+"',size='"+(component.getSize()==null ? "" : component.getSize())+ "',manufacturer='" + (component.getManufacturer()==null ? "" : component.getManufacturer()) + "' where component_id='"+ component.getComponentId()+"'");
                
                if(modifiedProcedureIds.containsKey(lineNo)) {    //修改过procedure
                    String [] parts = modifiedProcedureIds.get(lineNo).split(",");
                    String [] addProcedureIds = parts[0].split("\\|");
                    String [] delProcedureIds = (parts.length==2 ? parts[1].split("\\|") : new String[0]);
                
                    for(String id : addProcedureIds) {
                        if(!id.trim().equals("")) {
                            System.out.println("ADD_ID : " + id);
                            sb.append(";");
                            sb.append("insert into component_procedure(component_id,procedure_id)values('" + component.getComponentId() + "'," + id + ")");
                        }
                    }
                
                    for(String id : delProcedureIds) {
                        if(!id.trim().equals("")) {
                            System.out.println("DEL_ID : " + id);
                            sb.append(";");
                            sb.append("delete from component_procedure where component_id='" + component.getComponentId()+ "' and procedure_id=" + id);
                        }
                    } 
                 }
                
           } else {       // new component
                if(component==null || !component.valid()) {
                    Util.showMessageDialogWithTitle(this,"警告", "数据不完整！！！请补全数据再保存");
                    return;
                }
                sb.append("insert into component(component_id,name,material,size,manufacturer) values('" +  
                component.getComponentId() +"','"+  component.getName() + "','" + (component.getMaterial()==null ? "" : component.getMaterial())+ "','" + (component.getSize()==null ? "" : component.getSize())+ "','" + (component.getManufacturer()==null ? "" : component.getManufacturer()) + "')");
                
                if(component.getProcedures()!=null && component.getProcedures().size()>0) {    //插入零件的工序
                    for(String procedureName : component.getProcedures()) {
                        sb.append(";");
                        int procedureId = ProcedureDao.getInstance().getProcedureId(procedureName);
                        sb.append("insert into component_procedure(component_id,procedure_id) values ('" +
                                 component.getComponentId() + "'," + procedureId + ")");
                    }
               }
          }
        }
        
     //   System.out.println("SQL : " +  sb.toString());
        
        boolean success =  ComponentDao.getInstance().executeUpdate(sb.toString().split(";"));
        if(success) {           //保存成功
            //-------------------------------------修改零件信息日志----------------------------
            LoginWindow.logger.info("修改零件信息成功！ : ");
            //-------------------------------------修改零件信息日志----------------------------

            Util.showMessageDialog(this,"保存成功！！！");
            modifiedComponents.clear();
            modifiedProcedureIds.clear();
            ++recoreNumInDb;  
            
            saveButton.setEnabled(false);
            addButton.setEnabled(true);
            isAdd=false;

        } else {               //保存失败
            //-------------------------------------修改零件信息日志----------------------------
            LoginWindow.logger.error("修改零件信息失败！ : " + ComponentDao.getInstance().getErrorMessage());
            //-------------------------------------修改零件信息日志----------------------------
            Util.showMessageDialogWithTitle(this,"警告", "发生未知错误，无法保存！！请联系系统管理员");
        } 
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }//GEN-LAST:event_saveButtonActionPerformed
     
     private class MyMouseAdapter extends MouseAdapter {      //listen for the componentProcedureTable click event 
        public void mousePressed(MouseEvent e) { 
            deleteRowIndex = componentManagerTable.rowAtPoint(e.getPoint());
            System.out.println(deleteRowIndex);
            if (componentManagerTable.equals(e.getSource())) {  
                int clickTimes = e.getClickCount();
                if(clickTimes==2) {
                    modifiedComponents.put(deleteRowIndex+1,((ComponentManagerTableModel)componentManagerTable.getModel()).getComponentList().get(deleteRowIndex));
                }
                deleteButton.setEnabled(true);
             //   editProcedureButton.setEnabled(true);
                
                int deleteColumn = componentManagerTable.columnAtPoint(e.getPoint());
                if(deleteColumn==5) {    //点击的是工序一栏
                     ComponentManagerTableModel componentManagerTableModel = (ComponentManagerTableModel)(componentManagerTable.getModel());
                     //componentManagerTableModel.getModifiedComponents().put(componentManagerTableModel.getComponentList().get(deleteRowIndex).getComponentId(),componentManagerTableModel.getComponentList().get(deleteRowIndex));
                      modifiedComponents.put(deleteRowIndex+1,((ComponentManagerTableModel)componentManagerTable.getModel()).getComponentList().get(deleteRowIndex));
                     final String component_id = componentManagerTableModel.getComponentList().get(deleteRowIndex).getComponentId();
                     final ComponentManagerPanel componentManagerPanel = ComponentManagerPanel.this;
                     java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            ComponentProcedureSelectDialog componentProcedureSelectDialog = new ComponentProcedureSelectDialog(null, true,component_id,componentManagerPanel);
                            componentProcedureSelectDialog.setLocationRelativeTo(null);
                            componentProcedureSelectDialog.setResizable(false);
                            componentProcedureSelectDialog.setVisible(true);
                        }
                    });
                }
            }  
        }  
    }     

    public int getDeleteRowIndex() {
        return deleteRowIndex;
    }

    public void setDeleteRowIndex(int deleteRowIndex) {
        this.deleteRowIndex = deleteRowIndex;
    }

    public JTable getComponentManagerTable() {
        return componentManagerTable;
    }

    public void setComponentManagerTable(JTable componentManagerTable) {
        this.componentManagerTable = componentManagerTable;
    }

    public Map<Integer, String> getModifiedProcedureIds() {
        return modifiedProcedureIds;
    }

    public void setModifiedProcedureIds(Map<Integer, String> modifiedProcedureIds) {
        this.modifiedProcedureIds = modifiedProcedureIds;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable componentManagerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}


