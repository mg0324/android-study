package com.tomise.meigang.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.显示调用
                //startActivity(new Intent(MainActivity.this,BActivity.class));
                //2.隐示调用
                //startActivity(new Intent("actionName"));
                //startActivity(new Intent(BActivity.ACTION));
                //通过scheme参数匹配调用
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("meigang://hello")));

            }
        });

    }
}
