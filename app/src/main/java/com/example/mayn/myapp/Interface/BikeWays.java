package com.example.mayn.myapp.Interface;

import android.util.Log;

/**
 * Created by shuqinggang on 2018/6/5.
 */

public class BikeWays implements StraveInterface {
    @Override
    public void travel(String ways) {
        Log.e("BikeWays",ways);
    }
}
