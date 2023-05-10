package com.example.gates.domesticstaff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.gates.DashBoard;
import com.example.gates.R;
import com.example.gates.controller.Controller;
import com.example.gates.domesticstaff.adapter.AffStaffListAdapter;
import com.example.gates.domesticstaff.adapter.AllStaffMemberAdapter;
import com.example.gates.domesticstaff.model.AllStaffMemberModel;
import com.example.gates.domesticstaff.model.AllStaffModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffMembers extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    String staff_type;
    ShimmerFrameLayout shimmerFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_members);

        imageView = findViewById(R.id.img);
        shimmerFrameLayout = findViewById(R.id.shimmer);
        staff_type = getIntent().getStringExtra("staff-name");
        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        processdata();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AllStaffList.class));
            }
        });
    }

    public void processdata(){
        Call<List<AllStaffMemberModel>> call = Controller
                .getInstance()
                .getapi()
                .staff_members
                        ("CP",staff_type);

        call.enqueue(new Callback<List<AllStaffMemberModel>>() {
            @Override
            public void onResponse(Call<List<AllStaffMemberModel>> call, Response<List<AllStaffMemberModel>> response) {
                List<AllStaffMemberModel> data = response.body();
                if(data!=null){
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    AllStaffMemberAdapter myAdaptar = new AllStaffMemberAdapter(data);
                    recyclerView.setAdapter(myAdaptar);
                }
                else if (data==null) {
                    Toast.makeText(StaffMembers.this, data.toString(), Toast.LENGTH_SHORT).show();
                    recyclerView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);

                } else {
                    shimmerFrameLayout.startShimmer();
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call <List<AllStaffMemberModel>>call, Throwable t) {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                Toast.makeText(StaffMembers.this, t.toString(), Toast.LENGTH_SHORT).show();
                recyclerView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}