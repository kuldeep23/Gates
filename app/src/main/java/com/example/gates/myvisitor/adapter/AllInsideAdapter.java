package com.example.gates.myvisitor.adapter;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gates.DashBoard;
import com.example.gates.R;
import com.example.gates.controller.Controller;
import com.example.gates.myvisitor.MyVisitorMain;
import com.example.gates.myvisitor.model.AllInsideModel;
import com.example.gates.myvisitor.model.AllVisitorModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllInsideAdapter  extends RecyclerView.Adapter<AllInsideAdapter.myViewHolder>
{
    List<AllInsideModel> data;
    TextToSpeech textToSpeech;


    public AllInsideAdapter(List<AllInsideModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AllInsideAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insidesinglerowdesign,parent,false);
        return  new AllInsideAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllInsideAdapter.myViewHolder holder, int position) {

        final AllInsideModel temp = data.get(position);
        holder.visitorname.setText(data.get(position).getVisitor_name());
        holder.visitorsubtype.setText(data.get(position).getVisitor_type_detail());
        holder.visitortype.setText(data.get(position).getVisitor_type());
        holder.visitorstatus.setText(data.get(position).getVisitor_status());
        holder.visitorapprovedby.setText(data.get(position).getvisitor_approve_by());
        holder.visitorenterdate.setText(data.get(position).getVisitor_enter_date());
        holder.visitorentertime.setText(data.get(position).getVisitor_enter_time());
        //holder.visitorexitdate.setText(data.get(position).getVisitor_exit_date());
        //holder.visitorexittime.setText(data.get(position).getVisitor_exit_time());


        Glide.with(holder.visitorname.getContext()).load(data.get(position).getVisitor_image()).into(holder.visitorimage);
        //Animation
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_four));

        holder.call.setOnClickListener(new View.OnClickListener() {
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
        });

        holder.wrongentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if(i != TextToSpeech.ERROR)
                            textToSpeech.setLanguage(Locale.US);
                        textToSpeech.speak("Do you want to update this wrong visitor?? Then press enter yes more otherwise press cancel", TextToSpeech.QUEUE_FLUSH, null);
                    }
                });

                new MaterialAlertDialogBuilder(view.getContext(), R.style.AlertDialogTheme)
                        .setTitle("Wrong Visitor")
                        .setMessage("Do you want to update this wrong visitor??")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Call<AllVisitorModel> call = Controller
                                        .getInstance()
                                        .getapi()
                                        .visitorwrong(temp.getVisitor_id());

                                call.enqueue(new Callback<AllVisitorModel>() {
                                    @Override
                                    public void onResponse(Call<AllVisitorModel> call, Response<AllVisitorModel> response) {
                                        if (response.isSuccessful()) {
                                            if (response.body() != null) {
                                                textToSpeech = new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
                                                    @Override
                                                    public void onInit(int i) {
                                                        if(i != TextToSpeech.ERROR)
                                                            textToSpeech.setLanguage(Locale.US);
                                                        textToSpeech.speak("Wrong Entry Updated Successfully. Do you want to update more wrong visitor? Then press enter update more otherwise press no", TextToSpeech.QUEUE_FLUSH, null);
                                                    }
                                                });
                                                new MaterialAlertDialogBuilder(view.getContext(), R.style.AlertDialogTheme)
                                                        .setTitle("Wrong Visitor")
                                                        .setMessage("Wrong visitor update successfully!!!")
                                                        .setPositiveButton("NO", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                Intent goToNextActivity = new Intent(view.getContext(), DashBoard.class);
                                                                view.getContext().startActivity(goToNextActivity);
                                                            }
                                                        })
                                                        .setNeutralButton("Update More", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                Intent goToNextActivity = new Intent(view.getContext(), MyVisitorMain.class);
                                                                view.getContext().startActivity(goToNextActivity);
                                                            }
                                                        })
                                                        .show();
                                            } else {
                                                Toast.makeText(view.getContext(), "Visitor Wrong Update Un-Successfull", Toast.LENGTH_SHORT).show();
                                            }
                                        }else{
                                            Toast.makeText(view.getContext(), "Response not successful "+response.toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<AllVisitorModel> call, Throwable t) {
                                        Toast.makeText(view.getContext(), "Error occurred!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goToNextActivity = new Intent(view.getContext(), MyVisitorMain.class);
                                view.getContext().startActivity(goToNextActivity);
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView visitorimage;
        private TextView visitorname, visitorsubtype, visitortype,
                visitorstatus, visitorapprovedby, visitorenterdate, visitorentertime,
                visitorexitdate, visitorexittime;
        private Button call, wrongentry;
        private CardView cardView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            visitorimage = itemView.findViewById(R.id.visitor_image);
            visitorname = itemView.findViewById(R.id.visitor_name);
            visitorsubtype = itemView.findViewById(R.id.visitor_sub_type);
            visitortype = itemView.findViewById(R.id.visitor_type);
            visitorstatus = itemView.findViewById(R.id.visitor_status);
            visitorapprovedby = itemView.findViewById(R.id.visitor_approved_by);
            visitorenterdate = itemView.findViewById(R.id.visitor_enter_date);
            visitorentertime = itemView.findViewById(R.id.visitor_enter_time);
            //visitorexitdate = itemView.findViewById(R.id.visitor_exit_date);
           // visitorexittime = itemView.findViewById(R.id.visitor_exit_time);
            call = itemView.findViewById(R.id.visitor_call);
            wrongentry = itemView.findViewById(R.id.wrong_entry);
            cardView = itemView.findViewById(R.id.eachCardView);
        }
    }
}

