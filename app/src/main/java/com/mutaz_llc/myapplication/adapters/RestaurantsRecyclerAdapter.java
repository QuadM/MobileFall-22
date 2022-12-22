package com.mutaz_llc.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mutaz_llc.myapplication.MainActivity;
import com.mutaz_llc.myapplication.MealFragment;
import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.models.Restaurant;
import com.mutaz_llc.myapplication.ui.main.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RestaurantsRecyclerAdapter extends RecyclerView.Adapter<RestaurantsRecyclerAdapter.MyViewHolder> {

    private List<Restaurant> restaurantsList = new ArrayList<>();
    private final Context mContext;
    int viewId;

    public RestaurantsRecyclerAdapter(Context context, List<Restaurant> restaurantsList, int viewId){
        this.mContext = context;
        this.restaurantsList = restaurantsList;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int thisId = View.generateViewId();
        holder.container.setId(thisId);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
                MealFragment fragment = new MealFragment();
                fragmentManager.beginTransaction().replace(viewId, fragment).commit();

            }
        });
        holder.itemName.setText(restaurantsList.get(position).getName());
        holder.itemDescription.setText(restaurantsList.get(position).getDescription());
        String txt = "rating:"+restaurantsList.get(position).getRatingString();
        holder.itemRating.setText(txt);
        holder.itemImage.setImageResource(R.color.purple_500);




    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
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
