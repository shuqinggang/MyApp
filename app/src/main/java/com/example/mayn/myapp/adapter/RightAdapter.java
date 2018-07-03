package com.example.mayn.myapp.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.TwoMessage;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/29.
 */

public class RightAdapter extends BaseQuickAdapter<TwoMessage,BaseViewHolder> {
    List<TwoMessage> lists;
    ShopOnClickListtener shopOnClickListtener;

    public ShopOnClickListtener getShopOnClickListtener() {
        return shopOnClickListtener;
    }

    public void setShopOnClickListtener(ShopOnClickListtener shopOnClickListtener) {
        this.shopOnClickListtener = shopOnClickListtener;
    }

    public RightAdapter(@Nullable List<TwoMessage> data) {
        super(R.layout.right_layout,data);
        this.lists=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, TwoMessage item) {
        TextView txRight=helper.getView(R.id.tx_right);
        TextView txName=helper.getView(R.id.tx_right_name);
        TextView txNum=helper.getView(R.id.tx_right_num);
        TextView txPrice=helper.getView(R.id.tx_right_price);
        ImageView imgAdd=helper.getView(R.id.img_add);

        if(helper.getPosition()==0){
            txName.setText(item.getName());
            txNum.setText(item.getNumber()+"");
            txPrice.setText(item.getPrice()+"");
            txRight.setText(item.getTag());
            txRight.setVisibility(View.VISIBLE);
        }else{
             if(item.getTag().equals(lists.get(helper.getPosition()-1).getTag())){
                 txName.setText(item.getName());
                 txNum.setText(item.getNumber()+"");
                 txPrice.setText(item.getPrice()+"");
                 txRight.setText(item.getTag());
                 txRight.setVisibility(View.GONE);
             }else {
                 txName.setText(item.getName());
                 txNum.setText(item.getNumber()+"");
                 txPrice.setText(item.getPrice()+"");
                 txRight.setText(item.getTag());
                 txRight.setVisibility(View.VISIBLE);
             }
        }

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopOnClickListtener.adds(v,helper.getPosition());
            }
        });
    }

    public interface ShopOnClickListtener{
        void adds(View v,int pos);
        void romove(View v,int pos);
    }

}
