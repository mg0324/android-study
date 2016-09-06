package com.tomise.meigang.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView taskValue = (TextView) findViewById(R.id.tvTaskValue);
        taskValue.setText(String.format("TaskId:%s",getTaskId()));

        TextView instanceValue = (TextView) findViewById(R.id.tvInstance);
        instanceValue.setText(String.format("CurrentInstance:%s",toString()));

        findViewById(R.id.btnAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.BtnB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,BActivity.class);
                startActivity(i);
            }
        });
    }
}
