package com.training.nagarro.services;

import com.training.nagarro.models.DerivedTshirt;

import java.util.ArrayList;

public interface Filter {
    public ArrayList<DerivedTshirt> sortRating(ArrayList<DerivedTshirt> t);
    public ArrayList<DerivedTshirt> sortPrice(ArrayList<DerivedTshirt> t);
}
