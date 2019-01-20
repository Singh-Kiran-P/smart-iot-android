package com.example.singhkiran.smartiot.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;

public class Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void showinfo(View view) {
        Intent intent  = getIntent();
        Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
        //Toast.makeText(this, login_response.getEmail(), Toast.LENGTH_SHORT).show();

        TextView id = findViewById(R.id.tv_id);
        id.setText(login_response.getId());

        TextView name = findViewById(R.id.tv_name);
        name.setText(login_response.getName());

        TextView username = findViewById(R.id.tv_username);
        username.setText(login_response.getUsername());

        TextView email = findViewById(R.id.tv_email);
        email.setText(login_response.getEmail());

        TextView role = findViewById(R.id.tv_role);
        role.setText(login_response.getRole());
    }
}
