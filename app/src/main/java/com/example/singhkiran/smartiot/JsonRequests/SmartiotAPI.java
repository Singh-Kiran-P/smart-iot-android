package com.example.singhkiran.smartiot.JsonRequests;

import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.SignUp.Register_Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SmartiotAPI {
    @POST("api/users/login")
    Call<Login_Model> loginPost(@Body Login_Model Login);

    @POST("api/users/register")
    Call<Register_Model> registerPost(@Body Register_Model Register);

    @POST("api/iot/led")
    Call<Led_Model> ledPost(@Body Led_Model Led);

}
