package com.tomise.meigang.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent("com.tomise.meigang.learnintent.intent.BActivity"));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"不允许调用LearnIntent APP中的组件",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
