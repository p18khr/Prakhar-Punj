package com.training.nagarro.services;

import java.util.ArrayList;
import java.util.Collections;

import com.training.nagarro.models.DerivedTshirt;

public class DerivedFilter implements Filter {

    public ArrayList<DerivedTshirt> sortRating(ArrayList<DerivedTshirt> t){
        for(int i=0;i<t.size();i++){
            for(int j=0;j<t.size()-i-1;j++){
                if(t.get(j).getRating()<t.get(j+1).getRating()){
                    Collections.swap(t,j,j+1);
                }
            }
        }
        return t;
    }

    public ArrayList<DerivedTshirt> sortPrice(ArrayList<DerivedTshirt> t){
        for(int i=0;i<t.size();i++){
            for(int j=0;j<t.size()-i-1;j++){
                if(t.get(j).getPrice()>t.get(j+1).getPrice()){
                    Collections.swap(t,j,j+1);
                }
            }
        }
        return t;
    }

}
