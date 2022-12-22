package com.mutaz_llc.myapplication.models;

import java.util.List;

public class Restaurant {


     String uid;
    double rating;
    String name, imageUrl, description;
    User owner;
    List<Meal> meals;
    public Restaurant(){};

    public Restaurant(String uid, double rating, String name, String imageUrl, String description, User owner, List<Meal> meals) {
        this.uid = uid;
        this.rating = rating;
        this.name = name;
        this.imageUrl=imageUrl;
        this.description = description;
        this.owner = owner;
        this.meals = meals;

    }

    public String getRatingString() {
//        String beforeP = Double.toString(rating).split(".")[0];
//        String afterP = Double.toString(rating).split(".")[1];
//        return afterP.length()>1?(beforeP+"."+afterP.charAt(0)):beforeP;
        return  Double.toString(rating);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
