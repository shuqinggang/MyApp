package com.example.mayn.myapp;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by shuqinggang on 2018/6/5.
 * 单列模式
 * activity管理类
 */

public class ActivityManager {
    private static  volatile BaseActivity instance;
    private Stack<Activity> activityStack=new Stack<>();
    private ActivityManager(){
    }

    public static BaseActivity getInstance(){
        if(instance==null){
            synchronized (BaseActivity.class){
                if(instance==null){
                    instance=new BaseActivity();
                }
            }
        }
        return instance;
    }
    public void addActivity(Activity activity){
        activityStack.push(activity);
    }

    public void removeActivity(Activity activity){
        activityStack.remove(activity);
    }

    public void killMyProcess(){
        int nCount = activityStack.size();
        for (int i = nCount - 1; i >= 0; i--) {
            Activity activity = activityStack.get(i);
            activity.finish();
        }

        activityStack.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
