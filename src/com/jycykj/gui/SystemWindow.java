/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;
import com.jycykj.helper.ImageIconUtil;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
 
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
        
        ImageIcon imageIconSource = new ImageIcon("pics/system.png");
        Image image = imageIconSource.getImage();
      //  Image systemImage = image.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        this.setIconImage(image);
        
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
        jSeparator2 = new javax.swing.JSeparator();
        imagePanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        operateMenu = new javax.swing.JMenu();
        dataRecordMenu = new javax.swing.JMenu();
        makeProduceCardMenu = new javax.swing.JMenuItem();
        fillProduceCardMenu = new javax.swing.JMenuItem();
        washMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ImExportMenu = new javax.swing.JMenu();
        importMenu = new javax.swing.JMenuItem();
        ReportMenu = new javax.swing.JMenu();
        wWLRMenu = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        gWLRMenu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        workTimeMenu = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        FinishComponentMenu = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        workerEvaluationMenu = new javax.swing.JMenuItem();
        registerNewUserMenu = new javax.swing.JMenuItem();
        systemMaintainMenu = new javax.swing.JMenu();
        workerProfileMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        procedureManageMenu = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        componentManageMenu = new javax.swing.JMenuItem();
        checklogMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
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
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        operateMenu.setMnemonic('f');
        operateMenu.setText("操作");
        operateMenu.setIcon(ImageIconUtil.getIcon("pics/action.png"));
        operateMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        dataRecordMenu.setText("数据录入");
        dataRecordMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        dataRecordMenu.setIcon(ImageIconUtil.getIcon("pics/data_record.png"));

        makeProduceCardMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        makeProduceCardMenu.setText("制作生产工艺流程卡");
        makeProduceCardMenu.setIcon(ImageIconUtil.getIcon("pics/make.png"));
        dataRecordMenu.add(makeProduceCardMenu);

        fillProduceCardMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        fillProduceCardMenu.setText("填写生产工艺流程卡");
        fillProduceCardMenu.setIcon(ImageIconUtil.getIcon("pics/write.png"));
        fillProduceCardMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillProduceCardMenuActionPerformed(evt);
            }
        });
        dataRecordMenu.add(fillProduceCardMenu);

        washMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        washMenu.setText("清洗情况统计");
        washMenu.setIcon(ImageIconUtil.getIcon("pics/wash.png"));
        dataRecordMenu.add(washMenu);

        operateMenu.add(dataRecordMenu);
        operateMenu.add(jSeparator3);

        ImExportMenu.setText("数据导入");
        ImExportMenu.setIcon(ImageIconUtil.getIcon("pics/import_export.png"));
        ImExportMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        importMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        importMenu.setText("导入");
        importMenu.setIcon(ImageIconUtil.getIcon("pics/import.png"));
        importMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuActionPerformed(evt);
            }
        });
        ImExportMenu.add(importMenu);

        operateMenu.add(ImExportMenu);

        ReportMenu.setText("报表");
        ReportMenu.setIcon(ImageIconUtil.getIcon("pics/report.png"));
        ReportMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        wWLRMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        wWLRMenu.setText("员工冲次统计表");
        wWLRMenu.setIcon(ImageIconUtil.getIcon("pics/worker_report.png"));
        wWLRMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wWLRMenuActionPerformed(evt);
            }
        });
        ReportMenu.add(wWLRMenu);
        ReportMenu.add(jSeparator5);

        gWLRMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        gWLRMenu.setText("班组冲次统计表");
        gWLRMenu.setIcon(ImageIconUtil.getIcon("pics/group_report.png"));
        gWLRMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gWLRMenuActionPerformed(evt);
            }
        });
        ReportMenu.add(gWLRMenu);
        ReportMenu.add(jSeparator6);

        workTimeMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        workTimeMenu.setText("员工工作时间统计表");
        workTimeMenu.setIcon(ImageIconUtil.getIcon("pics/time_report.png"));
        ReportMenu.add(workTimeMenu);
        ReportMenu.add(jSeparator7);

        FinishComponentMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        FinishComponentMenu.setText("当月完成零件");
        FinishComponentMenu.setIcon(ImageIconUtil.getIcon("pics/finish_component.png"));
        ReportMenu.add(FinishComponentMenu);
        ReportMenu.add(jSeparator8);

        workerEvaluationMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        workerEvaluationMenu.setText("当月员工考核表");
        workerEvaluationMenu.setIcon(ImageIconUtil.getIcon("pics/evaluation.png"));
        ReportMenu.add(workerEvaluationMenu);

        operateMenu.add(ReportMenu);

        registerNewUserMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        registerNewUserMenu.setText("注册新用户(管理员权限)");
        registerNewUserMenu.setIcon(ImageIconUtil.getIcon("pics/register.png"));
        registerNewUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewUserMenuActionPerformed(evt);
            }
        });
        operateMenu.add(registerNewUserMenu);

        systemMaintainMenu.setText("系统维护(管理员权限)");
        systemMaintainMenu.setIcon(ImageIconUtil.getIcon("pics/system_maintain.png"));
        systemMaintainMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        workerProfileMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        workerProfileMenu.setText("员工花名册");
        workerProfileMenu.setIcon(ImageIconUtil.getIcon("pics/worker_list.png"));
        workerProfileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workerProfileMenuActionPerformed(evt);
            }
        });
        systemMaintainMenu.add(workerProfileMenu);
        systemMaintainMenu.add(jSeparator1);

        procedureManageMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        procedureManageMenu.setText("工序管理");
        procedureManageMenu.setIcon(ImageIconUtil.getIcon("pics/procedure_manage.png"));
        systemMaintainMenu.add(procedureManageMenu);
        systemMaintainMenu.add(jSeparator9);

        componentManageMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        componentManageMenu.setText("零件管理");
        componentManageMenu.setIcon(ImageIconUtil.getIcon("pics/component_manage.png"));
        systemMaintainMenu.add(componentManageMenu);

        operateMenu.add(systemMaintainMenu);

        checklogMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        checklogMenu.setText("查看日志(管理员权限)");
        checklogMenu.setIcon(ImageIconUtil.getIcon("pics/check_log.png"));
        checklogMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checklogMenuActionPerformed(evt);
            }
        });
        operateMenu.add(checklogMenu);
        operateMenu.add(jSeparator4);

        exitMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        exitMenu.setText("退出 ");
        exitMenu.setIcon(ImageIconUtil.getIcon("pics/exit.png"));
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        operateMenu.add(exitMenu);

        menuBar.add(operateMenu);
        //menuBar.add(new JSeparator(JSeparator.HORIZONTAL));

        helpMenu.setMnemonic('h');
        helpMenu.setText("帮助");
        helpMenu.setIcon(ImageIconUtil.getIcon("pics/help.png"));
        helpMenu.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("关于");
        aboutMenuItem.setIcon(ImageIconUtil.getIcon("pics/about.png"));
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JMenuItem FinishComponentMenu;
    private javax.swing.JMenu ImExportMenu;
    private javax.swing.JMenu ReportMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem checklogMenu;
    private javax.swing.JMenuItem componentManageMenu;
    private javax.swing.JMenu dataRecordMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem fillProduceCardMenu;
    private javax.swing.JMenuItem gWLRMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JMenuItem importMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem makeProduceCardMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operateMenu;
    private javax.swing.JMenuItem procedureManageMenu;
    private javax.swing.JMenuItem registerNewUserMenu;
    private javax.swing.JMenu systemMaintainMenu;
    private javax.swing.JMenuItem wWLRMenu;
    private javax.swing.JMenuItem washMenu;
    private javax.swing.JMenuItem workTimeMenu;
    private javax.swing.JMenuItem workerEvaluationMenu;
    private javax.swing.JMenuItem workerProfileMenu;
    // End of variables declaration//GEN-END:variables
}
