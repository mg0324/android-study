package com.tomise.meigang.learnbroatcastreveiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                Intent i = new Intent();
                i.setAction("com.tomise.meigang.mggb");//指定发送广播频道
                i.putExtra("data",editText.getText().toString());
                //sendBroadcast(i);//发送随机广播
                sendOrderedBroadcast(i,null);//发送顺序广播
            }
        });
    }



}
