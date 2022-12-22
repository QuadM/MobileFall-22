package com.mutaz_llc.myapplication.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Map;

public class Order {
    protected String uid;
    double totalPrice;
    String userId;
    Map<Meal,Double> content; // < the Meal , number/count purchased of that meal >

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Order(String uid, String userId, Map<Meal, Double> content) {
        this.uid = uid;
        this.userId = userId;
        this.content = content;
        this.totalPrice = 0;
        if(!content.isEmpty()){
            content.forEach((meal, count) -> {totalPrice+=meal.price*count;});
        }

    }
}
