/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.database;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
import java.sql.SQLException;
public class CreateTable {
    
    public static void createTables(Connection connection) {
        
        String sql = "CREATE TABLE IF NOT EXISTS book  ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "title VARCHAR(100) NOT NULL, "
                + "author VARCHAR(100) NOT NULL,"
                + "price REAL NOT NULL,"
                + "year INT NOT NULL)";
        
        try(Statement stmt = connection.createStatement()) {;;
            stmt.execute(sql);
            System.out.println("table created. succesful");
        }
        catch(SQLException e) {
            System.out.println("error, " + e.getMessage());
        }
        
        
    }
}
