package com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest.ChangePermission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest.ChangePermission_Request;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.RequestAdapter;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.AdminLoadAppActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.FansActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.NormalLoadAppActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOError;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Permission_Request  {
    API_Server api_server = new API_Server();
    Activity activity;
    private SmartiotAPI smartiotAPI;
    Permission_Model permission_Model;
    public Permission_Request(Activity activity) {
        this.activity = activity;

        MakeRequest();

    }
    public Permission_Request(String userId, String eindPoint, String permsTblId, String permission, Activity activity) {
        this.activity = activity;
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        permission_Model = new Permission_Model(eindPoint,permsTblId,userId,permission);
        createRequest2();

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




    }
    private void createRequest2() {

        recyclerView = activity.findViewById(R.id.admin_recycler_request);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        Gson gson = new GsonBuilder().create();




        Call<Permission_Model> call = smartiotAPI.givePerms(permission_Model);

        call.enqueue(new Callback<Permission_Model>() {
            @Override
            public void onResponse(Call<Permission_Model> call, Response<Permission_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(activity, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Permission_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                try {
                    Toast.makeText(activity, postResponse.getMessage(), Toast.LENGTH_SHORT).show();



                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Permission_Model> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });


    }

    public void changeItem(int position, String text) {
        Toast.makeText(activity, list.get(position).getEndPoint(), Toast.LENGTH_SHORT).show();


        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Request Permission for Endpoint "+list.get(position).getEndPoint());
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Grant", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                new Permission_Request(list.get(position).getUserId(),list.get(position).getEndPoint(),list.get(position).getId(),"1",activity);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("Deny ", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Permission_Request(list.get(position).getUserId(),list.get(position).getEndPoint(),list.get(position).getId(),"0",activity);
                dialog.cancel();

            }

        });

        builder.show();
    }
}

