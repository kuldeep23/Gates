package com.example.gates.residentdirectory;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gates.R;
import com.example.gates.api.apiset;
import com.example.gates.residentdirectory.model.GetModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResidentDirectory extends AppCompatActivity {

    TextView tv;
    String url = "https://gatesadmin.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data2);

        tv = (TextView) findViewById(R.id.tv);
        tv.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiset api  = retrofit.create(apiset.class);
        Call<List<GetModel>> call = api.getmodels();

        call.enqueue(new Callback<List<GetModel>>() {
            @Override
            public void onResponse(Call<List<GetModel>> call, Response<List<GetModel>> response) {
              // Toast.makeText(GetData.this, response.toString(), Toast.LENGTH_SHORT).show();
                List<GetModel> data =response.body();
                  for(int i=0; i<data.size(); i++)
                      tv.append("Name: "+ data.get(i).getName()+
                              "\nEmail :" + data.get(i).getEmail()+
                              "\nPassword :" + data.get(i).getPassword()+
                              "\nStatus :" + data.get(i).getStatus()+"\n\n");

            }

            @Override
            public void onFailure(Call<List<GetModel>> call, Throwable t) {
                Toast.makeText(ResidentDirectory.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}