package com.sdcode.ipcserver.intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyBroadcastReceiver", "onReceive: " + intent.getAction());
        if (Objects.equals(intent.getAction(), Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, "AIRPLANE_MODE_CHANGED", Toast.LENGTH_SHORT).show();
        } else if (Objects.equals(intent.getAction(), "SAMIR_CUSTOM_ACTION")) {
            Toast.makeText(context, "SAMIR_CUSTOM_ACTION", Toast.LENGTH_SHORT).show();
        }
    }

}
