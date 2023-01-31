package com.example.gates.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gates.controller.Controller;
import com.example.gates.DashBoard;
import com.example.gates.R;
import com.example.gates.signinsignup.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {


    EditText t1,t2;
    Button loginbtn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        t1=(EditText)findViewById(R.id.idEdtEmail);
        t2 = (EditText) findViewById(R.id.idEdtPassword);
        loginbtn = (Button) findViewById(R.id.idBtnLogin);

      //  checkUserExistance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processlogin();
            }
        });

    }

    void processlogin(){

        String email = t1.getText().toString();
        String password = t2.getText().toString();
        Call<LoginModel> call = Controller
                                    .getInstance()
                                    .getapi()
                                    .verifyuser(email,password);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                LoginModel obj = response.body();
                String output = obj.getMessage();
                if(output.equals("failed"))
                {
                    t1.setText("");
                    t2.setText("");
                }
                if(output.equals("exist"))
                {
                    SharedPreferences sp= getSharedPreferences("credentials", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("email",t1.getText().toString());
                    editor.putString("password",t2.getText().toString());
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), DashBoard.class));
                    finish();
                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(Login.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* void checkUserExistance(){
        SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email")){
        startActivity(new Intent(getApplicationContext(),DashBord.class));
        finish();
        }
        else {
            tv.setText("Please login....");
            tv.setTextColor(Color.RED);
        }
    }*/
}