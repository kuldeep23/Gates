package com.example.gates.domesticstaff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gates.R;
import com.example.gates.controller.Controller;
import com.example.gates.domesticstaff.adapter.AffStaffListAdapter;
import com.example.gates.domesticstaff.adapter.AllStaffMemberAdapter;
import com.example.gates.domesticstaff.model.AllStaffMemberModel;
import com.example.gates.domesticstaff.model.AllStaffModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffMembers extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_members);

        recyclerView = findViewById(R.id.recview);
        imageView = findViewById(R.id.img);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        processdata();
    }

    public void processdata(){
        Call<List<AllStaffMemberModel>> call = Controller
                .getInstance()
                .getapi()
                .staff_members
                        ("CP","Maid");

        call.enqueue(new Callback<List<AllStaffMemberModel>>() {
            @Override
            public void onResponse(Call<List<AllStaffMemberModel>> call, Response<List<AllStaffMemberModel>> response) {
                List<AllStaffMemberModel> data = response.body();
                if(data!=null){
                    recyclerView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    AllStaffMemberAdapter myAdaptar = new AllStaffMemberAdapter(data);
                    recyclerView.setAdapter(myAdaptar);
                }
                else {
                    recyclerView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call <List<AllStaffMemberModel>>call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}