/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class ProducedProcedure implements Comparable<ProducedProcedure> {      //the procedure done by worker
    private Component component;      //component;
    private Procedure procedure;      //procedure
    private Worker operator;
    private int passedNum;            //passed num
    private int failedNum;            //failed num
    private Date date;                 //date                  
  
    public ProducedProcedure(Component component, Procedure procedure, Worker operator) {
        this.component = component;
        this.procedure = procedure;
        this.operator = operator;
    }

    public ProducedProcedure() {
       
    }
    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Worker getOperator() {
        return operator;
    }

    public void setOperator(Worker operator) {
        this.operator = operator;
    }

    
    
    public int getPassedNum() {
        return passedNum;
    }

    public void setPassedNum(int passedNum) {
        this.passedNum = passedNum;
    }

    public int getFailedNum() {
        return failedNum;
    }

    public void setFailedNum(int failedNum) {
        this.failedNum = failedNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(ProducedProcedure producedProcedure) {
        return this.getComponent().getBatchName().compareTo(producedProcedure.getComponent().getBatchName());
    }

   
}
