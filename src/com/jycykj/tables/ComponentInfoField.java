/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

/**
 *
 * @author lenovo
 */
public enum ComponentInfoField {

    
    Material("Material"),
    Size("Size"),
    Manufacturer("Manufacturer"),
    Deliverer("Deliverer");
    
    private final String fName;

    @Override
    public String toString() {
        return fName;
    }

    private ComponentInfoField(String aName) {
        fName = aName;
    }

    public static ComponentInfoField valueFrom(String aText) {
        for (ComponentInfoField componentField : values()) {
            if (componentField.toString().equals(aText)) {
                return componentField;
            }
        }
        throw new IllegalArgumentException("Cannot parse into a QuoteField: " + aText);
    }
}
