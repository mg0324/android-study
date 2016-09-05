package com.tomise.meigang.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                c.putSerializable("user",u);
                i.putExtra("userBundle",c);

                //4.接收返回值
                
                //使用意图启动activity
                startActivity(i);

            }
        });
    }
}
