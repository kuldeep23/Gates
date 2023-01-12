package com.example.gates.myvisitor.adapter;

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
import com.example.gates.myvisitor.model.AllVisitorModel;

import java.util.List;

public class AllVisitorAdaptar extends RecyclerView.Adapter<AllVisitorAdaptar.myViewHolder>
{
    List<AllVisitorModel> data;


    public AllVisitorAdaptar(List<AllVisitorModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.t1.setText(data.get(position).getName());
        holder.t2.setText(data.get(position).getDesig());
        Glide.with(holder.t1.getContext()).load("https://gatesadmin.000webhostapp.com/images/"+data.get(position).getImage()).into(holder.img);

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
        private TextView t1, t2;
        private CardView cardView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            cardView = itemView.findViewById(R.id.eachCardView);
        }
    }
}
