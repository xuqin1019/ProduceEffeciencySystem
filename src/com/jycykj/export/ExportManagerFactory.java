/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import java.io.File;
import javax.swing.JTable;
/**
 *
 * @author lenovo
 */
public class ExportManagerFactory {
    public static ExportManagerSupport getManager(File f , JTable table,String title) {
        if(f.getName().endsWith(".xls")){
            return new ExcelExportManager(f,table,title);
        } else {
            return new PdfExportManager(f,table,title);
        }
    }
}
