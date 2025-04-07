/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookstore;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import com.mycompany.bookstore.dataBase.CreateTable;
import java.sql.Connection;
import com.mycompany.bookstore.model.Book;
import com.mycompany.bookstore.dao.BooksDAO;
 
/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BookStore {

    public static void main(String[] args) {
       
        ConnectionSQL connect = new ConnectionSQL();
        Connection  connection = connect.connect();
        
        
        
        
        BooksDAO.findBook(connection,2);
   
        
        
        
    }
}
