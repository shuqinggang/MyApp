package com.example.mayn.myapp.Interface;

import com.example.mayn.myapp.NetworkUtils.Haizizhuanpingying;

/**
 * Created by shuqinggang on 2018/6/28.
 */

public class Person {
    String name;
    String pinying;
    String firstpingyin;

    public Person(String name) {
        this.name = name;
        this.pinying= Haizizhuanpingying.getPingyin(name);
        this.firstpingyin= Haizizhuanpingying.getPinyingDa(Haizizhuanpingying.getPingyin(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinying() {
        return pinying;
    }

    public void setPinying(String pinying) {
        this.pinying = pinying;
    }

    public String getFirstpingyin() {
        return firstpingyin;
    }

    public void setFirstpingyin(String firstpingyin) {
        this.firstpingyin = firstpingyin;
    }
}
