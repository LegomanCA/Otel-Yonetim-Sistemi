package project_classes;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class DBConnection {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "faruk123";
    
    public DBConnection()
    {}
    
    public static Connection getConnect() throws SQLException
    {
        return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
    
    }
    
    
    
}
