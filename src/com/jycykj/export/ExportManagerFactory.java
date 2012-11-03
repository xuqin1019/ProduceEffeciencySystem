/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import java.io.File;
/**
 *
 * @author lenovo
 */
public class ExportManagerFactory {
    public static ExportManager getManager(File f) {
        if(f.getName().endsWith(".xls")){
            return new ExcelExportManager(f);
        } else {
            return new PdfExportManager(f);
        }
    }
}
