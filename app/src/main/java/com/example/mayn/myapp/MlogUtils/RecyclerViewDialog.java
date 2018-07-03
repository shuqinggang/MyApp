package com.example.mayn.myapp.MlogUtils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.adapter.DialogAdapter;
import com.example.mayn.myapp.bean.DialogBean;
import com.example.mayn.myapp.presenter.FirstPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuqinggang on 2018/6/22.
 */

public class RecyclerViewDialog extends Dialog{

    DialogAdapter mDialogAdapter;
    Context mcontext;
    public RecyclerViewDialog(Context context) {
        super(context,R.style.MyDilaog);
        this.mcontext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inittView();
    }
    public void inittView(){
         View view= LayoutInflater.from(mcontext).inflate(R.layout.myrecyclerbiew_layout,null);
         RecyclerView rv=(RecyclerView)view.findViewById(R.id.dialog_rv);
         Button btn_confirm=(Button)view.findViewById(R.id.btn_confirm);
         Button btn_cancle=(Button)view.findViewById(R.id.btn_cancle);
         setContentView(view);

        Window window=getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp=window.getAttributes();
        DisplayMetrics displayMetrics=mcontext.getResources().getDisplayMetrics();
        lp.width= (int)(displayMetrics.widthPixels*0.8);
        //   lp.height= (int)(displayMetrics.heightPixels*0.8);
         window.setAttributes(lp);
         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mcontext,RecyclerView.VERTICAL,false);
         rv.setLayoutManager(linearLayoutManager);
         mDialogAdapter=new DialogAdapter(getData());
         rv.setAdapter(mDialogAdapter);
    }
    public List<DialogBean> getData(){
        List<DialogBean> lists=new ArrayList<>();
        for(int i=0;i<10;i++){
            DialogBean bean = new DialogBean();
            if(i%3==0) {
                bean.setName("shuqinggang"+i);
                bean.setPhone("1744454612"+i);
                bean.setWork("码农"+i);
            }else if(i%4==0){
                bean.setName("shuqinggang"+i);
                bean.setPhone("1744454612"+i);
                bean.setWork("码农"+i);
            }else {
                bean.setName("shuqinggang"+i);
                bean.setPhone("1744454612"+i);
                bean.setWork("码农"+i);
            }
            lists.add(bean);
        }
        return lists;
    }
}
