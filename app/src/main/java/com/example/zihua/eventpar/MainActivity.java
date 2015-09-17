package com.example.zihua.eventpar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册EventBus(切记，在哪个activity要接受，就在哪个注册)
        EventBus.getDefault().register(this);

        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.getid);
        btn = (Button) findViewById(R.id.btnid);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销EventBus事件
        EventBus.getDefault().unregister(this);
    }

    //该方法接受上一个activity传递来的消息。目测是映射机制。
    // （!!这里需要一个Bean来完成收发，也就是get方法）
    public void onEventMainThread(Type type){
        String msg = "onEventMainThread收到了消息：" + type.getMsg();
        Log.d("harvic", msg);
        textView.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnid:
                Intent intent = new Intent();
                intent.setClass(this, OtherActivity.class);
                startActivity(intent);
                break;
        }
    }
}
