package com.example.singhkiran.smartiot.UI.UserNormal.Iot_Devices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singhkiran.smartiot.R;

public class LedActivity extends AppCompatActivity {
    SwitchCompat switchCompat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrml_iot_activity_led);

        switchCompat = findViewById(R.id.switchButton);
        imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat.isChecked()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledon));
                    Toast.makeText(LedActivity.this, "Led1 ON", Toast.LENGTH_SHORT).show();


                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ledoff));
                    Toast.makeText(LedActivity.this, "Led1 OFF", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
