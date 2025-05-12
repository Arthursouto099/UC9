/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.initial_config;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ConnectionSQL {

    static final String db_url = Dotenv.load().get("DB_URL");
    static final String db_user = Dotenv.load().get("DB_USER");
    static final String db_password = Dotenv.load().get("DB_PASSWORD");

    public static Connection connect() {
        try {
            System.out.println("Conectado com sucesso");
            return DriverManager.getConnection(db_url, db_user, db_password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
