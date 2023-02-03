package com.example.gates.api;

import com.example.gates.mybanner.bannermodel;
import com.example.gates.mycomplaint.model.ComplaintModel;
import com.example.gates.signinsignup.model.LoginModel;
import com.example.gates.myvisitor.model.AllVisitorModel;
import com.example.gates.residentdirectory.model.GetModel;
import com.example.gates.signinsignup.model.RegisterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {

    @FormUrlEncoded
    @POST("jh_login.php")
    Call<LoginModel> verifyuser(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("details.php")
    Call<List<GetModel>> getmodels();

    @GET("get_image.php")
    Call<List<AllVisitorModel>> getdata();

    @GET("banner.php")
    Call<List<bannermodel>> getbanner();

    @FormUrlEncoded
    @POST("signup.php")
    Call<ComplaintModel> adddata(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("status") String status);

    @FormUrlEncoded
    @POST("jh_users.php")
    Call<RegisterModel> register_user(
            @Field("Owner_Tenant") String owner_tenant,
            @Field("Owner_Name") String owner_name,
            @Field("Owner_Image") String owner_image,
            @Field("Contact_Number") String contact_number,
            @Field("Email") String email,
            @Field("Password") String password,
            @Field("HomeTown_Address") String hometown_address,
            @Field("Member") String member,
            @Field("Gender") String gender,
            @Field("DOB") String dob,
            @Field("Blood_Group") String blood_group,
            @Field("Profession") String profession,
            @Field("Profession_Details") String profession_details,
            @Field("Flat_Number") String flat_number,
            @Field("Flat_Block") String flat_block,
            @Field("Flat_Floor") String flat_floor,
            @Field("Flat_Type") String flat_type,
            @Field("Parking_Type") String parking_type,
            @Field("Parking_Number") String parking_number,
            @Field("Pet_Type") String pet_type,
            @Field("Pet_Name") String pet_name,
            @Field("Two_Wheeler_Type") String two_wheeler_type,
            @Field("Two_Wheeler_Number") String two_wheeler_number,
            @Field("Four_Wheeler_Brand") String four_wheeler_brand,
            @Field("Four_Wheeler_Number") String four_wheeler_number);
}
