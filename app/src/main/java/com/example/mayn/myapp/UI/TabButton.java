package com.example.mayn.myapp.UI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mayn.myapp.R;


/**
 * 导航栏按钮
 */
public class TabButton extends LinearLayout {
    public static final int DEFAULT_TXT_COLOR = 0xFF727272;
    public static int tChecked = 0xFF0574E6;
    public static int tNoCheck = 0xFF727272;
    private Drawable dChecked;
    private Drawable dNoCheck;

    private ImageView iv;
    private TextView tv;
    private String text;
    private boolean isCheck = false;

    public TabButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.ui_tab_button, this);
        iv = (ImageView) findViewById(R.id.icon);
        tv = (TextView) findViewById(R.id.name);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.tabButton);

        for (int i = 0; i < a.getIndexCount(); i++) {
                int at = a.getIndex(i);
                switch (at) {
                    case R.styleable.tabButton_src:
                        dNoCheck = a.getDrawable(at);
                        break;
                    case R.styleable.tabButton_srcCheck:
                        dChecked = a.getDrawable(at);
                        break;
                    case R.styleable.tabButton_textColor:
                        tNoCheck = a.getColor(at, DEFAULT_TXT_COLOR);
                        break;
                    case R.styleable.tabButton_text:
                        text = a.getString(at);
                        break;
                }
        }

        iv.setImageDrawable(dNoCheck);
        tv.setTextColor(tNoCheck);
        try {
            tv.setText(text);
        } catch (Exception e) {
            tv.setVisibility(View.GONE);
        }

        a.recycle();
    }

    /**
     * 设置是否被选中
     *
     * @param isCheck
     */
    public void setChecked(boolean isCheck) {
        this.isCheck = isCheck;
        toggle();
    }

    /**
     * 改变按钮状态
     */
    public void toggle() {
        if (isCheck) {
            iv.setImageDrawable(dChecked);
            tv.setTextColor(tChecked);
        } else {
            iv.setImageDrawable(dNoCheck);
            tv.setTextColor(tNoCheck);
        }
    }

    public void setTitle(String title) {
        tv.setText(title);
    }

    public void setDrawable(int src, int srcChecked) {
        dNoCheck = getResources().getDrawable(src);
        dChecked = getResources().getDrawable(srcChecked);
    }

}
