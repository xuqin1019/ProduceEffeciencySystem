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
import com.jycykj.tables.GroupWorkLoadTableModel;
import com.jycykj.tables.WorkLoadTableModel;
import com.jycykj.tables.WorkerWorkLoadTableModel;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author lenovo
 */
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form WorkerLoadReportPanel
     */
    private static final String exportRootPath = "reportExportPath";       //文件选择器的根目录
    private ReportDialog jDialog = null;
            
    public ReportPanel(ReportDialog jDialog) {
        this.jDialog = jDialog;
        initComponents();
        exportButton.setEnabled(false);
        
      //  addListenerToDatePickerButton(startDatePickerButton,startDateTextField);
      //  addListenerToDatePickerButton(endDatePickerButton,endDateTextField);
    }
    
//    private void  addListenerToDatePickerButton(JButton button , final DateTextField dateTextField) {
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                 DatePicker dp = new DatePicker(dateTextField, Locale.CHINA);
//                 Date selectedDate = dp.parseDate(dateTextField.getText());
//                 dp.setSelectedDate(selectedDate);
//                 dp.start(dateTextField);
//            }
//        });
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        startDateTextField = new com.jycykj.gui.DateTextField();
        startDatePickerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        endDateTextField = new com.jycykj.gui.DateTextField();
        endDatePickerButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        exportButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 715));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jLabel3.setText("请选择查询的日期范围");

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel1.setText("起始：");

        startDateTextField.setEditable(false);

        startDatePickerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jycykj/gui/cal.jpg"))); // NOI18N
        //startDatePickerButton.setIcon(ImageIconUtil.getIcon("pics/cal.png"));
        startDatePickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel2.setText("终止：");

        endDateTextField.setEditable(false);

        endDatePickerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jycykj/gui/cal.jpg"))); // NOI18N
        endDatePickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        searchButton.setText("查询");
        searchButton.setIcon(ImageIconUtil.getIcon("pics/lookup.png"));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exportButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        exportButton.setText("导出");
        exportButton.setIcon(ImageIconUtil.getIcon("pics/export.png"));
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        cancelButton.setText("关闭");
        cancelButton.setIcon(ImageIconUtil.getIcon("pics/close.png"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        reportTable.setCellSelectionEnabled(true);
        reportTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(reportTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButton)
                    .addComponent(cancelButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDatePickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDatePickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(startDatePickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(endDatePickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       // int year = Integer.parseInt((String)yearComboBox.getSelectedItem());
       // int month = Integer.parseInt((String)monthComboBox.getSelectedItem());
        String startTimeString = startDateTextField.getText().trim();
        String endTimeString = endDateTextField.getText().trim();
        if(startTimeString.compareTo(endTimeString)==1) {
            System.out.println("error");
            Util.showMessageDialog(this, "起始日期不能晚于终止日期，按确定重新选择");
            return;
        }
        
        ReportType reportType = this.jDialog.reportType;
         WorkLoadTableModel workLoadTableModel = null;
        if(reportType==ReportType.WorkerWorkLoad) {
            workLoadTableModel = new WorkerWorkLoadTableModel(startTimeString,endTimeString);
            titleLabel.setText(startTimeString + " 到 " + endTimeString + " 员工冲次统计表");
        } else if(reportType==ReportType.GroupWorkLoad) {
            workLoadTableModel = new GroupWorkLoadTableModel(startTimeString, endTimeString);
            titleLabel.setText(startTimeString + " 到 " + endTimeString + " 班组冲次统计表");
        }
       
        if(workLoadTableModel.getRowCount()==0) {
            titleLabel.setText(titleLabel.getText()+"(没有数据)");
            exportButton.setEnabled(false);
        } else {
            exportButton.setEnabled(true);
        }
        reportTable.setDefaultRenderer(Integer.class, new LeftAlignRenderer());
      //  reportTable.setDefaultRenderer(, new LeftAlignRenderer());
        reportTable.setModel(workLoadTableModel);
        
        reportTable.setAutoCreateRowSorter(true);     //设置表格的排序
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        jDialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        // TODO add your handling code here:
      //  new FileDialog(this,"选择导出表格的位置",FileDialog.SAVE);
        JFileChooser jFileChooser = new JFileChooser(ConfigurePropertyEditor.get(exportRootPath));  //读取配置文件
        jFileChooser.setAcceptAllFileFilterUsed(false);
        ExportFileFilter excelFilter = new ExportFileFilter(".xls", "excel 文件 (*.xls)");
        ExportFileFilter pdfFilter = new ExportFileFilter(".pdf", "pdf 文件 (*.pdf)");
        
        jFileChooser.addChoosableFileFilter(pdfFilter);
        jFileChooser.addChoosableFileFilter(excelFilter);
        
        int rVal = jFileChooser.showSaveDialog(jDialog);
     
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
            ExportManagerSupport exportManager = ExportManagerFactory.getManager(newFile,reportTable,titleLabel.getText());
            if(exportManager.writeTableModel()) {
                
                //----------------------------------导出报表日志------------------------------------
                LoginWindow.logger.info("导出报表成功！ : " + titleLabel.getText() + "--->" + newFile.getAbsolutePath());
                //----------------------------------导出报表日志------------------------------------
               
                Util.showMessageDialog(this, "导出成功！");
            } else {
                
                //----------------------------------导出报表日志------------------------------------
                LoginWindow.logger.error("导出报表失败！ : " + titleLabel.getText() + "--->" + newFile.getAbsolutePath() + "  " + exportManager.getErrorMessage());
                //----------------------------------导出报表日志------------------------------------
                
                Util.showMessageDialogWithTitle(this,"警告", "导出失败:"+exportManager.getErrorMessage());
            }
            
            ConfigurePropertyEditor.set(exportRootPath,file.getParent());     //写回配置文件
        }
        if(rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("cancel");
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void startDatePickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerButtonActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatePickerDialog produceCardDatePickerDialog = new DatePickerDialog(null, true,startDateTextField,startDatePickerButton.getLocationOnScreen().x+10,startDatePickerButton.getLocationOnScreen().y+startDatePickerButton.getHeight()+10);
                produceCardDatePickerDialog.setResizable(false);
                produceCardDatePickerDialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_startDatePickerButtonActionPerformed

    private void endDatePickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerButtonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatePickerDialog produceCardDatePickerDialog = new DatePickerDialog(null, true,endDateTextField,endDatePickerButton.getLocationOnScreen().x+10,endDatePickerButton.getLocationOnScreen().y+endDatePickerButton.getHeight()+10);
                produceCardDatePickerDialog.setResizable(false);
                produceCardDatePickerDialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_endDatePickerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton endDatePickerButton;
    private com.jycykj.gui.DateTextField endDateTextField;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reportTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton startDatePickerButton;
    private com.jycykj.gui.DateTextField startDateTextField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
