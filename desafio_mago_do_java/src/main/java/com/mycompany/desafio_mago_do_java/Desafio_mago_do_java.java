/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.desafio_mago_do_java;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Desafio_mago_do_java {

    public static void main(String[] args) {
        System.out.println(reverteString("Ana"));
    }
    
    
    
    
    public static String reverteString(String str) {
        String newString = "";
        
        for(int i = str.length(); i > 0; i--) {
            newString += str.charAt(i - 1);
        }
        
        if(newString.toLowerCase().equals(str.toLowerCase())) {
            System.out.println("ela é igual de tras pra frente");
        }
        
        return  newString;
    }
    
   
}
