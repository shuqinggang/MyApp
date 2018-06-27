package com.example.mayn.myapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.DialogBean;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/22.
 */

public class DialogAdapter extends BaseQuickAdapter<DialogBean,BaseViewHolder> {


    public DialogAdapter(List<DialogBean> data) {
        super(R.layout.item_dialog_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DialogBean item) {
        helper.setText(R.id.et_name,item.getName());
        helper.setText(R.id.et_gongzuo,item.getWork());
        helper.setText(R.id.et_phone,item.getPhone());
    }
}
