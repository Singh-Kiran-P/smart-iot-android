package com.example.singhkiran.smartiot.JsonRequests.Iot.Led;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.FansActivity;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Led_Request {
    API_Server api_server = new API_Server();
    Context context;
    private SmartiotAPI smartiotAPI;
    private Led_Model led_model;
    SwitchCompat switchFan1,switchFan2;
    String endpoint;
    ImageView imageView,imageView2;



    public Led_Request(String action, String userId, String endpoint, Context context)  {
        this.context = context;
        this.endpoint = endpoint;
        led_model = new Led_Model(action, userId, endpoint,"");
        MakeRequest(context);

    }


    public void MakeRequest(Context context1) {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void   createRequest() {

        Call<Led_Model> call = smartiotAPI.ledPost(led_model);

        call.enqueue(new Callback<Led_Model>() {
            @Override
            public void onResponse(Call<Led_Model> call, Response<Led_Model> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Led_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                String Message = postResponse.getMessage();
                try {
                    if (postResponse.getStatus().equals("403")) {
                        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = context.getSharedPreferences("acti", Context.MODE_WORLD_READABLE).edit();
                        editor.putBoolean(endpoint, false);
                        editor.apply();

                    }
                    if (postResponse.getStatus().equals("200")) {
                        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
                    }

                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Led_Model> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });

    }
}

