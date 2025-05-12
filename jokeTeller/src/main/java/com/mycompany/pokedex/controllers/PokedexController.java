/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedex.controllers;
import com.mycompany.pokedex.services.getPokemonsForAPI;
import com.mycompany.pokedex.model.Pokemon;
import java.util.ArrayList;
import org.json.*;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class PokedexController {
    public  static Pokemon  findPokemon(String pokemon) {
        
        ArrayList<String> abilitesToArray = new ArrayList<>();

        JSONObject response = getPokemonsForAPI.getPokemon(pokemon);
        
        if(response == null) return null;
        

        JSONArray forms = response.getJSONArray("forms");
        
        String name = forms.getJSONObject(0).getString("name");
        int heigth = response.getInt("height");
        
        JSONArray abilities = response.getJSONArray("abilities");
        
        for (int i = 0; i < abilities.length(); i++) {
            JSONObject ability = abilities.getJSONObject(i);
            JSONObject abilityObject = ability.getJSONObject("ability");
            abilitesToArray.add(abilityObject.getString("name"));
        }
        
        
        
       
  
        
    


        
        return new  Pokemon(name, abilitesToArray, heigth);
        
        
    }
}
