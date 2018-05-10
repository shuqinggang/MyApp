package com.example.mayn.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;


import com.example.mayn.myapp.NetworkUtils.ActivityUtil;
import com.example.mayn.myapp.NetworkUtils.FileUtils;
import com.example.mayn.myapp.NetworkUtils.LogUtil;
import com.example.mayn.myapp.UI.TabButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.first_tab)
    TabButton firstTab;
    @BindView(R.id.discorve_tab)
    TabButton discorveTab;
    @BindView(R.id.message_tab)
    TabButton messageTab;
    @BindView(R.id.set_tab)
    TabButton setTab;
    List<TabButton> list;
    boolean permission=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list=new ArrayList<>();
        list.add(firstTab);
        list.add(discorveTab);
        list.add(messageTab);
        list.add(setTab);
        list.get(0).setChecked(true);
        checkPermission();
    }

    private void checkPermission() {
       if(ActivityUtil.hasPermissions(this)){
           permission=true;
       }
    }

    @OnClick({R.id.first_tab,R.id.discorve_tab,R.id.message_tab,R.id.set_tab})
    public void setChangeTab(View v){
        switch (v.getId()){
            case R.id.first_tab:
                changTab(0);
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.discorve_tab:
                changTab(1);
                String f= FileUtils.getStringFromFile(FileUtils.filePath+FileUtils.fileName);
                LogUtil.e("FileContent",f);
                break;
            case R.id.message_tab:
                changTab(2);
                startActivity(new Intent(this,MyActivity.class));
                break;
            case R.id.set_tab:
                changTab(3);
                FileUtils.savaFile(FileUtils.filePath,FileUtils.fileName,"I love you,weiping");
                break;
        }
    }
    public void changTab(int position){
        for (TabButton t:list) {
            t.setChecked(false);
            list.get(position).setChecked(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ActivityUtil.PERMISSION_CODE) {
            boolean alert = false;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    alert = true;
                    break;
                }
            }

            if (alert) {
                new AlertDialog.Builder(this).setMessage("申请权限")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                                startActivityForResult(intent, 100);
                            }
                        })
                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                checkPermission();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exitApp();
                            }
                        }).show();
            } else {
                checkPermission();
            }
        } else if (requestCode == ActivityUtil.PERMISSION_CODE_SMS) {
            permission = true;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void exitApp(){
        System.exit(0);
    }
}
