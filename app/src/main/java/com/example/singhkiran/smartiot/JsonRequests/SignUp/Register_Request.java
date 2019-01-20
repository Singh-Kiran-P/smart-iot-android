package com.example.singhkiran.smartiot.JsonRequests.SignUp;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.SmartiotAPI;
import com.example.singhkiran.smartiot.JsonRequests.retrofit2_config;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.SignupActivity;

import java.io.IOError;

import retrofit2.Call;
import retrofit2.Callback;

public class Register_Request {
    private SmartiotAPI smartiotAPI;
    Context context;
    //get value's from inputbox login and password
    final EditText name = ((SignupActivity) context).findViewById(R.id.et_name);
    final EditText email = ((SignupActivity) context).findViewById(R.id.et_email);
    final EditText username = ((SignupActivity) context).findViewById(R.id.et_username);
    final EditText password = ((SignupActivity) context).findViewById(R.id.et_password);
    final EditText password2 = ((SignupActivity) context).findViewById(R.id.et_password2);

    public void MakeRequest(final Context context1) {
        context = context1;

        API_Server api_server = new API_Server();
        if (password != password2) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_SHORT).show();
        }

        retrofit2_config retrofit2 = new retrofit2_config();
        smartiotAPI =retrofit2.retrofit.create(SmartiotAPI.class);
        createRequest();

    }

    private void createRequest() {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        final Register_Model register = new Register_Model(Name,Email,Username,Password);


        Call<Register_Model> call = smartiotAPI.registerPost(register);

        call.enqueue(new Callback<Register_Model>() {
            @Override
            public void onResponse(Call<Register_Model> call, retrofit2.Response<Register_Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code :" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Register_Model postResponse = response.body();
                // response
                Log.d("Response", postResponse.toString());
                try {
/*
                    Intent intent = new Intent(context, Main_Page.class);
                    intent.putExtra("info",Login_Model.class);
                    context.startActivity(intent);
*/
                    Toast.makeText(context, postResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (IOError e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Register_Model> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });

    }


}
