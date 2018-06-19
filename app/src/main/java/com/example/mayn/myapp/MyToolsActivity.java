package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mayn.myapp.NetworkUtils.AppInfoUtils;
import com.example.mayn.myapp.NetworkUtils.Application;

import java.util.List;

public class MyToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tools);
        getAalicationInfor();
    }
    public void getAalicationInfor(){
       List<Application> list= AppInfoUtils.getAllApplication(this);
       Log.e("MyToolsActivity",list.toString());
    }
}
