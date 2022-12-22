package com.mutaz_llc.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mutaz_llc.myapplication.adapters.RestaurantsRecyclerAdapter;
import com.mutaz_llc.myapplication.models.Meal;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.models.User;
import com.mutaz_llc.myapplication.placeholder.PlaceholderContent;
import com.mutaz_llc.myapplication.ui.main.LoginFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 */
public class RestaurantFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "restaurantList";
    // TODO: Customize parameters
    private Bundle b;
    private ArrayList<Restaurant> restaurantList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    public static RestaurantFragment newInstance() {
        return new RestaurantFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            b = getArguments().getBundle(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set the adapter

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialization();
        if (view instanceof RecyclerView) {
            Context context = getActivity();
            RecyclerView recyclerView = view.findViewById(R.id.restaurant_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


            recyclerView.setAdapter(new RestaurantsRecyclerAdapter(context, restaurantList, R.id.restaurant_list));

        }
    }

    private void dataInitialization() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();

        User user1 = new User(uid, "Mutaz@123", "Mutaz-123@gmail.com", "Mutaz123");
        User users[] = {user1};
        ArrayList<Meal> mealList;

        mealList = new ArrayList<>();
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));


    }
}