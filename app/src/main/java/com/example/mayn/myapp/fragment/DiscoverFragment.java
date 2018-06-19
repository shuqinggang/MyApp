package com.example.mayn.myapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mayn.myapp.Login.LoginActivity;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.NetworkUtils.LogUtil;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.UI.FriendsActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment  {

    @BindView(R.id.ll_friend)
    LinearLayout llFriend;
    MainActivity mainActivity;
    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void init() {
      mainActivity=(MainActivity)getActivity();
    }

    @OnClick({R.id.ll_friend,R.id.ll_scan})
    public void onclickLL(View view){
        switch (view.getId()){
            case R.id.ll_friend:
                Intent intents=new Intent(mainActivity,FriendsActivity.class);
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(mainActivity);
                ActivityCompat.startActivity(mainActivity, intents, activityOptions.toBundle());
                break;
            case R.id.ll_scan:
                LogUtil.e("DiscoverFragment","ll_scan");
                break;
                default:
                    break;
        }
    }
}
