/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ComponentDao;
import com.jycykj.model.FinishedComponent;
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
     
     public List<WorkLoad> getWorkerWorkLoad(String startTimeString, String endTimeString) {
        return componetDao.getWorkerWorkLoad(startTimeString, endTimeString);
    }
     
    public List<FinishedComponent> getComponentWorkLoad(int year, int month) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<WorkLoad> getGroupWorkLoad(String startDateString, String endDateString) {
        return componetDao.getGroupWorkLoad(startDateString,endDateString);
    }

   
     
     
}
