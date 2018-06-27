package com.example.mayn.myapp.NetworkUtils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by shuqinggang on 2018/6/27.
 */

public class IOUtil {
    public static void closeAll(Closeable... closeables){
        if(closeables == null){
            return;
        }
        for (Closeable closeable : closeables) {
            if(closeable!=null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
