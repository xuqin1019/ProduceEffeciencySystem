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
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author lenovo
 */
public class ExcelExportManager implements ExportManager {
   // private ExcelFileWriter excelFileWriter;
    
    private File f;
    private JTable table;
    
    public ExcelExportManager(File f,JTable table) {
        this.f=f;
        this.table = table;
    }

    @Override
    public boolean writeTableModel() {
        if(table==null) {
            return false;
        }
        WritableWorkbook wbook = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(f);
           wbook = Workbook.createWorkbook(fileOutputStream); // 建立excel文件
           WritableSheet wsheet = wbook.createSheet("第一页", 0); // sheet名称
           WritableFont wfont = new WritableFont(WritableFont.ARIAL,16,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
           WritableCellFormat wcfFC = new WritableCellFormat(wfont);
           wsheet.addCell(new Label(1, 0, "报表", wcfFC));
           
           
           wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
           wcfFC = new WritableCellFormat(wfont);
           
           TableModel tableModel = table.getModel();
           int rowCount = tableModel.getRowCount();
           int columnCount = tableModel.getColumnCount();
           for( int col = 0; col < columnCount; col++ ){
                wsheet.addCell(new Label(col, 2, tableModel.getColumnName(col),wcfFC));
           }
           
           for( int row = 0; row < rowCount; row++ ){
                for( int col = 0; col < columnCount; col++ ){
                    wsheet.addCell(new Label(col, row+3,tableModel.getValueAt( row, col ).toString(),wcfFC));
                }
          }
          
            // 主体内容生成结束        
        wbook.write(); // 写入文件
        wbook.close();
         fileOutputStream.close();
        System.out.println("closed");
        } catch (Exception ex) {
            Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        return true;
        
    }
}
