/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import  java.sql.ResultSet;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ListUsers {
     
    public static String listUsers(Connection connection) {
        
        String sql = "Select * from users";
        String userTable = "";
        
        
        try(Statement smt = connection.createStatement()) {
           ResultSet values = smt.executeQuery(sql);
           
           userTable += "ID | NAME | EMAIL \n";
           userTable += "--------------------- \n";
           
           while(values.next()) {
               int id = values.getInt("id");
               String name = values.getString("name");
               String email = values.getString("email");
               
               userTable += "ID " + id +  " NAME: " + name + " EMAIL: " + email + "\n";
           }
           
            return userTable;
           
        } catch (Exception e) {
            System.out.println("Erro ao buscar os usuarios, " + e.getMessage());
            userTable += e.getMessage();
            return userTable;
            
        }
    }
    
}
