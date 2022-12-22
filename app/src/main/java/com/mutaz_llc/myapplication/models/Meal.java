package com.mutaz_llc.myapplication.models;

public class Meal {
    protected String uid;
    String name,imageUrl,description;
    double price;
    int count;
    boolean isAvailable;


    public Meal(String uid, String name, String imageUrl, String description, double price, boolean isAvailable) {
        this.uid = uid;
        this.name = name;
        this.imageUrl=imageUrl;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.count=0;
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

    public double getPrice() {
        return price;
    }
    public String getPriceString() {
        String beforeP = Double.toString(price).split(".")[0];
        String afterP = Double.toString(price).split(".")[1];
        return afterP.length()>1?beforeP+"."+afterP.charAt(0):beforeP;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
