package com.example.myapplication.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.model.FaceBin;
import com.example.myapplication.utils.AssetUtil;
import com.example.myapplication.utils.XmlUtil;

import java.io.InputStream;
import java.util.Optional;

public class ShowLoverActivity extends Activity {
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity", "Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
        mIntent = getIntent();
        String paramVal = mIntent.getStringExtra("param1");
        Log.d("SecondActivity", "paramVal is " + paramVal);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setVisibility(View.INVISIBLE);
            }
        });

        Optional<InputStream> inputStreamOptional = AssetUtil.getAssetInputStream("");
        inputStreamOptional.ifPresent(inputStream -> {
            FaceBin faceBin = XmlUtil.pull2xml(inputStream);
            Log.d("ShowLoverActivity", faceBin.getFrom());
        });
    }
}
