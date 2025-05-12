/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.initial_config;
import java.sql.*;
/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class CreateTables {
    public  static void  initTables() {
       String sql = "CREATE TABLE IF NOT EXISTS client("
               + "id INT PRIMARY KEY AUTO_INCREMENT,"
               + "name VARCHAR(40) NOT NULL,"   
               + "email  VARCHAR(40) UNIQUE NOT NULL,"
               + "password VARCHAR(300) NOT NULL,"
               + "address INT,"
               + "FOREIGN KEY (address) REFERENCES address(id));";
               
//          String sql = "CREATE TABLE IF NOT EXISTS address ("
//               + "id INT PRIMARY KEY AUTO_INCREMENT,"
//               + "cep VARCHAR(100) NOT NULL,"
//               + "estado varchar(100) not null,"
//               + "bairro VARCHAR(100) NOT NULL,"
//               + "logradouro VARCHAR(100) NOT NULL, "
//               + "localidade VARCHAR(100) NOT NULL) ;";
//       
        try(Statement s = ConnectionSQL.connect().createStatement()) {
            s.execute(sql);
            System.out.println("TABELA CRIADA COM SUCESSO");
            
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
    
    
    
    
    
}
