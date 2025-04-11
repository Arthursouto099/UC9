/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.model;
import com.mycompany.bookstore.model.Book;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class User {
       private int id;
       private String name;
       private Book retend = null;

        public User(String name) {
        this.name = name;
        if(this.retend != null) {
            this.retend.setIsRetend(true);
        }
        
        }
       
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getRetend() {
        return retend;
    }

    public void setRetend(Book retend) {
        this.retend = retend;
    }
       
       
       
       
       
       
}
