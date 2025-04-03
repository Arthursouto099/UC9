/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;
import java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.bookstore.model.Book;
import  javax.swing.JOptionPane;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BooksDAO {
    public static void insertBook(Book book, Connection connection) {
        
        String sql = "insert into books (title, author, price, year) values (?, ?, ?, ?)";
        
        try(PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, book.getTitle());
            psmt.setString(2, book.getAuthor());
            psmt.setDouble(3, book.getPrice());
            psmt.setInt(4, book.getYear());
            
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User created susseful");
            
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "erro" + " " + e.getMessage());
        }
        
        
    }
    
    
    public static void updateBook(Connection connection, int id, String title, String author, double price, int year) {
        String sql = "UPDATE books SET title = ?, author = ?, price = ?, year = ? where id = ?";
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setDouble(3, price );
            stmt.setInt(4, year);
            stmt.setInt(5, id);
            
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }   

}
