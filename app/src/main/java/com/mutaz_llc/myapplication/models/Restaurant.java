package com.mutaz_llc.myapplication.models;

import java.util.List;

public class Restaurant {
    protected String uid;
    double rating;
    String name, imageUrl, description;
    User owner;
    List<Meal> meals;

    public Restaurant(String uid, double rating, String name, String imageUrl, String description, User owner, List<Meal> meals) {
        this.uid = uid;
        this.rating = rating;
        this.name = name;
        this.imageUrl=imageUrl;
        this.description = description;
        this.owner = owner;
        this.meals = meals;

    }

    public double getRating() {
        return rating;
    }

    public String getRatingString() {
//        String beforeP = Double.toString(rating).split(".")[0];
//        String afterP = Double.toString(rating).split(".")[1];
//        return afterP.length()>1?(beforeP+"."+afterP.charAt(0)):beforeP;
        return  Double.toString(rating);
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
