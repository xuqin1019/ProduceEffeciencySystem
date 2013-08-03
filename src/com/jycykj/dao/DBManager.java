/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/system_db_test?useUnicode=true&amp;characterEncoding=utf-8";
    private String username = "root";
    private String password = "891019";
    private Connection connection = null;
    private static DBManager dbManager = null;

    private DBManager() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DBManager getDBManager() {
        if (null == dbManager) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void close(ResultSet rs, Statement s) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(Statement s) {
        this.close(null, s);
    }
}
