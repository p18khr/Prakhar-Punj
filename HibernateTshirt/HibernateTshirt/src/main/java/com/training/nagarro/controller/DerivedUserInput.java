package com.training.nagarro.controller;

import com.training.nagarro.dao.DerivedIODataBase;
import com.training.nagarro.services.CheckData;

import java.util.Scanner;

public class DerivedUserInput implements UserInput {

    public Scanner scan = new Scanner(System.in);

    @Override
    public String preferenceInput(){
        System.out.println("Enter preference: ");
        String preference = scan.next();
                                                    // ACCEPTS preference input
        CheckData cd = new CheckData();
        cd.validatePreference(preference);

        return preference;
    }
@Override
    public String sizeInput(){
        System.out.println("Enter Size: ");
        String size = scan.next();

        CheckData cd = new CheckData();                // ACCEPTS size input
        cd.validateSize(size);

        return size;
    }
@Override
    public String genderInput(){
        System.out.println("Enter Gender: ");
        String gender = scan.next();
                                               // ACCEPTS gender input
        CheckData cd = new CheckData();
        cd.validateGender(gender);

        return gender;
    }
@Override
     public String colorInput(){
         System.out.println("Enter the shirt colour: ");
         String color = scan.next();                    // ACCEPTS color input

         CheckData cd = new CheckData();
         cd.validateColor(color);
         return color;

     }
     @Override
    public void inputAcceptor(){
        String color = colorInput();
        String gender = genderInput();
        String size = sizeInput();
        String preference = preferenceInput();

         DerivedIODataBase io = new DerivedIODataBase();
         io.getData(preference,color,gender,size);

    }
}
