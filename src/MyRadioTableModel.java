
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class MyRadioTableModel extends AbstractTableModel{
    private List<Integer> indexes = new ArrayList<Integer>();
    
    
    String [] headers = new String[]{"Question","Answer"};
    //Class [] types = new Class[]{Integer.class,MyRadioPanel.class};
     Class [] types = new Class[]{Integer.class,Integer.class};

    public MyRadioTableModel() {
        indexes.add(0);
        indexes.add(0);
    }
     
     
     @Override
    public int getRowCount() {
       return 2;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==1) {
            return indexes.get(rowIndex);
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1) {
            
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
       return headers[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    
}
