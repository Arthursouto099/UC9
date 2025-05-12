/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerclient.model;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Address {
    private  int id;
    private  String cep;
    private String estado;
    private String bairro;
    private  String logradouro;
    private  String localidade;
    private  String code_address;

    public Address(String cep, String estado, String bairro, String logradouro, String localidade) {
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.localidade = localidade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    

    
    public String getCode_address() {
        return code_address;
    }

    public void setCode_address(String code_address) {
        this.code_address = code_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
    
    
}
