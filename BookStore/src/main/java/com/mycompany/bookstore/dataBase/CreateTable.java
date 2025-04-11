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
    
    public static void createTables() {
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        
//        String sql = "CREATE TABLE IF NOT EXISTS books( "
//                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + "title VARCHAR(100) NOT NULL, "
//                + "author VARCHAR(255) NOT NULL, "
//                + "price REAL NOT NULL, "
//                + "year INTEGER NOT NULL)"
                
            String sql = "CREATE TABLE IF NOT EXISTS users("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(100) NOT NULL,"
                + "id_book INTEGER,"
                + "FOREIGN KEY (id_book) REFERENCES books(id) ON DELETE SET NULL)";
            
            String alterTable = "ALTER TABLE books ADD COLUMN isRented INTEGER DEFAULT 0";
        
        try(Statement pstmt = connection.createStatement() ) {
            pstmt.execute(alterTable);
            System.out.println("Table created");
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
