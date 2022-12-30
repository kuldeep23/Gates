package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gates.model.responsemodel;

import java.util.Collection;

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
        tv = (TextView) findViewById(R.id.idtext);
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
        Call<responsemodel> call = Controller
                                    .getInstance()
                                    .getapi()
                                    .verifyuser(email,password);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj = response.body();
                String output = obj.getMessage();
                if(output.equals("failed"))
                {
                    t1.setText("");
                    t2.setText("");
                    tv.setTextColor(Color.RED);
                    tv.setText("Invalid username or password");
                }
                if(output.equals("exist"))
                {
                    SharedPreferences sp= getSharedPreferences("credentials", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("email",t1.getText().toString());
                    editor.putString("password",t2.getText().toString());
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(),DashBord.class));
                    finish();
                }

            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                tv.setText(t.toString());
                tv.setTextColor(Color.RED);
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