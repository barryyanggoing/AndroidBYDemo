package com.xigua.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.xigua.aidldemo1.IMyBinder;

/**
 * @author : BarryYang
 * @date : 2021/6/19 5:26 下午
 * @desc :
 */
public class AidlService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public static class MyBinder extends IMyBinder.Stub {

        @Override
        public void testAidl() throws RemoteException {
            Log.i("BarryYang", "testaidl111");
        }
    }

}
