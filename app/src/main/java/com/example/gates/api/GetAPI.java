package com.example.gates.api;


import com.example.gates.model.GetModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPI
{
    @GET("details.php")
    Call<List<GetModel>> getmodels();
}
