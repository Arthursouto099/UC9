/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedex.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;


/**
 
import org.json.JSONArray;
*
 * @author ARTHURSANTOSTAVARESS
 */
public class getPokemonsForAPI {

    public static JSONObject getPokemon(String pokemon) {

        String url = " https://pokeapi.co/api/v2/pokemon/" + pokemon;

        // Criando meu cliente http para receber as respostas do servidor
        OkHttpClient clientHTTP = new OkHttpClient();

        // Definindo a minha requisição
        Request req = new Request.Builder()
                .get()
                .url(url)
                .build();

        // executando minha requisição 
        // no caso a minha resposta quem recebe e o meu cliente http, no qual eu utlizo
        // a minha requisição como parametro da minha chamada
        try (Response res = clientHTTP.newCall(req).execute()) {
            if (!res.isSuccessful()) {
                return null;
            }
            
            // pegando o corpo da resposta do servidor no qual me conecto
            String data = res.body().string();
            
         

            // criando um json com os dados da resposta
            return new JSONObject(data);

        } catch (Exception e) {
            e.getStackTrace();
            return null;

        }

    }


}
