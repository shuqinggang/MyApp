package com.example.mayn.myapp.MlogUtils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.mayn.myapp.R;

/**
 * Created by shuqinggang on 2018/6/15.
 */

public class MyDialog extends Dialog implements View.OnClickListener {
    Context mcontext;
    CliclText cliclText;
    public MyDialog(@NonNull Context context) {
        super(context,R.style.MyDilaog);
        this.mcontext=context;
    }
    public interface CliclText{
        void takePhotos();
        void takeImg();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inite();
    }
    public void inite(){
        View view= LayoutInflater.from(mcontext).inflate(R.layout.alert_item_layout,null);
        TextView takePhoto=(TextView)view.findViewById(R.id.item_tx_take_photo);
        TextView itemTx=(TextView)view.findViewById(R.id.item_tx_xc);
        setContentView(view);
        takePhoto.setOnClickListener(this);
        itemTx.setOnClickListener(this);
        Window window=getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics d = mcontext.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
        window.setAttributes(lp);
    }

    public CliclText getCliclText() {
        return cliclText;
    }

    public void setCliclText(CliclText cliclText) {
        this.cliclText = cliclText;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_tx_take_photo:
                 cliclText.takePhotos();
                break;
            case R.id.item_tx_xc:
                cliclText.takeImg();
                break;
            default:
                break;
        }
    }
}
