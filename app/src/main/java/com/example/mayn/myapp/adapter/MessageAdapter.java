package com.example.mayn.myapp.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.UI.GlideCircleTransform;
import com.example.mayn.myapp.bean.MessageBean;

/**
 * Created by shuqinggang on 2018/6/6.
 */

public class MessageAdapter extends BaseQuickAdapter<MessageBean,BaseViewHolder>{
    Context mcontext;

    public MessageAdapter(int layoutId,Context context) {
        super(layoutId);
        this.mcontext=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBean item) {
        ImageView imageView=helper.getView(R.id.img_quns);
        TextView message_name=helper.getView(R.id.message_name);
        TextView message_u=helper.getView(R.id.message_u);

        Glide.with(mcontext).load(Integer.parseInt(item.getImg())).centerCrop().transform(new GlideCircleTransform(mcontext)).into(imageView);
       // imageView.setImageResource(Integer.parseInt(item.getImg()));
        message_name.setText(item.getGroupname());
        message_u.setText(item.getInfor());
    }


}
