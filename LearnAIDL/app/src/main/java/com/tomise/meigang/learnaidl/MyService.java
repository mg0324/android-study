package com.tomise.meigang.learnaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service{
    public static final String TAG = "MyService";
    private boolean running = true;
    private String data = "默认";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.i(TAG,"返回");
        return myBinder;
        //Log.i(TAG,"接收到的数据："+intent.getStringExtra("data").toString());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"MyService create");
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (running){
                    Log.i(TAG,"myservice is running...接收到的数据是："+MyService.this.data);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MyService destroy");
        this.running = false;
    }

    private IMyAidlInterface.Stub myBinder = new IMyAidlInterface.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setData(String data) throws RemoteException {
            MyService.this.data = data;
            //Log.i(TAG,"接收"+data);
        }
    };
}
