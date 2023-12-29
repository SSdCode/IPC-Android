package com.sdcode.ipcclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sdcode.ipcclient.aidl.AIDLActivity;
import com.sdcode.ipcclient.intent.SendBroadcast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private Button aidl_Example, sendCustomBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aidl_Example = findViewById(R.id.aidl_Example);
        sendCustomBroadcast = findViewById(R.id.sendCustomBroadcast);

        aidl_Example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AIDLActivity.class));
            }
        });

        sendCustomBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendBroadcast.sendCustomBroadcast(getApplicationContext(), "SAMIR_CUSTOM_ACTION");
            }
        });
    }
}