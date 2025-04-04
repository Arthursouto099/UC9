/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ConnectionSQLITE {

    public Connection connectDATABASE() {
        
        Connection connectionDATABASE =null;
        
        String sql = "jdbc:sqlite:libraryDATABASE.db";
        
        try {
          connectionDATABASE = DriverManager.getConnection(sql);
          System.out.println("Connection successful");
           
            
        }
        catch(SQLException e) {
            System.out.println("Connection failed");
        }
        
        
        
        return  connectionDATABASE;
    }
    
    
    public void disconnectDATABASE(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            
        }
        
        
    }
    
}
