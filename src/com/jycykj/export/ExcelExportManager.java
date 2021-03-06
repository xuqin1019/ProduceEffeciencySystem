/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author lenovo
 */
public class ExcelExportManager extends ExportManagerSupport {
   // private ExcelFileWriter excelFileWriter;
    public ExcelExportManager(File f,JTable table,String title) {
       super(f, table, title);
    }

    @Override
    public boolean writeTableModel() {
        if(super.getTable()==null) {
            return false;
        }
        WritableWorkbook wbook = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(super.getF());
           wbook = Workbook.createWorkbook(fileOutputStream); // 建立excel文件
           WritableSheet wsheet = wbook.createSheet("第一页", 0); // sheet名称
            wsheet.addCell(new Label(0, 0, super.getTitle()));
           
           
           TableModel tableModel = super.getTable().getModel();
           int rowCount = tableModel.getRowCount();
           int columnCount = tableModel.getColumnCount();
           for( int col = 0; col < columnCount; col++ ){
                wsheet.addCell(new Label(col, 2, tableModel.getColumnName(col)));
           }
           
           for( int row = 0; row < rowCount; row++ ){
                for( int col = 0; col < columnCount; col++ ){
                    wsheet.addCell(new Label(col, row+3,tableModel.getValueAt( row, col ).toString()));
                }
          }
            // 主体内容生成结束        
        wbook.write(); // 写入文件
        wbook.close();
        fileOutputStream.close();
        System.out.println("closed");
        } catch (Exception ex) {
            Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
            super.setErrorMessage(ex.getMessage());
            return false;
        } 
        return true;
    }
}
