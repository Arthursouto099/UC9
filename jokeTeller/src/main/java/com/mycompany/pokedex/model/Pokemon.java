/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedex.model;

import java.util.ArrayList;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class Pokemon {
    private String pokemon;
    private ArrayList<String> abilites;
    private int heigth; 

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public Pokemon(String pokemon, ArrayList<String> abilites, int  heigth) {
        this.pokemon = pokemon;
        this.abilites = abilites;
        this.heigth =  heigth;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public ArrayList<String> getAbilites() {
        return abilites;
    }

    public void setAbilites(ArrayList<String> abilites) {
        this.abilites = abilites;
    }
    
    
    
}

