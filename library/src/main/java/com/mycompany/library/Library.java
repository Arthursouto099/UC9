/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library;
import com.mycompany.library.database.ConnectionSQLITE;
import java.sql.Connection;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Library {

    public static void main(String[] args) {
        ConnectionSQLITE myIstance = new ConnectionSQLITE();
        Connection con = myIstance.connectDATABASE();
    }
}
