package com.example.singhkiran.smartiot.JsonRequests.ChangeUserData;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserData_Request {

    Context context;
    private SmartiotAPI smartiotAPI;
    private UserData_Model userData_model;

    public UserData_Request(String userId, String name, String email,String password, Context context) {
        this.context = context;
        userData_model = new UserData_Model(name,email,userId,password);
        MakeRequest(context);

    }


    public void MakeRequest(Context context1) {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void createRequest() {

        Call<UserData_Model> call = smartiotAPI.changeData_Post(userData_model);

        call.enqueue(new Callback<UserData_Model>() {
            @Override
            public void onResponse(Call<UserData_Model> call, Response<UserData_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                UserData_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                String Message = postResponse.getMessage();
                try {
                    if (postResponse.getStatus().equals(403)) {
                        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
                    }
                    if (postResponse.getStatus().equals(200)) {
                        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
                    }

                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<UserData_Model> call, Throwable t) {

            }


        });

    }
}
