import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class MyFrame extends JFrame {
 
       JPanel mainPanel = new JPanel();
       JButton add = new JButton();
       JButton left = new JButton();
       JButton right = new JButton();
       JLabel label = new JLabel();
       JTextField field = new JTextField();
       DefaultListModel leftModel = new DefaultListModel();
       DefaultListModel rightMOdel = new DefaultListModel();
       JList leftList = new JList(leftModel);
       JList rightList = new JList(rightMOdel);
 
       JPanel left_Right_Panel = new JPanel();
 
       public MyFrame() {
              this.setTitle("test");
              this.setPreferredSize(new Dimension(600, 400));
              this.initComponent();
              this.addData();
              this.setVisible(true);
              this.pack();
       }
 
       /**
        * 初始化组件
        */
       private void initComponent() {
 
              label.setText("添加选项：");
              add.setText("添加");
              leftList.setPreferredSize(new Dimension(150, 150));
              rightList.setPreferredSize(leftList.getPreferredSize());
              left.setText("左");
              right.setText("右");
              mainPanel.setBorder(BorderFactory.createTitledBorder("左右选择框"));
              mainPanel.setLayout(new GridBagLayout());
 
              GridBagConstraints c = new GridBagConstraints();
 
              c.gridx = 0; // 0行0列
              c.gridy = 0;
              c.gridwidth = 1;
              c.gridheight = 1;
              c.fill = GridBagConstraints.HORIZONTAL;
              c.weightx = 0;
              c.weighty = 0;
              mainPanel.add(label, c);
 
              c.gridx++;
              c.weightx = 1;
              mainPanel.add(field, c);
 
              c.gridx++;
              c.weightx = 0;
              c.gridwidth = 1;
              c.gridheight = 1;
              // c.fill = GridBagConstraints.HORIZONTAL;
              mainPanel.add(add, c);
 
              c.gridx = 0;
              c.gridy = 1;
              c.weightx = 1;
              c.weighty = 1;
              c.gridwidth = 2;
              c.gridheight = 2;
              c.fill = GridBagConstraints.BOTH;
              mainPanel.add(leftList, c);
 
              c.gridx = 2;
              c.gridy = 1;
              c.gridwidth = 1;
              c.gridheight = 1;
              c.weightx = 0;
              c.weighty = 0.5;
              c.anchor = GridBagConstraints.SOUTH;
              c.fill = GridBagConstraints.HORIZONTAL;
              mainPanel.add(left, c);
 
              c.gridx = 2;
              c.gridy = 2;
              c.anchor = GridBagConstraints.NORTH;
              c.fill = GridBagConstraints.HORIZONTAL;
              mainPanel.add(right, c);
 
              c.gridx = 3;
              c.gridy = 1;
              c.gridwidth = 1;
              c.gridheight = 2;
              c.weightx = 1;
              c.weighty = 1;
              c.fill = GridBagConstraints.BOTH;
              mainPanel.add(rightList, c);
 
              this.getContentPane().add(mainPanel);
 
       }
 
       private void addData() {
              add.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            addItem();
                     }
 
              });
 
              left.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            leftItem();
                     }
 
              });
 
              right.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            rightItem();
                     }
 
              });
       }
 
       /**
        * 增加项
        */
       private void addItem() {
              if (field.getText() != null && !field.getText().equals("")) {
                     ((DefaultListModel) leftList.getModel()).addElement(field.getText());
                     field.setText("");
              }
       }
 
       /**
        * 左移项
        */
       private void leftItem() {
              if (rightList.getSelectedIndex() != -1) {
                     Object o = rightList.getSelectedValue();
                     ((DefaultListModel) rightList.getModel()).remove(rightList
                                   .getSelectedIndex());
                     ((DefaultListModel) leftList.getModel()).addElement(o);
              }
       }
 
       /**
        * 右移项
        */
       private void rightItem() {
              if (leftList.getSelectedIndex() != -1) {
                     Object o = leftList.getSelectedValue();
                     ((DefaultListModel) leftList.getModel()).remove(leftList
                                   .getSelectedIndex());
                     ((DefaultListModel) rightList.getModel()).addElement(o);
              }
 
       }
 
       public static void main(String args[]) {
              try {
                     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              } catch (ClassNotFoundException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (InstantiationException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (IllegalAccessException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (UnsupportedLookAndFeelException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              MyFrame frame = new MyFrame();
       }
 
}