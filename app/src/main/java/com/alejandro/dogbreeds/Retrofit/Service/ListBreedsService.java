package com.alejandro.dogbreeds.Retrofit.Service;

import com.alejandro.dogbreeds.domain.Breeds;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListBreedsService {

    @GET("/api/breeds/list")
    Call<Breeds> createResponseCall();

}
