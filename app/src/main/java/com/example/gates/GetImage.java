package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gates.model.responsemodel1;

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
        Call<List<responsemodel1>> call = Controller
                                        .getInstance()
                                        .getapi()
                                        .getdata();

        call.enqueue(new Callback<List<responsemodel1>>() {
            @Override
            public void onResponse(Call<List<responsemodel1>> call, Response<List<responsemodel1>> response) {
                List<responsemodel1> data = response.body();
                MyAdaptar myAdaptar = new MyAdaptar(data);
                recview.setAdapter(myAdaptar);
            }

            @Override
            public void onFailure(Call<List<responsemodel1>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}