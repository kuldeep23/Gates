package com.example.gates;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashBord extends AppCompatActivity {

    CardView cardHome, cardChat, cardProfile, cardWidget, cardSetting, cardLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord);

        cardHome = findViewById(R.id.card_home);
        cardChat = findViewById(R.id.card_chat);
        cardProfile = findViewById(R.id.card_profile);
        cardWidget = findViewById(R.id.card_widget);
        cardSetting = findViewById(R.id.card_setting);
        cardLogout = findViewById(R.id.card_logout);

        checkUserExistance();

        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GetData.class));
                showToast("Home Click");
            }
        });

        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                showToast("Card Chat Click");
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GetImage.class));
                showToast("Card Profile Click");
            }
        });

        cardWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Card Widget Click");
            }
        });

        cardSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Card Setting Click");
            }
        });


        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("email").commit();
                sp.edit().remove("password").commit();
                sp.edit().apply();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
                showToast("Card Logout Click");
            }
        });


    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void checkUserExistance(){
        SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email"))
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            //tv.setText(sp.getString("email",""));
        else
            startActivity(new Intent(getApplicationContext(),Login.class));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                }).create().show();
    }
}