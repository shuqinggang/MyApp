package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.mayn.myapp.NetworkUtils.DownLoadObserver;
import com.example.mayn.myapp.NetworkUtils.DownloadManager;
import com.example.mayn.myapp.bean.DownloadInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DownFileActivity extends BaseActivity {
     @BindView(R.id.main_progress1)
     ProgressBar progressBar1;
     @BindView(R.id.main_btn_down1)
     Button main_btn_down1;
     @BindView(R.id.main_btn_cancel1)
     Button main_btn_cancel1;
     String urls="http://dg6m0ddeht37z.cloudfront.net/cake_1a8ee0b9-c8aa-44c4-8efb-b32e1794ef2e.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_file);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.main_btn_down1,R.id.main_btn_cancel1})
    public void setThing(View view){
        switch (view.getId()){
            case R.id.main_btn_down1:
                DownloadManager.getInstance().download(urls, new DownLoadObserver() {
                    @Override
                    public void onNext(DownloadInfo downloadInfo) {
                        super.onNext(downloadInfo);
                        progressBar1.setMax((int) downloadInfo.getTotal());
                        progressBar1.setProgress((int) downloadInfo.getProgress());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("DownFileActivity","下载完成");
                    }
                });
                break;
            case R.id.main_btn_cancel1:
                DownloadManager.getInstance().cancel(urls);
                break;
        }
    }

}
