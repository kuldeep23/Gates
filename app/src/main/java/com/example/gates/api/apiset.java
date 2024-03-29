package com.example.gates.api;

import com.example.gates.domesticstaff.model.AllStaffMemberModel;
import com.example.gates.domesticstaff.model.AllStaffModel;
import com.example.gates.mybanner.bannermodel;
import com.example.gates.mycomplaint.model.ComplaintModel;
import com.example.gates.myvisitor.model.AllInsideModel;
import com.example.gates.myvisitor.model.AllWrongModel;
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

    @FormUrlEncoded
    @POST("get_all_visitors.php")
    Call<List<AllVisitorModel>> all_visitors(
            @Field("soc") String soc,
            @Field("visitor_flat_no") String flat_no,
            @Field("visitor_is_valid") String is_valid
    );

    @FormUrlEncoded
    @POST("get_inside_visitors.php")
    Call<List<AllInsideModel>> all_inside_visitors(
            @Field("soc") String soc,
            @Field("visitor_flat_no") String flat_no,
            @Field("visitor_is_valid") String is_valid
    );

    @FormUrlEncoded
    @POST("get_wrong_visitors.php")
    Call<List<AllWrongModel>> all_wrong_visitors(
            @Field("soc") String soc,
            @Field("flat_no") String flat_no
    );

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


    @FormUrlEncoded
    @POST("visitor_wrong.php")
    Call<AllVisitorModel> visitorwrong(
            @Field("visitor_id") String visitorid
    );

    @FormUrlEncoded
    @POST("staff_list.php")
    Call<List<AllStaffModel>> staff_list(
            @Field("soc") String soc
    );

    @FormUrlEncoded
    @POST("staff_member.php")
    Call<List<AllStaffMemberModel>> staff_members(
            @Field("soc") String soc,
            @Field("staff_type") String staff_type
    );
}
