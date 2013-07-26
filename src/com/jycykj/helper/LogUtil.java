/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.helper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


/**
 *
 * @author xuqin
 */
public class LogUtil {       //log类
    public static String LoggerName = "defaultLogger";
    
    public static void InitLogger(String name, String path) {
        if (name == null) return;
	Logger log = Logger.getLogger(name);
        try {
            FileHandler fileHandler = new FileHandler(path,true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new LogFormatter());
            log.addHandler(fileHandler);
            LoggerName = name;
        }
        catch (Exception e) {
            System.out.println("Failed to configure logger: " + name + " @ " + path);
        }
    }
    
    static class LogFormatter extends java.util.logging.Formatter {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        
        @Override
        public String format(LogRecord record) {
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间     
            String str = formatter.format(curDate);     
            return str + " " + record.getLevel() + ":" + record.getMessage()+"\n";
        }
    }
}
