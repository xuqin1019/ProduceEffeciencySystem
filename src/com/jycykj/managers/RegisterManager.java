/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.UserDao;
import com.jycykj.gui.RegisterUserPanel;
import com.jycykj.helper.Util;
import com.jycykj.model.User;
/**
 *
 * @author lenovo
 */
public class RegisterManager {
    
    private String errorMessage;
    
    private UserDao userDao;
    
    private static RegisterManager registerManager;
    
    private RegisterUserPanel registerUserPanel;
    
    
    private RegisterManager(RegisterUserPanel registerUserPanel) {
        userDao = UserDao.getInstance();
        this.registerUserPanel = registerUserPanel; 
    }
    
    public static RegisterManager newInstance(RegisterUserPanel registerUserPanel) {
        if(registerManager==null) {
            registerManager = new RegisterManager(registerUserPanel);
        }
        return registerManager;
    }
    
    public boolean varify() {
        if(isEmpty(registerUserPanel.getUserTextField().getText().trim())) {
            Util.showMessageDialogWithTitle(registerUserPanel, "警告","用户名不能为空");
            return false;
        } else if(isEmpty(registerUserPanel.getPasswordField().getText()) || isEmpty(registerUserPanel.getPasswordAgainField().getText())) {
            Util.showMessageDialogWithTitle(registerUserPanel, "警告","密码不能为空");
            return false;
        } else if(!registerUserPanel.getPasswordField().getText().equals(registerUserPanel.getPasswordAgainField().getText())) {
             Util.showMessageDialogWithTitle(registerUserPanel, "警告","两次输入密码不一致");
             return false;
        } 
        return true;
    }
    
    public boolean createUser() {
        User user = new User();
        user.setName(registerUserPanel.getUserTextField().getText().trim());
        user.setPassword(registerUserPanel.getPasswordField().getText());
        if(registerUserPanel.getOperatorRadioButton().isSelected()) {
            user.setRole(0);
        } else {
            user.setRole(1);
        }
        boolean success = userDao.create(user);
        errorMessage = userDao.getErrorMessage();
        return success;
    } 
    
    private boolean isEmpty(String str) {
        return str.trim().equals("");
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
