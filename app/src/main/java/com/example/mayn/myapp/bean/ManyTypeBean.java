package com.example.mayn.myapp.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by shuqinggang on 2018/7/4.
 */

public class ManyTypeBean implements MultiItemEntity {
    public static final int BANNER_VIEW_TYPE = 0;//轮播图
    public static final int CHANNEL_VIEW_TYPE = 1;//频道
    public static final int GIRL_VIEW_TYPE = 2;//美女
    public static final int NORMAL_VIEW_TYPE = 3;//正常布局

    public String names;
    public  String content;
    public String url;
    public List<String> lists;
    public int itemType;
    public List<String> titles;
    @Override
    public int getItemType() {
        return itemType;
    }
}
