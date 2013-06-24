
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class MyRadioPanel  extends JPanel {
     private JRadioButton[] buttons = new JRadioButton[3];
     
     public MyRadioPanel(String[] strButtonText) {
        for(int i=0;i<buttons.length;++i) {
            buttons[i] = new JRadioButton(strButtonText[i]);
            add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JRadioButton jRadioButton = (JRadioButton) e.getSource();
                    int index = Arrays.asList(buttons).indexOf(jRadioButton);
                    setSelectedIndex(index);
                    System.out.println("clicked");
                }
            });
        }
        
        
        
     }
     
    public JRadioButton[] getButtons() {
       return buttons;
    }

    public void setSelectedIndex(int index) {
       for (int i = 0; i < buttons.length; i++) {
           buttons[i].setSelected(i == index);
       }
    }
    
   public int getSelectedIndex() {
       for(int i=0;i<buttons.length;++i) {
           if(buttons[i].isSelected()) {
               return i;
           }
       }
       return 0;
   }
   
   
   
}
