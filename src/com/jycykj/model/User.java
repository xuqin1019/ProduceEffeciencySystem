/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

/**
 *
 * @author lenovo
 */

public class User {
    private static final int Operator=0;
    private static final int Admin=1;
    
 //   private int id;
    private String name;
    private String password;
    private int role=Operator;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
   
}
