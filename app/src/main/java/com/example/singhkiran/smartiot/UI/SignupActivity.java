package com.example.singhkiran.smartiot.UI;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.JsonRequests.SignUp.SignUp_Request;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void signup_btn(View view) {
        SignUp_Request signUp_request = new SignUp_Request();
        signUp_request.MakeRequest(this);
    }
}
