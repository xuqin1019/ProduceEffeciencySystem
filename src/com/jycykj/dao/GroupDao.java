/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.dao;

import com.jycykj.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuqin
 */
public class GroupDao {
    private String errorMessage;
    
    private static GroupDao instance = null;

    public static GroupDao getInstance() {
        if (instance == null) {
            instance = new GroupDao();
        }
        return instance;
    }

    public int getNextGroupId() {
        return -1;
    }
    
    public int getGroupId(String groupName) {
        PreparedStatement statement = null;
        Connection connection;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select group_id from `group` where name = '" + groupName +"'";
            statement = connection.prepareStatement(sql);
           
            rs = statement.executeQuery();
           
            if (rs.next()) {
               return rs.getInt(1);
            }
          
        } catch (SQLException e) {
            return -1;
        } finally {
            DBManager.close(rs, statement);
        }
        return -1;
    }
    
     public boolean executeUpdate(String sql) {
         System.out.println(sql);
         boolean success = false;
         PreparedStatement statement = null;
         Connection connection;
          try {
            connection = DBManager.getDBManager().getConnection();
            statement=connection.prepareStatement(sql);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            //success = false;
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DBManager.getDBManager().close(statement);
        }
        return success;
    }
     
     public boolean executeUpdate(String[] sqls) {
        // System.out.println(sql);
         boolean success = false;
         PreparedStatement statement = null;
         Connection connection = null;
         try {
            connection = DBManager.getDBManager().getConnection();
            connection.setAutoCommit(false);
            
            for(String sql : sqls) {
                statement=connection.prepareStatement(sql);
                statement.execute();
            }
            connection.commit();
            connection.setAutoCommit(true);
            success = true; 
        } catch (SQLException e) {
           if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch(SQLException excep) {
                    excep.printStackTrace();;
                }
            }
           errorMessage = e.getMessage();
        } finally {
            DBManager.getDBManager().close(statement);
        }
        return success;
    }
    
     public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Group> getGroups() {
        List<Group> groups = new ArrayList<Group>();
        PreparedStatement statement = null;
        Connection connection;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select group_id , name,info from `group`";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
               Group group = new Group();
               group.setGroupId(rs.getInt("group_id"));
               group.setGroupName(rs.getString("name"));
               group.setInfo(rs.getString("info"));
               groups.add(group);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return groups;
    }
}
