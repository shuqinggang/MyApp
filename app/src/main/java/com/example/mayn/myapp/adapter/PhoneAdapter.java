package com.example.mayn.myapp.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.Interface.Person;
import com.example.mayn.myapp.LinelaoutActivity;
import com.example.mayn.myapp.R;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/28.
 */

public class PhoneAdapter extends BaseQuickAdapter<Person,BaseViewHolder> {
    List<Person> lists;
    onScrollPosition onScrollPositions;

    public onScrollPosition getOnScrollPositions() {
        return onScrollPositions;
    }

    public void setOnScrollPositions(onScrollPosition onScrollPositions) {
        this.onScrollPositions = onScrollPositions;
    }

    public PhoneAdapter(@Nullable List<Person> lists) {
        super(R.layout.item_phone_layout,lists);
        this.lists = lists;
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
          TextView pinyin=helper.getView(R.id.tx_pinyin);
          TextView names=helper.getView(R.id.tx_namess);
          if(helper.getPosition()==0){
              pinyin.setText(item.getFirstpingyin());
              names.setText(item.getName());
              pinyin.setVisibility(View.VISIBLE);
          }else{
              if(item.getFirstpingyin().equals(lists.get(helper.getPosition()-1).getFirstpingyin())){
                  pinyin.setVisibility(View.GONE);
                  names.setText(item.getName());
              }else {
                  pinyin.setVisibility(View.VISIBLE);
                  pinyin.setText(item.getFirstpingyin());
                  names.setText(item.getName());
              }

          }
    }

    public interface onScrollPosition{
        void getPositionPin(String str);
    }

}
