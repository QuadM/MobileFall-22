package com.mutaz_llc.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mutaz_llc.myapplication.R;
import com.mutaz_llc.myapplication.models.Meal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MealsRecyclerAdapter extends RecyclerView.Adapter<MealsRecyclerAdapter.MyViewHolder> {

    private List<Meal> mealsList = new ArrayList<>();
    private final Context mContext;
    private final int width;

    public MealsRecyclerAdapter(Context context, List<Meal> mealsList,int width){
        this.mContext = context;
        this.mealsList = mealsList;
        this.width=width;
    }

    @NonNull
    @Override
    public MealsRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.fragment_meal_item,parent,false);

        return new MealsRecyclerAdapter.MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.itemName.setText(mealsList.get(position).getName());
        holder.itemDescription.setText(mealsList.get(position).getDescription());
        String txt = Double.toString(mealsList.get(position).getPrice());
        holder.itemPrice.setText(txt);
//        holder.itemImage.setImageResource(R.color.purple_500);
        Picasso.get()
                .load(mealsList.get(position).getImageUrl())
                .resize(250,250)
                .centerInside()
                .placeholder(R.drawable.global_layout)
                .into(holder.itemImage);

        holder.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mealsList.get(position).setCount(mealsList.get(position).getCount() + 1);
                holder.count.setText(Integer.toString(mealsList.get(position).getCount()));
            }
        });holder.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = mealsList.get(position).getCount();
                mealsList.get(position).setCount(count>0?count-1:count);
                holder.count.setText(Integer.toString(mealsList.get(position).getCount()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.mealsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName, itemDescription, itemPrice, count;
        Button incrementBtn, decrementBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.meal_image);
            itemName = itemView.findViewById(R.id.meal_name);
            itemDescription = itemView.findViewById(R.id.meal_description);
            itemPrice = itemView.findViewById(R.id.meal_price);
            count = itemView.findViewById(R.id.item_count);
            incrementBtn = itemView.findViewById(R.id.increment_button);
            decrementBtn = itemView.findViewById(R.id.decrement_button);
        }
    }

}
