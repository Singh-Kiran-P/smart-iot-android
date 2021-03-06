package com.example.singhkiran.smartiot.JsonRequests.Login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.Auth.LoginActivity;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.AdminLoadAppActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.NormalLoadAppActivity;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Request {

    API_Server api_server = new API_Server();
    String username_result;
    String password_result;
    Context context;
    private SmartiotAPI smartiotAPI;

    public void MakeRequest(Context context1) {
        //get value's from inputbox login and password
        context = context1;
        final EditText username = ((LoginActivity) context).findViewById(R.id.et_username);
        final EditText password = ((LoginActivity) context).findViewById(R.id.et_password);
        username_result = username.getText().toString();
        password_result = password.getText().toString();
        Log.d("Server_url", "login: " + api_server.getServer_url());

        //change server Server_url
        if (password_result.equals("sr")) {

            if (username_result.equals("")) {
                Toast.makeText(context, "Server changed to => " + api_server.getServer_url(), Toast.LENGTH_SHORT).show();
                Log.d("Server_url", "login: " + api_server.getServer_url());
                return;
            }
            if (!username_result.equals("")) {
                api_server.setServer_url("http://" + username_result+":8080");
                Toast.makeText(context, "Server changed to => " + api_server.getServer_url(), Toast.LENGTH_SHORT).show();
                return;

            }
        }
        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI = retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void createRequest() {
        final Login_Model login = new Login_Model(username_result, password_result);

        Call<Login_Model> call = smartiotAPI.loginPost(login);

        call.enqueue(new Callback<Login_Model>() {
            @Override
            public void onResponse(Call<Login_Model> call, Response<Login_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Login_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                try {

                    if (postResponse.getRole() == null) {
                        Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if (postResponse.getRole().equals("admin")) {
                        Intent intent = new Intent(context, AdminLoadAppActivity.class);
                        if (postResponse.getStatus().equals("200")) {
                            intent.putExtra("info", postResponse);
                            context.startActivity(intent);
                            Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        if (!postResponse.getStatus().equals("200")) {

                            Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (postResponse.getRole().equals("normal_user")) {
                        Intent intent = new Intent(context, NormalLoadAppActivity.class);
                        if (postResponse.getStatus().equals("200")) {
                            intent.putExtra("info", postResponse);
                            context.startActivity(intent);
                            Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        if (!postResponse.getStatus().equals("200")) {

                            Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }


                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Login_Model> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });

    }
}
