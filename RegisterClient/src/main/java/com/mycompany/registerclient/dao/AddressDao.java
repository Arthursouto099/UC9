/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.dao;
import com.mycompany.registerclient.model.Address;
import java.sql.*;
import com.mycompany.registerclient.initial_config.ConnectionSQL;
import java.util.UUID;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class AddressDao {
    public static String registerAddress(Address address) {
        String sql = "INSERT INTO address (cep,  estado,  bairro,  logradouro, localidade, code_address) values(?,?,?,?,?,?)";
        String code = UUID.randomUUID().toString();
        try(PreparedStatement pr = ConnectionSQL.connect().prepareStatement(sql)) {
           pr.setString(1, address.getCep());
           pr.setString(2, address.getEstado());
           pr.setString(3, address.getBairro());
           pr.setString(4, address.getLogradouro());
           pr.setString(5, address.getLocalidade());
           pr.setString(6, code);
           
           
           pr.executeUpdate();
           System.out.println("ENDEREÇO CRIADO COM SUCESSO");
           return  code;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return "CODE NÃO GERADO, ERRO INTERNO" ;
            
        }
    }
    
    
    
     public static Address  getAddressByIdClient(int id) {
        String sql = "select * from client c inner join address ad on c.address = ad.id where c.id = ?";
        
                
        try(PreparedStatement p = ConnectionSQL.connect().prepareStatement(sql)) {
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            
            if(r.next()) {
                Address address = new Address(
                r.getString("cep"),
                r.getString("estado"),
                r.getString("bairro"),
                r.getString("logradouro"),
                r.getString("localidade")
                );
                
                address.setId(r.getInt("id"));
                address.setCode_address(r.getString("code_address"));
                return  address;
            }
            
            return null;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        
    }
    
    
    
    public static  Address getAddressByCode(String code) {
        String sql = "Select * from address where code_address = ? ";
        
        
        try(PreparedStatement p = ConnectionSQL.connect().prepareStatement(sql)) {
            p.setString(1, code);
            ResultSet r = p.executeQuery();
            
            if(r.next()) {
                Address address = new Address(
                r.getString("cep"),
                r.getString("estado"),
                r.getString("bairro"),
                r.getString("logradouro"),
                r.getString("localidade")
                );
                
                address.setId(r.getInt("id"));
                return  address;
            }
            
            return null;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static  boolean  removeAddress(String code_address) {
        String sql = "DELETE FROM address WHERE code_address = ? ";
        
        
        try(PreparedStatement p = ConnectionSQL.connect().prepareStatement(sql)) {
            p.setString(1, code_address);
            p.executeUpdate();
            System.out.println("ENDEREÇO APAGADO COM SUCESSO");
            return  true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public  static boolean editAddress(String  code_address, Address address) {
        String sql = "UPDATE address SET cep =?, estado = ?, bairro = ?, logradouro =?, localidade =? where code_address= ?";
        
        try(PreparedStatement pr = ConnectionSQL.connect().prepareStatement(sql)) {
           pr.setString(1, address.getCep());
           pr.setString(2, address.getEstado());
           pr.setString(3, address.getBairro());
           pr.setString(4, address.getLogradouro());
           pr.setString(5, address.getLocalidade());
           pr.setString(6, code_address);
           
           pr.executeUpdate();
           System.out.println("ENDEREÇO ALTERADO COM SUCESSO");
           return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
            
        }
    }
    
}
