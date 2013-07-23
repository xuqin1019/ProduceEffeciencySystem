/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.TableModel;



/**
 *
 * @author lenovo
 */
public class PdfExportManager implements ExportManager {
    
    private File f;
    private JTable table;
    
    public PdfExportManager(File f,JTable table) {
       this.f = f;
       this.table = table;
    }
    
    @Override
    public boolean writeTableModel() {
        Document document = new Document(PageSize.A4.rotate());
        try {
            TableModel tableModel = table.getModel();
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
            document.open();
            
            PdfPTable pdfTable = new PdfPTable(columnCount);    //column number
             PdfPCell c1=null;
            for( int col = 0; col < columnCount; col++ ){
                c1 = new PdfPCell(new Phrase(tableModel.getColumnName(col)));
                c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(c1);
            }
           
            for( int row = 0; row < rowCount; row++ ){
                for( int col = 0; col < columnCount; col++ ){
                    c1 = new PdfPCell(new Phrase(tableModel.getValueAt( row, col ).toString()));
                    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                    pdfTable.addCell(c1);
                }
            }
            document.add(pdfTable);
            document.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
       
        return true;
    }
    
}
