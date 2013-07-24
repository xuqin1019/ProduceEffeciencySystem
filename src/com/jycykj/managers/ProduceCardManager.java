/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ComponentDao;
import com.jycykj.model.Component;
import com.jycykj.model.ProducedProcedure;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class ProduceCardManager {
    private ComponentDao componetDao = null;
    
    private String errorMessage;      //errorMessage
    
    private static ProduceCardManager produceCardManager = null;
    
    private ProduceCardManager() {
        componetDao = ComponentDao.getInstance();
    }
    
    public static ProduceCardManager newInstance() {
        if(produceCardManager==null) {
            produceCardManager = new ProduceCardManager();
        }
        return produceCardManager;
    }
    
    public List<String> getComponentIds() {
        return componetDao.getComponentIds();
    }
    
    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyy年 MM月 dd日");
        return df.format(new Date(System.currentTimeMillis()));
    }

    public Component getComponent(String componentId) {
       return componetDao.getComponent(componentId);
    }

    public List<ProducedProcedure> getWorks(String componentId,String batchName) {
        return componetDao.getWorks(componentId,batchName);
    }

    public List<String> getProcedureNames(String componentId) {
       return componetDao.getProcedureNames(componentId);
    }
    
    public List<String> getComponentBatchIds(String componentName) {   //获得component对应的批次号
        return componetDao.getCompoentBatchIds(componentName);
    }

    public List<String> getWorkerNames() {
        return componetDao.getWorkerNames();
    }

    public float getProcedureFactor(String procedureName) {
        return componetDao.getProcedureFactor(procedureName);
    }

    public boolean putProducedProcedure(ProducedProcedure producedProcedure) {
        boolean success = componetDao.putProducedProcedure(producedProcedure);
        errorMessage = componetDao.getErrorMessage();
        return success;
    }

    public boolean deleteProduceWork(ProducedProcedure producedProcedure) {
        return componetDao.deleteProduceWork(producedProcedure);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
