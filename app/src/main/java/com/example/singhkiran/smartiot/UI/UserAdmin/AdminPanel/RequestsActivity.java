package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Feedback.Feedback_Request;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Request;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Request;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.RequestAdapter;

import java.util.ArrayList;
import java.util.List;

public class RequestsActivity extends AppCompatActivity implements RequestAdapter.onRequestListener {
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_requests);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
        actionBar.setTitle("Requests");
        this.mHandler = new Handler();
        m_Runnable.run();

        new Permission_Request(this);

    }
    List<Permission_Model> mRequest;
    @Override
    public void onRequestClick(int position) {
        mRequest.get(position);
//        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }

    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
//            Toast.makeText(FeedbackActivity.this,"in runnable",Toast.LENGTH_SHORT).show();
            new Permission_Request(RequestsActivity.this);

            RequestsActivity.this.mHandler.postDelayed(m_Runnable,2000);
        }

    };
    @Override
    protected void onStop() {
        super.onStop();
        RequestsActivity.this.mHandler.removeCallbacksAndMessages(null);
    }

}
