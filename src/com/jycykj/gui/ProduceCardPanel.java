/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.jycykj.export.ExportManagerFactory;
import com.jycykj.export.ExportManagerSupport;
import com.jycykj.helper.ConfigurePropertyEditor;
import com.jycykj.helper.ImageIconUtil;
import com.jycykj.helper.Util;
import com.jycykj.managers.ProduceCardManager;
import com.jycykj.model.Component;
import com.jycykj.model.Procedure;
import com.jycykj.model.ProducedProcedure;
import com.jycykj.model.Worker;
import com.jycykj.tables.ComponentInfoTableModel;
import com.jycykj.tables.ComponentProcedureTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lenovo
 */
public class ProduceCardPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProduceCardPanel
     */
    private static final String exportRootPath = "produceCardExportPath";       //文件选择器的根目录
    private ProduceCardManager produceCardManager = null;
    private ComponentInfoTableModel componentInfoTableModel = null;
    private ComponentProcedureTableModel componentProcedureTableModel = null;
    private TableRowSorter<TableModel> sorter = null;     //sorter，用于排序
    
    private int numOfRecords = 0;                  //记录条数
    
    //String [] componentIds = null;     //used to show in the list
    
    boolean deleteRowButtonLastStatus = false;      //用来保存tab切换的时候deleteRowButton的状态
    int deleteRowIndex = -1;
    
    private ProducedProcedure addedProducedProcedure = null;
    
    private ProduceCardDialog produceCardDialog = null;
    
    private boolean nothingAdded = true;
    
    public ProduceCardPanel(ProduceCardDialog produceCardDialog) {
        this.produceCardDialog = produceCardDialog;
        produceCardManager = ProduceCardManager.newInstance();
        initComponents();
        this.timeLabel.setText(produceCardManager.getCurrentTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        componentLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        componentNameLabel = new javax.swing.JLabel();
        componentIdTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        batchIdTextField = new javax.swing.JTextField();
        filterTextField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        componentInfoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        componentProcedureTable = new JTable();
        jPanel2 = new javax.swing.JPanel();
        countNumLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        addRowButton = new javax.swing.JButton();
        deleteRowButton = new javax.swing.JButton();

        headerPanel.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N

        headerLabel.setFont(new java.awt.Font("宋体", 3, 24)); // NOI18N
        headerLabel.setText("生产工艺流程卡");

        timeLabel.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        timeLabel.setText("2012 年 5 月 27 日");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel3.setText("零件名称：");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel4.setText("图号：");

        //设置componentIdTextField的下拉提醒
        List<String> componentIdsString = produceCardManager.getComponentIds();
        Util.setupAutoComplete(componentIdTextField, componentIdsString);
        componentIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                componentIdTextFieldFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel2.setText("批次号：");

        batchIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                batchIdTextFieldFocusLost(evt);
            }
        });

        filterButton.setText("筛选");
        filterButton.setIcon(ImageIconUtil.getIcon("pics/filter.png"));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        exportButton.setText("导出");
        exportButton.setIcon(ImageIconUtil.getIcon("pics/export.png"));
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(componentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(componentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(headerPanelLayout.createSequentialGroup()
                                        .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(filterButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exportButton))
                                    .addGroup(headerPanelLayout.createSequentialGroup()
                                        .addComponent(componentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(batchIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componentNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeLabel)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(componentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(batchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton)
                    .addComponent(exportButton))
                .addGap(354, 354, 354)
                .addComponent(componentLabel))
        );

        jTabbedPane1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        componentInfoTableModel = new ComponentInfoTableModel(componentIdTextField.getText().trim());
        componentInfoTable.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        componentInfoTable.setModel(componentInfoTableModel);
        componentNameLabel.setText(componentInfoTableModel.getComponent().getName());
        jScrollPane1.setViewportView(componentInfoTable);

        jTabbedPane1.addTab("零件原材料", jScrollPane1);

        componentProcedureTable.setRowHeight(20);
        componentProcedureTableModel = new ComponentProcedureTableModel(componentIdTextField.getText().trim(),"");
        componentProcedureTable.setDefaultRenderer(Integer.class,new LeftAlignRenderer());
        componentProcedureTable.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        componentProcedureTable.setModel(componentProcedureTableModel);
        //TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(componentProcedureTableModel);
        //componentProcedureTable.setRowSorter(sorter);
        //refreshCountNumLabel();
        componentProcedureTable.addMouseListener(new MyMouseAdapter());
        jScrollPane2.setViewportView(componentProcedureTable);

        jTabbedPane1.addTab("零件工序", jScrollPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(countNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(countNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        cancelButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        cancelButton.setText("关闭");
        cancelButton.setIcon(ImageIconUtil.getIcon("pics/close.png"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addRowButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        addRowButton.setText("添加");
        addRowButton.setIcon(ImageIconUtil.getIcon("pics/addrow.png"));
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });

        deleteRowButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        deleteRowButton.setText("删除");
        deleteRowButton.setIcon(ImageIconUtil.getIcon("pics/deleterow.png"));
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(deleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRowButton)
                    .addComponent(deleteRowButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        produceCardDialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        if(jTabbedPane1.getSelectedIndex()==1) {    //在第二个table tab中
            if(nothingAdded) {
                addRowButton.setEnabled(true);
            }
            if(notSaved()) {
                System.out.println("notSaved()");
                addRowButton.setEnabled(false);
                saveButton.setEnabled(true);
            }
            if(deleteRowButtonLastStatus) {      
                System.out.println("deleteRowButtonLastStatus==true");
                deleteRowButton.setEnabled(true);  //切换成true的状态
            }
            refreshCountNumLabel();              //刷新
        } else {                       //在第一个table tab中，所有按钮设置为false
            countNumLabel.setText("");
            addRowButton.setEnabled(false);
            deleteRowButton.setEnabled(false);
            saveButton.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged
    
    private void refreshCountNumLabel() {
        if(jTabbedPane1.getSelectedIndex()==1) {
            countNumLabel.setText("总共" + numOfRecords + "条记录");
        } else {
            countNumLabel.setText("");
        }
    }
    
    private boolean notSaved() {
        return nothingAdded==false && addedProducedProcedure!=null;
    }
    
    private void save() {
        addedProducedProcedure=null;
    }
    
    private void addRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowButtonActionPerformed
        // TODO add your handling code here:
        if(batchIdTextField.getText().trim().length()==0) {
            Util.showMessageDialog(this,"请先在表格上面的文本框中输入批次号！");
            return;
        }
        
        Component component = new Component();
        component.setBatchName(batchIdTextField.getText().trim());
      
        addedProducedProcedure = new ProducedProcedure(component,new Procedure() ,new Worker());    // the new line added
       
        componentProcedureTableModel.getWorks().add(addedProducedProcedure);    //add one line to the table
        
        componentProcedureTableModel.fireTableRowsInserted(componentProcedureTableModel.getRowCount()-1, componentProcedureTableModel.getRowCount()-1);   //refresh
        
        List<String> procedureNames = produceCardManager.getProcedureNames(componentIdTextField.getText().trim());    //add procedure in combox
        List<String> workerNames = produceCardManager.getWorkerNames();
       
         renderColumnAsCombox(1,procedureNames,addedProducedProcedure);
         renderColumnAsTextField(3,workerNames,addedProducedProcedure);
         
         nothingAdded = false;
         
         addRowButton.setEnabled(false);          //add record one by one
         saveButton.setEnabled(true);
    }//GEN-LAST:event_addRowButtonActionPerformed
    
    void renderColumnAsTextField(int columnIndex , List<String> items, ProducedProcedure producedProcedure) {
         TableColumn col = componentProcedureTable.getColumnModel().getColumn(columnIndex);
         JTextField textField = new JTextField();
         Util.setupAutoComplete(textField, items);
         col.setCellEditor(new DefaultCellEditor(textField));
    }
    
    
    void renderColumnAsCombox(int columnIndex , List<String> items,ProducedProcedure producedProcedure) {
        TableColumn col = componentProcedureTable.getColumnModel().getColumn(columnIndex);
        JComboBox comboBox = new JComboBox();
        for(String item : items) {
           comboBox.addItem(item);
        }
        comboBox.addActionListener(new MyComboxActionListener(columnIndex,comboBox,producedProcedure));
        col.setCellEditor(new DefaultCellEditor(comboBox));
    }
   
    
    class MyComboxActionListener implements ActionListener {  // listen for the select event of the combox
        private JComboBox jComboBox;
        private ProducedProcedure producedProcedure;
        private int columnIndex;
        
        public MyComboxActionListener(int columnIndex,JComboBox jComboBox , ProducedProcedure producedProcedure) {
            this.columnIndex = columnIndex;
            this.jComboBox = jComboBox;
            this.producedProcedure = producedProcedure;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
              String selectedItem = (String)jComboBox.getSelectedItem();
              if(columnIndex == 1) {      //set the procedure
                  producedProcedure.getProcedure().setProcedureName(selectedItem);
                  producedProcedure.getProcedure().setFactor(produceCardManager.getProcedureFactor(selectedItem));   //automately update the factor
                  componentProcedureTableModel.fireTableDataChanged();
              } else if(columnIndex == 3) {    //set the operator
                  producedProcedure.getOperator().setWorkerName(selectedItem);
                  componentProcedureTableModel.fireTableDataChanged();
              }
        }
    }
    
    private void deleteRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowButtonActionPerformed
        // TODO add your handling code here:
        //删除某条记录
        int choice = JOptionPane.showConfirmDialog(this,"你确定要删除此条记录吗","警告",JOptionPane.WARNING_MESSAGE);
        if(choice==JOptionPane.YES_OPTION) {
            System.out.println(deleteRowIndex);
            
            if(!notSaved()) { 
                componentProcedureTableModel.getWorks().get(deleteRowIndex).getComponent().setComponentId(componentIdTextField.getText().trim());
                if(!produceCardManager.deleteProduceWork(componentProcedureTableModel.getWorks().get(deleteRowIndex))) {
                    //------------------------------删除记录日志------------------------------
                    LoginWindow.logger.error("删除记录出错 : " + componentProcedureTableModel.getWorks().get(deleteRowIndex).toString());
                    //------------------------------删除记录日志------------------------------
                    Util.showMessageDialog(this, "删除记录出错，请联系开发人员！！");
                    return;
                } else {
                    //------------------------------删除记录日志------------------------------
                    LoginWindow.logger.info("删除记录成功 : " + componentProcedureTableModel.getWorks().get(deleteRowIndex).toString());
                    //------------------------------删除记录日志------------------------------
                    Util.showMessageDialog(this, "删除记录成功！！");
                }
            }
            componentProcedureTableModel.getWorks().remove(deleteRowIndex);
            componentProcedureTableModel.fireTableRowsDeleted(deleteRowIndex, deleteRowIndex);
            
            //reset the num label
             numOfRecords = componentProcedureTableModel.getWorks().size();
             refreshCountNumLabel();
           
            //删除成功后，addRowButton设置为true ， deleteRowButton设置为false
            addRowButton.setEnabled(true);       
            deleteRowButton.setEnabled(false);
            
            nothingAdded = true;
            deleteRowButtonLastStatus = false;
            saveButton.setEnabled(false);
            
            filterTextField.requestFocus();       //使得filterTextField获得焦点
        }
    }//GEN-LAST:event_deleteRowButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
        Util.Error e = Util.valid(addedProducedProcedure);
        if(e==Util.Error.BatchNameError) {
            Util.showMessageDialog(this, "输入批次号有误，请重新输入");
            return;
        } else if(e==Util.Error.ProcedureNameError) {
             Util.showMessageDialog(this, "输入工序有误，请重新输入");
            return;
        } else if(e==Util.Error.FactorError) {
             Util.showMessageDialog(this, "输入系数有误，请重新输入");
            return;
        }else if(e==Util.Error.WorkerNameError) {
             Util.showMessageDialog(this, "输入操作工有误，请重新输入");
            return;
        }else if(e==Util.Error.PassedNumError) {
             Util.showMessageDialog(this, "输入合格数有误，请重新输入");
            return;
        }else if(e==Util.Error.FailedNumError) {
             Util.showMessageDialog(this, "输入报废数有误，请重新输入");
            return;
        }else if(e==Util.Error.DateError) {
             Util.showMessageDialog(this, "输入时间有误，请重新输入");
            return;
        } else {
            addedProducedProcedure.getComponent().setComponentId(componentIdTextField.getText().trim());
            if(produceCardManager.putProducedProcedure(addedProducedProcedure)) {
                
                //------------------------------录入记录日志------------------------------
                LoginWindow.logger.info("录入记录成功 : " + componentProcedureTableModel.getWorks().get(deleteRowIndex).toString());
                //------------------------------录入记录日志------------------------------
                
                Util.showMessageDialog(this, "录入数据成功!!");
            } else {
                
                //------------------------------录入记录日志------------------------------
                LoginWindow.logger.error("录入记录失败 : " + componentProcedureTableModel.getWorks().get(deleteRowIndex).toString());
                //------------------------------录入记录日志------------------------------
                
                Util.showMessageDialog(this,produceCardManager.getErrorMessage());
                return;
            }
            
            //reset the num label
             numOfRecords = componentProcedureTableModel.getWorks().size();
             refreshCountNumLabel();
            
            //数据录入成功后，addRowButton设置为true,saveButton设置为false
            addedProducedProcedure=null;
            addRowButton.setEnabled(true);
            saveButton.setEnabled(false);
        }
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void componentIdTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_componentIdTextFieldFocusLost
        // TODO add your handling code here:
        System.out.println("Component Text Field lose focus");
        componentInfoTableModel = new ComponentInfoTableModel(componentIdTextField.getText().trim());
        componentInfoTable.setModel(componentInfoTableModel);
        componentNameLabel.setText(componentInfoTableModel.getComponent().getName());
        
        //根据component和batch填充componentProcedure表格
        String batchName = batchIdTextField.getText().trim().length()==0 ? "" : batchIdTextField.getText().trim(); 
        componentProcedureTableModel = new ComponentProcedureTableModel(componentIdTextField.getText().trim(),batchName);
        componentProcedureTable.setModel(componentProcedureTableModel);
        
        numOfRecords = componentProcedureTableModel.getWorks().size();
        refreshCountNumLabel();
        
        setSorter(componentProcedureTableModel, componentProcedureTable);   //使得表格可以排序

        //component的TextField的lostFocus时间触发BatchId TextField的内容填充
        List<String> batchIdsString = produceCardManager.getComponentBatchIds(componentIdTextField.getText().trim());
        for(String str : batchIdsString) {
            System.out.print(str + " ");
        }
        System.out.println();
        Util.setupAutoComplete(batchIdTextField, batchIdsString);
    }//GEN-LAST:event_componentIdTextFieldFocusLost

    private void batchIdTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_batchIdTextFieldFocusLost
        // TODO add your handling code here:
        System.out.println("BatchId Text Field lose focus");
        
        if(componentIdTextField.getText().trim().length()==0) {  //componentIdTextField为空
            Util.showMessageDialog(this, "请先输入图号");
           // Util.showConfirmDialog(this, "请先输入图号");
            return;
        }
        
        componentProcedureTableModel = new ComponentProcedureTableModel(componentIdTextField.getText().trim(),batchIdTextField.getText().trim());
        componentProcedureTable.setModel(componentProcedureTableModel);
        
        numOfRecords = componentProcedureTableModel.getWorks().size();
        refreshCountNumLabel();
        
        setSorter(componentProcedureTableModel, componentProcedureTable);     //使得表格可以排序

        if(jTabbedPane1.getSelectedIndex()==1) {     //如果是在第二个table tab中
            addRowButton.setEnabled(true);
            deleteRowButton.setEnabled(false);
        }
    }//GEN-LAST:event_batchIdTextFieldFocusLost

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
        
        setSorter(componentProcedureTableModel, componentProcedureTable);
        String text = filterTextField.getText();
        if (text.length() == 0) {
          //sorter.setRowFilter(null);
            Util.showMessageDialog(this, "请输入筛选条件");
        } else {
            //调用方法实现过滤内容
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
        
       //refresh
        numOfRecords =  sorter.getViewRowCount();
        refreshCountNumLabel();
    }//GEN-LAST:event_filterButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser(ConfigurePropertyEditor.get(exportRootPath));   //读取配置文件
        jFileChooser.setAcceptAllFileFilterUsed(false);
        ExportFileFilter excelFilter = new ExportFileFilter(".xls", "excel 文件 (*.xls)");
        jFileChooser.addChoosableFileFilter(excelFilter);
        
        int rVal = jFileChooser.showSaveDialog(produceCardDialog);
     
        if(rVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            ExportFileFilter fileFilter = (ExportFileFilter)jFileChooser.getFileFilter();
            String ends = fileFilter.getEnds();
            File newFile = null;
            if(file.getAbsolutePath().toUpperCase().endsWith(ends.toUpperCase())) {
                newFile = file;
            } else {
                newFile = new File(file.getAbsolutePath()+ends);
            }
            System.out.println(newFile.getName());
            
            //(图号,批次号,过滤文本)
            String title = "(" + componentIdTextField.getText() + "," + batchIdTextField.getText() + "," + filterTextField.getText() + ")";
            ExportManagerSupport exportManager = ExportManagerFactory.getManager(newFile,componentProcedureTable,title);
            if(exportManager.writeTableModel()) {
                
                //----------------------------------导出报表日志------------------------------------
                LoginWindow.logger.info("导出报表成功！ : " + title + "--->" + newFile.getAbsolutePath());
                //----------------------------------导出报表日志------------------------------------
               
                Util.showMessageDialog(this, "导出成功！");
            } else {
                
                //----------------------------------导出报表日志------------------------------------
                LoginWindow.logger.error("导出报表失败！ : " + title + "--->" + newFile.getAbsolutePath() + "  " + exportManager.getErrorMessage());
                //----------------------------------导出报表日志------------------------------------
                
                Util.showMessageDialogWithTitle(this,"警告", "导出失败:"+exportManager.getErrorMessage());
            }
            ConfigurePropertyEditor.set(exportRootPath,file.getParent());     //写回配置文件
        }
        if(rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("cancel");
        }
    }//GEN-LAST:event_exportButtonActionPerformed
    
    private void setSorter(ComponentProcedureTableModel model,JTable table) {
          //对表格进行排序
        sorter = new TableRowSorter<TableModel>(componentProcedureTableModel);
        sorter.setComparator(2,new Comparator<Float>() {      //第二列是数据类型是Float,但表格单元的属性是String,不一致，所以得自定义一个比较函数
            @Override
            public int compare(Float o1, Float o2) {
                return o1.compareTo(o2);
            }
        });
        table.setRowSorter(sorter);
    }
    
    private class MyMouseAdapter extends MouseAdapter {      //listen for the componentProcedureTable click event 
        public void mousePressed(MouseEvent e) {  
            if (componentProcedureTable.equals(e.getSource())) {  
                deleteRowIndex = componentProcedureTable.rowAtPoint(e.getPoint());    //选择某行后
                System.out.println("Mouse pressed : " + deleteRowIndex);
                if(componentProcedureTable.columnAtPoint(e.getPoint())!=1) {       //如果不是工序的那一列被选中（因为选择工序后会自动取消选中的行）
                    deleteRowButton.setEnabled(true);     //选择某行后,deleteRowButton设置为true             
                    deleteRowButtonLastStatus = true;
                }  else {
                     deleteRowButton.setEnabled(false);
                     deleteRowButtonLastStatus = false;
                }   
            }  
        }  
    } 

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowButton;
    private javax.swing.JTextField batchIdTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField componentIdTextField;
    private javax.swing.JTable componentInfoTable;
    private javax.swing.JLabel componentLabel;
    private javax.swing.JLabel componentNameLabel;
    private javax.swing.JTable componentProcedureTable;
    private javax.swing.JLabel countNumLabel;
    private javax.swing.JButton deleteRowButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
