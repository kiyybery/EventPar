package com.example.zihua.eventpar;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

/**
 * Created by zihua on 2015/9/17.
 */
public class OtherActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_layout);
        btn = (Button) findViewById(R.id.other_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.other_btn:
                //传递“11111”的信息到EventBus的机制，等待Main取出
                //(bean里面有一个接收字符串的方法)
                EventBus.getDefault().post(new Type("11111"));
        }
    }
}
