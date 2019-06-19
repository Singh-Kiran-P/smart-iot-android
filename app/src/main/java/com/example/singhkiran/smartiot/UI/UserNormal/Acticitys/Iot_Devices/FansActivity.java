package com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Iot.Led.Led_Request;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest.ChangePermission_Request;
import com.example.singhkiran.smartiot.R;

public class FansActivity extends AppCompatActivity {
    SwitchCompat switchFan1, switchFan2;
    ImageView imageView, imageView2;
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

        switchFan2 = findViewById(R.id.switchButton_FAN2);
        imageView2 = findViewById(R.id.imageView_FAN2);
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));


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

        switchFan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchFan2.isChecked()) {
                    imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "fan_main", FansActivity.this);


                } else {
                    imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "fan_main", FansActivity.this);


                }
            }
        });
    }

    public void request_FanMain(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new  ChangePermission_Request(userId,"fan_main",FansActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FansActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }

    public void request_Fan01(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");

        builder.setIcon(R.drawable.ic_quesetion);
        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new  ChangePermission_Request(userId,"fan01",FansActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FansActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }
}

