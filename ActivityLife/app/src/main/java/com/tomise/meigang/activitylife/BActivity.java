package com.tomise.meigang.activitylife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        System.out.println(this.getLocalClassName()+"->onCreate");
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
