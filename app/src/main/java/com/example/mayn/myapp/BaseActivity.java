package com.example.mayn.myapp;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.mayn.myapp.NetworkUtils.StatusBarCompat;
import com.example.mayn.myapp.bean.PersonBean;

import java.util.Stack;


public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this, Color.parseColor("#0574E6"));
    }

    public void testMode(){
        PersonBean.Builder builder=new PersonBean.Builder();
        PersonBean personBean=builder.name("shuqinggang")
                .age("28")
                .height(180)
                .weight(50)
                .build();
    }

}
