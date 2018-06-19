package com.example.mayn.myapp.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.TypeActivity;
import com.example.mayn.myapp.adapter.MessageAdapter;
import com.example.mayn.myapp.bean.MultipleItem;
import com.example.mayn.myapp.presenter.FirstPresenter;

import java.util.ArrayList;
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
        messageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mainActivity, TypeActivity.class));
            }
        });
    }

    @Override
    public void refresh(List data) {
        messageAdapter.addData(data);
    }

//    public static List<MultipleItem> getMultipleItemData() {
//        List<MultipleItem> list = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//
//            if (i % 3 == 0) {
//
//                MultipleItem item = new MultipleItem();
//                item.itemType = MultipleItem.HEADER;
//                list.add(item);
//
//                MultipleItem item0 = new MultipleItem();
//                item0.itemType = MultipleItem.CONTENT;
//                item0.name = "01" + i;
//                list.add(item0);
//
//                MultipleItem item1 = new MultipleItem();
//                item1.itemType = MultipleItem.CONTENT;
//                item1.name = "02" + i;
//                list.add(item1);
//
//            } else if (i % 4 == 0) {
//
//                MultipleItem item = new MultipleItem();
//                item.itemType = MultipleItem.HEADER;
//                list.add(item);
//
//                MultipleItem item0 = new MultipleItem();
//                item0.itemType = MultipleItem.CONTENT;
//                item0.name = "01" + i;
//                list.add(item0);
//
//                MultipleItem item1 = new MultipleItem();
//                item1.itemType = MultipleItem.CONTENT;
//                item1.name = "02" + i;
//                list.add(item1);
//
//                MultipleItem item2 = new MultipleItem();
//                item2.itemType = MultipleItem.CONTENT;
//                item2.name = "03" + i;
//                list.add(item2);
//
//            } else {
//                MultipleItem item = new MultipleItem();
//                item.itemType = MultipleItem.HEADER;
//                list.add(item);
//            }
//        }
//
//
//        return list;
//    }

}
