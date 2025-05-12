/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.model;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Client {
    private String email;
    private  String password;
    private int id;
    private String name;
    int address;

    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    
    public  Client(String email, String name) {
        this.email = email;
        this.name = name;
    }
    

    public Client(String email, String password, String name, int address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
