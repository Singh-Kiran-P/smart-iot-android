package com.example.singhkiran.smartiot.JsonRequests;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Feedback.Feedback_Model;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ChangeUserData.UserData_Model;
import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest.ChangePermission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.SendFeedback.SendFeedback_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Model;
import com.example.singhkiran.smartiot.JsonRequests.SignUp.Register_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
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
    @DELETE("api/iot/mainKill")
    Call<Led_Model> mainKill();

    @GET("api/admin/showDevices")
    Call<List<Device_Model>> getDevices();

    @GET("api/admin/showFeedback")
    Call<List<Feedback_Model>> getFeedback1();

    @GET("api/admin/showPermissionRequests")
    Call<List<Permission_Model>> getRequests();

    @POST("api/admin/givePermission")
    Call<Permission_Model> givePerms(@Body Permission_Model permission_model);

    @POST("api/users/data/changeFCM_token")
    Call<UserData_Model> changeFCM(@Body UserData_Model UserData);

    @PUT("api/users/data/changeUserData")
    Call<UserData_Model> changeData_Post(@Body UserData_Model UserData);

    @POST("api/users/data/showLogs")
    Call<List<ShowLogs_Model>> getUsersLogs(@Body ShowLogs_Model showLogs);

    @POST("api/users/data/sendFeedback")
    Call<SendFeedback_Model> sendUserFeedback(@Body SendFeedback_Model SendFeedback);

    @POST("api/users/data/request_permission")
    Call<ChangePermission_Model> changePermissionUser(@Body ChangePermission_Model changePermission_model);



//
//    @POST("api/users/data/")
//    Call<Led_Model> ledPost(@Body Led_Model Led);
//
//    @POST("api/users/data/")
//    Call<Led_Model> ledPost(@Body Led_Model Led);

}
