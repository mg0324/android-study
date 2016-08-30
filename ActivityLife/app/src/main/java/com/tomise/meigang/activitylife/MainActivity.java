package com.tomise.meigang.activitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(this.getLocalClassName()+"->onCreate");

        findViewById(R.id.button_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(this.getLocalClassName()+"->onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(this.getLocalClassName()+"->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(this.getLocalClassName()+"->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(this.getLocalClassName()+"->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(this.getLocalClassName()+"->onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(this.getLocalClassName()+"->onRestart");
    }
}
