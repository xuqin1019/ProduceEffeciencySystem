/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;

import com.jycykj.model.ProducedProcedure;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author lenovo
 */
 class ComponetProcedureTableListener  implements  TableModelListener {
        
        private ComponentProcedureTableModel componentProcedureTableModel;
        
        public ComponetProcedureTableListener(ComponentProcedureTableModel componentProcedureTableModel) {
            this.componentProcedureTableModel = componentProcedureTableModel;
        }
        
        @Override
        public void tableChanged(TableModelEvent e) {
            
            switch(e.getType()) {
                case TableModelEvent.INSERT : 
                    System.out.println("insert");
                  //  componentProcedureTableModel.getWorks().add(new ProducedProcedure());
               
            }
        }
        
}