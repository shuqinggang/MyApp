package com.example.mayn.myapp.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shuqinggang on 2018/7/11.
 *
 */

public class CustView extends View {
    Paint mPait;
    int realWidth;
    public CustView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initePaint();
    }

    public CustView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initePaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        realWidth=measureWidth(widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect=new RectF(0,100,realWidth,500);
        canvas.drawRoundRect(rect,20,20,mPait);
    }

    public void  initePaint(){
        mPait=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPait.setColor(Color.RED);
        mPait.setStrokeWidth(10);
    }

    public int measureWidth(int widthMeasureSpec){
        int width=0;
        int defalueSize=500;
        int specModel=MeasureSpec.getMode(widthMeasureSpec);
        int specWidth=MeasureSpec.getSize(widthMeasureSpec);
        switch (specModel){
            case MeasureSpec.UNSPECIFIED:
                 width=defalueSize;
                break;
            case MeasureSpec.AT_MOST:
                width=Math.min(specWidth,defalueSize);
                break;
            case MeasureSpec.EXACTLY:
                width=specWidth;
                break;
                default:
                    break;
        }
        return  width;
    }
}
