package com.example.mayn.myapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.FirstBean;

/**
 * Created by mayn on 2018/5/11.
 */

public class FirstAdapter extends BaseQuickAdapter<FirstBean,BaseViewHolder>{
    Context mcontext;
    boolean isscroll=false;
    public FirstAdapter(int layoutId,Context context) {
        super(layoutId);
        this.mcontext=context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FirstBean item) {
        TextView names=helper.getView(R.id.tx_name);
        ImageView imgBackground=helper.getView(R.id.item_img);
        TextView txComment=helper.getView(R.id.tx_comment);
        final TextView txLikes=helper.getView(R.id.tx_likes);
        names.setText(item.getUserName());
        imgBackground.setImageResource(Integer.parseInt(item.getImgUrl()));
//        imgBackground.setImageResource(R.mipmap.ten);
//        helper.getView(R.id.item_img).setTag(Integer.parseInt(item.getImgUrl())+"");
//        if(!isscroll) {
//            if(helper.getView(R.id.item_img).getTag().toString().equals(Integer.parseInt(item.getImgUrl())+"")) {
//                imgBackground.setImageResource(Integer.parseInt(item.getImgUrl()));
//            }
//
//        }
     //   Glide.with(mContext).load(item.getImgUrl()).into(imgBackground);
        txComment.setText(item.getInfor());
        txLikes.setText(item.getYear());
        txLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(txLikes.getText().toString());
                txLikes.setText((i+1)+"");
                item.setYear((i+1)+"");
                Log.e("BaseQuickAdapter","点点"+helper.getPosition());
            }
        });
    }
    public void setScrolling(boolean isscroll){
        this.isscroll = isscroll;
    }
}
