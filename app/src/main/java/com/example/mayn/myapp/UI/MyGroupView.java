package com.example.mayn.myapp.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shuqinggang on 2018/7/19.
 */

public class MyGroupView extends ViewGroup{
    Context context;
    private int horizontalSpace = 10;
    private int verticalSpace = 10;
    public MyGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int hadUsedHorizontal = 0;//水平已经使用的距离
        int hadUsedVertical = 0;//垂直已经使用的距离
        int width = getMeasuredWidth();
         for(int i=0;i<getChildCount();i++){
            View view=getChildAt(i);
            if(view.getMeasuredWidth()+hadUsedHorizontal>width){
                hadUsedVertical = hadUsedVertical + view.getMeasuredHeight() + verticalSpace;
                hadUsedHorizontal = 0;
            }
             view.layout(hadUsedHorizontal, hadUsedVertical, hadUsedHorizontal + view.getMeasuredWidth(), hadUsedVertical + view.getMeasuredHeight());
             hadUsedHorizontal = hadUsedHorizontal + horizontalSpace + view.getMeasuredWidth();
         }
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }


    public void dealtailBitmap(String path){
        Bitmap bitmap= BitmapFactory.decodeFile(path);
    }
}
