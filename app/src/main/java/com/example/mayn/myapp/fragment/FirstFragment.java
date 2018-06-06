package com.example.mayn.myapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.UI.ListPtrFrameLayout;
import com.example.mayn.myapp.adapter.FirstAdapter;
import com.example.mayn.myapp.presenter.FirstPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

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
        firstAdapter=new FirstAdapter(R.layout.item_layout,mainActivity);
        lv.setLayoutManager(new LinearLayoutManager(mainActivity));
        // 外部对RecyclerView设置监听
        lv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                // 查看源码可知State有三种状态：SCROLL_STATE_IDLE（静止）、SCROLL_STATE_DRAGGING（上升）、SCROLL_STATE_SETTLING（下落）
                if (newState == SCROLL_STATE_IDLE) { // 滚动静止时才加载图片资源，极大提升流畅度
                    firstAdapter.setScrolling(false);
                    firstAdapter.notifyDataSetChanged(); // notify调用后onBindViewHolder会响应调用
                } else
                    firstAdapter.setScrolling(true);
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        lv.setAdapter(firstAdapter);
        firstPresenter.getDataList(0);
        firstAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 Log.e("BaseQuickAdapter","位置"+position);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void refresh(List data) {
          firstAdapter.addData(data);
    }
}
