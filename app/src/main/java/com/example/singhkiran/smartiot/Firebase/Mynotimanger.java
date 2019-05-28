package com.example.singhkiran.smartiot.Firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.Auth.SignupActivity;

public class Mynotimanger {
    private Context mCtx;
    private  static  Mynotimanger mynotimanger;

    private Mynotimanger(Context context){
        mCtx =context;
    }

    public  static synchronized  Mynotimanger getInstance(Context context){
        if(mynotimanger == null){
            mynotimanger = new Mynotimanger(context);

        }
        return mynotimanger;
    }

    public void displaynoti(String title ,String body){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx,Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark_focused)
                .setContentTitle(title)
                .setContentText(body);

        Intent intent = new Intent(mCtx, SignupActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(mCtx,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);

        NotificationManager mnotificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);

        if (mnotificationManager != null){
            mnotificationManager.notify(1,mBuilder.build());
        }
    }
}

