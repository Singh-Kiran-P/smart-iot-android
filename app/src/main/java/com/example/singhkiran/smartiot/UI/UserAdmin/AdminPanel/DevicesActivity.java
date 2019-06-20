package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Request;
import com.example.singhkiran.smartiot.R;

public class DevicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_devices);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Devices");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
        new Device_Request(this);



    }
}
