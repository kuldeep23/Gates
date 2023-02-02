package com.example.gates.mybanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gates.R;
import com.example.gates.mybanner.bannermodel;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.myViewHolder>
{
    List<bannermodel> data;


    public BannerAdapter(List<bannermodel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout,parent,false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Glide.with(holder.t1.getContext()).load("https://gatesadmin.000webhostapp.com/images/"+data.get(position).getBanner_Image()).into(holder.img);
        //Animation
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_four));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {

        private  ImageView img;
        private TextView t1;
        private CardView cardView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.eachCardView);
            img = itemView.findViewById(R.id.img);
            t1= itemView.findViewById(R.id.t1);
        }
    }
}
