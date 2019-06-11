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

public class FansActivity extends AppCompatActivity {
    SwitchCompat switchFan1;
    ImageView imageView;
    SwitchCompat switchCompat1;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrml_activity_fans);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));


        switchFan1 = findViewById(R.id.switchButton_FAN1);
        imageView = findViewById(R.id.imageView_FAN);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));


        switchFan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchFan1.isChecked()) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "fan01", FansActivity.this);


                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "fan01", FansActivity.this);


                }
            }
        });

    }
}
