package com.example.gates.myvisitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gates.controller.Controller;
import com.example.gates.R;
import com.example.gates.myvisitor.model.AllVisitorModel;
import com.example.gates.myvisitor.adapter.AllVisitorAdaptar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetImage extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_image);

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }

    public void processdata(){
        Call<List<AllVisitorModel>> call = Controller
                                        .getInstance()
                                        .getapi()
                                        .getdata();

        call.enqueue(new Callback<List<AllVisitorModel>>() {
            @Override
            public void onResponse(Call<List<AllVisitorModel>> call, Response<List<AllVisitorModel>> response) {
                List<AllVisitorModel> data = response.body();
                AllVisitorAdaptar myAdaptar = new AllVisitorAdaptar(data);
                recview.setAdapter(myAdaptar);
            }

            @Override
            public void onFailure(Call<List<AllVisitorModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}