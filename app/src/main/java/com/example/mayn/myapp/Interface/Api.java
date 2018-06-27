package com.example.mayn.myapp.Interface;

import com.example.mayn.myapp.bean.BlockedList;
import com.example.mayn.myapp.bean.FollowSimpleBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by shuqinggang on 2018/6/25.
 */

public interface Api {
    public static final String app_HS2 = "app_hs2";
    @FormUrlEncoded
    @POST("getFollowList_simple")
    Flowable<FollowSimpleBean> getFollowList_simple(@Field("username") String selfName, @Field("hs2") String hs2);

    @FormUrlEncoded
    @POST("getBlockList")
    Flowable<BlockedList> getBlockList(@Field("username") String username, @Field("hs2") String hs2);
}
