/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuqin
 */
public class ConfigurePropertyEditor {
    
    public static String get(String key) {
        Properties prop = new Properties();// 属性集合对象 
        FileInputStream fis;
        try {
            fis = new FileInputStream("conf.properties"); // 属性文件输入流
            prop.load(fis);// 将属性文件流装载到Properties对象中   
            fis.close();// 关闭流   
        } catch (Exception ex) {
            Logger.getLogger(ConfigurePropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop.getProperty(key);
    }
    
    public static void set(String key,String value) {
        Properties prop = new Properties();// 属性集合对象 
        FileInputStream fis;
        try {
            fis = new FileInputStream("conf.properties"); // 属性文件输入流
            prop.load(fis);// 将属性文件流装载到Properties对象中   
            fis.close();// 关闭流   
        } catch (Exception ex) {
            Logger.getLogger(ConfigurePropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        prop.setProperty(key, value);
         // 文件输出流   
        FileOutputStream fos;   
        try {
            fos = new FileOutputStream("conf.properties");
            // 将Properties集合保存到流中   
            prop.store(fos, "");   
            fos.close();// 关闭流   
        } catch (Exception ex) {
            Logger.getLogger(ConfigurePropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String [] args) {
        System.out.println(ConfigurePropertyEditor.get("produceCardImportPath"));
        ConfigurePropertyEditor.set("reportExportPath", "aaaa");
    }
}
