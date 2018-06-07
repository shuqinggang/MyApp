package com.example.mayn.myapp.presenter;

import android.content.Context;

import com.example.mayn.myapp.Interface.IFirstData;
import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.InterfaceImp.FirstData;

/**
 * Created by shuqinggang on 2018/6/5.
 */

public class FirstPresenter {

    RefreshRecyclerview view;
    IFirstData iFirstData;

    public FirstPresenter(RefreshRecyclerview view) {
        this.view = view;
        this.iFirstData = new FirstData();
    }
    public void getDataList(int page, Context mcontext){
         view.refresh(iFirstData.getNextData(page,mcontext));
    }

   public void getMessageList(){
        view.refresh(iFirstData.getMessageData());
   }
}
