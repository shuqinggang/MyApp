package com.example.mayn.myapp.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.adapter.MessageAdapter;
import com.example.mayn.myapp.presenter.FirstPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment implements RefreshRecyclerview {

    MainActivity mainActivity;
    @BindView(R.id.message_lv)
    RecyclerView message_lv;
    MessageAdapter messageAdapter;
    FirstPresenter firstPresenter;
    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_message;
    }

    @Override
    protected void init() {
        mainActivity=(MainActivity)getActivity();
        firstPresenter=new FirstPresenter(this);
        messageAdapter=new MessageAdapter(R.layout.item_message,mainActivity);
//        lv.setLayoutManager(new LinearLayoutManager(mainActivity));
        message_lv.setLayoutManager(new LinearLayoutManager(mainActivity));
        message_lv.addItemDecoration(new DividerItemDecoration(mainActivity,DividerItemDecoration.VERTICAL));
        message_lv.setAdapter(messageAdapter);
        firstPresenter.getMessageList();
    }

    @Override
    public void refresh(List data) {
        messageAdapter.addData(data);
    }
}
