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
import com.example.gates.domesticstaff.model.AllStaffModel;
import com.example.gates.domesticstaff.adapter.AffStaffListAdapter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.facebook.shimmer.ShimmerFrameLayout;

public class AllStaffList extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff_list);
        recyclerView = findViewById(R.id.recview);
        shimmerFrameLayout = findViewById(R.id.shimmer);
        imageView = findViewById(R.id.img);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        processdata();
        
    }

    public void processdata(){
        Call<List<AllStaffModel>> call = Controller
                .getInstance()
                .getapi()
                .staff_list
                        ("CP");

        call.enqueue(new Callback<List<AllStaffModel>>() {
            @Override
            public void onResponse(Call<List<AllStaffModel>> call, Response<List<AllStaffModel>> response) {
                List<AllStaffModel> data = response.body();
                if(data!=null){
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    AffStaffListAdapter myAdaptar = new AffStaffListAdapter(data);
                    recyclerView.setAdapter(myAdaptar);
                }
                else {
                    shimmerFrameLayout.startShimmer();
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call <List<AllStaffModel>>call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}