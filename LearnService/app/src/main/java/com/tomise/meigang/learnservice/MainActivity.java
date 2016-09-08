package com.tomise.meigang.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    public static TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //启动服务
        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);
        findViewById(R.id.btnBind).setOnClickListener(this);
        findViewById(R.id.btnUnBind).setOnClickListener(this);

        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                //启动服务
                startService(new Intent(this,MyService.class));//类似启动aty
                break;
            case R.id.btnStop:
                //停止服务
                stopService(new Intent(this,MyService.class));//Android操作系统中只会有一个服务实例
                break;
            case R.id.btnBind:
                //绑定服务
                bindService(new Intent(this, MyService.class),this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBind:
                //解绑服务
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("onServiceDisconnected");
    }
}
