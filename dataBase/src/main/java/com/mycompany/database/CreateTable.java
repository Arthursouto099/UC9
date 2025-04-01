package com.mycompany.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class CreateTable {

    public static void createTable(Connection connection) {

        String createTable = "Create table IF NOT EXISTS users  ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name VARCHAR(40) NOT NULL,"
                + "email VARCHAR(100) NOT NULL,"
                + "password VARCHAR(20) NOT NULL"
                + ")";

//           String createTable = "drop table users";

        try (Statement smt = connection.createStatement()) {
            smt.execute(createTable);
            System.out.println("Tabela criada com sucesso ou acessada com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao criar a tabela");

        }
    }
}
