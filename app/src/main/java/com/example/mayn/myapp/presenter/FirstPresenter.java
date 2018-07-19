package com.example.mayn.myapp.presenter;

import android.content.Context;

import com.example.mayn.myapp.Interface.IFirstData;
import com.example.mayn.myapp.Interface.RefreshRecyclerview;
import com.example.mayn.myapp.InterfaceImp.FirstData;

/**
 * Created by shuqinggang on 2018/6/5.
 * 5D:9F:68:C7:40:50:12:C8:83:FF:5F:65:FB:9C:C1:7A:5D:2D:95:52
 *
 *
 * 55:80:36:62:E3:5C:48:40:DE:EC:8A:3E:DC:17:D9:1E:01:CA:F2:26
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

   public void getDatas(){
       view.refresh(iFirstData.getDatas());
   }
}
