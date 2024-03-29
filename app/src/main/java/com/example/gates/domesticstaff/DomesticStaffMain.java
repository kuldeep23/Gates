package com.example.gates.domesticstaff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gates.R;

public class DomesticStaffMain extends AppCompatActivity {

    CardView cardView, cardView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.domestic_staff_main);

        cardView = findViewById(R.id.domestic);
        cardView1 = findViewById(R.id.visitor);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AllStaffList.class);
                startActivity(i);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(getApplicationContext(),StaffMembers.class);
                startActivity(i);*/
            }
        });
    }
}