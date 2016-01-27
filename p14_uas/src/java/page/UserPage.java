/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

/**
 *
 * @author Putra Sudaryanto
 */
import java.sql.*;
import java.util.*;
import model.UserModel;
import dbase.Database;

public class UserPage {
    private Connection connection;
    
    public UserPage() {
        connection = Database.getConnection();
    }
    
    public void checkUser(UserModel user) {
        try {
            PreparedStatement ps = connection.prepareStatement("select uname from users where uname = ?");
            ps.setString(1, user.getUname());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // found        
                updateUser(user);
            } else {
                addUser(user);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }
    
    public void addUser(UserModel user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(uname, password, email, registeredon) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, new java.sql.Date(user.getRegisteredon().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(String userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where uname=?");
            // Parameters start with 1
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(UserModel user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set password=?, email=?, registeredon=?"
            + "where uname=?");
            // Parameters start with 1
            System.out.println(new java.sql.Date(user.getRegisteredon().getTime()));
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(user.getRegisteredon().getTime()));
            preparedStatement.setString(4, user.getUname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<UserModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRegisteredon(rs.getDate("registeredon"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public UserModel getUserById(String userId) {
        UserModel user = new UserModel();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where uname=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRegisteredon(rs.getDate("registeredon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
