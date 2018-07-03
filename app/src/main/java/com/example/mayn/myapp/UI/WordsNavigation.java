package com.example.mayn.myapp.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by shuqinggang on 2018/6/28.
 */

public class WordsNavigation extends View {
    Context context;
    public int textSize=30;
    public String words[]={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    /*字母画笔*/
    private Paint wordsPaint;
    /*字母背景画笔*/
    private Paint bgPaint;
    private int itemWidth;
    /*每一个字母的高度*/
    private int itemHeight;
    /*手指按下的字母索引*/
    private int touchIndex = 0;
    /*手指按下的字母改变接口*/
    private onWordsChangeListener listener;

    public onWordsChangeListener getListener() {
        return listener;
    }

    public void setListener(onWordsChangeListener listener) {
        this.listener = listener;
    }

    public WordsNavigation(Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        wordsPaint=new Paint(Paint.EMBEDDED_BITMAP_TEXT_FLAG);
        bgPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        bgPaint.setColor(Color.BLUE);
        itemWidth=getMeasuredWidth();
        //使得边距好看一些
        int height = getMeasuredHeight() - 10;
        itemHeight = height / 27;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < words.length; i++) {
            //判断是不是我们按下的当前字母
            if (touchIndex == i) {
                //绘制文字圆形背景
                canvas.drawCircle(itemWidth - textSize*2+textSize/3, itemHeight / 2 + i * itemHeight-itemHeight/4, 20, bgPaint);
                wordsPaint.setColor(Color.WHITE);
            } else {
                wordsPaint.setColor(Color.GRAY);
            }
            wordsPaint.setTextSize(textSize);
            //获取文字的宽高
            Rect rect = new Rect();
            wordsPaint.getTextBounds(words[i], 0, 1, rect);
            int wordWidth = rect.width();
            //绘制字母
            float wordX = itemWidth  - textSize*2;
            float wordY = itemHeight / 2 + i * itemHeight;
            canvas.drawText(words[i], wordX, wordY, wordsPaint);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                //关键点===获得我们按下的是那个索引(字母)
                int index = (int) (y / itemHeight);
                if (index != touchIndex)
                    touchIndex = index;
                //防止数组越界
                if (listener != null && 0 <= touchIndex && touchIndex <= words.length - 1) {
                    //回调按下的字母
                   listener.setWordClick(words[touchIndex]);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起,不做任何操作
                break;
        }
        return true;
    }
    /*设置当前按下的是那个字母*/
    public void setTouchIndex(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                 touchIndex = i;
                invalidate();
                return;
            }
        }
    }
    public interface onWordsChangeListener{
        void setWordClick(String words);
    }
}
