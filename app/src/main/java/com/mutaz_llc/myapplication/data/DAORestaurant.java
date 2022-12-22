package com.mutaz_llc.myapplication.data;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mutaz_llc.myapplication.models.Restaurant;

import java.util.HashMap;

public class DAORestaurant {
    private DatabaseReference databaseReference;
    public DAORestaurant(){
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://mobile-cse431-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = db.getReference(Restaurant.class.getSimpleName());
    }

    public Task<Void> add(HashMap<String,Restaurant> R){ return databaseReference.push().setValue(R);}
    public Task<Void> update(String key, HashMap<String ,Object> map){
        return databaseReference.child(key).updateChildren(map);
    }
    public Task<Void> delete(String key){
        return databaseReference.child(key).removeValue();
    }
    public Query getAll(){
        return databaseReference;
    }
    public Query getEightFrom(String key){
        if(key == null){
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }
    public Query getOne(String key){
        return databaseReference.child(key);
    }

}
