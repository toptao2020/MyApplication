package com.example.myapplication.services;

import android.Manifest;
import android.app.AlarmManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.security.Provider;

public class LocationServices extends Service {
    private static String TAG = "LocationServices";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = LocationManager.NETWORK_PROVIDER;// 指定LocationManager的定位方法

        // NETWORK_PROVIDER 网络定位、GPS_PROVIDER GPS定位
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.w(TAG, "don't have permission");
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        // 调用getLastKnownLocation()方法获取当前的位置信息
        double lat = location.getLatitude();//获取纬度
        double lng = location.getLongitude();//获取经度
        Log.d(TAG,"the location is : lat :" + lat);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
