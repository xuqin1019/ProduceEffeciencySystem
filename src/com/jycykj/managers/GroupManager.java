/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.managers;

import com.jycykj.dao.GroupDao;
import com.jycykj.dao.ProcedureDao;
import com.jycykj.model.Group;
import com.jycykj.model.Procedure;
import java.util.List;

/**
 *
 * @author xuqin
 */
public class GroupManager {
    private GroupDao groupDao = null;
    private static GroupManager groupManager = null;
    
    public static GroupManager getInstance() {
        if(groupManager==null) {
            groupManager = new GroupManager();
        }
        return groupManager;
    }
    
    private GroupManager() {
        groupDao = GroupDao.getInstance();
    }

    public List<Group> getGroups() {
        return groupDao.getGroups();
    }
    
}
