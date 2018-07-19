package com.example.mayn.myapp.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shuqinggang on 2018/7/11.
 */

public class LineView extends View {

    private float sLeft, sTop, sRight, sBottom;
    private float x, y;
    private float mRadius;
    private float progress;
    private float sWidth, sHeight;
    Paint mPaint;

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initePaint();
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initePaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int h=getMeasuredHeight();
        int w=getMeasuredWidth();
        mRadius = (float) w / 2;
        sLeft = w * 0.25f;
        sRight = w * 0.75f;
        sTop = 0;
        sBottom = h;
        sWidth = sRight - sLeft;
        sHeight = sBottom - sTop;
        x = (float) w / 2;
        y = (float) (1 - 0.01 * progress) * sHeight;
        drawBackground(canvas);
        drawCircle(canvas);
    }

    public void initePaint(){
        mPaint=new Paint();
        mPaint.setColor(Color.GRAY);
    }

    private void drawBackground(Canvas canvas) {
        RectF rectBlackBg = new RectF(sLeft, sTop, sRight, y);
       // linearGradient = new LinearGradient(sLeft, sTop, sWidth, y, colorArray2, null, Shader.TileMode.MIRROR);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    //    paint.setShader(linearGradient);
        canvas.drawRoundRect(rectBlackBg, sWidth / 2, sWidth / 2, mPaint);

        RectF rectBlackBg2 = new RectF(sLeft, y, sRight, sBottom);
   //     linearGradient = new LinearGradient(sLeft, y, sWidth, sHeight - y, colorArray, null, Shader.TileMode.MIRROR);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
  //      paint.setShader(linearGradient);
        canvas.drawRoundRect(rectBlackBg2, sWidth / 2, sWidth / 2, mPaint);
    }
    public void drawCircle(Canvas canvas){
        Paint thumbPaint = new Paint();

        y = y < mRadius ? mRadius : y;
        y = y > sHeight - mRadius ? sHeight - mRadius : y;
        thumbPaint.setAntiAlias(true);
        thumbPaint.setStyle(Paint.Style.FILL);
        thumbPaint.setColor(Color.RED);
        canvas.drawCircle(x, y, mRadius, thumbPaint);
    }
}
