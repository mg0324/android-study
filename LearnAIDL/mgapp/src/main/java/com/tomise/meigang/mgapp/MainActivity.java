package com.tomise.meigang.mgapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.tomise.meigang.learnaidl.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private static final String TAG = "mgapp.MainActivity";

    private EditText editText;
    private Intent i;
    private IMyAidlInterface it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOuterStart).setOnClickListener(this);
        findViewById(R.id.btnOuterStop).setOnClickListener(this);
        findViewById(R.id.btnOuterBind).setOnClickListener(this);
        findViewById(R.id.btnOuterUnbind).setOnClickListener(this);

        i = new Intent("com.tomise.meigang.learnaidl.intent.action.MyService");
        i.setComponent(new ComponentName("com.tomise.meigang.learnaidl","com.tomise.meigang.learnaidl.MyService"));
        editText = (EditText) findViewById(R.id.editText);
        findViewById(R.id.btnShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String data = editText.getText().toString();
                    Log.i(TAG,"mgapp set data:"+ data);
                    it.setData(data);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOuterStart:
                //跨APP调用service
                startService(i);
                break;
            case R.id.btnOuterStop:
                stopService(i);
                break;
            case R.id.btnOuterBind:
                bindService(i,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnOuterUnbind:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            it = IMyAidlInterface.Stub.asInterface(service);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG,"mgapp MyService onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i(TAG,"mgapp MyService onServiceDisconnected");
    }
}
