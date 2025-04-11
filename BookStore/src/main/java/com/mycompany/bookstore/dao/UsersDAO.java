/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import com.mycompany.bookstore.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.mycompany.bookstore.model.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UsersDAO {
    
    public static int SUCCESS_QUERY = 0;
    public static int FAILURE_QUERY = 1;
    public static int NOT_ROWS_UPDATEDS = 2;
    
    public static int insertUser(User user) {
         ConnectionSQL connect = new ConnectionSQL();
         Connection  connection = connect.connect();
         
         
         String sql = "insert into users(name) values (?)";
         
         try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.executeUpdate();
            System.out.println("User created!");
            
            return 0;
        } catch (Exception e) {
             System.out.println("Error" + e.getMessage());
            return 1;
        }
          
    }
    
    
    public static int addBookToUser(Book book, int idUser) {
         ConnectionSQL connect = new ConnectionSQL();
         Connection  connection = connect.connect();
         String sql = "UPDATE users SET id_book = ? WHERE id = ?";
         String sql_1 = "UPDATE books set isRented = 1  WHERE id = ?";
         
         
         try(PreparedStatement ptmt = connection.prepareStatement(sql)) {
            ptmt.setInt(1, book.getId());
            ptmt.setInt(2, idUser);
            int rowsUpdated = ptmt.executeUpdate();
            
            
             if (rowsUpdated  > 0) {
                 try(PreparedStatement ptmt_1 = connection.prepareStatement(sql_1)) {
                     ptmt_1.setInt(1, book.getId());
                     ptmt_1.executeUpdate();
                     return  SUCCESS_QUERY;
                 } catch (Exception e) {
                     return NOT_ROWS_UPDATEDS;
                 }
             }
            
        } catch (SQLException e) {
             System.out.println(e.getMessage());
             return  FAILURE_QUERY;
        }
         
         return FAILURE_QUERY;
    }
    
    
}
