package com.mycompany.mysqlconnect.controller;


import javax.print.DocFlavor;
import  com.mycompany.mysqlconnect.model.User;
import  com.mycompany.mysqlconnect.dao.UserDAO;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UserController {
    
    public static String registerUser(String email, char[] password) {
        String passwordAsString = new String(password);
        boolean isSuccess = UserDAO.createUser(new User(email, passwordAsString));
        
        if (isSuccess) {
            return "Usuario criado com sucesso";
        }
        
        else {
            return "Erro ao criar usuario";
        }
        
   }
    
    public static boolean login(String email, char [] password) {
        String passwordAsString = new String(password);
        return  UserDAO.login(new User(email, passwordAsString));
    }
    

    public static ArrayList<User> getByReference(String reference) {
    
     ArrayList<User> users = UserDAO.getAllUsers();
     ArrayList<User> usersByReference = new ArrayList<>();
     
     
     for(User  u : users ) {
         if(u.getEmail().contains(reference)) {
             usersByReference.add(u);
         }
     }
     
     
     return  usersByReference;
        
}    
    
    public static  ArrayList<User> getUsers() {
        return UserDAO.getAllUsers();
    }
    
    
}
