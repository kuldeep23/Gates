package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         b1 = (Button) findViewById(R.id.idBtnLogin);
         b2 = (Button) findViewById(R.id.idBtnRegister);
        checkUserExistance();
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),Login.class));
             }
         });

         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),Register.class));
             }
         });
         
    }

    void checkUserExistance(){
        SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email")) {
            startActivity(new Intent(getApplicationContext(), DashBoard.class));
            finish();
        }
        else {
            Toast.makeText(this, "Please Login....", Toast.LENGTH_SHORT).show();
        }
    }
}