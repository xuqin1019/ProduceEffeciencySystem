/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.dao;

/**
 *
 * @author lenovo
 */
import com.jycykj.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
   private static UserDao instance = new UserDao();
   private String errorMessage;

   public static UserDao getInstance() {
      return instance;
   }
   
   public boolean create(User user) {        //used when registed
      PreparedStatement statement = null;
      Connection connection = null;
      try {
         connection = DBManager.getDBManager().getConnection();
         String sql = "insert into system_user " + "(name,password,role) " + "values (?, ?, ?)";
         statement = connection.prepareStatement(sql);
         statement.setString(1, user.getName());
         statement.setString(2, user.getPassword());
         statement.setInt(3, user.getRole());
         statement.executeUpdate();
         return true;
      } catch (SQLException e) {
        errorMessage = e.getMessage();  
        return false;
      } finally {
         DBManager.getDBManager().close(statement);
      }
   }
   
   public boolean find(User user) {
        PreparedStatement statement = null;
        Connection connection = null;
	ResultSet rs = null;
	try {
            connection = DBManager.getDBManager().getConnection();
            String sql = "select * from system_user where name=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            rs=statement.executeQuery();
            User user_from_db = null;
            while(rs.next()) {
                user_from_db = read(rs);
            }
            return (user_from_db!=null && user_from_db.getPassword().equals(user.getPassword()) && user_from_db.getRole()==user.getRole()); 
        } catch (SQLException e) {
            errorMessage = e.getMessage();
            return false;
	} finally {
            DBManager.close(rs, statement);
	}	
    }
   
   private User read(ResultSet rs) throws SQLException {
      int id = rs.getInt("id");
      String username = rs.getString("name");
      String password = rs.getString("password");
      int role = rs.getInt("role");
      User user = new User();
      user.setId(id);
      user.setName(username);
      user.setPassword(password);
      user.setRole(role);
      return user;
   }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
