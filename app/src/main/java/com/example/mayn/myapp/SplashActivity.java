package com.example.mayn.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.myapp.NetworkUtils.LogUtil;
import com.example.mayn.myapp.NetworkUtils.MyThreadPoolExecultor;
import com.mob.tools.MobLog;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends BaseActivity {

    TextView tx_start,tx_stop,tx_all_stop;
    boolean flag=true;
    List<String> lists;

    //轮播地址https://github.com/Bigkoo/Android-ConvenientBanner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tx_start=(TextView)findViewById(R.id.tx_start);
        tx_stop=(TextView)findViewById(R.id.tx_stop);
        tx_all_stop=(TextView)findViewById(R.id.tx_all_stop);
        lists=new ArrayList<>();
        lists.add("123456");
        lists.add("369852");

        tx_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,LifeActivity.class);
                Bundle bundle=new Bundle();
             //   bundle.putParcelableArrayList("lists", lists);
                bundle.putStringArrayList("lists", (ArrayList<String>) lists);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SplashActivity","onstart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("SplashActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SplashActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SplashActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SplashActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SplashActivity","onDestroy");
    }
}
