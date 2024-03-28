
package project_classes;



import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Employee {
    public int empId;
    public String username;
    public String password;

    public Employee(int id, String name, String pass) {
        this.empId=id;
        this.username=name;
        this.password=pass;
    }
    
    public static boolean addEmployee(String name, String pass) {
        String query = "INSERT INTO employees (empName, empPassword) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnect();
             PreparedStatement pst = con.prepareStatement(query)) {

            
            pst.setString(1, name);
            pst.setString(2, pass);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteEmployee(int empId) {
        String query = "DELETE FROM employees WHERE empID = ?";

        try (Connection con = DBConnection.getConnect();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, empId);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
