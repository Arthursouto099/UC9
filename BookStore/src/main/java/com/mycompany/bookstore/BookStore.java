/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookstore;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import com.mycompany.bookstore.dataBase.CreateTables;
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
        CreateTables.createTables(connection);
        Book bookTeste = new Book("Teste 1",  "Nathalia", 0, 2007);
        
        BooksDAO.updateBook(connection, 0, "junior developer", "Niguem", 50000,  2010);
        
        
        
    }
}
