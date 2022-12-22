package com.example.gates;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApi {
    @FormUrlEncoded
    @POST("signup.php")
    Call<Model> adddata(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("status") String status);
}
