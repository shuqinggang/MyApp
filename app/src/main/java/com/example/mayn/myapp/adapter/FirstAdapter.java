package com.example.mayn.myapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.FirstBean;
import com.example.mayn.myapp.bean.FirstWangyi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayn on 2018/5/11.
 */

public class FirstAdapter extends BaseQuickAdapter<FirstWangyi.VideoBean,BaseViewHolder>{
    Context mcontext;
    boolean isscroll=false;
    public static int pos=0;

    public FirstAdapter(int layoutId, Context context) {
        super(layoutId);
        this.mcontext=context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, final FirstWangyi.VideoBean item) {
          final ImageView img=helper.getView(R.id.images);
          final VideoView videoView=helper.getView(R.id.video);
          final ImageView img_start=helper.getView(R.id.img_start);
          Glide.with(mContext).load(item.getCover()).placeholder(R.mipmap.ten).dontAnimate().into(img);

          img_start.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  img.setVisibility(View.GONE);
                  img_start.setVisibility(View.GONE);
                  videoView.setVisibility(View.VISIBLE);
                  Uri uri=Uri.parse(item.getMp4_url());
                  videoView.setVideoURI(uri);
                  videoView.start();
                  videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                      @Override
                      public void onCompletion(MediaPlayer mp) {
                          mp.stop();
                          img.setVisibility(View.VISIBLE);
                          img_start.setVisibility(View.VISIBLE);
                          videoView.setVisibility(View.GONE);
                      }
                  });
              }
          });
          if(isscroll){
              videoView.pause();
              img.setVisibility(View.VISIBLE);
              img_start.setVisibility(View.VISIBLE);
              videoView.setVisibility(View.GONE);
          }

//        TextView names=helper.getView(R.id.tx_name);
//        ImageView imgBackground=helper.getView(R.id.item_img);
//        TextView txComment=helper.getView(R.id.tx_comment);
//        final TextView txLikes=helper.getView(R.id.tx_likes);
//        names.setText(item.getUserName());
//        imgBackground.setImageResource(Integer.parseInt(item.getImgUrl()));
////        imgBackground.setImageResource(R.mipmap.ten);
////        helper.getView(R.id.item_img).setTag(Integer.parseInt(item.getImgUrl())+"");
////        if(!isscroll) {
////            if(helper.getView(R.id.item_img).getTag().toString().equals(Integer.parseInt(item.getImgUrl())+"")) {
////                imgBackground.setImageResource(Integer.parseInt(item.getImgUrl()));
////            }
////
////        }
//     //   Glide.with(mContext).load(item.getImgUrl()).into(imgBackground);
//        txComment.setText(item.getInfor());
//        txLikes.setText(item.getYear());
//        txLikes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int i=Integer.parseInt(txLikes.getText().toString());
//                txLikes.setText((i+1)+"");
//                item.setYear((i+1)+"");
//                Log.e("BaseQuickAdapter","点点"+helper.getPosition());
//            }
//        });
    }


    public void setScrolling(boolean isscroll){
        this.isscroll = isscroll;
    }
}
