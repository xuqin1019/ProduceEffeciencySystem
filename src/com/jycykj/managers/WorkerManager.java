/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ComponentDao;
import com.jycykj.model.Worker;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class WorkerManager {
     private ComponentDao componentDao = null;
     
     private static WorkerManager workerManager = null;
     
     private WorkerManager() {
         componentDao = ComponentDao.getInstance();
     }
     
     public static WorkerManager getInstance() {
         if(workerManager==null) {
             workerManager=new WorkerManager();
         }
         return workerManager;
     }
     
     public List<Worker> getWorkers() {
         return componentDao.getWorkers();
     }

    public Map<String,Integer> getGroups() {
        return componentDao.getGroups();
    }
     
}
