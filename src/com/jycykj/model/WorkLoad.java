/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

/**
 *
 * @author lenovo
 */
public class WorkLoad {
    private int rank;
    private String name;
    private float workLoad;
    private float avgWorkLoad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
