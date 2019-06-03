package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.singhkiran.smartiot.JsonRequests.AdminPanel.Devices.Device_Request;
import com.example.singhkiran.smartiot.R;

public class DevicesActivity extends AppCompatActivity {
    String[] listArray = {"Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android","Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android","Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_devices);
        new Device_Request(this);



    }
}
