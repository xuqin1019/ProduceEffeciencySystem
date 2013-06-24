/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

/**
 *
 * @author lenovo
 */
public class Worker {
    private String workerId;
    private String workerName;
    private Group group;
    private String info;
    private int workLoad;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public boolean valid() {
     //  return workerId!=null && workerName!=null && group!=null &&
        return true;
    }

    @Override
    public String toString() {
        return "Worker{" + "workerId=" + workerId + ", workerName=" + workerName + ", group=" + group + ", info=" + info + ", workLoad=" + workLoad + '}';
    }
    
    
    
}
