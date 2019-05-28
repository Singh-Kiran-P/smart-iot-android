package com.example.singhkiran.smartiot.Firebase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.singhkiran.smartiot.R;

public class FirebaseMainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationManager mnotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            NotificationChannel mChannel = new NotificationChannel(Constants.CHANNEL_ID,Constants.CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);

            mChannel.setDescription(Constants.CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});

            mnotificationManager.createNotificationChannel(mChannel);
        }


    }
}
