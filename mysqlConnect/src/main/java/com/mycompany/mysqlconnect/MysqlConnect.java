/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mysqlconnect;
import com.mycompany.mysqlconnect.dao.UserDAO;
import  com.mycompany.mysqlconnect.dataBase.ConnectionSQL;
import com.mycompany.mysqlconnect.model.User;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class MysqlConnect {

    public static void main(String[] args) {
       User user = new User("arthurtavares@gmail.com", "3");    
       UserDAO.login(user);
       
        
    }
}
