package com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.SendFeedback;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ChangeUserData.UserData_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendFeedback_Request {


    Context context;
    private SmartiotAPI smartiotAPI;
    private SendFeedback_Model sendFeedback_model;

    public SendFeedback_Request(String userId, String feedback,Context context) {
        this.context = context;
        sendFeedback_model = new SendFeedback_Model(userId,feedback,"Android");
        MakeRequest(context);

    }


    public void MakeRequest(Context context1) {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void createRequest() {

        Call<SendFeedback_Model> call = smartiotAPI.sendUserFeedback(sendFeedback_model);

        call.enqueue(new Callback<SendFeedback_Model>() {
            @Override
            public void onResponse(Call<SendFeedback_Model> call, Response<SendFeedback_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                SendFeedback_Model postResponse = response.body();
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
            public void onFailure(Call<SendFeedback_Model> call, Throwable t) {

            }


        });

    }
}


