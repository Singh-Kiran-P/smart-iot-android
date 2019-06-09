package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Request;
import com.example.singhkiran.smartiot.R;

public class DevicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_devices);
        new Device_Request(this);



    }
}
