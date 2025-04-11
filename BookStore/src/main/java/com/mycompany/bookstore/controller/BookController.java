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
import java.util.ArrayList;
import  javax.swing.JOptionPane;
import javax.swing.DefaultListModel;



/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BookController {
    
    
    public static String insertBook(String title, String author, String price, String year) {
        
        try {
           int createdBook =  BooksDAO.insertBook(new Book(title, author, Double.parseDouble(price), Integer.parseInt(year)));
           
           if(createdBook == BooksDAO.SUCCESS_QUERY) { return "User created successfully";}
           else {throw new IllegalStateException();}
           
           
        }
        catch(HeadlessException | IllegalStateException  e) {
          return e.getMessage();
        }
    }
    
    
    public static  String updateBook(String id, String newTitle, String newAuthor, String newPrice, String newYear) {
        
        
        try {
           
           Book book = new Book(newTitle, newAuthor, Double.parseDouble(newPrice), Integer.parseInt(newYear));
           book.setId(Integer.parseInt(id.trim()));
           int updated = BooksDAO.updateBook(book);
           if(updated == BooksDAO.SUCCESS_QUERY) { return "User updated successfully";}
           
           return "Error";
           
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return  "Error " + e.getMessage();
        }
    }
    
    
    public static String deleteBook(String id) {
        try {
          
          int bookDeleted = BooksDAO.deleteBook(Integer.parseInt(id.trim()));
          
          if(bookDeleted == BooksDAO.SUCCESS_QUERY) {
              return "User deleted ";
          }
          else {
              return "User not finded";
          }
          
        } catch (Exception e) {
             return e.getMessage();
        }
        
        
    }
    
    
    public static ArrayList<Book> findBooks() {
        ArrayList<Book> books = new ArrayList<>();
        
        try {
            for(Book b : BooksDAO.findBooks()) {
                books.add(b);
            }
            
            
            return  books;
        }
        catch(Exception e) {
            return books;
        }
    }
    
    
}
