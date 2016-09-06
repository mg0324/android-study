package com.tomise.meigang.learnintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BActivity extends AppCompatActivity {
    public static final String ACTION = "com.tomise.meigang.learnintent.intent.BActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        String uri = getIntent().getData().toString();
        Toast.makeText(BActivity.this,"uri:"+uri,Toast.LENGTH_LONG).show();
    }
}
