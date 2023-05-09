package com.example.gates.domesticstaff.adapter;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
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
import com.example.gates.domesticstaff.model.AllStaffModel;


import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AffStaffListAdapter extends RecyclerView.Adapter<AffStaffListAdapter.myViewHolder>
{
    List<AllStaffModel> data;

    public AffStaffListAdapter(List<AllStaffModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AffStaffListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_list_design,parent,false);
        return  new AffStaffListAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AffStaffListAdapter.myViewHolder holder, int position) {

        final AllStaffModel temp = data.get(position);
        holder.staffname.setText(data.get(position).getStaff_name());
        Glide.with(holder.staffimage.getContext()).load(data.get(position).getStaff_icon()).into(holder.staffimage);
        //Animation
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_four));
     /*       holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = temp.getVisitor_mobile();
                Intent phone_intent = new Intent(Intent.ACTION_DIAL);
                phone_intent.setData(Uri.parse("tel:" + phone_number));
                if (ActivityCompat.checkSelfPermission(view.getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    view.getContext().startActivity(phone_intent);
                    return;
                }
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView staffimage;
        private TextView staffname;
        private CardView cardView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            staffimage = itemView.findViewById(R.id.staff_list_icon);
            staffname = itemView.findViewById(R.id.staff_type);
            cardView = itemView.findViewById(R.id.eachCardView);

        }
    }
}
