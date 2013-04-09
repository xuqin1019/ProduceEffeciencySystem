/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

/**
 *
 * @author lenovo
 */
public class FinishedComponent {
    private String componentName;
    private int finishedNum;
    private float workLoad;
    private float avgWorkLoad;

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getFinishedNum() {
        return finishedNum;
    }

    public void setFinishedNum(int finishedNum) {
        this.finishedNum = finishedNum;
    }

    public float getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(float workLoad) {
        this.workLoad = workLoad;
    }

    public float getAvgWorkLoad() {
        return avgWorkLoad;
    }

    public void setAvgWorkLoad(float avgWorkLoad) {
        this.avgWorkLoad = avgWorkLoad;
    }
    
    
}
