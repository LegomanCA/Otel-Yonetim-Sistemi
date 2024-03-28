package project_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserManager {
    
    public UserManager()
    {}
    
    public static boolean adminLogin(String username, String password) {
        try (Connection con = DBConnection.getConnect();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM admin WHERE adminName = ? AND adminPassword = ?")) {
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();  // If the result set has a next entry, the user is valid
            }
        } catch (SQLException e) { // Handle the exception according to your needs
            e.printStackTrace(); // Handle the exception according to your needs
            return false;
        }
    }
    
    public static boolean customerLogin(String email, String password) {
        try (Connection con = DBConnection.getConnect();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE email = ? AND password = ?")) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();  // If the result set has a next entry, the user is valid
            }
        } catch (SQLException e) { // Handle the exception according to your needs
            e.printStackTrace(); // Handle the exception according to your needs
            return false;
        }
    }
    
    public static boolean employeeLogin(String name, String password) {
        try (Connection con = DBConnection.getConnect();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM employees WHERE empName = ? AND empPassword = ?")) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();  // If the result set has a next entry, the user is valid
            }
        } catch (SQLException e) { // Handle the exception according to your needs
            e.printStackTrace(); // Handle the exception according to your needs
            return false;
        }
    }
    
}
