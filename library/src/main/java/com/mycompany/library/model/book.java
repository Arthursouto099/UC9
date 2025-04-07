/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

/**
 *
 * @author Usuario
 */
public class book {
    int id;
    String title;
    String author;
    double price;
    int yerar;

    public book(String title, String author, double price, int yerar) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yerar = yerar;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYerar() {
        return yerar;
    }

    public void setYerar(int yerar) {
        this.yerar = yerar;
    }
   
   
}
