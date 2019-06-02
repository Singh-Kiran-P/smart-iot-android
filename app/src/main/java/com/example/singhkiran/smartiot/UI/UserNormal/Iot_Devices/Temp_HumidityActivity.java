package com.example.singhkiran.smartiot.UI.UserNormal.Iot_Devices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.singhkiran.smartiot.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Temp_HumidityActivity extends AppCompatActivity {
    TextView txt_temp;
    TextView txt_humidity;
    DatabaseReference databaseReference;
    String status_temp;
    String status_humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrml_activity_temp_humidity);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));



        txt_temp = findViewById(R.id.txt_temp);
        txt_humidity = findViewById(R.id.txt_humidity);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status_temp = dataSnapshot.child("Temperature").getValue().toString();
                status_humidity = dataSnapshot.child("Humidity").getValue().toString();
                txt_temp.setText(status_temp);
                txt_humidity.setText(status_humidity);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
