package com.example.gates.api;


import com.example.gates.model.GetModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPI
{
    @GET("posts")
    Call<List<GetModel>> getmodels();
}
