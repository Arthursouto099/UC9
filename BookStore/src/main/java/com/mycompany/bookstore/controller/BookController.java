/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.controller;
import java.sql.SQLException;
import  com.mycompany.bookstore.model.Book;
import com.mycompany.bookstore.dao.BooksDAO;
import java.awt.HeadlessException;
import java.sql.Connection;
import  javax.swing.JOptionPane;



/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BookController {
    
    
    public static void insertBook(Book book, Connection connection) {
        
        try {
           int createdBook =  BooksDAO.insertBook(book, connection);
           
           if(createdBook == BooksDAO.SUCCESS_QUERY) { JOptionPane.showMessageDialog(null, "User created successfully");}
           else {throw new IllegalStateException();}
           
           
        }
        catch(HeadlessException | IllegalStateException  e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
}
