package com.example.mayn.myapp.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.MultipleItem;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/19.
 */

public class TypeAdapter extends BaseMultiItemQuickAdapter<MultipleItem,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TypeAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.HEADER, R.layout.item_head);
        addItemType(MultipleItem.CONTENT,R.layout.item_content);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (item.itemType){
            case MultipleItem.HEADER:
                helper.setText(R.id.type_name,item.name);
                break;
            case MultipleItem.CONTENT:
               helper.setText(R.id.type_content,item.content);
               break;
        }
    }

}
