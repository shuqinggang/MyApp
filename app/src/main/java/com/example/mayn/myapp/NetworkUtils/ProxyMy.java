package com.example.mayn.myapp.NetworkUtils;

import android.util.Log;

import com.example.mayn.myapp.bean.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shuqinggang on 2018/6/20.
 */

public class ProxyMy {
    private Person persons=new MyLike();
    public Person getProxy(){
        return (Person) Proxy.newProxyInstance(MyLike.class.getClassLoader(), persons.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sing")){
                    return method.invoke(persons,args);
                }
                if(method.getName().equals("dance")){
                    return method.invoke(persons,args);
                }
                return null;
            }
        });
    }
}
