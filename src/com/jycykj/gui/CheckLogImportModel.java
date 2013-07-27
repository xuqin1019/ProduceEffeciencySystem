/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuqin
 */
public class CheckLogImportModel extends Observable {
    private File importFile = null;
    private volatile int currentLine=0;
    private StringBuffer logText = new StringBuffer();
    
    public CheckLogImportModel(File importFile) {
        this.importFile = importFile;
    }
    
    public int getLineNum() {      //获取文件的行数
        int lineNum = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(importFile));
            while(br.readLine()!=null) {
               ++lineNum;
             }
        } catch (Exception ex) {
            Logger.getLogger(CheckLogImportModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(CheckLogImportModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lineNum;
    }
    
    public void importFile() {
       new Thread(new Runnable() {      //开启导入文件的线程
            @Override
            public void run() {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(importFile));
                    String line = null;
                    while((line=br.readLine())!=null) {
                        logText.append(line + "\n");
                        ++currentLine;
                    }
                    Thread.sleep(100);
                    
                    //成功导入(send notification)
                    setChanged();
                    notifyObservers();
                } catch (Exception ex) {
                    Logger.getLogger(CheckLogImportModel.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if(br!=null) {
                        try {
                            br.close();
                        } catch (IOException ex) {
                            Logger.getLogger(CheckLogImportModel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
               }
            }
        }).start();
    }

    public File getImportFile() {
        return importFile;
    }

    public void setImportFile(File importFile) {
        this.importFile = importFile;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public StringBuffer getLogText() {
        return logText;
    }

    public void setLogText(StringBuffer logText) {
        this.logText = logText;
    }
}
