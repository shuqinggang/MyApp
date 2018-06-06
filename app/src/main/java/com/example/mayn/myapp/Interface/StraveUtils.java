package com.example.mayn.myapp.Interface;

/**
 * Created by shuqinggang on 2018/6/5.
 *  策略模式
 *
 */

public class StraveUtils {
    StraveInterface straveInterface;

    public StraveInterface getStraveInterface() {
        return straveInterface;
    }

    public void setStraveInterface(StraveInterface straveInterface) {
        this.straveInterface = straveInterface;
    }
    public void travel(String ways){
        if(straveInterface!=null){
            straveInterface.travel(ways);
        }
    }
}
