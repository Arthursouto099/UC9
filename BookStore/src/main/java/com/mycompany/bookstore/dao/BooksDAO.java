/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.bookstore.model.Book;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BooksDAO {
    
    public static int SUCCESS_QUERY = 0;
    public static int FAILURE_QUERY = 1;
    public static int NOT_ROWS_UPDATEDS = 2;
    
    
    
    public static int insertBook(Book book) {
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        
        String sql = "insert into books (title, author, price, year) values (?, ?, ?, ?)";
        
        try(PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, book.getTitle());
            psmt.setString(2, book.getAuthor());
            psmt.setDouble(3, book.getPrice());
            psmt.setInt(4, book.getYear());
            
            psmt.executeUpdate();
            
            
            System.out.println("User created successfully");
            
            return 0;
            
        }
        catch(SQLException e) {
            System.out.println("erro" + " " + e.getMessage());
            return 1;
        }
        
        
    }
    
    
    public static int updateBook( Book book) {
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        String sql = "UPDATE books SET title = ?, author = ?, price = ?, year = ? where id = ?";
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice() );
            stmt.setInt(4, book.getYear());
            stmt.setInt(5, book.getId());
            
            int rowsUpdated = stmt.executeUpdate();
            
            if(rowsUpdated > 0) {
                System.out.println("user updated successfully");
                return 0;
               
            }
            
            else {
                return 2;
            }
            
            
        }
        catch(SQLException e) {
            System.out.println("Error " + e.getMessage());
            return 1;
        }
    }   
    
    
    public static int deleteBook(int id) {
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        String sql = "DELETE FROM books WHERE id = ?";
        
        try(PreparedStatement psmtm = connection.prepareStatement(sql)) {
            psmtm.setInt(1, id);
            
            int rowsDeleted = psmtm.executeUpdate();
            
            if(rowsDeleted > 0) {
                System.out.println("user deleted successfully");
                return 0;
            }
            
            return 2;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            return 1;
        }
    }
    
    public static String[] findBook( int id) {
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        String sql = "SELECT * FROM books WHERE id = ?";
        String[] info = new String[4];
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                info[0] = rs.getString("title");
                info[1] = rs.getString("author");
                info[2] = rs.getString("price");
                info[3] = rs.getString("year");
            }
            
            System.out.println(info[0] + " " + info[1]+ " " + info[2]+ " " + info[3]);
           
            
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return info;
    }
    
     public static ArrayList<Book> findBooks() {
         ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
          String sql = "SELECT * FROM books";
          ArrayList<Book> books = new ArrayList<>();
          
          try(Statement stmt = connection.createStatement()) {
              ResultSet rs = stmt.executeQuery(sql);
              
              while(rs.next()) {
                  Book myBook =  new Book(rs.getString("title"), rs.getString("author"), rs.getDouble("price"), rs.getInt("year"));
                  books.add(myBook);
                  
                  myBook.setId(rs.getInt("id"));
              }
              
              return  books;
          }
          catch(SQLException e) {
              System.out.println(e.getMessage());
              return  null;
          }
     }

}
