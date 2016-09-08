package com.tomise.meigang.learnservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.widget.TextView;
import android.widget.Toast;

import com.mg.android.utils.MGUtils;

import java.util.Date;

public class MyService extends Service{
    private boolean isLive = true;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        System.out.println("MyService onBind");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //MGUtils.showToast(this,"MyService Create");
        System.out.println("MyService Create");

        //开启线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(isLive){
                    //MGUtils.showToast(getApplicationContext(),"服务running at "+new Date().toLocaleString());
                    System.out.println("服务running at "+new Date().toLocaleString());
                    try {
                        sleep(1000);//休眠1秒
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
        //MGUtils.showToast(this,"MyService Destroy");
        setLive(false);
        System.out.println("MyService Destroy");
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    private MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder{

    }

}
