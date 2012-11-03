/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.UserDao;
import com.jycykj.gui.LoginWindow;
import com.jycykj.helper.Util;
import com.jycykj.model.User;

/**
 *
 * @author lenovo
 */
public class LoginManager {
    private boolean Varified=false;
    private User user;
    private UserDao userDao;
    
    private static LoginManager loginManager=null;
    
    private LoginWindow loginFrame = null;
    
    public static LoginManager newInstance(LoginWindow loginFrame) {
        if(loginManager==null) {
            loginManager = new LoginManager(loginFrame);
        }
        return loginManager;
    }
    
   
    private LoginManager(LoginWindow loginFrame) {
        this.loginFrame = loginFrame;
        userDao = UserDao.getInstance();
    }
    
    public boolean checkFields() {
        if(Util.isEmpty(loginFrame.getNameTextField().getText().trim())) {
            Util.showMessageDialogWithTitle(loginFrame, "警告", "用户名不可以为空");
            return false;
        }
        if(Util.isEmpty(loginFrame.getPasswordTextField().getText())) {
            Util.showMessageDialogWithTitle(loginFrame, "警告", "密码不可以为空");
            return false;
        }
        return true;
    }
    
    public boolean varify(User user) {
        return userDao.find(user);
    }
    
    public boolean isVarified() {
        return Varified;
    }

    public void setVarified(boolean Varified) {
        this.Varified = Varified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
            
}
