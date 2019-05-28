package com.example.singhkiran.smartiot.UI.UserNormal.Iot_Devices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.singhkiran.smartiot.R;

public class UltraSensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra_sensor);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.my_progressBar);
        progressBar.setProgress(20);
    }

    public void Measure(View view) {
    }
}
