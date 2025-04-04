/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.database;
import java.sql.Connection;
import java.sql.Statement;
import java

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class CreateTable {
    
    public static void createTables(Connection connection) {
        
        String sql = "CREATE TABLE book IF NOT EXISTS ("
                + "id INT PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "title VARCHAR(100) NOT NULL "
                + "author VARCHAR(100) NOT NULL"
                + "price REAL NOT NULL,"
                + "year INT NOT NULL)";
        
//        try(Statement stmt = connection.prepareStatement(sql)) {
//            
//        }
//        catch() {
//            
//        }
        
        
    }
}
