/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.dao;
import com.mycompany.registerclient.initial_config.ConnectionSQL;
import com.mycompany.registerclient.model.Client;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ClientDao {
    
    public static  boolean registerCliente(Client client) {
        
        String sql = ""; 
        if(client.getAddress() >= 1) {
               sql = "INSERT INTO client (name, email, password, address) values (?,?, ?, ?)";
        }
        else {
            sql = "INSERT INTO client (name, email, password) values (?,?, ?)";
        }
       
       
       
        
        try(PreparedStatement pt = ConnectionSQL.connect().prepareStatement(sql)) {
            pt.setString(1, client.getName());
            pt.setString(2,client.getEmail());
            pt.setString(3, BCrypt.hashpw(client.getPassword(), BCrypt.gensalt()));
            if(client.getAddress() >= 1) {
                pt.setInt(4, client.getAddress());
            }
            pt.executeUpdate();
            System.out.println("CLIENTE REGISTRADO COM SUCESSO");
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static boolean editClient(int id, Client client) {
     String  sql = "UPDATE client set name = ?, email = ?, password = ? where id = ? ";
     
     
        
       
        try(PreparedStatement pt = ConnectionSQL.connect().prepareStatement(sql)) {
            pt.setString(1, client.getName());
            pt.setString(2,client.getEmail());
            pt.setString(3, BCrypt.hashpw(client.getPassword(), BCrypt.gensalt()));
            pt.setInt(4, id);
            pt.executeUpdate();
            System.out.println("CLIENTE REGISTRADO COM SUCESSO");
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
     
     
    }
    
    
    public static  boolean deleteClient(int id_client) {
        String sql = "Delete from client where id = ?";
        
        try(PreparedStatement pr = ConnectionSQL.connect().prepareStatement(sql)) {
            pr.setInt(1, id_client);
            pr.executeUpdate();
            System.out.println("CLIENTE DELETADO COM SUCESSO");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
     public  static  boolean login(String email, String password) {
         String sql = "SELECT * FROM client where email = ?";
         
         
         try(PreparedStatement pstm = ConnectionSQL.connect().prepareStatement(sql)) {
             pstm.setString(1, email);
             
             ResultSet result = pstm.executeQuery();
             
             if(result.next()) {
                 String passwordHASH = result.getString("password");
                 
                 return  BCrypt.checkpw(password, passwordHASH);
             }
             
             return  false;
             
             
             
         } catch (SQLException e) {
             System.out.println(e.getMessage());
             return false;
         }
         
     }
    
    public static ArrayList<Client> findCLients() {
        String sql = "SELECT * FROM client";
        ArrayList<Client> list = new ArrayList<>();
        
        try(Statement st = ConnectionSQL.connect().createStatement()) {
           ResultSet result =  st.executeQuery(sql);
           
           while(result.next()) {
               int id = result.getInt("id");
               String name = result.getString("name");
               String email = result.getString("email");
               String password = result.getString("password");
               int address = result.getInt("address");
               
               Client c = new Client(email, password, name);
               c.setAddress(address);
               c.setId(id);
               list.add(c);
           }
           
           
           
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return list;
    }
    
}
