/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import com.jycykj.helper.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author xuqin
 */
public class CheckLogImportProgressDialog extends javax.swing.JDialog implements Observer{
    
    private CheckLogPanel checkLogPanel = null;       //传递过来的CheckLogPanel
    private CheckLogImportModel checkLogImportModel = null;
    
    /**
     * Creates new form CheckLogImportProgressDialog
     */
    public CheckLogImportProgressDialog(java.awt.Frame parent, boolean modal,CheckLogPanel checkLogPanel) {
        this(parent, modal);
        this.checkLogPanel = checkLogPanel;
        this.checkLogImportModel = new CheckLogImportModel(this.checkLogPanel.getImportFile());
        checkLogImportModel.addObserver(this);
        this.logFileTextField.setText(this.checkLogPanel.getImportFile().getAbsolutePath());
    }
    
    public CheckLogImportProgressDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        importButton = new javax.swing.JButton();
        logFileTextField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("导入日志文件");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        progressBar.setStringPainted(true);

        importButton.setText("开始导入");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel2.setText("日志文件 :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(logFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(importButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logFileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(importButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        // TODO add your handling code here:
        
        //设置进度条的参数
        progressBar.setMinimum(0);
        progressBar.setMaximum(checkLogImportModel.getLineNum());
        
        //开启进度条线程
        Timer timer = new Timer(30 , new ActionListener() { 
            public void actionPerformed(ActionEvent e) {  
                progressBar.setValue(checkLogImportModel.getCurrentLine());  
            }  
         });  
         timer.start();  
         
         //开始导入文件
         checkLogImportModel.importFile();
    }//GEN-LAST:event_importButtonActionPerformed

    @Override
    public void update(Observable o, Object arg) {    //在导入成功时调用 success
        CheckLogImportModel checkLogImportModel = (CheckLogImportModel)o; 
        this.checkLogPanel.getLogTextArea().setText(checkLogImportModel.getLogText().toString());
        Util.showMessageDialog(this, "导入日志成功！");
        this.dispose();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckLogImportProgressDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckLogImportProgressDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckLogImportProgressDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckLogImportProgressDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckLogImportProgressDialog dialog = new CheckLogImportProgressDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logFileTextField;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

  
}
