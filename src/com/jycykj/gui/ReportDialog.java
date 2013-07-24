/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;


import java.awt.Rectangle;

/**
 *
 * @author lenovo
 */
public class ReportDialog extends javax.swing.JDialog {
    
    /**
     * Creates new form WorkerLoadReportDialog
     */
    
    public ReportType reportType = null;
            
    public ReportDialog(ReportType reportType,java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.reportType = reportType;
        initComponents();
        if(reportType==ReportType.WorkerWorkLoad) {
            setTitle("员工冲次统计表");
        } else if(reportType==ReportType.GroupWorkLoad)  {
            setTitle("班组冲次统计表");
        } else if(reportType==ReportType.WorkerAvgWorkLoad)  {
            setTitle("员工平均冲次统计");
        } else if(reportType==ReportType.WorkerAvgWorkLoad)  {
            setTitle("班组平均冲次统计");
        } else if(reportType==ReportType.WorkerWorkTime)  {
            setTitle("员工工作时间统计表");
        } else if(reportType==ReportType.FinishComponentReport)  {
            setTitle("当月完成零件统计表");
        } else if(reportType==ReportType.WorkerEvaluationReport)  {
            setTitle("当月员工考核表");
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

        workerLoadReportPanel1 = new com.jycykj.gui.ReportPanel(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workerLoadReportPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(workerLoadReportPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReportDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportDialog dialog = new ReportDialog(ReportType.WorkerWorkLoad,new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
           //     dialog.setPreferredSize(new Dimension(600,800));
                dialog.setBounds(new Rectangle(50, 5, 800, 780));
                dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jycykj.gui.ReportPanel workerLoadReportPanel1;
    // End of variables declaration//GEN-END:variables
}
