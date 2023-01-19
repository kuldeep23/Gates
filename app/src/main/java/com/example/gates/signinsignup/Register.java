package com.example.gates.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.gates.R;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {


    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        textInputLayout = findViewById(R.id.textMember);
        autoCompleteTextView = findViewById(R.id.EditMember);

        String [] items = {"1", "2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,items);
        autoCompleteTextView.setAdapter(itemAdapter);

      /*  autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, s, Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}