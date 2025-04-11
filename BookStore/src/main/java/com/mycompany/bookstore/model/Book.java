/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.model;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Book {
    private int id;
    private  String title;
    private  String author;
    private double price;
    private int  year;
    private boolean isRetend;

    public Book(String title, String author, double price, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
        this.isRetend = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsRetend() {
        return isRetend;
    }

    public void setIsRetend(boolean isRetend) {
        this.isRetend = isRetend;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    public String getInfo() {
        return  "ID: "+this.id + " TITLE: " + this.title + " AUTHOR: " + this.author + " PRICE: " + this.price + " YEAR: " + this.year + " ISRETEND: " + this.isRetend;
    }
    
    
}
