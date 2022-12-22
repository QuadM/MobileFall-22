package com.mutaz_llc.myapplication.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String Uid;
    String username, password, email;
    List<Order> orders;
    List<Restaurant> favoriteRestaurants;

    public User(String uid, String username, String email, String password) {
        Uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.orders = new ArrayList<>();
        this.favoriteRestaurants = new ArrayList<>();
    }
    public User(String uid, String username, String password, String email, List<Order> orders, List<Restaurant> favoriteRestaurants) {
        Uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.orders = orders;
        this.favoriteRestaurants = favoriteRestaurants;
    }
}
