package com.example.singhkiran.smartiot.JsonRequests;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ChangeUserData.UserData_Model;
import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Model;
import com.example.singhkiran.smartiot.JsonRequests.SignUp.Register_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SmartiotAPI {
    @POST("api/users/login")
    Call<Login_Model> loginPost(@Body Login_Model Login);

    @POST("api/users/register")
    Call<Register_Model> registerPost(@Body Register_Model Register);

    @POST("api/iot/led")
    Call<Led_Model> ledPost(@Body Led_Model Led);

    @PUT("api/users/data/changeUserData")
    Call<UserData_Model> changeData_Post(@Body UserData_Model UserData);

    @GET("api/admin/showDevices")
    Call<List<Device_Model>> getDevices();

    @POST("api/users/data/showLogs")
   Call<List<ShowLogs_Model>> getUsersLogs(@Body ShowLogs_Model showLogs);



//
//    @POST("api/users/data/")
//    Call<Led_Model> ledPost(@Body Led_Model Led);
//
//    @POST("api/users/data/")
//    Call<Led_Model> ledPost(@Body Led_Model Led);

}
