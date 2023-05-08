package com.example.gates.domesticstaff.adapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gates.R;
import com.example.gates.domesticstaff.model.AllStaffMemberModel;
import com.example.gates.domesticstaff.model.AllStaffModel;

import java.util.List;

public class AllStaffMemberAdapter extends RecyclerView.Adapter<AllStaffMemberAdapter.myViewHolder>
{
    List<AllStaffMemberModel> data;

    public AllStaffMemberAdapter(List<AllStaffMemberModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AllStaffMemberAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staffmembersinglerow,parent,false);
        return  new AllStaffMemberAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllStaffMemberAdapter.myViewHolder holder, int position) {

        final AllStaffMemberModel temp = data.get(position);
        holder.staffname.setText(data.get(position).getStaff_name());
        holder.stafftype.setText(data.get(position).getStaff_type());
        Glide.with(holder.staffimage.getContext()).load(data.get(position).getStaff_icon()).into(holder.staffimage);
        //Animation
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_four));

            holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = temp.getStaff_mobile_no();
                Intent phone_intent = new Intent(Intent.ACTION_DIAL);
                phone_intent.setData(Uri.parse("tel:" + phone_number));
                if (ActivityCompat.checkSelfPermission(view.getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    view.getContext().startActivity(phone_intent);
                    return;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView staffimage;
        private TextView staffname, stafftype;
        private CardView cardView;

        private Button call;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            staffimage = itemView.findViewById(R.id.visitor_image);
            staffname = itemView.findViewById(R.id.visitor_name);
            stafftype = itemView.findViewById(R.id.visitor_type);
            staffname = itemView.findViewById(R.id.visitor_name);
            staffname = itemView.findViewById(R.id.visitor_name);
            cardView = itemView.findViewById(R.id.eachCardView);
            call = itemView.findViewById(R.id.visitor_call);
        }
    }
}

