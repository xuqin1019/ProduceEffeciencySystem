/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.helper;

import com.jycykj.model.ProducedProcedure;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Util {
    
    public static enum Error{
        BatchNameError,ProcedureNameError,FactorError,WorkerNameError,PassedNumError,FailedNumError,DateError, Success
    }
    
    public static boolean isEmpty(String str) {
        return str.equals("");
    }
    
    public static void showMessageDialog(Component component,String message) {
        JOptionPane.showMessageDialog(component, message);
    } 
    
    public static void showMessageDialogWithTitle(Component component,String title,String message) {
        JOptionPane.showMessageDialog(component, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showConfirmDialog(Component component,String message) {
        JOptionPane.showConfirmDialog(component,message);
    }
    
    public static Date parseDateString(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String date2Str(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }
    
    

    public static Error valid(ProducedProcedure producedProcedure) {
        if(producedProcedure.getComponent().getBatchName()==null) {
            return Error.BatchNameError;
        } else if(producedProcedure.getProcedure().getProcedureName()==null) {
            return Error.ProcedureNameError;
        } else if(producedProcedure.getProcedure().getFactor()==0.0f) {
            return Error.FactorError;
        } else if(producedProcedure.getOperator().getWorkerName()==null) {
            return Error.WorkerNameError;
        } else if(producedProcedure.getPassedNum()<0) {
            return Error.PassedNumError;
        } else if(producedProcedure.getFailedNum()<0) {
            return Error.FailedNumError;
        } else if(producedProcedure.getDate()==null) {
            return Error.DateError;
        }
        return Error.Success;
    }
}
