/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dataBase;
import java.sql.Connection;
import  java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class CreateTable {
    
    public static void createTables(Connection connection) {
        
        String sql = "CREATE TABLE IF NOT EXISTS books( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title VARCHAR(100) NOT NULL, "
                + "author VARCHAR(255) NOT NULL, "
                + "price REAL NOT NULL, "
                + "year INTEGER NOT NULL)";
        
        try(Statement pstmt = connection.createStatement() ) {
            pstmt.execute(sql);
            System.out.println("Table created");
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
