package com.example.dsa_project_android.Manager;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Manager {

    @FormUrlEncoded
    @POST("registerNewUser")
    Call<Void> register(@Body RegisterCredentials credentials);

    @FormUrlEncoded
    @POST("login")
    Call<Void> login(@Body LoginCredentials credentials);
}