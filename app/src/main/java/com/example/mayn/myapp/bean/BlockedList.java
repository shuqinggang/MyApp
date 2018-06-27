package com.example.mayn.myapp.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shuqinggang on 2018/6/26.
 */

public class BlockedList implements Serializable {


    /**
     * success : 1
     * list : [{"username":"test@cake.com","nickname":"test","gender":1,"country":"USA","countrycode":"CA","city":"","image":"https://s3.amazonaws.com/voicecall/868336e6-217a-4458-b6a3-b7c493c87cd0.png","type":1,"region":""}]
     */

    private int success;
    private ArrayList<BlockedBean> list;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public ArrayList<BlockedBean> getList() {
        return list;
    }

    public void setList(ArrayList<BlockedBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BlockedList{" +
                "success=" + success +
                ", list=" + list +
                '}';
    }
}
