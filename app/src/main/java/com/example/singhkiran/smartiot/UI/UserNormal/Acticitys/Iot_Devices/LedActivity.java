package com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class LedActivity extends AppCompatActivity {
    SwitchCompat switchCompat;
    ImageView imageView;
    SwitchCompat switchCompat1, switchCompat3, switchCompat4;
    ImageView imageView1, imageView3, imageView4;

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

        switchCompat3 = findViewById(R.id.switchButton3);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

        switchCompat4 = findViewById(R.id.switchButton4);
        imageView4 = findViewById(R.id.imageView4);
        imageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
        SharedPreferences prefss = getSharedPreferences("acti", MODE_PRIVATE);
        boolean LED1 = prefss.getBoolean("led01", false);
        boolean LED2 = prefss.getBoolean("led02", false);
        boolean LED3 = prefss.getBoolean("led03", false);
        boolean LED4 = prefss.getBoolean("led04", false);
        if (LED1) {
            switchCompat.setChecked(LED1);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

        }
        if (LED2) {
            switchCompat1.setChecked(LED2);
            imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

        }
        if (LED3) {
            switchCompat3.setChecked(LED3);
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

        }
        if (LED4) {
            switchCompat4.setChecked(LED4);
            imageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

        }

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat.isChecked()) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));

                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led01", LedActivity.this);

                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led01", switchCompat.isChecked());
                    editor.apply();


                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led01", false);
                    editor.apply();
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
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led02", true);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led02", LedActivity.this);


                } else {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led02", false);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "led02", LedActivity.this);


                }
            }
        });
        switchCompat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat3.isChecked()) {
                    imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led03", true);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led03", LedActivity.this);


                } else {
                    imageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led03", false);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "led03", LedActivity.this);


                }
            }
        });
        switchCompat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat4.isChecked()) {
                    imageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led04", true);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("1", userId, "led04", LedActivity.this);


                } else {
                    imageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
                    SharedPreferences.Editor editor = getSharedPreferences("acti", MODE_PRIVATE).edit();
                    editor.putBoolean("led04", false);
                    editor.apply();
                    Intent intent = getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    String userId = login_response.getId();

                    new Led_Request("0", userId, "led04", LedActivity.this);
                    switchCompat4.setChecked(false);

                }
            }
        });
    }

    public void request_Led01(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new ChangePermission_Request(userId, "led01", LedActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LedActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }

    public void request_Led2(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new ChangePermission_Request(userId, "led02", LedActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LedActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }

    public void request_Led3(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new ChangePermission_Request(userId, "led03", LedActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LedActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }

    public void request_Led4(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Request Permission for this Endpoint");
        builder.setIcon(R.drawable.ic_quesetion);

        builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                String userId = login_response.getId();
                new ChangePermission_Request(userId, "led04", LedActivity.this);
                dialog.cancel();
            }

        });

        builder.setNegativeButton("No", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LedActivity.this, "Request canceled", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }

        });

        builder.show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
    }
}
