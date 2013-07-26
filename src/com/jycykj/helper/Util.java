/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.helper;

import com.jycykj.model.ProducedProcedure;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lenovo
 */
public class Util {

   
    
    public static enum Error{
        BatchNameError,ProcedureNameError,FactorError,WorkerNameError,PassedNumError,FailedNumError,DateError, Success
    }
    
    public static boolean isEmpty(String str) {
        return str.equals("");
    }
    
    public static void showMessageDialog(Component component,String message) {
        JOptionPane.showMessageDialog(component, message);
    } 
    
    public static void showMessageDialogWithTitle(Component component,String title,String message) {
        JOptionPane.showMessageDialog(component, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showConfirmDialog(Component component,String message) {
        JOptionPane.showConfirmDialog(component,message);
    }
    
    public static void showScrollMessageDialogWithTitle(Component component , String title, String message) {
        JTextArea textArea = new JTextArea(10,35);
        textArea.setText(message);
        textArea.setEditable(false);
        // wrap a scrollpane around it
        JScrollPane scrollPane = new JScrollPane(textArea);
        // display them in a message dialog
        JOptionPane.showMessageDialog(component, scrollPane, "警告", JOptionPane.WARNING_MESSAGE);
    }
    
    public static Date parseDateString(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String date2Str(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }
    
    

    public static Error valid(ProducedProcedure producedProcedure) {
        if(producedProcedure.getComponent().getBatchName()==null) {
            return Error.BatchNameError;
        } else if(producedProcedure.getProcedure().getProcedureName()==null) {
            return Error.ProcedureNameError;
        } else if(producedProcedure.getProcedure().getFactor()==0.0f) {
            return Error.FactorError;
        } else if(producedProcedure.getOperator().getWorkerName()==null) {
            return Error.WorkerNameError;
        } else if(producedProcedure.getPassedNum()<0) {
            return Error.PassedNumError;
        } else if(producedProcedure.getFailedNum()<0) {
            return Error.FailedNumError;
        } else if(producedProcedure.getDate()==null) {
            return Error.DateError;
        }
        return Error.Success;
    }
    
    public static void setupAutoComplete(final JTextField txtInput, final List<String> popitems) {
                                System.out.print("reset : ");
                                for(String str : popitems) {
                                    System.out.print(str + " and ");
                                }
                                System.out.println();
                final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		setAdjusting(cbInput, false);
		for (String item : popitems) {
                    model.addElement(item);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
                                            txtInput.setText(cbInput.getSelectedItem().toString());
                                        }
                                }
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                                
                                                if(cbInput!=null && cbInput.getSelectedItem()!=null) {
                                                    txtInput.setText(cbInput.getSelectedItem().toString());
                                                } 
                                                
                                                //按下回车时触发loseFocuse事件来更新table model
                                                txtInput.setFocusable(false);   
                                                txtInput.setFocusable(true);
                                                cbInput.setPopupVisible(false);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
                                updateList();
                              //  System.out.println("insertUpdate");
			}

			public void removeUpdate(DocumentEvent e) {
                                updateList();
                             //   System.out.println("removeUpdate");
			}

			public void changedUpdate(DocumentEvent e) {
                                updateList();
                             //   System.out.println("changedUpdate");
			}

			private void updateList() {
                                setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
                                        for (String item : popitems) {
                                                System.out.print(item + " updateList ");
					//	if (item.toLowerCase().startsWith(input.toLowerCase()) && !item.toLowerCase().equals(input.toLowerCase())) {
                                                if (item.toLowerCase().startsWith(input.toLowerCase())) {    
							model.addElement(item);
						}
                                        }
                                        System.out.println();
				}
                                
                               cbInput.setPopupVisible(model.getSize() > 0);
                               setAdjusting(cbInput, false);
                               
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);
                
                
	}
    
         private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}
         
         private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}
}
