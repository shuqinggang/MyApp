package com.example.mayn.myapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mayn.myapp.NetworkUtils.BezierTypeEvaluator;
import com.example.mayn.myapp.NetworkUtils.CreatDatas;
import com.example.mayn.myapp.adapter.LeftAdapter;
import com.example.mayn.myapp.adapter.RightAdapter;
import com.example.mayn.myapp.bean.OneMessage;
import com.example.mayn.myapp.bean.TwoMessage;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

public class ShopActivity extends BaseActivity implements RightAdapter.ShopOnClickListtener {
    public static final String TAG=ShopActivity.class.getName();
    List<OneMessage> listOne;
    LeftAdapter leftAdapter;
    List<TwoMessage> listTwo;
    RightAdapter rightAdapter;
    RecyclerView rvLeft;
    RecyclerView rvRight;
    RecyclerView rv_above;
    ImageView shopping_cart;
    RelativeLayout main_layout;
    public static int viewPostion=0;
   // SmoothScrollLayoutManager smoothScrollLayoutManager;
    LinearLayoutManager rightLinearLayoutManager;
    LinearLayoutManager leftLinearLayoutManager;
    boolean isLeft=true;//判断是否点击左边，防止刷新左边部分
    boolean move;
    int selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        main_layout = (RelativeLayout) findViewById(R.id.main_layout);
        rvLeft=(RecyclerView)findViewById(R.id.rv_left);
        rvRight=(RecyclerView)findViewById(R.id.rv_right);
        rv_above=(RecyclerView)findViewById(R.id.rv_above);
        shopping_cart=(ImageView)findViewById(R.id.shopping_cart);

        leftLinearLayoutManager=new LinearLayoutManager(this);
        rvLeft.setLayoutManager(leftLinearLayoutManager);
        leftAdapter=new LeftAdapter(getDataOne());
        rvLeft.setAdapter(leftAdapter);

        rightLinearLayoutManager=new LinearLayoutManager(this);
        rvRight.setLayoutManager(rightLinearLayoutManager);
        rightAdapter=new RightAdapter(getDataTwo());
        rvRight.setAdapter(rightAdapter);



        leftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                isLeft=true;
                getPosition(listOne.get(position).getName());
                viewPostion=position;
                leftAdapter.notifyDataSetChanged();
            }
        });

        rvRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (move) {
                    move = false;
                    //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                    int n = selection - rightLinearLayoutManager.findFirstVisibleItemPosition();
                    if (0 <= n && n < rvRight.getChildCount()) {
                        //获取要置顶的项顶部离RecyclerView顶部的距离
                        int top = rvRight.getChildAt(n).getTop();
                        //最后的移动
                        rvRight.scrollBy(0, top);
                    }
                }else {
                    int pos = rightLinearLayoutManager.findFirstVisibleItemPosition();
                    if (listTwo.get(pos).isIsfirst()) {
                        viewPostion = listTwo.get(pos).getPosition();
                        int first = leftLinearLayoutManager.findFirstVisibleItemPosition();
                        int last = leftLinearLayoutManager.findLastVisibleItemPosition();
                        if (dy > 0 && last <= viewPostion) {
                            rvLeft.scrollToPosition(viewPostion);
                        }
                        if (dy < 0 && first >= viewPostion) {
                            rvLeft.scrollToPosition(viewPostion);
                        }
                        leftAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
        rightAdapter.setShopOnClickListtener(this);

    }

    public void getPosition(String name){
        for(int i=0;i<listTwo.size();i++){
            if(listTwo.get(i).getTag().equals(name)){
                selection=i;
                moveToPosition(i);
                return;
            }
        }
    }
    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = rightLinearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = rightLinearLayoutManager.findLastVisibleItemPosition();
        move = true;
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            rvRight.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = rvRight.getChildAt(n - firstItem).getTop();
            rvRight.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            rvRight.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
        }
    }

    public List<OneMessage> getDataOne(){
        listOne= CreatDatas.getOneData();
        return listOne;
    }

    public List<TwoMessage> getDataTwo(){
        listTwo=CreatDatas.getTwoData();
        return listTwo;
    }

    @Override
    public void adds(View view, int pos) {
        //贝塞尔起始数据点
        int[] startPosition = new int[2];
        //贝塞尔结束数据点
        int[] endPosition = new int[2];
        //控制点
        int[] recyclerPosition = new int[2];

        view.getLocationInWindow(startPosition);
        shopping_cart.getLocationInWindow(endPosition);
        rvRight.getLocationInWindow(recyclerPosition);

        PointF startF = new PointF();
        PointF endF = new PointF();
        PointF controllF = new PointF();

        startF.x = startPosition[0];
        startF.y = startPosition[1] - recyclerPosition[1]+rv_above.getHeight();
        endF.x = endPosition[0];
        endF.y = endPosition[1] - recyclerPosition[1]+rv_above.getHeight();
        controllF.x = endF.x;
        controllF.y = startF.y;

        final ImageView imageView = new ImageView(this);
        main_layout.addView(imageView);
        imageView.setImageResource(R.mipmap.ic_add_circle_blue_700_36dp);
        imageView.getLayoutParams().width = 30;
        imageView.getLayoutParams().height =30;
        imageView.setVisibility(View.VISIBLE);
        imageView.setX(startF.x);
        imageView.setY(startF.y);

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new BezierTypeEvaluator(controllF), startF, endF);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                imageView.setX(pointF.x);
                imageView.setY(pointF.y);
            }

        });
        ObjectAnimator objectAnimatorX = new ObjectAnimator().ofFloat(shopping_cart, "scaleX", 0.6f, 1.0f);
        ObjectAnimator objectAnimatorY = new ObjectAnimator().ofFloat(shopping_cart, "scaleY", 0.6f, 1.0f);
        objectAnimatorX.setInterpolator(new AccelerateInterpolator());
        objectAnimatorY.setInterpolator(new AccelerateInterpolator());
        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimatorX).with(objectAnimatorY).after(valueAnimator);
        set.setDuration(800);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                main_layout.removeView(imageView);
            }
        });
        set.start();
    }

    @Override
    public void romove(View v, int pos) {

    }

    public class SmoothScrollLayoutManager extends LinearLayoutManager {

        public SmoothScrollLayoutManager(Context context) {
            super(context);
        }

        @Override
        public void smoothScrollToPosition(RecyclerView recyclerView,
                                           RecyclerView.State state, final int position) {

            LinearSmoothScroller smoothScroller =
                    new LinearSmoothScroller(recyclerView.getContext()) {
                        // 返回：滑过1px时经历的时间(ms)。
                        @Override
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 150f / displayMetrics.densityDpi;
                        }
                    };

            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }
    }
}
