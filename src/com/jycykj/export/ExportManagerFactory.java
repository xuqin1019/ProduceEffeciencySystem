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
    public static ExportManager getManager(File f , JTable table) {
        if(f.getName().endsWith(".xls")){
            return new ExcelExportManager(f,table);
        } else {
            return new PdfExportManager(f,table);
        }
    }
}
