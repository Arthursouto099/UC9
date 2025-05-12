/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.controller;

import com.mycompany.registerclient.model.Client;
import com.mycompany.registerclient.dao.ClientDao;
import java.util.ArrayList;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ClientController {

    public ClientController() {
    }

    public static String register(int address, String name, String email, char[] password) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (email.matches(regex)) {
            boolean isFunc = ClientDao.registerCliente(new Client(email, new String(password), name, address));
            if (isFunc) {
                return "CLIENTE CADASTRADO COM SUCESSO";
            }
            return "ERRO";
        }
        
        return  "EMAIL INVALIDO";

    }
    
    
    public  static boolean editClient(int id, String name, String email, char[] password) {
        return  ClientDao.editClient(id, new Client(email, new String(password), name));
    }
    
    public static boolean removeClient(int id) {
        return ClientDao.deleteClient(id);
    }
    
    
    public static boolean login(String email, String password) {
        return  ClientDao.login(email, password);
    }
    
    
    
    public static  ArrayList<Client> findClients() {
        return ClientDao.findCLients();
    } 
}
