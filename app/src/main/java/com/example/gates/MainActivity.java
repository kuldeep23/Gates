package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.gates.api.MyApi;
import com.example.gates.model.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText name, email, pwd, status;
    String url ="https://gatesadmin.000webhostapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.idEdtUserName);
        email = (EditText) findViewById(R.id.idEdtEmail);
        pwd = (EditText) findViewById(R.id.idEdtPassword);
        status = (EditText) findViewById(R.id.idEdtStatus);

        btn = (Button) findViewById(R.id.idBtnLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process();
            }
        });

    }

    public void process(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApi api =retrofit.create(MyApi.class);

        Call<Model> call = api.adddata(name.getText().toString(),
                                       email.getText().toString(),
                                        pwd.getText().toString(),
                                        status.getText().toString());

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                name.setText("");
                email.setText("");
                pwd.setText("");
                status.setText("");
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}