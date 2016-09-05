package com.tomise.meigang.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvReturnValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvReturnValue = (TextView) findViewById(R.id.tvForReturnValue);

        findViewById(R.id.btnOpenAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,OtherActivity.class);
                //1.简单数据传递
                i.putExtra("data","where are you?");
                //2.数据包传递
                Bundle b = new Bundle();
                b.putString("name","xiaogang");
                b.putInt("age",23);
                i.putExtra("bundle",b);
                //3.传递值对象
                Bundle c = new Bundle();
                User u = new User("xiaohong",20);
                //c.putSerializable("user",u);
                c.putParcelable("user",u);
                i.putExtra("userBundle",c);

                //4.接收返回值
                startActivityForResult(i,1);
                //使用意图启动activity
                //startActivity(i);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String red = data.getStringExtra("dd");
        tvReturnValue.setText(red);//写入显示
    }
}
