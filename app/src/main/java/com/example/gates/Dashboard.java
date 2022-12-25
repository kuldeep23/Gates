package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tv = (TextView) findViewById(R.id.idtext);
        btn = (Button) findViewById(R.id.idBtnLogout);

        checkUserExistance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("email").commit();
                sp.edit().remove("password").commit();
                sp.edit().apply();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
    }

    public void checkUserExistance(){
        SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email"))
            tv.setText(sp.getString("email",""));
        else
            startActivity(new Intent(getApplicationContext(),Login.class));
    }

}


