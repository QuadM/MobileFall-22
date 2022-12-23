package com.mutaz_llc.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mutaz_llc.myapplication.MainActivity;
import com.mutaz_llc.myapplication.MealFragment;
import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.models.Meal;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.ui.main.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RestaurantsRecyclerAdapter extends FirebaseRecyclerAdapter<Restaurant,RestaurantsRecyclerAdapter.MyViewHolder> {

    private final Context mContext;
    int viewId;

    public RestaurantsRecyclerAdapter(Context context, FirebaseRecyclerOptions<Restaurant> restaurantsList, int viewId){
        super(restaurantsList);
        this.mContext = context;
        this.viewId = viewId;
    }

    @NonNull
    @Override
    public RestaurantsRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_restaurant_item,parent,false);
        return new RestaurantsRecyclerAdapter.MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Restaurant model) {
        int thisId = View.generateViewId();
        holder.container.setId(thisId);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("restaurant_id",  model.getUid());
                FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
                MealFragment fragment = new MealFragment();
                fragment.setArguments(b);

                fragmentManager.beginTransaction().replace(R.id.main_container, fragment)
                        .addToBackStack("Restaurants")
                        .setCustomAnimations
                                (R.anim.enter_left_to_right
                                ,R.anim.exit_left_to_right
                                ,R.anim.enter_right_to_left
                                ,R.anim.exit_right_to_left)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });
        holder.itemName.setText(model.getName());
        holder.itemDescription.setText(model.getDescription());
        String txt = "rating:"+Double.toString(model.getRating());
        holder.itemRating.setText(txt);
        holder.itemImage.setImageResource(R.color.purple_500);


    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        View container;
        ImageView itemImage;
        TextView itemName, itemDescription, itemRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.restaurant_item_container);
            itemImage = itemView.findViewById(R.id.restaurant_image);
            itemName = itemView.findViewById(R.id.restaurant_name);
            itemDescription = itemView.findViewById(R.id.restaurant_description);
            itemRating = itemView.findViewById(R.id.restaurant_rating);
        }
    }

}
