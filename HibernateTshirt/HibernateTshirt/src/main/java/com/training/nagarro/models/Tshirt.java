package com.training.nagarro.models;

import javax.persistence.*;

@Entity
public interface Tshirt {

    @Id
    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public String getColour();

    public void setColour(String colour);

    public String getGender();

    public void setGender(String gender);
    public String getSize();

    public void setSize(String size);

    public double getPrice();

    public void setPrice(double price);

    public float getRating();

    public void setRating(float rating);

    public String getAvailability();

    public void setAvailability(String availability);

}
