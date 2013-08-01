/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ComponentDao;
import com.jycykj.model.Component;
import java.util.List;

/**
 *
 * @author xuqin
 */
public class ComponentManager {
    
    private ComponentDao componentDao = null;
    
    private static ComponentManager componentManager = null;
    
    public static ComponentManager getInstance() {
        if(componentManager==null) {
            componentManager = new ComponentManager();
        }
        return componentManager;
    }
    
    private ComponentManager() {
        componentDao = ComponentDao.getInstance();
    }
    
    public List<Component> getComponents() {
        return componentDao.getComponents();
    }
   
    public List<String> getProcedures(String componentId) {
        return componentDao.getProcedureNames(componentId);
    }
}
