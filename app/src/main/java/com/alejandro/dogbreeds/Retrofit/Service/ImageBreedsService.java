package com.alejandro.dogbreeds.Retrofit.Service;

import com.alejandro.dogbreeds.domain.Breeds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImageBreedsService {

    @GET("/api/breed/{name_breed}/images")
    Call<Breeds> createResponseCall(@Path("name_breed") String var1);

}
