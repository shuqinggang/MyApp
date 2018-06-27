package com.example.mayn.myapp.NetworkUtils;

import android.util.Log;

import com.example.mayn.myapp.bean.Person;

/**
 * Created by shuqinggang on 2018/6/20.
 */

public class MyLike implements Person {
    public static final String TAG="MyLike";
    @Override
    public String single(String name) {
        Log.e(TAG,"single"+name);
        return "我喜欢的歌曲"+name;
    }

    @Override
    public String dance(String name) {
        Log.e(TAG,"dance"+name);
        return "我喜欢的舞蹈"+name;
    }
}
