/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;
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
        if(!adminLogin) {
            systemMaintainMenu.disable();
            registerNewUserMenu.setEnabled(false);
            this.setTitle("生产效率管理系统(操作员登录)");
        } else {
            this.setTitle("生产效率管理系统(管理员登录)");
        }
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
        menuBar = new javax.swing.JMenuBar();
        operateMenu = new javax.swing.JMenu();
        dataRecordMenu = new javax.swing.JMenu();
        produceCardMenu = new javax.swing.JMenuItem();
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
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("生产效率管理系统");

        operateMenu.setMnemonic('f');
        operateMenu.setText("操作");

        dataRecordMenu.setText("数据录入");

        produceCardMenu.setText("生产工艺流程卡");
        produceCardMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produceCardMenuActionPerformed(evt);
            }
        });
        dataRecordMenu.add(produceCardMenu);

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
        workerEvaluationMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workerEvaluationMenuActionPerformed(evt);
            }
        });
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
        systemMaintainMenu.add(workerProfileMenu);

        procedureMenu.setText("生产工艺流程情况");
        systemMaintainMenu.add(procedureMenu);

        operateMenu.add(systemMaintainMenu);

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

    private void importMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importMenuActionPerformed

    private void workerEvaluationMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workerEvaluationMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workerEvaluationMenuActionPerformed

    private void registerNewUserMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewUserMenuActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterUserDialog dialog = new RegisterUserDialog(SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
              
                
    }//GEN-LAST:event_registerNewUserMenuActionPerformed

    private void produceCardMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produceCardMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProduceCardDialog dialog = new ProduceCardDialog(SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_produceCardMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMenuActionPerformed

    private void wWLRMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wWLRMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportDialog dialog = new ReportDialog(ReportType.WorkerWorkLoad,SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_wWLRMenuActionPerformed

    private void gWLRMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gWLRMenuActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportDialog dialog = new ReportDialog(ReportType.GroupWorkLoad,SystemWindow.this, true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_gWLRMenuActionPerformed

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
    private javax.swing.JMenu dataRecordMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem gAvgWLRMenu;
    private javax.swing.JMenuItem gWLRMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operateMenu;
    private javax.swing.JMenuItem procedureMenu;
    private javax.swing.JMenuItem produceCardMenu;
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
