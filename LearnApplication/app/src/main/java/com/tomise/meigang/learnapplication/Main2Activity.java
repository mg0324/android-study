package com.tomise.meigang.learnapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private EditText edInput;
    App app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        app = (App) getApplicationContext();
        TextView tvLabel = (TextView) findViewById(R.id.tvLabel);
        tvLabel.setText(app.getData());
        edInput = (EditText) findViewById(R.id.etInput);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setData(edInput.getText().toString());
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }


}
