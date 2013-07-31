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
public class Component {
    private String componentId;
    private String batchName;
    
    private String name;          
    private String material;
    private String size;
    private String manufacturer;
    private List<String> procedures;

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchId) {
        this.batchName = batchId;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }

    public boolean valid() {
        return (componentId!=null && !componentId.equals("")) && 
                (name!=null && !name.equals(""));
    }
}
