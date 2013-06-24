
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class MyRadioCellRenderer extends MyRadioPanel implements TableCellRenderer {
    
    public MyRadioCellRenderer(String[] strButtonTexts) {
        super(strButtonTexts);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Integer) {
            setSelectedIndex(((Integer) value).intValue());
        }
        return this;
    }
    
}
