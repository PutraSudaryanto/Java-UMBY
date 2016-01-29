/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

/**
 *
 * @author Putra Sudaryanto
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/_kampus_java_crud","root","root");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/_kampus_java_crud_simple","root","root");
            return con;
        } catch(Exception ex) {
            System.out.println("Database.getConnection() Error -->" +
            ex.getMessage());
            return null;
        }
    }
    
    public static void close(Connection con) {
        try {
            con.close();
        } catch(Exception ex) {
        }
    }
    
}
