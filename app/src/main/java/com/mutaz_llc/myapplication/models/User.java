package com.mutaz_llc.myapplication.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String Uid;
    String username, password, email;
    List<Order> orders;
    List<Restaurant> favoriteRestaurants;

    public User(){};
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

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Restaurant> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public void setFavoriteRestaurants(List<Restaurant> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }
}
