/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.ProcedureDao;
import com.jycykj.model.Procedure;
import java.util.List;

/**
 *
 * @author xuqin
 */
public class ProcedureManager {
    private ProcedureDao procedureDao = null;
    private static ProcedureManager procedureManager = null;
    
    public static ProcedureManager getInstance() {
        if(procedureManager==null) {
            procedureManager = new ProcedureManager();
        }
        return procedureManager;
    }
    
    private ProcedureManager() {
        procedureDao = ProcedureDao.getInstance();
    }

    public List<Procedure> getProcedures() {
        return procedureDao.getProcedures();
    }
    
}
