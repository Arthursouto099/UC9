/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;




/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class InsertUser {
    
    
    public static void insert(Connection connection, String name, String email, String password ) {
        
        String insert = "Insert into users(name, email, password) values(?,?,?)";
        
        try(PreparedStatement pstm = connection.prepareStatement(insert)) {
        pstm.setString(1, name);
        pstm.setString(2, email);
        pstm.setString(3, password);
        
        pstm.executeUpdate();
        
        System.out.println("Usuario inserido com sucesso");
        JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso");
            
            
        }catch(SQLException e) {
            System.err.println("Erro ao criar Usuario, " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
