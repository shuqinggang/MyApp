package com.example.mayn.myapp.NetworkUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shuqinggang on 2018/6/26.
 */

public class AppRequest {
    private static String BASE_URL="http://www.cake.tv/";
    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor())
            .retryOnConnectionFailure(true) // 断线重连
            .connectTimeout(20, TimeUnit.SECONDS)   // 连接超时时间
            .build();

    static Retrofit.Builder builder=new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL);

    public static <T> T createService(Class<T> serviceClass) {
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}
