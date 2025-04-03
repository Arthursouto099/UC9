/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dataBase;
import  java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ConnectionSQL {
    
    public Connection connect() {
        
        Connection connection = null;
        String connectionStr = "jdbc:sqlite:library.db";
        
        try {
         connection = DriverManager.getConnection(connectionStr);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return connection;        
        
    }
    
    public void disconnect(Connection connection) {
        
        if(connection != null) {
            try {
                connection.close();
            }
            
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }
    
    
}
