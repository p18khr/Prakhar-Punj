package com.training.nagarro.dao;

import com.training.nagarro.models.Tshirt;

import java.util.List;

public interface IODataBase {
    void insertIntoDatabase(Tshirt tshirtObj); // inserts Tshirt object in the database
    void getData(String preference,String color,String gender,String size);
                 // retrieves data from the database
    void viewData(List<Tshirt> t);  // prints the retrieved data
}
