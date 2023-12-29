package com.sdcode.ipcclient.intent;

import android.content.Context;
import android.content.Intent;

public class SendBroadcast {
    public static void sendCustomBroadcast(Context context, String action){
        context.sendBroadcast(new Intent(action));
    }
}
