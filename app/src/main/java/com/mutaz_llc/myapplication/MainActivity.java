package com.mutaz_llc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.mutaz_llc.myapplication.ui.main.LoginFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager m;
    FragmentTransaction ft;
//    List<Restaurant> restaurantList = [ new Restaurant(uuid,3.2,"nagaf","","description", user1, )]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment lf = new LoginFragment();
        m = getSupportFragmentManager();
        ft = m.beginTransaction();

        ft.replace(R.id.main_container, lf)
                    .commitNow();

    }
    void changeFragment(int fragmentId,Fragment fragment){
        ft.replace(fragmentId,fragment).commitNow();
    }

}