package com.example.gates.api;

import com.example.gates.mycomplaint.model.ComplaintModel;
import com.example.gates.signinsignup.model.LoginModel;
import com.example.gates.myvisitor.model.AllVisitorModel;
import com.example.gates.residentdirectory.model.GetModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginModel> verifyuser(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("details.php")
    Call<List<GetModel>> getmodels();

    @GET("get_image.php")
    Call<List<AllVisitorModel>> getdata();

    @FormUrlEncoded
    @POST("signup.php")
    Call<ComplaintModel> adddata(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("status") String status);
}
