package com.sdcode.ipcserver.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.sdcode.ipcserver.IMathAidlInterface;

public class AIDLMathService extends Service {
    public AIDLMathService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IMathAidlInterface.Stub binder = new IMathAidlInterface.Stub() {
        @Override
        public int sum(int a, int b) throws RemoteException {
            return a + b;
        }
    };
}