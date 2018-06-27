package com.example.mayn.myapp.NetworkUtils;

import com.example.mayn.myapp.bean.DownloadInfo;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by shuqinggang on 2018/6/27.
 * 下载信息的观察者
 */

public abstract class DownLoadObserver implements Observer<DownloadInfo> {
    protected Disposable d;//可以用于取消注册的监听者
    protected DownloadInfo downloadInfo;
    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
    }

    @Override
    public void onNext(DownloadInfo downloadInfo) {
        this.downloadInfo = downloadInfo;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

}
