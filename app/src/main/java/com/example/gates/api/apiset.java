package com.example.gates.api;

import com.example.gates.model.responsemodel;
import com.example.gates.model.responsemodel1;
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
    Call<responsemodel> verifyuser(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("details.php")
    Call<List<GetModel>> getmodels();

    @GET("get_image.php")
    Call<List<responsemodel1>> getdata();
}
