package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Request;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Request;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.RequestAdapter;

import java.util.ArrayList;
import java.util.List;

public class RequestsActivity extends AppCompatActivity implements RequestAdapter.onRequestListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_requests);


        new Permission_Request(this);

    }
    List<Permission_Model> mRequest;
    @Override
    public void onRequestClick(int position) {
        mRequest.get(position);
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }
}
