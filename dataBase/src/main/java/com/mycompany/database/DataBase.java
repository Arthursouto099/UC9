/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.database;
import java.sql.Connection;
/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class DataBase {

    public static void main(String[] args) {
       ConexaoSQLite myConnection = new ConexaoSQLite();
       Connection connection =  myConnection.conectar();
       

        
        
       
    }
}
