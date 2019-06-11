package com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Request;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;

public class LedActivity extends AppCompatActivity {
    SwitchCompat switchCompat;
    ImageView imageView;
    SwitchCompat switchCompat1;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrml_iot_activity_led);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));

        switchCompat = findViewById(R.id.switchButton);
        imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

        switchCompat1 = findViewById(R.id.switchButton1);
        imageView1 = findViewById(R.id.imageView1);
        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat.isChecked()) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led01", LedActivity.this);


                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "led01", LedActivity.this);


                }
            }
        });
        switchCompat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat1.isChecked()) {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led02", LedActivity.this);


                } else {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "led02", LedActivity.this);


                }
            }
        });
    }
}
