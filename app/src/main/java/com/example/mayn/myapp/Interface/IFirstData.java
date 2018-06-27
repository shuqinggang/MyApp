package com.example.mayn.myapp.Interface;

import android.content.Context;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/5.
 */

public interface IFirstData<T> {
    List<T> getNextData(int page, Context context);
    List<T> getMessageData();
    List<T> getDatas();
}
