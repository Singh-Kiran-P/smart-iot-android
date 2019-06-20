package com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Feedback;

import android.app.Activity;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Model;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.FeedbackAdapter;
import com.example.singhkiran.smartiot.UI.UserNormal.Adapters.LogsAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feedback_Request {
    API_Server api_server = new API_Server();
    Activity activity;
    private SmartiotAPI smartiotAPI;

    public Feedback_Request(Activity activity) {
        this.activity = activity;

        MakeRequest();

    }


    public void MakeRequest() {
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    RecyclerView recyclerView;
    List<Feedback_Model> list = new ArrayList<>();
    FeedbackAdapter adapter;

    private void createRequest() {

        recyclerView = activity.findViewById(R.id.admin_feedback_request);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        Gson gson = new GsonBuilder().create();


        smartiotAPI.getFeedback1().enqueue(new Callback<List<Feedback_Model>>() {
            @Override
            public void onResponse(Call<List<Feedback_Model>> call, Response<List<Feedback_Model>> response) {
                System.out.println(response.code());

                List<Feedback_Model> feedbackList = response.body();
                adapter = new FeedbackAdapter(activity, feedbackList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Feedback_Model>> call, Throwable t) {

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

