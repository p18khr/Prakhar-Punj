package com.training.nagarro.services;

import com.training.nagarro.controller.DerivedUserInput;

public class CheckData {

    public void validatePreference(String preference){
        if(!(preference.equalsIgnoreCase("Ratingandprice")||
                preference.equalsIgnoreCase("ratingprice")||
                preference.equalsIgnoreCase("priceandrating")||
                preference.equalsIgnoreCase("pricerating")||
                preference.equalsIgnoreCase("both") ||
                preference.equalsIgnoreCase("price") ||
                preference.equalsIgnoreCase("rating"))){

            System.out.println("Enter only price,rating or price and rating as preference");
            DerivedUserInput du = new DerivedUserInput();
            du.preferenceInput();
        }

    }
    public void validateSize(String s){
        if(!(s.equalsIgnoreCase("s") || s.equalsIgnoreCase("m") ||
        s.equalsIgnoreCase("l") || s.equalsIgnoreCase("xl") ||
        s.equalsIgnoreCase("xxl"))){

            System.out.println("Enter only S,M,L,XL,XXL");
            DerivedUserInput du = new DerivedUserInput();
            du.sizeInput();
        }
        else{

        }
    }

    public void validateGender(String g){
        if(!(g.equalsIgnoreCase("m") || g.equalsIgnoreCase("f")||
                g.equalsIgnoreCase("u"))){
            System.out.println("Enter only M | F | U");
            DerivedUserInput du = new DerivedUserInput();
            du.genderInput();
        }
    }

    public void validateColor(String color){

        if(!color.matches("^[A-Za-z]*$")){
            System.out.println("Use only alphabets");

            DerivedUserInput du = new DerivedUserInput();
            du.colorInput();
        }
    }

}
