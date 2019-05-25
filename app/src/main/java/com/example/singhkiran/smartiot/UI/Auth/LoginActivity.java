package com.example.singhkiran.smartiot.UI.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Request;
import com.example.singhkiran.smartiot.R;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    private Button signup_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //set default API_Url
        API_Server api_server = new API_Server();
        api_server.setServer_url(API_Server.DefauldServerURL);


        //set onclick listener for signup page button
        signup_page = (Button) findViewById(R.id.btn_signup);
        signup_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupPage();
            }
        });

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

    }

    //open signup activity
    private void openSignupPage() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    //On click Login Button
    public void login(View view) {
        try {
            Login_Request login_request = new Login_Request();
            login_request.MakeRequest(this);
        }catch (Error e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    //On click signup Button
    public void signup_btn(View view) {

        //open signup page
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}


