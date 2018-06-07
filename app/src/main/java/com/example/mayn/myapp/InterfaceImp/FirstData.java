package com.example.mayn.myapp.InterfaceImp;

import android.content.Context;

import com.example.mayn.myapp.Interface.IFirstData;
import com.example.mayn.myapp.NetworkUtils.GsonUtil;
import com.example.mayn.myapp.NetworkUtils.JsonAssetsReaderUtil;
import com.example.mayn.myapp.R;
import com.example.mayn.myapp.bean.FirstBean;
import com.example.mayn.myapp.bean.FirstWangyi;
import com.example.mayn.myapp.bean.MessageBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuqinggang on 2018/6/5.
 */

public class FirstData implements IFirstData{

    @Override
    public List getNextData(int page, Context mcontext) {
        return setData(mcontext);
    }

    @Override
    public List getMessageData() {
        return setData1();
    }

    public List setData(Context context){
        String str=JsonAssetsReaderUtil.getJsonStrFromAssets(context,"basefirst");
        FirstWangyi list= GsonUtil.parseJsonWithGson(str,FirstWangyi.class);
        return list.getVideo();
//        List<String> imgList=new ArrayList<>();
//        imgList.add((R.mipmap.two)+"");
//        imgList.add((R.mipmap.one)+"");
//        imgList.add((R.mipmap.three)+"");
//        imgList.add((R.mipmap.four)+"");
//        imgList.add((R.mipmap.five)+"");
//        imgList.add((R.mipmap.six)+"");
//        imgList.add((R.mipmap.seven)+"");
//        imgList.add((R.mipmap.eight)+"");
//        List<FirstBean> list=new ArrayList<>();
//         for(int i=0;i<imgList.size();i++){
//             FirstBean firstBean = new FirstBean();
//             firstBean.setImgUrl(imgList.get(i));
//             firstBean.setInfor("");
//             firstBean.setUserName("结婚那天的照片");
//             firstBean.setYear(i*2+i+"");
//             list.add(firstBean);
//         }
//         return list;
    }


    public List setData1(){
        List<String> imgList=new ArrayList<>();
        imgList.add((R.mipmap.qun)+"");
        imgList.add((R.mipmap.dingyh)+"");
        imgList.add((R.mipmap.news)+"");
        imgList.add((R.mipmap.one)+"");
        List<MessageBean> list=new ArrayList<>();
        for(int i=0;i<imgList.size();i++){
          MessageBean messageBean=new MessageBean();
          messageBean.setGroupname("公众号和聊天群");
          messageBean.setImg(imgList.get(i));
          messageBean.setInfor("这个谁");
          list.add(messageBean);
        }
        return list;
    }

}
