package com.example.gates.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.gates.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {


    AutoCompleteTextView autoCompleteTextViewOwnerType, autoCompleteTextViewMember, autoCompleteTextViewGender,autoCompleteTextViewBlood,
                         autoCompleteTextViewProf, autoCompleteTextViewFBlock, autoCompleteTextViewFFloor,
                         autoCompleteTextViewFType, autoCompleteTextViewParkingType, autoCompleteTextViewPetType,
                         autoCompleteTextViewTwoTpye, autoCompleteTextViewFourType;
    TextInputEditText dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        autoCompleteTextViewOwnerType = findViewById(R.id.EditOwnerType);
        autoCompleteTextViewMember = findViewById(R.id.EditMember);
        autoCompleteTextViewGender = findViewById(R.id.EditGender);
        autoCompleteTextViewBlood = findViewById(R.id.EditBlood);
        autoCompleteTextViewProf = findViewById(R.id.EditProfession);
        autoCompleteTextViewFBlock = findViewById(R.id.EditFblock);
        autoCompleteTextViewFFloor = findViewById(R.id.EditFFloor);
        autoCompleteTextViewFType = findViewById(R.id.EditFType);
        autoCompleteTextViewParkingType = findViewById(R.id.EditParkingType);
        autoCompleteTextViewPetType = findViewById(R.id.EditPetType);
        autoCompleteTextViewTwoTpye = findViewById(R.id.EditTwoType);
        autoCompleteTextViewFourType = findViewById(R.id.EditFourType);
        dob = findViewById(R.id.EditDOB);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(date);
        ArrayAdapter<String> ownerAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,OWNERTPYE);
        autoCompleteTextViewOwnerType.setAdapter(ownerAdapter);
        autoCompleteTextViewOwnerType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, formattedDate, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> memberAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,MEMBERS);
        autoCompleteTextViewMember.setAdapter(memberAdapter);
        autoCompleteTextViewMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewMember.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,GENDER);
        autoCompleteTextViewGender.setAdapter(genderAdapter);
        autoCompleteTextViewGender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewGender.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> profAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PROFESSION);
        autoCompleteTextViewProf.setAdapter(profAdapter);
        autoCompleteTextViewProf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewProf.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Date").build();

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        dob.setText(materialDatePicker.getHeaderText());
                    }
                });
                materialDatePicker.show(getSupportFragmentManager(),"TAG");
            }

        });

        ArrayAdapter<String> bloodAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,BLOOD);
        autoCompleteTextViewBlood.setAdapter(bloodAdapter);
        autoCompleteTextViewBlood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewBlood.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> fblockAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FBLOCK);
        autoCompleteTextViewFBlock.setAdapter(fblockAdapter);
        autoCompleteTextViewFBlock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewFBlock.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ffloorAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FFLOOR);
        autoCompleteTextViewFFloor.setAdapter(ffloorAdapter);
        autoCompleteTextViewFFloor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewFFloor.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ftypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FTYPE);
        autoCompleteTextViewFType.setAdapter(ftypeAdapter);
        autoCompleteTextViewFType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewFType.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ptypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PTYPE);
        autoCompleteTextViewParkingType.setAdapter(ptypeAdapter);
        autoCompleteTextViewParkingType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewParkingType.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> pettypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PETTYPE);
        autoCompleteTextViewPetType.setAdapter(pettypeAdapter);
        autoCompleteTextViewPetType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewPetType.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> twotypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,TWOTYPE);
        autoCompleteTextViewTwoTpye.setAdapter(twotypeAdapter);
        autoCompleteTextViewTwoTpye.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewTwoTpye.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        ArrayAdapter<String> fourtypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FOURTYPE);
        autoCompleteTextViewFourType.setAdapter(fourtypeAdapter);
        autoCompleteTextViewFourType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = String.valueOf(adapterView.getItemIdAtPosition(i));
                Toast.makeText(Register.this, autoCompleteTextViewFourType.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private static final String[] OWNERTPYE = new String[] {
            "Owner", "Tenant"
    };

    private static final String[] MEMBERS = new String[] {
            "1", "2", "3", "4", "5", "6","7"
    };

    private static final String[] GENDER = new String[] {
            "Male", "Female",
    };

    private static final String[] BLOOD = new String[] {
            "A+", "A-", "B+","B-","O+","O-","AB+","AB-"
    };

    private static final String[] PROFESSION = new String[] {
            "Doctor", "Teacher", "Engineer","Government Service","Private Job","Defence","Business","Railway","Law","Contractor","Ex-Service Man","Other"
    };

    private static final String[] FBLOCK = new String[] {
            "BLOCK - A", "BLOCK - B"
    };

    private static final String[] FFLOOR = new String[] {
            "FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "SIXTH","SEVENTH", "EIGHTH","NINTH","TENTH","ELEVENTH"
    };

    private static final String[] FTYPE = new String[] {
            "3 BHK", "2 BHK", "3 BHK + Servent"
    };

    private static final String[] PTYPE = new String[] {
            "Covered", "Open"
    };

    private static final String[] PETTYPE = new String[] {
            "Dog", "Cat", "Bird", "Fish", "Rabbit", "Other"
    };

    private static final String[] TWOTYPE = new String[] {
            "Bike", "Scooty"
    };

    private static final String[] FOURTYPE = new String[] {
            "Maruti Suzuki", "Tata Motors" ,"Mahindra & Mahindra", "Kia", "Hyundai","Toyota", "Renaults","Honda","Ford","Skoda","MG","Volkswagen","BMW","Jeep","Audi","Mercedes","Nissan","Datsun"
    };
}