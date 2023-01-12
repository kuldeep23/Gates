package com.example.gates.mycomplaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gates.R;
import com.example.gates.api.apiset;
import com.example.gates.mycomplaint.model.ComplaintModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyComplaintMain extends AppCompatActivity {

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

        apiset api =retrofit.create(apiset.class);

        Call<ComplaintModel> call = api.adddata(name.getText().toString(),
                                       email.getText().toString(),
                                        pwd.getText().toString(),
                                        status.getText().toString());

        call.enqueue(new Callback<ComplaintModel>() {
            @Override
            public void onResponse(Call<ComplaintModel> call, Response<ComplaintModel> response) {
                name.setText("");
                email.setText("");
                pwd.setText("");
                status.setText("");
                Toast.makeText(MyComplaintMain.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ComplaintModel> call, Throwable t) {
                Toast.makeText(MyComplaintMain.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}