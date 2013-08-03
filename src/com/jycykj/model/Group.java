/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.model;

/**
 *
 * @author lenovo
 */
public class Group {
    private int groupId;
    private String groupName;
    private String info;

    public Group() {
    }
    
    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
     public Group(int groupId, String groupName,String info) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.info = info;
    }
    
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public boolean valid() {
       return groupName!=null && !groupName.equals("");
    }
}
