package com.mutaz_llc.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.mutaz_llc.myapplication.adapters.RestaurantsRecyclerAdapter;
import com.mutaz_llc.myapplication.data.DAORestaurant;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.ui.main.LoginFragment;

/**
 * A fragment representing a list of Items.
 */
public class RestaurantFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "restaurantList";
    // TODO: Customize parameters
    private Bundle b;
//    private ArrayList<Restaurant> restaurantList;

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RestaurantsRecyclerAdapter adapter;
    DAORestaurant daoRestaurant;

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



        Context context = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.restaurant_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        daoRestaurant = new DAORestaurant();
        FirebaseRecyclerOptions<Restaurant> restaurantOptions = new FirebaseRecyclerOptions.Builder<Restaurant>()
                .setQuery(daoRestaurant.getAll(), new SnapshotParser<Restaurant>() {
                    @NonNull
                    @Override
                    public Restaurant parseSnapshot(@NonNull DataSnapshot snapshot) {
                        Restaurant r = snapshot.getValue(Restaurant.class);
                        return r;
                    }
                }).build();
        adapter = new RestaurantsRecyclerAdapter(context, restaurantOptions, R.id.restaurant_list);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View logout_button = getActivity().findViewById(R.id.logout_button);
        logout_button.setVisibility(view.VISIBLE);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                LoginFragment lf = LoginFragment.newInstance();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).replace(R.id.main_container,lf).commit();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override
    public void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

//   private void dataInitialization() {
//        UUID uuid = UUID.randomUUID();
//        String uid = uuid.toString();
//
//        User user1 = new User(uid, "Mutaz@123", "Mutaz-123@gmail.com", "Mutaz123");
//        User users[] = {user1};
//        ArrayList<Meal> mealList;
//
//        mealList = new ArrayList<>();
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//
//        restaurantList = new ArrayList<>();
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//        restaurantList.add(new Restaurant(uid, 3.2, "nagaf", "", "description", user1, mealList));
//
//
//    }
}