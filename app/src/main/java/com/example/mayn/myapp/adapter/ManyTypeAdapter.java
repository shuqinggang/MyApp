package com.example.mayn.myapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.ManyTypeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by shuqinggang on 2018/7/4.
 */

public class ManyTypeAdapter extends BaseMultiItemQuickAdapter<ManyTypeBean,BaseViewHolder> implements OnBannerListener {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    Context mContext;
    List<ManyTypeBean> datas;
    public ManyTypeAdapter(List<ManyTypeBean> data,Context context) {
        super(data);
        addItemType(ManyTypeBean.BANNER_VIEW_TYPE, R.layout.item_baner);
        addItemType(ManyTypeBean.CHANNEL_VIEW_TYPE, R.layout.item_ll);
        addItemType(ManyTypeBean.GIRL_VIEW_TYPE, R.layout.item_gridview);
        addItemType(ManyTypeBean.NORMAL_VIEW_TYPE, R.layout.item_normal);
        this.mContext=context;
        this.datas=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ManyTypeBean item) {
          switch (item.itemType){
              case ManyTypeBean.BANNER_VIEW_TYPE:
                  Banner banner=helper.getView(R.id.banner);
                  banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                  //设置图片加载器，图片加载器在下方
                  banner.setImageLoader(new MyLoader());
                  //设置图片网址或地址的集合
                  banner.setImages(item.lists);
                  //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
                  banner.setBannerAnimation(Transformer.Default);
                  //设置轮播图的标题集合
                  banner.setBannerTitles(item.titles);
                  //设置轮播间隔时间
                  banner.setDelayTime(3000);
                  //设置是否为自动轮播，默认是“是”。
                  banner.isAutoPlay(true);
                  //设置指示器的位置，小点点，左中右。
                  banner.setIndicatorGravity(BannerConfig.CENTER)
                          //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                          .setOnBannerListener(this)
                          //必须最后调用的方法，启动轮播图。
                          .start();
                  break;
              case ManyTypeBean.CHANNEL_VIEW_TYPE:
                  helper.setText(R.id.tx_nam,item.names);
                  ImageView imageView=helper.getView(R.id.imgs_im);
                  imageView.setImageResource(R.mipmap.friends);
                  Glide.with(mContext).load(item.url).into(imageView);
                  break;
              case ManyTypeBean.GIRL_VIEW_TYPE:
                  helper.setText(R.id.tx_p_price,item.names);
                  helper.setText(R.id.tx_p_namne,item.content);
                  ImageView imgs=helper.getView(R.id.img_bb);
                  Glide.with(mContext).load(item.url).into(imgs);
                  break;
              case ManyTypeBean.NORMAL_VIEW_TYPE:
                  helper.setText(R.id.tx_normal,item.names);
                  break;
          }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);

            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        //一共分为8列，返回一个item所占的列数
                        case ManyTypeBean.BANNER_VIEW_TYPE:
                            return 8;
                        case ManyTypeBean.CHANNEL_VIEW_TYPE:
                            return 2;

                        case ManyTypeBean.GIRL_VIEW_TYPE:
                            return 4;
                        case ManyTypeBean.NORMAL_VIEW_TYPE:
                            return 8;
                        default:
                            return 8;
                    }
                }
            });
        }
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(mContext,datas.get(0).titles.get(position),Toast.LENGTH_SHORT).show();
    }

    public class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}