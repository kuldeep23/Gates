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

import com.example.gates.billpayment.BillPaymentMain;
import com.example.gates.communication.CommunicationMain;
import com.example.gates.domesticstaff.DomesticStaffMain;
import com.example.gates.mycomplaint.MyComplaint;
import com.example.gates.mycomplaint.MyComplaintMain;
import com.example.gates.myvisitor.GetImage;
import com.example.gates.myvisitor.MyVisitorMain;
import com.example.gates.residentdirectory.ResidentDirectory;
import com.example.gates.signinsignup.Login;

public class DashBoard extends AppCompatActivity {

    CardView cardvisitor, carddomestic, cardbills, cardcommunication, cardcomplaints, cardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        cardvisitor = findViewById(R.id.visitor);
        carddomestic = findViewById(R.id.domestic);
        cardbills = findViewById(R.id.bills);
        cardcommunication = findViewById(R.id.communication);
        cardcomplaints = findViewById(R.id.complaints);

        checkUserExistance();

        cardvisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MyVisitorMain.class));
            }
        });

        carddomestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DomesticStaffMain.class));
            }
        });

        cardbills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BillPaymentMain.class));
            }
        });

        cardcommunication.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CommunicationMain.class));
            }
        });

        cardcomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("email").commit();
                sp.edit().remove("password").commit();
                sp.edit().apply();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                showToast("Card Logout Click");*/
                startActivity(new Intent(getApplicationContext(), MyComplaint.class));
            }
        });

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
