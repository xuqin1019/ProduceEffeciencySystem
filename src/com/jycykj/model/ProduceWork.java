/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

import java.util.List;

/**
 *
 * @author lenovo
 */
public class ProduceWork {
    private Worker worker;
    private List<ProducedProcedure> procedures;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<ProducedProcedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<ProducedProcedure> procedures) {
        this.procedures = procedures;
    }
    
    
}
