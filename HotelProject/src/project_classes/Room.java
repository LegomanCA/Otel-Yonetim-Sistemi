
package project_classes;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    int roomID;
    String roomType;
    double price;
    String status;

    Room(int id, String type, double price, String status )
    {
        this.roomID=id;
        this.roomType=type;
        this.price=price;
        this.status=status;
    }
    
    public static List<Room> getAllRooms()
    {
        List<Room> rooms = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnect()) {
            String query = "SELECT RoomID, RoomType, Price, Status FROM rooms";
            try (PreparedStatement statement = con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int roomId = resultSet.getInt("RoomID");
                    String roomType = resultSet.getString("RoomType");
                    double price = resultSet.getDouble("Price");
                    String status = resultSet.getString("Status");
                    
                    Room room = new Room(roomId, roomType, price, status);
                    rooms.add(room);
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
        }

        return rooms;
    }
    
    public static boolean updateRoom(Room room)
    {   
        try(Connection con = DBConnection.getConnect();
        PreparedStatement preparedStatement = con.prepareStatement("update rooms set RoomType = ? , Price = ? , Status = ? WHERE RoomID = ? ;")) {
            
            preparedStatement.setString(1, room.getRoomType());
            preparedStatement.setDouble(2, room.getPrice());
            preparedStatement.setString(3, room.getStatus());
            preparedStatement.setInt(4, room.getRoomId());
            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            con.close();
         
            
            return rowsUpdated > 0;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean requestRoom(int id)
    {   
        try(Connection con = DBConnection.getConnect();
        PreparedStatement preparedStatement = con.prepareStatement("update rooms set Status = 'pending' WHERE RoomID = ? ;")) {
            
            preparedStatement.setInt(1, id);
            
            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            con.close();
            
            return rowsUpdated > 0;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean reserveRoom(int id)
    {   
        try(Connection con = DBConnection.getConnect();
        PreparedStatement preparedStatement = con.prepareStatement("update rooms set Status = 'reserved' WHERE RoomID = ? ;")) {
            
            preparedStatement.setInt(1, id);
            
            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            con.close();
            
            return rowsUpdated > 0;
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public static boolean addRoom(String type, Double price, String status) {
        String query = "INSERT INTO rooms (RoomType, Price, Status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnect();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, type);
            pst.setDouble(2, price);
            pst.setString(3, status);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteRoom(int roomId) {
        String query = "DELETE FROM rooms WHERE RoomID = ?";

        try (Connection con = DBConnection.getConnect();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, roomId);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Room> getAllPendingRooms()
    {
        List<Room> rooms = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnect()) {
            String query = "SELECT RoomID, RoomType, Price, Status FROM rooms WHERE Status = 'pending' ";
            try (PreparedStatement statement = con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int roomId = resultSet.getInt("RoomID");
                    String roomType = resultSet.getString("RoomType");
                    double price = resultSet.getDouble("Price");
                    String status = resultSet.getString("Status");
                    
                    Room room = new Room(roomId, roomType, price, status);
                    rooms.add(room);
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
        }

        return rooms;
    }
    
    public static List<Room> getAllAvailableRooms()
    {
        List<Room> rooms = new ArrayList<>();
        
        try (Connection con = DBConnection.getConnect()) {
            String query = "SELECT RoomID, RoomType, Price, Status FROM rooms WHERE Status = 'available' ";
            try (PreparedStatement statement = con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int roomId = resultSet.getInt("RoomID");
                    String roomType = resultSet.getString("RoomType");
                    double price = resultSet.getDouble("Price");
                    String status = resultSet.getString("Status");
                    
                    Room room = new Room(roomId, roomType, price, status);
                    rooms.add(room);
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
        }

        return rooms;
    }
    
    public int getRoomId() {
        return roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus(){
        return status;
    }

}

    

