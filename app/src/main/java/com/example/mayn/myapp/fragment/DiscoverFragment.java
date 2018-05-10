package com.example.mayn.myapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayn.myapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment {


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

    }

}
