/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

/**
 *
 * @author lenovo
 */
public enum ComponentProcedureField {
    
    
    BatchId("BatchId"),
    Procedure("Procedure"),
    Factor("Factor"),
    Operator("Operator"),
    PassedNum("PassedNum"),
    FailedNum("FailedNum"),
    Date("Date");
    
    private final String fName;

    @Override
    public String toString() {
        return fName;
    }

    private ComponentProcedureField(String aName) {
        fName = aName;
    }

    public static ComponentProcedureField valueFrom(String aText) {
        for (ComponentProcedureField componentProcedureField : values()) {
            if (componentProcedureField.toString().equals(aText)) {
                return componentProcedureField;
            }
        }
        throw new IllegalArgumentException("Cannot parse into a QuoteField: " + aText);
    }
}
