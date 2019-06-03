package com.example.singhkiran.smartiot.JsonRequests.AdminPanel.Devices;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.DevicesActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOError;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Device_Request {
    API_Server api_server = new API_Server();
    Activity activity;
    private SmartiotAPI smartiotAPI;

    public Device_Request(Activity activity) {
        this.activity = activity;

        MakeRequest();

    }


    public void MakeRequest() {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    RecyclerView recyclerView;
    List<Device_Model> list = new ArrayList<>();
    DeviceAdapter adapter;

    private void createRequest() {

        recyclerView = activity.findViewById(R.id.recycler_devices);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        Gson gson = new GsonBuilder().create();


        smartiotAPI.getDevices().enqueue(new Callback<List<Device_Model>>() {
            @Override
            public void onResponse(Call<List<Device_Model>> call, Response<List<Device_Model>> response) {
                System.out.println(response.code());

                List<Device_Model> devices = response.body();
                adapter = new DeviceAdapter(activity, devices);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Device_Model>> call, Throwable t) {

            }});
//        });
//        call.enqueue(new Callback<>() {
//            @Override
//            public void onResponse(Call<List<Device_Model>> call, Response<List<Device_Model>> response) {
//                list = response.body().getDevices();
//                adapter = new DeviceAdapter(activity, list);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<DeviceWrapper> call, Throwable t) {
//
//            }
//        });

    }
}

