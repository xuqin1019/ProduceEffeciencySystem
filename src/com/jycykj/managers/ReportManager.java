/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ComponentDao;
import com.jycykj.model.WorkLoad;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class ReportManager {
     private ComponentDao componetDao = null;
     
     private static ReportManager reportManager = null;
     
     public static ReportManager newInstance() {
         if(reportManager==null) {
             reportManager = new ReportManager();
         }
         return reportManager;
     }
     
     public ReportManager() {
         componetDao = ComponentDao.getInstance();
     }
     
     public List<WorkLoad> getWorkerWorkLoad(int year,int month) {
         return componetDao.getWorkerWorkLoad(year,month);
     }
     
     
}
