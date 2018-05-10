package com.example.mayn.myapp;

import android.app.Application;
import android.content.Context;

import com.example.mayn.myapp.NetworkUtils.SharePrefreUtils;
import com.mob.MobSDK;

/**
 * Created by mayn on 2018/5/8.
 */

public class MyApp extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        MobSDK.init(this);
        SharePrefreUtils.inite(mContext);
    }
    public static Context getContext(){
        return mContext;
    }

}
