/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.controller;

import com.mycompany.registerclient.controller.AddressController;
import com.mycompany.registerclient.model.Address;
import com.mycompany.registerclient.dao.AddressDao;
import org.json.JSONObject;
import com.mycompany.registerclient.service.ViaCep;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class AddressController {

    public static String register(String cep, String estado, String bairro, String logradouro, String localidade) {
        String isCode = AddressDao.registerAddress(new Address(cep, estado, bairro, logradouro, localidade));
        if (!isCode.equals("CODE NÃO GERADO, ERRO INTERNO")) {
            return isCode + ":" + "ENDEREÇO CADASTRADO COM SUCESSO";
        } else {
            return "INTERNAL ERROR";
        }
    }

    public static Address getByCode(String code) {
        return AddressDao.getAddressByCode(code);
    }
    
    
    public  static boolean deleteAddress(String code_address) {
        return AddressDao.removeAddress(code_address);
    }
    
    public  static boolean editAddress(String code_address, String cep, String estado, String bairro, String logradouro, String localidade ) {
        return AddressDao.editAddress(code_address, new Address(cep, estado, bairro, logradouro, localidade));
    }
    
    public static Address  getAddressByIdClient(int id) {
        return AddressDao.getAddressByIdClient(id);
    }

    public static Address getAddressByCEP(String cep) throws Exception {
        JSONObject addressJson = ViaCep.buscarCep(cep);

        // Verifica se a resposta contém a chave "erro" (CEP inválido)
        if (addressJson.has("erro")) {
            return null;
        }

        // Cria e retorna um objeto Endereco com os dados obtidos
        return new Address(cep, addressJson.getString("estado"), addressJson.getString("bairro"), addressJson.getString("logradouro"), addressJson.getString("localidade"));
    }
}
