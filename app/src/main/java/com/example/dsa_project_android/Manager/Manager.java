package com.example.dsa_project_android.Manager;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Manager {

    @FormUrlEncoded
    @POST("registerNewUser")
    Call<Void> register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("mail") String mail,
            @Field("age") int age
    );
}