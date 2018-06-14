package com.example.mayn.myapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.UI.ListPtrFrameLayout;
import com.example.mayn.myapp.adapter.FirstAdapter;
import com.example.mayn.myapp.bean.FirstWangyi;
import com.example.mayn.myapp.presenter.FirstPresenter;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;
import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment implements RefreshRecyclerview {
    MainActivity mainActivity;
    @BindView(R.id.lv)
    RecyclerView lv;
//    @BindView(R.id.ptrLayout)
//    ListPtrFrameLayout ptrLayout;
    FirstAdapter firstAdapter;
    FirstPresenter firstPresenter;
    public int firstVisibleItem, lastVisibleItem, visibleCount;
    public FirstFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_first;
    }

    @Override
    protected void init() {
        mainActivity = (MainActivity) getActivity();
//        ptrLayout.setPtrHandler(new PtrDefaultHandler() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                frame.autoRefresh();
//            }
//        });

        firstPresenter=new FirstPresenter(this);
        firstAdapter=new FirstAdapter(R.layout.item_video,mainActivity);
        lv.setLayoutManager(new LinearLayoutManager(mainActivity));
        // 外部对RecyclerView设置监听
        lv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean scrollState = false;
            int firstVisibleItem, lastVisibleItem;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                // 查看源码可知State有三种状态：SCROLL_STATE_IDLE（静止）、SCROLL_STATE_DRAGGING（上升）、SCROLL_STATE_SETTLING（下落）
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case SCROLL_STATE_IDLE: //滚动停止
                        scrollState = false;
//                        autoPlayVideo(recyclerView);
                        break;
                    case SCROLL_STATE_DRAGGING: //手指拖动
                        scrollState = true;
                        break;
                    case SCROLL_STATE_SETTLING: //惯性滚动
                        scrollState = true;
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManagers = recyclerView.getLayoutManager();
                LinearLayoutManager layoutManager = (LinearLayoutManager) layoutManagers;
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {

                        //如果滑出去了上面和下面就是否，和今日头条一样
                        //是否全屏
                        if(!GSYVideoManager.isFullState(mainActivity)) {
                            GSYVideoManager.releaseAllVideos();
                            firstAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        lv.setAdapter(firstAdapter);
        firstPresenter.getDataList(0,mainActivity);
        firstAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 Log.e("BaseQuickAdapter","位置"+position);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }

    @Override
    public void refresh(List data) {
          firstAdapter.addData(data);
    }
}
