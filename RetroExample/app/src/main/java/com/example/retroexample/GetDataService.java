package com.example.retroexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService
{



    @GET("/users/gopaltnl/repos")
    Call<List<Pojo>> getAllPhotos();
}
