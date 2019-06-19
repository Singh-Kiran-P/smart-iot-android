package com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.SendFeedback.SendFeedback_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePermission_Request {

    Context context;
    private SmartiotAPI smartiotAPI;
    private ChangePermission_Model changePermission_Model;

    public ChangePermission_Request(String userId, String eindPoint,Context context) {
        this.context = context;
        changePermission_Model = new ChangePermission_Model(userId,eindPoint);
        MakeRequest(context);

    }


    public void MakeRequest(Context context1) {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void createRequest() {

        Call<ChangePermission_Model> call = smartiotAPI.changePermissionUser(changePermission_Model);

        call.enqueue(new Callback<ChangePermission_Model>() {
            @Override
            public void onResponse(Call<ChangePermission_Model> call, Response<ChangePermission_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                ChangePermission_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                String Message = postResponse.getMessage();
                try {


                    Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();


                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ChangePermission_Model> call, Throwable t) {

            }


        });

    }
}


