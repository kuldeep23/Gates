package com.example.gates.signinsignup;

import static com.example.gates.controller.Controller.url;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.gates.R;
import com.example.gates.api.apiset;
import com.example.gates.signinsignup.model.RegisterModel;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    private ImageView selectedImage;
    Bitmap bitmap;
    String image;
    AutoCompleteTextView owner_tenant, member, gender, blood_group, profession, flat_block, flat_floor,
            flat_type, parking_type, pet_type, two_wheeler_type, four_wheeler_brand;
    TextInputEditText owner_name, contact_number, email, password, hometown_address, profession_details, flat_number,
            parking_number, pet_name, two_wheeler_number, dob, four_wheeler_number;
    Button register;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        selectedImage = findViewById(R.id.imageView);
        owner_name = findViewById(R.id.EditOwnerName);
        contact_number = findViewById(R.id.EditMoblieNumber);
        email = findViewById(R.id.EditEmail);
        progressBar = findViewById(R.id.progressBar);
        password = findViewById(R.id.EditPassword);
        hometown_address = findViewById(R.id.EditAddress);
        profession_details = findViewById(R.id.EditProfDetails);
        flat_number = findViewById(R.id.EditFlatNumber);
        parking_number = findViewById(R.id.EditParkingNumber);
        pet_name = findViewById(R.id.EditPetName);
        two_wheeler_number =findViewById(R.id.EditVehicleNumber);
        four_wheeler_number = findViewById(R.id.EditFourVehicleNumber);
        owner_tenant = findViewById(R.id.EditOwnerType);
        member = findViewById(R.id.EditMember);
        gender = findViewById(R.id.EditGender);
        blood_group = findViewById(R.id.EditBlood);
        profession = findViewById(R.id.EditProfession);
        flat_block = findViewById(R.id.EditFblock);
        flat_floor = findViewById(R.id.EditFFloor);
        flat_type = findViewById(R.id.EditFType);
        parking_type = findViewById(R.id.EditParkingType);
        pet_type = findViewById(R.id.EditPetType);
        two_wheeler_type = findViewById(R.id.EditTwoType);
        four_wheeler_brand = findViewById(R.id.EditFourType);
        dob = findViewById(R.id.EditDOB);
        register = findViewById(R.id.idBtnRegister);


        selectedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(Register.this)
                        .compress(200)                          //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(300, 300)	//Final image resolution will be less than 1080 x 1080(Optional)
                        /*.crop()*/	    			            //Crop image(Optional), Check Customization for more option
                        .start();
            }
        });

        ArrayAdapter<String> ownerAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,OWNERTPYE);
        owner_tenant.setAdapter(ownerAdapter);
        owner_tenant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, owner_tenant.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> memberAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,MEMBERS);
        member.setAdapter(memberAdapter);
        member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, member.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,GENDER);
        gender.setAdapter(genderAdapter);
        gender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, gender.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> profAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PROFESSION);
        profession.setAdapter(profAdapter);
        profession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(Register.this, profession.getText().toString(), Toast.LENGTH_SHORT).show();
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
        blood_group.setAdapter(bloodAdapter);
        blood_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, blood_group.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> fblockAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FBLOCK);
        flat_block.setAdapter(fblockAdapter);
        flat_block.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, flat_block.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ffloorAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FFLOOR);
        flat_floor.setAdapter(ffloorAdapter);
        flat_floor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, flat_floor.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ftypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FTYPE);
        flat_type.setAdapter(ftypeAdapter);
        flat_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, flat_type.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> ptypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PTYPE);
        parking_type.setAdapter(ptypeAdapter);
        parking_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, parking_type.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> pettypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,PETTYPE);
        pet_type.setAdapter(pettypeAdapter);
        pet_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, pet_type.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> twotypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,TWOTYPE);
        two_wheeler_type.setAdapter(twotypeAdapter);
        two_wheeler_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, two_wheeler_type.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        ArrayAdapter<String> fourtypeAdapter = new ArrayAdapter<>(Register.this,R.layout.item_list,FOURTYPE);
        four_wheeler_brand.setAdapter(fourtypeAdapter);
        four_wheeler_brand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Register.this, four_wheeler_brand.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process(bitmap);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            selectedImage.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            "Maruti Suzuki", "Tata Motors" ,"Mahindra & Mahindra", "Kia", "Hyundai","Toyota", "Renaults",
            "Honda","Ford","Skoda","MG","Volkswagen","BMW","Jeep","Audi","Mercedes","Nissan","Datsun"
    };


    private void process(Bitmap bitmap) {

        progressBar.setVisibility(View.VISIBLE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        image = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiset api =retrofit.create(apiset.class);

        Call<RegisterModel> call = api.register_user(
                owner_tenant.getText().toString(),
                owner_name.getText().toString(),
                image,
                contact_number.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                hometown_address.getText().toString(),
                member.getText().toString(),
                gender.getText().toString(),
                dob.getText().toString(),
                blood_group.getText().toString(),
                profession.getText().toString(),
                profession_details.getText().toString(),
                flat_number.getText().toString(),
                flat_block.getText().toString(),
                flat_floor.getText().toString(),
                flat_type.getText().toString(),
                parking_type.getText().toString(),
                parking_number.getText().toString(),
                pet_type.getText().toString(),
                pet_name.getText().toString(),
                two_wheeler_type.getText().toString(),
                two_wheeler_number.getText().toString(),
                four_wheeler_brand.getText().toString(),
                four_wheeler_number.getText().toString()
                );

        call.enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Register.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(Register.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}