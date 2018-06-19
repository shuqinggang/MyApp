package com.example.mayn.myapp.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by shuqinggang on 2018/6/19.
 */

public class MultipleItem implements MultiItemEntity {
    public static final int HEADER = 1;
    public static final int CONTENT = 2;

    public String name;
    public String content;
    public int itemType;
    @Override
    public int getItemType() {
        return itemType;
    }
}
