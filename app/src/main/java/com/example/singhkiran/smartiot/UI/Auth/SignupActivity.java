package com.example.singhkiran.smartiot.UI.Auth;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.JsonRequests.SignUp.Register_Request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void signup_btn(View view) {
        Register_Request signUp_request = new Register_Request();
        signUp_request.MakeRequest(this);

    }
}
