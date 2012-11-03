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
public abstract class ExportManager {
    
    protected File f; 
    
    public ExportManager(File f ) {
        this.f = f;
    }
    
  //  public abstract void exportData(List<Object> lists);
}
