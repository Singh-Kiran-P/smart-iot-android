package com.example.singhkiran.send_json_request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface SmartiotAPI {
    @POST("api/users/register")
     Call<Login> createPost(@Body Login Login);
}
