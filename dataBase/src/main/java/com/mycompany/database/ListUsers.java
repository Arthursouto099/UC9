/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.util.ArrayList;


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
           
           userTable += "ID | NAME | EMAIL | PASSWORD \n";
           userTable += "--------------------- \n";
           
           while(values.next()) {
               int id = values.getInt("id");
               String name = values.getString("name");
               String email = values.getString("email");
               String password = values.getString("password");
               
               userTable += "ID " + id +  " NAME: " + name + " EMAIL: " + email + "Password: " + password + "\n";
           }
           
            return userTable;
           
        } catch (Exception e) {
            System.out.println("Erro ao buscar os usuarios, " + e.getMessage());
            userTable += e.getMessage();
            return userTable;
            
        }
    }
    
      public static String getUSer(Connection connection,  String email, String password) {
       
        String user = "";
        
        String sql = "Select * from users where email = ? and password = ?";
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeQuery();
            
            ResultSet userByData = pstmt.executeQuery();
            user += userByData.getString("name") + ":";
            user += userByData.getString("email") + ":";
            user += userByData.getString("password");
            
            if(userByData.next()) {
                return user;
            }
            
            return  null;
            
           
            
            
            
            
            
        }catch(SQLException e) {
            return null;
        }
        
        
        
        
        
        
        
       
    }
    
    
    public static ArrayList<String> getEmailsAndPasswords(Connection connection) {
        
                
        ArrayList<String> emailsAsString = new ArrayList<>();
        String sqlStr = "Select email, password from users";
        
        try(PreparedStatement pstmt = connection.prepareStatement(sqlStr)) {
    
            
            ResultSet emailAndPasswordByDATA = pstmt.executeQuery();
            
            while(emailAndPasswordByDATA.next()) {
                String email = emailAndPasswordByDATA.getString("email");
                String password = emailAndPasswordByDATA.getString("password");
                
                String strFormated = "";
                
                strFormated += email;
                strFormated += ":";
                strFormated += password;
                
                emailsAsString.add(strFormated);
            }
            
            return emailsAsString;
            
            
        }
        
        catch(SQLException e) {
            System.out.println(e.getMessage());
            return emailsAsString;
        }
    }
    
}
