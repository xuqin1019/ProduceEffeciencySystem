/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.TableModel;





/**
 *
 * @author lenovo
 */
public class PdfExportManager extends ExportManagerSupport {
    
    
    
    public PdfExportManager(File f,JTable table,String title) {
       super(f, table, title);
    }
    
    @Override
    public boolean writeTableModel() {
        Document document = new Document(PageSize.A4.rotate());
        try {
            TableModel tableModel = super.getTable().getModel();
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(super.getF()));
            document.open();
           
            BaseFont bf=BaseFont.createFont( "STSong-Light",   "UniGB-UCS2-H",   BaseFont.NOT_EMBEDDED);
            Font font=new Font(bf,12,Font.NORMAL);
            
            
            PdfPTable pdfTable = new PdfPTable(columnCount);    //column number
            
            PdfPCell c1=null;
            
            Paragraph p = new Paragraph(super.getTitle(),font);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph("  "));
            
            for( int col = 0; col < columnCount; col++ ){
                c1 = new PdfPCell(new Phrase(tableModel.getColumnName(col),font));
                c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(c1);
            }
           
            for( int row = 0; row < rowCount; row++ ){
                for( int col = 0; col < columnCount; col++ ){
                    c1 = new PdfPCell(new Phrase(tableModel.getValueAt( row, col ).toString(),font));
                    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                    pdfTable.addCell(c1);
                }
            }
            document.add(pdfTable);
            document.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            super.setErrorMessage(e.getMessage());
            return false;
        }
       
        return true;
    }

}
