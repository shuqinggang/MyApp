package com.example.mayn.myapp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;

import com.squareup.picasso.Picasso;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;

/**
 * Created by mayn on 2018/5/11.
 */

public class ListPtrFrameLayout  extends PtrFrameLayout implements AbsListView.OnScrollListener {
    private CommonHeader commonHeader;
    private Context mCtx;
    private OnScrollBottomListener bottomListener;
    private boolean isLoadMore = false;
//    private boolean disallowInterceptTouchEvent = false;

    public ListPtrFrameLayout(Context context) {
        super(context);
        mCtx = context;
        initViews();
    }

    public ListPtrFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ListPtrFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        commonHeader = new CommonHeader(getContext());
        setHeaderView(commonHeader);
        //使头布局的状态和刷新状态同步
        addPtrUIHandler(commonHeader);
    }

    public void setHeader(PtrUIHandler header) {
        setHeaderView((View) header);
        addPtrUIHandler(header);
    }

    /**
     * 通过字段key指定上一次更新时间
     *
     * @param key
     */
    public void setLastUpdateTimeKey(String key) {
        if (commonHeader != null) {
            commonHeader.setLastUpdateTimeKey(key);
        }
    }

    public void setBottomListener(OnScrollBottomListener listener) {
        bottomListener = listener;
    }

    public void loadMoreComplete() {
        isLoadMore = false;
    }

    /**
     * 通过对象指定上一次更新时间
     *
     * @param object
     */
    public void setLastUpdateTimeRelateObject(Object object) {
        if (commonHeader != null) {
            commonHeader.setLastUpdateTimeRelateObject(object);
        }
    }

    private Object picassoTag;

    public void setPicassoTag(Object tag) {
        picassoTag = tag;
    }

    private boolean scrolllisten = true;

    public void setScrolllisten(boolean canlisten) {
        scrolllisten = canlisten;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        boolean isStop = scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE;
        if (picassoTag != null) {
            if (isStop) {
                Picasso.with(mCtx).resumeTag(picassoTag);
            } else {
                Picasso.with(mCtx).pauseTag(picassoTag);
            }
        }

        if (isStop && view.getLastVisiblePosition() == (view.getCount() - 1)) {
            if (bottomListener != null) {
                if (!isLoadMore) {
                    isLoadMore = true;
                    bottomListener.onBottom();
                }
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // 解决listView滑动与下拉刷新冲突问题
        // 当firstVisibleItem是第0位。如果firstView==null说明列表为空，
        // 需要刷新;或者top==0说明已经到达列表顶部, 也需要刷新
        View firstView = view.getChildAt(firstVisibleItem);
        if (scrolllisten) {
            if (firstVisibleItem == 0 && (firstView == null || firstView.getTop() == 0)) {
                this.setEnabled(true);
            } else {
                this.setEnabled(false);
            }
        }
    }

    public interface OnScrollBottomListener {
        void onBottom();
    }

//    @Override
//    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        disallowInterceptTouchEvent = disallowIntercept;
//        super.requestDisallowInterceptTouchEvent(disallowIntercept);
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent e) {
//        if (disallowInterceptTouchEvent) {
//            return dispatchTouchEventSupper(e);
//        }
//        return super.dispatchTouchEvent(e);
//    }
}
