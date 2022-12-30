package com.example.gates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Home Click");
            }
        });

        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Card Chat Click");
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                showToast("Card Logout Click");
            }
        });


    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}