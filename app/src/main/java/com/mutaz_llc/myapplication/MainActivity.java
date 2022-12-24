package com.mutaz_llc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mutaz_llc.myapplication.models.Meal;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.models.User;
import com.mutaz_llc.myapplication.ui.main.LoginFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    FragmentManager m;
    FragmentTransaction ft;

    FirebaseDatabase db = FirebaseDatabase.getInstance("https://mobile-cse431-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference databaseReference = db.getReference("Restaurant");

    FirebaseAuth mAuth;
    View logout_button;


    HashMap<String, Restaurant> restaurantList = new HashMap<>();
    User u;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        u = new User("1", "Mutaz#123", "Mutaz@gmail.com", "password"); // --init user
//        for (int i = 0; i < 10; i++) {
//            ArrayList<Meal> mealList = new ArrayList<>();
//            for (int j = 0; j < 10; j++) {
//                String uidm = UUID.randomUUID().toString();
//                mealList.add(new Meal(uidm, "sandwich" + Integer.toString(i) + Integer.toString(j), "https://images.deliveryhero.io/image/talabat/Menuitems/20200119_Talabat_Qat_637470879621511982.jpg", "description", 35, true));
//            }
//            String uid = UUID.randomUUID().toString();
//            restaurantList.put(uid, new Restaurant(uid, i, "Nagaf " + Integer.toString(i), "https://menuegypt.com/restaurants_logos/nagf_logo.jpg", "description " + Integer.toString(i), u, mealList));
//        }   //---------- init restaurantList
//        databaseReference.setValue(restaurantList); // --- init DB
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser =  mAuth.getCurrentUser();
//        mAuth.signOut();
        setContentView(R.layout.activity_main);
        LoginFragment lf = new LoginFragment();
        RestaurantFragment rf = new RestaurantFragment();
        m = getSupportFragmentManager();
        ft = m.beginTransaction();

        logout_button = findViewById(R.id.logout_button);
        logout_button.setVisibility(View.INVISIBLE);


        ft.replace(R.id.main_container, mUser==null?lf:rf)
                .commitNow();

    }

    void changeFragment(int fragmentId, Fragment fragment) {
        ft.replace(fragmentId, fragment).commitNow();
    }


}