package com.example.gates;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPI
{
    @GET("posts")
    Call<List<GetModel>> getmodels();
}
