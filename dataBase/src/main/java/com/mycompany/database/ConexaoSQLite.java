/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ConexaoSQLite {
    
    public Connection conectar() {
        Connection conexao = null;
        
        String url = "jdbc:sqlite:usuarios.db";
        
        try {
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida");
        }
        
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conexao;
    }
}
