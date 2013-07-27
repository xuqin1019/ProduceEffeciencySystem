/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.tables;
import com.jycykj.helper.Util;
import com.jycykj.managers.ProduceCardManager;
import com.jycykj.model.Procedure;
import com.jycykj.model.ProducedProcedure;
import com.jycykj.model.Worker;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author lenovo
 */
public class ComponentProcedureTableModel extends AbstractTableModel {

    private int previousLines=0;       //the lines that exist previous , updated when click save button on the panel
    
    private String [] headers = {"批次号","工序","系数","操作工","合格数","报废数","日期"};
    
    private Class [] types = {String.class , String.class, String.class, String.class,Integer.class,Integer.class , String.class};
 
    private boolean [] canEdit = {false,true,false,true,true,true,true,true};
    
    private List<ProducedProcedure> works = null;
    
     private List<ComponentProcedureField> fColumnMapping=null;
     
  
     private ProduceCardManager produceCardManager = null;
    
     public ComponentProcedureTableModel(String componentId,String batchName) {
        produceCardManager = ProduceCardManager.newInstance();                //single pattern
        fColumnMapping = Arrays.asList(new ComponentProcedureField [] {ComponentProcedureField.BatchId,ComponentProcedureField.Procedure,ComponentProcedureField.Factor,ComponentProcedureField.Operator,ComponentProcedureField.PassedNum,ComponentProcedureField.FailedNum,ComponentProcedureField.Date});   //
        
        works = produceCardManager.getWorks(componentId,batchName);
        Collections.sort(works);
        previousLines = works.size();
        
        this.addTableModelListener(new ComponetProcedureTableListener(this));
    }
    
    
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
       return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(rowIndex <= previousLines-1) {
            return false;
        }
        return canEdit[columnIndex];
     //   return true;
    }

    @Override
    public int getRowCount() {
        if(works==null) {
            return 0;
        }
        return works.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }
    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (rowIndex < 0 || rowIndex > getRowCount()-1) {
        throw new IllegalArgumentException("Row index is out of range: " + rowIndex);
      }
      if (columnIndex < 0 || columnIndex > getColumnCount()-1) {
        throw new IllegalArgumentException("Column index is out of range: " + columnIndex);
      }
      ProducedProcedure producedProcedure = works.get(rowIndex);
      ComponentProcedureField field = getField(columnIndex);
      return getFieldValue(producedProcedure, field);
    }
    
    private ComponentProcedureField getField(int columnIndex) {
        return (ComponentProcedureField)fColumnMapping.get(columnIndex);
    }
   
    private Object getFieldValue(ProducedProcedure producedProcedure , ComponentProcedureField componentField) {
        Object result = null;
        com.jycykj.model.Component component = producedProcedure.getComponent();
        Procedure procedure = producedProcedure.getProcedure();
        Worker operator = producedProcedure.getOperator();
        
        if(componentField == ComponentProcedureField.BatchId) {
            result = (component==null ? "" : component.getBatchName());
        } else if(componentField == ComponentProcedureField.Procedure) {
            result = (procedure==null ? "" : procedure.getProcedureName());
        } else if(componentField == ComponentProcedureField.Factor) {
            result = (procedure==null ? "" : procedure.getFactor());
        } else if(componentField == ComponentProcedureField.Operator){
            result = (operator==null ? "" : operator.getWorkerName());
        } else if(componentField == ComponentProcedureField.PassedNum) {
            result = (producedProcedure.getPassedNum()==0 ? "" : producedProcedure.getPassedNum());
        } else if(componentField == ComponentProcedureField.FailedNum) {
            result = (producedProcedure.getFailedNum()==0 ? "" : producedProcedure.getFailedNum());
        } else {
           result = (producedProcedure.getDate()==null ?  null : Util.date2Str(producedProcedure.getDate()));
           // String dateString = producedProcedure.getDate()==null ?  null : Util.date2Str(producedProcedure.getDate());
           // DateTextField dateTextField = new DateTextField();
           // dateTextField.setText(dateString==null? "":dateString);
           // result = new DatePickerPanel(dateTextField,new JButton());
            
          // result = new JDateChooser();
        }
        return result;
    }
    
    
    
    public void setWorks(List<ProducedProcedure> works) {
        this.works = works;
    }
    
    public void setfColumnMapping(List<ComponentProcedureField> fColumnMapping) {
        this.fColumnMapping = fColumnMapping;
    }

    public List<ProducedProcedure> getWorks() {
        return works;
    }

    public int getPreviousLines() {
        return previousLines;
    }

    public void setPreviousLines(int previousLines) {
        this.previousLines = previousLines;
    }
    
    public void setValueAt(Object value, int row, int col) {
        if(value!=null) {
            ComponentProcedureField field = getField(col);
            ProducedProcedure producedProcedure = works.get(row);
            if(field==ComponentProcedureField.BatchId) {
                producedProcedure.getComponent().setBatchName((String)value);
            } else if(field==ComponentProcedureField.Procedure) {
                producedProcedure.getProcedure().setProcedureName((String)value);
            } else if(field==ComponentProcedureField.Factor) {
                producedProcedure.getProcedure().setFactor((Float)value);
            } else if(field==ComponentProcedureField.Operator) {
                producedProcedure.getOperator().setWorkerName((String)value);
            } else if(field==ComponentProcedureField.PassedNum) {
                producedProcedure.setPassedNum((Integer)value);
            } else if(field ==ComponentProcedureField.FailedNum) {
                producedProcedure.setFailedNum((Integer)value);
            } else {
                if((Pattern.matches("\\d{4}-\\d{2}-\\d{2}", (String)value))) {
                     producedProcedure.setDate(Util.parseDateString((String)value));
                }
              //  producedProcedure.setDate(Util.parseDateString(((DatePickerPanel)value).getDateTextField().getText().trim()));
            }
               fireTableCellUpdated(row, col); 
        }
    }
    
    
}
