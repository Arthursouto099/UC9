/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class DeleteUser {
   
    
    
    public static String deleteUSer(Connection connection, int id) {
        
        String deleteUser = "Delete from users where id = ?";
        
        try(PreparedStatement psmt = connection.prepareStatement(deleteUser)) {
            psmt.setInt(1, id);
            int rowsDeleted =  psmt.executeUpdate();
            
            if(rowsDeleted > 0) {
                return "Usuario deletado com sucesso";
            }
            
            else {
                return "Nenhum usuario com esse id foi encontrado";
            }
            
            
        }
        
        catch(SQLException e) {
            System.out.println("Erro ao deletar Usuario" + e.getMessage());
            return e.getMessage();
        }
        
    }
    
}
