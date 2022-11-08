package com.training.nagarro.models;

import javax.persistence.*;

@Entity
public class DerivedTshirt implements Tshirt{

    @Id
    String id;
    String name;
    String colour;
    String gender;
    String size;
    double price;
    float rating;
    String availability;

    @Override
    public String getId() {

        return id;
    }
   @Override
    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String getName() {

        return name;
    }
    @Override
    public void setName(String name) {

        this.name = name;
    }
    @Override
    public String getColour() {

        return colour;
    }
    @Override
    public void setColour(String colour) {

        this.colour = colour;
    }
    @Override
    public String getGender() {

        return gender;
    }
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String getSize() {

        return size;
    }
    @Override
    public void setSize(String size) {

        this.size = size;
    }
    @Override
    public double getPrice() {

        return price;
    }
    @Override
    public void setPrice(double price) {

        this.price = price;
    }
    @Override
    public float getRating() {

        return rating;
    }
    @Override
    public void setRating(float rating) {

        this.rating = rating;
    }
    @Override
    public String getAvailability() {

        return availability;
    }
    @Override
    public void setAvailability(String availability) {

        this.availability = availability;
    }

}
