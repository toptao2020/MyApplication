package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.services.AlarmServices;
import com.example.myapplication.services.LocationServices;
import com.example.myapplication.utils.AssetUtil;
import com.example.myapplication.view.activity.ShowLoverActivity;

public class MainActivity extends Activity {
    private TextView mTextView;

    private Button mButton;

    private Button mAlarmButton;

    private Button mServiceButton;

    private Context mContext;

    private int sumVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mAlarmButton = findViewById(R.id.alarmButton);
        mServiceButton = findViewById(R.id.serviceButton);
        AssetUtil.setAssetManager(getAssets());
        mButton.setOnClickListener(v -> {
            sumVal++;
            mTextView.setText(sumVal % 2 == 0 ? "lover" : "123");
        });
        mContext = this;
        mAlarmButton.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, AlarmServices.class);
            startService(intent);
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowLoverActivity.class);
                intent.putExtra("param1", "data1");
                intent.putExtra("param2", "data2");
                startActivity(intent);
            }
        });
        mServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LocationServices.class);
                startService(intent);
            }
        });
    }
}