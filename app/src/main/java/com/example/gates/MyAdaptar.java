package com.example.gates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gates.model.responsemodel1;

import java.util.List;

public class MyAdaptar extends RecyclerView.Adapter<MyAdaptar.myViewHolder>
{
    List<responsemodel1> data;

    public MyAdaptar(List<responsemodel1> data) {
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView t1, t2;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
