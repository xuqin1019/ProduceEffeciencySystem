
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class MyRadioCellEditor extends DefaultCellEditor implements ItemListener {
    
    private MyRadioCellRenderer panel = null;

    public void setPanel(MyRadioCellRenderer panel) {
        this.panel = panel;
    }
   
    
    public MyRadioCellEditor(MyRadioCellRenderer myRadioPanel) {
         super(new JComboBox());
         setPanel(myRadioPanel);
        JRadioButton[] buttons = panel.getButtons();
        for(int i=0;i<buttons.length;++i) {
            buttons[i].addItemListener(this);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        super.fireEditingStopped();
    }

    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Integer) {
             panel.setSelectedIndex(((Integer) value).intValue());
        }
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return new Integer(panel.getSelectedIndex());
    }
}
