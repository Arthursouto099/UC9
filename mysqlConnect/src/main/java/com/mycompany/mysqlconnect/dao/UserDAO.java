/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mysqlconnect.dao;

import com.mycompany.mysqlconnect.dataBase.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.mysqlconnect.model.User;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.ResultSet;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UserDAO {

    public static boolean createUser(User user) {
        String sql = "INSERT INTO users (email, password) values(?, ?)";
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (PreparedStatement pstmt = ConnectionSQL.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, hashPassword);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean login(User user) {
        String sql = "SELECT password FROM users WHERE email = ?";

        try (PreparedStatement pstmt = ConnectionSQL.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                boolean isPassword = BCrypt.checkpw(user.getPassword(), result.getString("password"));
                if (isPassword) {
                    System.out.println("logado com sucesso");
                    return true;
                } else {
                    throw new SQLException("Senha incorreta");
                }
            } else {
                throw new  SQLException("Usuario não encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;

    }
    
    
    
    
    
    
 public static User findUserByEmail(String email) {
     String sql = "SELECT * FROM users WHERE email = ?";
     
     try(PreparedStatement pstmt = ConnectionSQL.connect().prepareStatement(sql)) {
         pstmt.setString(1, email);
         ResultSet result = pstmt.executeQuery();
         
         if(result.next()) {
             User  u = new User(result.getString("email"), result.getString("password"));
             u.setId(result.getInt("id"));
             return  u;
         }
         
         else {
             throw new SQLException("Usuario não eonctrado");
         }
         
         
     } catch (SQLException e) {
         System.out.println(e.getMessage());
         return  null;
     }
     
     
 }
 
 
 public static  boolean updatePassword(String email, String password) {
     String sql = "UPDATE users SET password = ? WHERE email = ?";
     String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
     
     
            try(PreparedStatement p = ConnectionSQL.connect().prepareStatement(sql)) {
                p.setString(1, hashPassword);
                p.setString(2, email);
                return  p.executeUpdate() > 0;
                    
                
                
                
            } catch (Exception e) {
                e.printStackTrace();
                return  false;
            }
 }

}
