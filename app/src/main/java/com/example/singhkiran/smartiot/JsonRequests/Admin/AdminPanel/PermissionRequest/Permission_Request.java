package com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest;

import android.app.Activity;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.RequestAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Permission_Request  {
    API_Server api_server = new API_Server();
    Activity activity;
    private SmartiotAPI smartiotAPI;

    public Permission_Request(Activity activity) {
        this.activity = activity;

        MakeRequest();

    }


    public void MakeRequest() {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    RecyclerView recyclerView;
    RequestAdapter adapter;
    List<Permission_Model>  list ;

    private void createRequest() {

        recyclerView = activity.findViewById(R.id.admin_recycler_request);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        Gson gson = new GsonBuilder().create();


        smartiotAPI.getRequests().enqueue(new Callback<List<Permission_Model>>() {
            @Override
            public void onResponse(Call<List<Permission_Model>> call, Response<List<Permission_Model>> response) {
                System.out.println(response.code());

                list = response.body();
                adapter = new RequestAdapter(activity, list);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new RequestAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        changeItem(position, "Clicked");

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Permission_Model>> call, Throwable t) {

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


    public void changeItem(int position, String text) {
        Toast.makeText(activity, list.get(position).getEndPoint(), Toast.LENGTH_SHORT).show();
    }
}

