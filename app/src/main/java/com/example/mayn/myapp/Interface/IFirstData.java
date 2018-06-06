package com.example.mayn.myapp.Interface;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/5.
 */

public interface IFirstData<T> {
    List<T> getNextData(int page);
    List<T> getMessageData();
}
