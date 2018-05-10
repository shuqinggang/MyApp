package com.example.mayn.myapp;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.mayn.myapp.NetworkUtils.StatusBarCompat;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this, Color.parseColor("#0574E6"));
    }
}
