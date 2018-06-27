package com.example.mayn.myapp.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.mayn.myapp.DownFileActivity;
import com.example.mayn.myapp.Interface.Api;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.MlogUtils.RecyclerViewDialog;
import com.example.mayn.myapp.MyToolsActivity;
import com.example.mayn.myapp.NetworkUtils.AppRequest;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.SettingImageActivity;
import com.example.mayn.myapp.UI.GlideCircleTransform;
import com.example.mayn.myapp.UI.GlideRoundTransform;
import com.example.mayn.myapp.bean.BlockedList;
import com.example.mayn.myapp.bean.FollowSimpleBean;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment {
    MainActivity mainActivity;
    @BindView(R.id.userImg)
    ImageView userImg;
    @BindView(R.id.my_ll)
    LinearLayout line;
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_setting;
    }


    @Override
    protected void init() {
        mainActivity = (MainActivity) getActivity();
        Glide.with(this).load(R.mipmap.one).centerCrop().transform(new GlideCircleTransform(mainActivity)).into(userImg);
        initDatas();
    }

    @OnClick({R.id.my_ll})
    public void toMysetting(){
         startActivity(new Intent(mainActivity, DownFileActivity.class));
//        RecyclerViewDialog dialog=new RecyclerViewDialog(mainActivity);
//        dialog.show();
//        AppRequest.createService(Api.class).getBlockList("patricia.meredith222@gmail.com","306d52812494c74cd494c5726af40046")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BlockedList>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.e("BlockedList","s");
//                    }
//
//                    @Override
//                    public void onNext(BlockedList blockedList) {
//                      Log.e("BlockedList",blockedList.getList().toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.e("BlockedList","eeeeeeeeeeeeeeeeeeeeeeee");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e("BlockedList","eeeeeeeeeeeeeeeeeeeeeeee");
//                    }
//                });
    }
    public void  initDatas(){
    }
}
