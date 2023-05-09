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


public class AllStaffList extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff_list);
        recyclerView = findViewById(R.id.recview);
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
                    recyclerView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    AffStaffListAdapter myAdaptar = new AffStaffListAdapter(data);
                    recyclerView.setAdapter(myAdaptar);
                }
                else {
                    recyclerView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call <List<AllStaffModel>>call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}