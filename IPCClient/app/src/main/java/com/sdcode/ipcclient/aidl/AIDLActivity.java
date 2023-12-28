package com.sdcode.ipcclient.aidl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sdcode.ipcclient.R;
import com.sdcode.ipcserver.IMathAidlInterface;

public class AIDLActivity extends AppCompatActivity {
    private final String TAG = "AIDLActivity";
    IMathAidlInterface iMathAidlService;
    Button sumBtn;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: Initialize service 1.");
            iMathAidlService = IMathAidlInterface.Stub.asInterface(service);
            Log.d(TAG, "onServiceConnected: Initialize service 2.");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidlactivity);

        sumBtn = findViewById(R.id.sumBtn);
        Intent i = new Intent("SUM");
        i.setPackage("com.sdcode.ipcserver");
        boolean bindResult = bindService(i, serviceConnection, BIND_AUTO_CREATE);
        Log.d(TAG, "bindService result: " + bindResult);

        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(), "Sum is :"+ iMathAidlService.sum(10, 20),Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onCreate: do sum :-" + iMathAidlService.sum(10, 20));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}