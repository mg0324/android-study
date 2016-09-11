package com.tomise.meigang.learnbroatcastreveiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        String data = intent.getStringExtra("data");
        Log.i("MyReceiver","接收到广播："+data);
        abortBroadcast();
    }
}
