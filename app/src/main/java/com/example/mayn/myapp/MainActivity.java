package com.example.mayn.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mayn.myapp.NetworkUtils.ActivityUtil;
import com.example.mayn.myapp.NetworkUtils.FileUtils;
import com.example.mayn.myapp.NetworkUtils.LogUtil;
import com.example.mayn.myapp.UI.TabButton;
import com.example.mayn.myapp.fragment.BaseFragment;
import com.example.mayn.myapp.fragment.DiscoverFragment;
import com.example.mayn.myapp.fragment.FirstFragment;
import com.example.mayn.myapp.fragment.MessageFragment;
import com.example.mayn.myapp.fragment.SettingFragment;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

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
    boolean permission = false;
    @BindView(R.id.title_img)
    TextView titleImg;
    @BindView(R.id.title_txt)
    TextView titleTxt;
    @BindView(R.id.title_right)
    TextView titleRight;
    @BindView(R.id.ll_main)
    LinearLayout llMain;

    List<BaseFragment> listFragment;
    @BindView(R.id.viewpage)
    ViewPager viewpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//            getWindow().setEnterTransition(new Explode());
//            getWindow().setExitTransition(new Explode());
//        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        listFragment = new ArrayList<>();
        listFragment.add(new FirstFragment());
        listFragment.add(new DiscoverFragment());
        listFragment.add(new MessageFragment());
        listFragment.add(new SettingFragment());
        list.add(firstTab);
        list.add(discorveTab);
        list.add(messageTab);
        list.add(setTab);
        list.get(0).setChecked(true);
        checkPermission();

        viewpage.setOffscreenPageLimit(3);
        viewpage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return listFragment.get(position);
            }

            @Override
            public int getCount() {
                return listFragment.size();
            }
        });

        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void checkPermission() {
        if (ActivityUtil.hasPermissions(this)) {
            permission = true;
        }
    }

    @OnClick({R.id.first_tab, R.id.discorve_tab, R.id.message_tab, R.id.set_tab})
    public void setChangeTab(View v) {
        switch (v.getId()) {
            case R.id.first_tab:
                changTab(0);
                titleTxt.setText(getResources().getString(R.string.first_tab));
                //    startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.discorve_tab:
                changTab(1);
                titleTxt.setText(getResources().getString(R.string.discorve_tab));
                String f = FileUtils.getStringFromFile(FileUtils.filePath + FileUtils.fileName);
                LogUtil.e("FileContent", f);
                break;
            case R.id.message_tab:
                changTab(2);
                titleTxt.setText(getResources().getString(R.string.message_tab));
             //   startActivity(new Intent(this, MyActivity.class));
                break;
            case R.id.set_tab:
                changTab(3);
                titleTxt.setText(getResources().getString(R.string.set_tab));
                FileUtils.savaFile(FileUtils.filePath, FileUtils.fileName, "I love you,weiping");
                break;
        }
    }

    public void changTab(int position) {
        if(position==0){
            titleTxt.setText(getResources().getString(R.string.first_tab));
        }else if(position==1){
            titleTxt.setText(getResources().getString(R.string.discorve_tab));
            GSYVideoManager.onPause();
        }else if(position==2){
            titleTxt.setText(getResources().getString(R.string.message_tab));
            GSYVideoManager.onPause();
        }else {
            titleTxt.setText(getResources().getString(R.string.set_tab));
            GSYVideoManager.onPause();
        }
        if(position<listFragment.size())
            viewpage.setCurrentItem(position);
        for (TabButton t : list) {
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

    public void exitApp() {
        System.exit(0);
    }
}
