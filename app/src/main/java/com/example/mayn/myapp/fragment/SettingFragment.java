package com.example.mayn.myapp.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.MyToolsActivity;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.UI.GlideCircleTransform;
import com.example.mayn.myapp.UI.GlideRoundTransform;

import butterknife.BindView;
import butterknife.OnClick;

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
    }

    @OnClick({R.id.my_ll})
    public void toMysetting(){
         startActivity(new Intent(mainActivity, MyToolsActivity.class));
    }
}
