/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookstore;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import java.sql.Connection;
import com.mycompany.bookstore.model.Book;
import com.mycompany.bookstore.dao.BooksDAO;
import com.mycompany.bookstore.dataBase.CreateTable;
import com.mycompany.bookstore.dao.UsersDAO;
import com.mycompany.bookstore.model.User;
import java.util.ArrayList;
 
/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BookStore {

    public static void main(String[] args) {
       

//      
//       
       ArrayList<Book> list  = BooksDAO.findBooks();
       
        for (Book book : list) {
            System.out.println(book.getInfo());
        }
   
        
        
        
    }
}
