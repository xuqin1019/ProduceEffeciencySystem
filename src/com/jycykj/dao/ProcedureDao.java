/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.dao;

import com.jycykj.model.Procedure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xuqin
 */
public class ProcedureDao {
    private String errorMessage;
    
    private static ProcedureDao instance = null;

    public static ProcedureDao getInstance() {
        if (instance == null) {
            instance = new ProcedureDao();
        }
        return instance;
    }

    public String getNextProcedureId() {
        return "";
    }
    
    public int getProcedureId(String procedureName) {
        PreparedStatement statement = null;
        Connection connection;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select procedure_id from `procedure` where name = '" + procedureName +"'";
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
    
    public Map<String,Integer> getProceduresMap() {
        Map<String,Integer> map = new HashMap<String, Integer>();
        PreparedStatement statement = null;
        Connection connection;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select procedure_id,name from `procedure`";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()) {
                int procedure_id = rs.getInt(1);
                String name = rs.getString(2);
                map.put(name, procedure_id);
            }
          
        } catch (SQLException e) {
            errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DBManager.close(rs, statement);
        }
        return map;
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

    public List<Procedure> getProcedures() {
        List<Procedure> procedures = new ArrayList<Procedure>();
        PreparedStatement statement = null;
        Connection connection;
        ResultSet rs = null;
        try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select procedure_id , name,factor from `procedure`";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
               Procedure procedure = new Procedure();
               procedure.setProcedureId(String.valueOf(rs.getInt("procedure_id")));
               procedure.setProcedureName(rs.getString("name"));
               procedure.setFactor(rs.getFloat("factor"));
               procedures.add(procedure);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.close(rs, statement);
        }
        return procedures;
    }
}
