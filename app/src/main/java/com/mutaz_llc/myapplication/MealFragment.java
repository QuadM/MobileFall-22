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

import com.mutaz_llc.myapplication.adapters.MealsRecyclerAdapter;
import com.mutaz_llc.myapplication.models.Meal;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.models.User;
import com.mutaz_llc.myapplication.placeholder.PlaceholderContent;

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
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_list, container, false);

        // Set the adapter

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInit();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MealsRecyclerAdapter(context, mealList));
        }
    }

    private void dataInit() {

        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();

        User user1 = new User(uid, "Mutaz@123", "Mutaz-123@gmail.com", "Mutaz123");
        User users[] = {user1};
        mealList = new ArrayList<>();
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
        mealList.add(new Meal(uid, "sandwich fool", "", "description", 5, true));
    }
}