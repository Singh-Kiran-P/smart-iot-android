package com.example.singhkiran.smartiot.Firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebase extends FirebaseMessagingService {
    public static String Refreshed_Token;

    @Override
    public void onNewToken(String token) {
        Log.d("Token", "Refreshed token: " + token);
        Refreshed_Token = token;
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
    }
}
