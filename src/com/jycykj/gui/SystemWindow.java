/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
 
/**
 *
 * @author lenovo
 */
public class SystemWindow extends javax.swing.JFrame {
    private boolean adminLogin;         //if login as admin
   /**
     * Creates new form NewApplication
     */
    public SystemWindow(boolean adminLogin) {
        this.adminLogin=adminLogin;
        initComponents();
        this.setLocationRelativeTo(null);      //居中显示
        if(!adminLogin) {
            systemMaintainMenu.disable();
            registerNewUserMenu.setEnabled(false);
            this.setTitle("生产效率管理系统(操作员登录)");
        } else {
            this.setTitle("生产效率管理系统(管理员登录)");
        }
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示", JOptionPane.YES_NO_OPTION);
                if (a == 0) {  
                    //----------------------------------系统登陆日志---------------------------
                    LoginWindow.logger.info("-----------本次登录结束--------------\n\n\n\n");
                    System.exit(0);  //关闭
                } else {
                    return;
                }
           }    
        });
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuBar = new javax.swing.JMenuBar();
        operateMenu = new javax.swing.JMenu();
        dataRecordMenu = new javax.swing.JMenu();
        makeProduceCardMenu = new javax.swing.JMenuItem();
        fillProduceCardMenu = new javax.swing.JMenuItem();
        washMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ImExportMenu = new javax.swing.JMenu();
        importMenu = new javax.swing.JMenuItem();
        ExportMenu = new javax.swing.JMenuItem();
        ReportMenu = new javax.swing.JMenu();
        wWLRMenu = new javax.swing.JMenuItem();
        gWLRMenu = new javax.swing.JMenuItem();
        wAvgWLRMenu = new javax.swing.JMenuItem();
        gAvgWLRMenu = new javax.swing.JMenuItem();
        workTimeMenu = new javax.swing.JMenuItem();
        FinishComponentMenu = new javax.swing.JMenuItem();
        workerEvaluationMenu = new javax.swing.JMenuItem();
        registerNewUserMenu = new javax.swing.JMenuItem();
        systemMaintainMenu = new javax.swing.JMenu();
        workerProfileMenu = new javax.swing.JMenuItem();
        procedureMenu = new javax.swing.JMenuItem();
        checklogMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("生产效率管理系统");

        operateMenu.setMnemonic('f');
        operateMenu.setText("操作");

        dataRecordMenu.setText("数据录入");

        makeProduceCardMenu.setText("制作生产工艺流程卡");
        dataRecordMenu.add(makeProduceCardMenu);

        fillProduceCardMenu.setText("填写生产工艺流程卡");
        fillProduceCardMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillProduceCardMenuActionPerformed(evt);
            }
        });
        dataRecordMenu.add(fillProduceCardMenu);

        washMenu.setText("清洗情况统计");
        dataRecordMenu.add(washMenu);

        operateMenu.add(dataRecordMenu);
        operateMenu.add(jSeparator1);

        ImExportMenu.setText("导入导出");

        importMenu.setText("导入");
        importMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuActionPerformed(evt);
            }
        });
        ImExportMenu.add(importMenu);

        ExportMenu.setText("导出");
        ImExportMenu.add(ExportMenu);

        operateMenu.add(ImExportMenu);

        ReportMenu.setText("报表");

        wWLRMenu.setText("员工冲次统计表");
        wWLRMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wWLRMenuActionPerformed(evt);
            }
        });
        ReportMenu.add(wWLRMenu);

        gWLRMenu.setText("班组冲次统计表");
        gWLRMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gWLRMenuActionPerformed(evt);
            }
        });
        ReportMenu.add(gWLRMenu);

        wAvgWLRMenu.setText("员工平均冲次统计");
        ReportMenu.add(wAvgWLRMenu);

        gAvgWLRMenu.setText("班组平均冲次统计");
        ReportMenu.add(gAvgWLRMenu);

        workTimeMenu.setText("员工工作时间统计表");
        ReportMenu.add(workTimeMenu);

        FinishComponentMenu.setText("当月完成零件");
        ReportMenu.add(FinishComponentMenu);

        workerEvaluationMenu.setText("当月员工考核表");
        ReportMenu.add(workerEvaluationMenu);

        operateMenu.add(ReportMenu);

        registerNewUserMenu.setText("注册新用户(管理员权限)");
        registerNewUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewUserMenuActionPerformed(evt);
            }
        });
        operateMenu.add(registerNewUserMenu);

        systemMaintainMenu.setText("系统维护(管理员权限)");

        workerProfileMenu.setText("员工花名册");
        workerProfileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workerProfileMenuActionPerformed(evt);
            }
        });
        systemMaintainMenu.add(workerProfileMenu);

        procedureMenu.setText("生产工艺流程情况");
        systemMaintainMenu.add(procedureMenu);

        operateMenu.add(systemMaintainMenu);

        checklogMenu.setText("查看日志(管理员权限)");
        checklogMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checklogMenuActionPerformed(evt);
            }
        });
        operateMenu.add(checklogMenu);

        exitMenu.setText("退出 ");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        operateMenu.add(exitMenu);

        menuBar.add(operateMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("帮助");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("关于");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //导入信息菜单(已经完成日志记录)
    private void importMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuActionPerformed
        // TODO add your handling code here:
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImportDataDialog importDataDialog = new ImportDataDialog(SystemWindow.this, true);
                importDataDialog.setLocationRelativeTo(SystemWindow.this);
                importDataDialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_importMenuActionPerformed
    
    
    //注册用户菜单(已经完成日志记录)
    private void registerNewUserMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewUserMenuActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterUserDialog dialog = new RegisterUserDialog(SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
              
                
    }//GEN-LAST:event_registerNewUserMenuActionPerformed
    
    //生产工艺流程卡菜单(已经完成日志记录)
    private void fillProduceCardMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillProduceCardMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProduceCardDialog dialog = new ProduceCardDialog(SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_fillProduceCardMenuActionPerformed

    //退出菜单(已经完成日志记录)
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
        
        int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示", JOptionPane.YES_NO_OPTION);
        if(a==0) {
        
            //----------------------------------系统登陆日志---------------------------
            LoginWindow.logger.info("-----------本次登录结束--------------\n\n\n\n");
            this.dispose();
            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_exitMenuActionPerformed
    
    //员工报表菜单(已经完成日志记录)
    private void wWLRMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wWLRMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportDialog dialog = new ReportDialog(ReportType.WorkerWorkLoad,SystemWindow.this, true);
                dialog.setBounds(new Rectangle(50, 5, 800, 780));
                dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_wWLRMenuActionPerformed
    
    
    //班组报表菜单(已经完成日志记录)
    private void gWLRMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gWLRMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportDialog dialog = new ReportDialog(ReportType.GroupWorkLoad,SystemWindow.this, true);
                dialog.setBounds(new Rectangle(50, 5, 800, 780));
                dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_gWLRMenuActionPerformed

    
    //修改员工信息菜单(已经完成日志记录)
    private void workerProfileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workerProfileMenuActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WorkerManagerDialog dialog = new WorkerManagerDialog(SystemWindow.this, true);
               // dialog.setBounds(new Rectangle(50, 5, 800, 780));
                dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_workerProfileMenuActionPerformed
    
    //查看日志菜单
    private void checklogMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checklogMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckLogDialog dialog = new CheckLogDialog(SystemWindow.this, true);
               // dialog.setBounds(new Rectangle(50, 5, 800, 780));
                dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_checklogMenuActionPerformed

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
            java.util.logging.Logger.getLogger(SystemWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemWindow(true).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExportMenu;
    private javax.swing.JMenuItem FinishComponentMenu;
    private javax.swing.JMenu ImExportMenu;
    private javax.swing.JMenu ReportMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem checklogMenu;
    private javax.swing.JMenu dataRecordMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem fillProduceCardMenu;
    private javax.swing.JMenuItem gAvgWLRMenu;
    private javax.swing.JMenuItem gWLRMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem makeProduceCardMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operateMenu;
    private javax.swing.JMenuItem procedureMenu;
    private javax.swing.JMenuItem registerNewUserMenu;
    private javax.swing.JMenu systemMaintainMenu;
    private javax.swing.JMenuItem wAvgWLRMenu;
    private javax.swing.JMenuItem wWLRMenu;
    private javax.swing.JMenuItem washMenu;
    private javax.swing.JMenuItem workTimeMenu;
    private javax.swing.JMenuItem workerEvaluationMenu;
    private javax.swing.JMenuItem workerProfileMenu;
    // End of variables declaration//GEN-END:variables
}
