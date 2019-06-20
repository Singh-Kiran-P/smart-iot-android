package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Feedback.Feedback_Request;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.LedActivity;

public class FeedbackActivity extends AppCompatActivity {
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_feedback);
        this.mHandler = new Handler();
        m_Runnable.run();


        ActionBar actionBar;
        actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
        actionBar.setTitle("Feedback");

        new Feedback_Request(this);

    }

    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
//            Toast.makeText(FeedbackActivity.this,"in runnable",Toast.LENGTH_SHORT).show();
            new Feedback_Request(FeedbackActivity.this);

            FeedbackActivity.this.mHandler.postDelayed(m_Runnable,2000);

        }

    };

    @Override
    protected void onStop() {
        super.onStop();
        FeedbackActivity.this.mHandler.removeCallbacksAndMessages(null);
    }
}

