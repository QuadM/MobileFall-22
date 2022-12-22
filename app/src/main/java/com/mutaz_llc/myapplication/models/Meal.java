package com.mutaz_llc.myapplication.models;

public class Meal {
    protected String uid;
    String name,imageUrl,description;
    double price;
    int count;
    boolean isAvailable;

    public Meal(){};
    public Meal(String uid, String name, String imageUrl, String description, double price, boolean isAvailable) {
        this.uid = uid;
        this.name = name;
        this.imageUrl=imageUrl;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.count=0;
    }

    public String getPriceString() {
//        String beforeP = Double.toString(price).split(".")[0];
//        String afterP = Double.toString(price).split(".")[1];
        return Double.toString(price);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
