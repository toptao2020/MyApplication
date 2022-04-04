package com.example.myapplication.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.broadcast.AlarmReceiver;

import java.util.Date;

public class AlarmServices extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AlarmServices", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("AlarmServices", "onStartCommand");
        new Thread(() -> Log.d("AlarmServices", "executed at " + new Date().toString())).start();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anMinuter =10 * 1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anMinuter;
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("AlarmServices", "onDestroy");
    }
}
