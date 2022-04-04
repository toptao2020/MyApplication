package com.example.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication.services.AlarmServices;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "onReceive");
        Intent i = new Intent(context, AlarmServices.class);
//        context.startService(i);
    }
}
