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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.FirstBean;
import com.example.mayn.myapp.bean.FirstWangyi;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayn on 2018/5/11.
 */

public class FirstAdapter extends BaseQuickAdapter<FirstWangyi.VideoBean,BaseViewHolder>{
    Context mcontext;
    boolean isscroll=false;
    public static  int pos=0;

    public FirstAdapter(int layoutId, Context context) {
        super(layoutId);
        this.mcontext=context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, final FirstWangyi.VideoBean item) {
        TextView title=helper.getView(R.id.titles);
        TextView infor=helper.getView(R.id.rv_tx);
        ImageView img=new ImageView(mcontext);
        img.setImageResource(R.mipmap.ten);
        GSYVideoOptionBuilder gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        final StandardGSYVideoPlayer gsyVideoPlayer=helper.getView(R.id.video);
        title.setText(item.getTitle()+"");
        infor.setText(item.getCategory());
        Glide.with(mContext).load(item.getCover()).into(img);
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
                .setThumbImageView(img)
                .setUrl(item.getMp4_url())
                .setSetUpLazy(true)//lazy可以防止滑动卡顿
                .setVideoTitle(item.getTitle())
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
                .setPlayPosition(helper.getPosition())
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!gsyVideoPlayer.isIfCurrentIsFullscreen()) {
                            //静音
                            GSYVideoManager.instance().setNeedMute(false);
                        }

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //全屏不静音
                        GSYVideoManager.instance().setNeedMute(true);
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        GSYVideoManager.instance().setNeedMute(false);
                        gsyVideoPlayer.getCurrentPlayer().getTitleTextView().setText((String)objects[0]);
                    }
                }).build(gsyVideoPlayer);


        //增加title
        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);

        //设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);

        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               resolveFullBtn(gsyVideoPlayer);
            }
        });


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
    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(mcontext, true, true);
    }

    public void setScrolling(boolean isscroll){
        this.isscroll = isscroll;
    }
}
