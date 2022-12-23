package com.mutaz_llc.myapplication;

import android.app.Activity;
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
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.provider.FirebaseInitProvider;
import com.mutaz_llc.myapplication.adapters.MealsRecyclerAdapter;
import com.mutaz_llc.myapplication.adapters.RestaurantsRecyclerAdapter;
import com.mutaz_llc.myapplication.data.DAORestaurant;
import com.mutaz_llc.myapplication.models.Meal;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 */
public class MealFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance("https://mobile-cse431-default-rtdb.europe-west1.firebasedatabase.app/") ;
    DatabaseReference db = firebaseDatabase.getReference("Restaurant");

    Bundle bundle;
    String restaurant_id;
    DAORestaurant daoRestaurant;
    MealsRecyclerAdapter adapter;
    ArrayList<Meal> mealList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MealFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MealFragment newInstance(int columnCount) {
        MealFragment fragment = new MealFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            bundle = getArguments();
            restaurant_id = bundle.getString("restaurant_id");
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_list, container, false);

//        Context context = getActivity();
//        RecyclerView recyclerView = view.findViewById(R.id.meal_container);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        daoRestaurant = new DAORestaurant();
//        FirebaseRecyclerOptions<Restaurant> restaurantOptions = new FirebaseRecyclerOptions.Builder<Restaurant>()
//                .setQuery(daoRestaurant.getOne(restaurant_id), new SnapshotParser<Restaurant>() {
//                    @NonNull
//                    @Override
//                    public Restaurant parseSnapshot(@NonNull DataSnapshot snapshot) {
//                        Restaurant r = snapshot.getValue(Restaurant.class);
//                        mealList = r.getMeals();
//                        return r;
//                    }
//                }).build();
//
//        adapter = new MealsRecyclerAdapter(context, mealList);
//        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInit();

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            MealsRecyclerAdapter adapter = new MealsRecyclerAdapter(context, mealList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);

            db.child(restaurant_id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    ArrayList<Meal>t = task.getResult().getValue(Restaurant.class).getMeals();
                    for(Meal item: t){
                        mealList.add(item);
                        adapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private void dataInit() {

        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();

        User user1 = new User(uid, "Mutaz@123", "Mutaz-123@gmail.com", "Mutaz123");
        User users[] = {user1};
        mealList = new ArrayList<>();
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
//        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
    }
}