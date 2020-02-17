package com.empsystem.dao;

/**
 * DatabaseConnect
 * @author Michael
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    private static String user;
    private static String password;
    private static String DB_URL;

        
    public boolean connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, user, password);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // Could not connect to the database
        }
    } 

    public Connection getConnection() {
        return connection;
    }
    
    public void setDatabase(String user, String password, String DB_URL){
        Database.user = user;
        Database.password = password;
        Database.DB_URL = DB_URL;
    }
    
}



















