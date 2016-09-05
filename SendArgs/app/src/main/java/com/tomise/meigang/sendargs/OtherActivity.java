package com.tomise.meigang.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OtherActivity extends AppCompatActivity {

    TextView tvShow;
    TextView tvBundel;
    TextView tvObject;
    EditText etReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        //接收到Intent,并获取参数
        Intent i = getIntent();
        tvShow = (TextView) findViewById(R.id.tvShow);
        tvBundel = (TextView) findViewById(R.id.tvBundleValue);
        tvObject = (TextView) findViewById(R.id.tvObjectValue);
        etReturn = (EditText) findViewById(R.id.etReturn);
        //1.获取简单数据
        String data = i.getStringExtra("data");
        tvShow.setText(data);
        //2.获取数据包
        Bundle b = i.getBundleExtra("bundle");
        tvBundel.setText(String.format("i'm here,%s,%d year old",b.getString("name"),b.getInt("age")));
        //3.获取数据包中值对象
        Bundle c = i.getBundleExtra("userBundle");
        //User u = (User) c.getSerializable("user");
        User u = (User) c.getParcelable("user");
        tvObject.setText(String.format("nice to meet you,i'm %s,%d year old",u.getName(),u.getAge()));
        //4.返回数据给上一个activity
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String str = etReturn.getText().toString();
                intent.putExtra("dd",str);
                //设置返回值
                setResult(1,intent);
                finish();
            }
        });
    }
}
