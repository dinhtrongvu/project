package com.example.dev.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dev.cheanh.CreatePictureActivity;
import com.example.dev.cheanh.R;
import com.example.dev.model.ItemRecycler;

import java.util.ArrayList;

public class AdaperRecycler extends RecyclerView.Adapter<AdaperRecycler.ItemHolder> implements View.OnClickListener {
    ArrayList<ItemRecycler> arr;
    Context context;

    public AdaperRecycler(ArrayList<ItemRecycler> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_item_recyclerview,null);
        ItemHolder itemHolder=new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        ItemRecycler ir=arr.get(position);
        Glide.with(context).
                load("file:///android_asset/"+"picture/" + "h"+ir.getId()+".jpeg")
                .into(holder.imgpickture);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgpickture;
        public ImageView imglike;
        public ItemHolder(View itemView) {
            super(itemView);
            imglike=itemView.findViewById(R.id.imglike);
            imgpickture=itemView.findViewById(R.id.imgpickture);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context, CreatePictureActivity.class);
                   i.putExtra("picture",arr.get(getPosition()).getId());
                   i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(i);
                }
            });
            imglike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imglike.setImageResource(R.drawable.star_favorite);
                    //todo
                }
            });


        }

    }

}
