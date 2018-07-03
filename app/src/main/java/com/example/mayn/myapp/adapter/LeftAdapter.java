package com.example.mayn.myapp.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.ShopActivity;
import com.example.mayn.myapp.bean.OneMessage;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/29.
 */

public class LeftAdapter extends BaseQuickAdapter<OneMessage,BaseViewHolder>{

    public LeftAdapter(@Nullable List<OneMessage> data) {
        super(R.layout.left_layout,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OneMessage item) {
        helper.setText(R.id.tx_lefts,item.getName());
        helper.getView(R.id.tx_lefts).setTag(item.getName());
        helper.getView(R.id.tx_lefts).setBackgroundColor(Color.WHITE);
        if(ShopActivity.viewPostion==helper.getPosition()){
                helper.getView(R.id.tx_lefts).setBackgroundColor(Color.RED);
        }

    }
}
