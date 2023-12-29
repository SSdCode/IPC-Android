package com.sdcode.ipcserver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sdcode.ipcserver.intent.MyBroadcastReceiver;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("SAMIR_CUSTOM_ACTION");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myBroadcastReceiver, intentFilter, Context.RECEIVER_EXPORTED);

        findViewById(R.id.sendCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("SAMIR_CUSTOM_ACTION"));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(myBroadcastReceiver);
    }
}