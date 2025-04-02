/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UpdateUser {
    public static void updateUser(Connection connection, int id, String name, String email, String password) {
        
        try{
            String update = "Update users set name = ?, email = ?, password = ?, where id = ?";
            
            try (PreparedStatement pstmt = connection.prepareStatement(update)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setInt(4, id);
                
                int rowsUpdated = pstmt.executeUpdate();
                
                if(rowsUpdated > 0 ) {
                    System.out.println("Usuario editado com sucesso");
                }
                
                else {
                    System.out.println("Nenhum usuario foi encontrado com esse id");
                }
                
                
                
            }catch(SQLException e) {
                 System.out.println(e.getMessage());
            }
            
            
            
        }
        
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    
    public static String updateUserByEmail(Connection connection, String oldEmail, String newEmail, String password, String name) {
        String strSQL = "Update users set name = ?, email = ?, password = ? where email = ?";
        
        try(PreparedStatement pstmt = connection.prepareStatement(strSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, password);
            pstmt.setString(4, oldEmail); 
            int rowUpdated = pstmt.executeUpdate();
            
            if(rowUpdated > 0) return "Usuario editado com sucesso";
            else return "Nenhum Usuario com esse email encontrado" ;
        }
        
        catch(SQLException e) {
            return  e.getMessage();
        }
    }
}
