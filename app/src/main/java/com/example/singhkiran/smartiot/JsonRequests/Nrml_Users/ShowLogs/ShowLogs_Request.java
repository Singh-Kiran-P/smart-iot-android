package com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs;

import android.app.Activity;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;
import com.example.singhkiran.smartiot.UI.UserNormal.Adapters.LogsAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowLogs_Request {

    API_Server api_server = new API_Server();
    Activity activity;
    public ShowLogs_Model showLogs_model;
    private SmartiotAPI smartiotAPI;

    public ShowLogs_Request(Activity activity, String userId) {
        this.activity = activity;
        showLogs_model = new ShowLogs_Model(userId);
        MakeRequest();

    }


    public void MakeRequest() {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    RecyclerView recyclerView;
    List<ShowLogs_Model> list = new ArrayList<>();
    LogsAdapter adapter;

    private void createRequest() {

        recyclerView = activity.findViewById(R.id.nrml_recycler_Logs);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        Gson gson = new GsonBuilder().create();

        Call<List<ShowLogs_Model>> call = smartiotAPI.getUsersLogs(showLogs_model);

        call.enqueue(new Callback<List<ShowLogs_Model>>() {
            @Override
            public void onResponse(Call<List<ShowLogs_Model>> call, Response<List<ShowLogs_Model>> response) {
                System.out.println(response.code());
                Toast.makeText(activity, response.toString(), Toast.LENGTH_SHORT).show();


                List<ShowLogs_Model> logs = response.body();
                if (logs.get(0).getStatus() != null) {
                    if (logs.get(0).getStatus().equals("465")) {
                        String message = logs.get(0).getMessage();
                        logs.remove(0);
                        ShowLogs_Model model = new ShowLogs_Model();
                        model.setName("No Logs");
                        model.setPermission(message);
                        model.setCreatedOn("");
                        model.setValue("");
                        model.setUserId("");
                        model.setMessage("");
                        model.setStatus("");
//                        model.setEindpoint("");
                        logs.add(model);
                        adapter = new LogsAdapter(activity, logs);

                    }
                } else {
                    adapter = new LogsAdapter(activity, logs);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ShowLogs_Model>> call, Throwable t) {
                Toast.makeText(activity , t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
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

