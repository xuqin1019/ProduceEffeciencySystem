/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.export;

import java.io.File;
import javax.swing.JTable;

/**
 *
 * @author xuqin
 */
public class ExportManagerSupport implements ExportManager{
    
    private File f;
    private JTable table;
    private String title;
    private String errorMessage;

    public ExportManagerSupport(File f, JTable table, String title) {
        this.f = f;
        this.table = table;
        this.title = title;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public File getF() {
        return f;
    }

    public JTable getTable() {
        return table;
    }

    public String getTitle() {
        return title;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public boolean writeTableModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
