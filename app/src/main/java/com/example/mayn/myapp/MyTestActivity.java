package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mayn.myapp.adapter.ManyTypeAdapter;
import com.example.mayn.myapp.bean.ManyTypeBean;

import java.util.ArrayList;
import java.util.List;

public class MyTestActivity extends BaseActivity {

    RecyclerView rv_tt;
    ManyTypeAdapter manyTypeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);
        rv_tt=findViewById(R.id.rv_tt);

        rv_tt.setLayoutManager(new GridLayoutManager(this,8));
        manyTypeAdapter=new ManyTypeAdapter(getList(),this);
        rv_tt.setAdapter(manyTypeAdapter);

    }

    public List<ManyTypeBean> getList() {
        List<ManyTypeBean> list = new ArrayList<>();
        ManyTypeBean mn = new ManyTypeBean();
        mn.itemType = ManyTypeBean.BANNER_VIEW_TYPE;
        mn.names = "轮播";
        List<String> strList = new ArrayList<>();
        strList.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=d31d7aca77f40ad10ae4c1e3672d1151/d439b6003af33a8730364de8ca5c10385243b5ed.jpg");
        strList.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=1d071b503501213fd03348dc64e636f8/fc1f4134970a304eb5088f73ddc8a786c9175c14.jpg");
        strList.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=61c889fe00d79123ffe092749d355917/48540923dd54564e39103dcfbfde9c82d0584fcb.jpg");
        strList.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=a40474ebca5c10383b7ec8c28210931c/2cf5e0fe9925bc311134756952df8db1ca1370d1.jpg");
        mn.lists=strList;
        List<String> stringList=new ArrayList<>();
        stringList.add("古感美女");
        stringList.add("性感美女");
        stringList.add("清新美女");
        stringList.add("古装美女");
        mn.titles=stringList;

        ManyTypeBean mn1 = new ManyTypeBean();
        mn1.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn1.names = "美女频道";
        mn1.url="http://b.hiphotos.baidu.com/image/h%3D300/sign=d31d7aca77f40ad10ae4c1e3672d1151/d439b6003af33a8730364de8ca5c10385243b5ed.jpg";

        ManyTypeBean mn2 = new ManyTypeBean();
        mn2.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn2.names = "美食频道";
        mn2.url="http://img5.imgtn.bdimg.com/it/u=2545731062,3052777903&fm=27&gp=0.jpg";

        ManyTypeBean mn3 = new ManyTypeBean();
        mn3.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn3.names = "游戏频道";
        mn3.url="http://img1.imgtn.bdimg.com/it/u=2488096158,1388281573&fm=27&gp=0.jpg";

        ManyTypeBean mn4 = new ManyTypeBean();
        mn4.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn4.names = "交通频道";
        mn4.url="http://img1.imgtn.bdimg.com/it/u=3154227379,3366830248&fm=27&gp=0.jpg";

        ManyTypeBean mn5 = new ManyTypeBean();
        mn5.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn5.names = "出行频道";
        mn5.url="http://img3.imgtn.bdimg.com/it/u=3273547605,227033952&fm=27&gp=0.jpg";


        ManyTypeBean mn6 = new ManyTypeBean();
        mn6.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn6.names = "租房频道";
        mn6.url="http://img5.imgtn.bdimg.com/it/u=329357936,384003429&fm=27&gp=0.jpg";

        ManyTypeBean mn7 = new ManyTypeBean();
        mn7.itemType = ManyTypeBean.CHANNEL_VIEW_TYPE;
        mn7.names = "情感频道";
        mn7.url="http://img2.imgtn.bdimg.com/it/u=729096588,3964717962&fm=27&gp=0.jpg";


        ManyTypeBean mn8 = new ManyTypeBean();
        mn8.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn8.names = "￥12";
        mn8.content="陕西苹果";
        mn8.url="http://img3.imgtn.bdimg.com/it/u=918799260,1658309823&fm=200&gp=0.jpg";

        ManyTypeBean mn9 = new ManyTypeBean();
        mn9.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn9.names = "￥8.8";
        mn9.content="进口香蕉";
        mn9.url="http://img4.imgtn.bdimg.com/it/u=2682670603,3612728365&fm=200&gp=0.jpg";

        ManyTypeBean mn10 = new ManyTypeBean();
        mn10.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn10.names = "￥5.6";
        mn10.content="崇明岛西瓜";
        mn10.url="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=378259055,3955971374&fm=27&gp=0.jpg";

        ManyTypeBean mn11 = new ManyTypeBean();
        mn11.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn11.names = "￥9.9";
        mn11.content="香梨";
        mn11.url="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2280430229,497093268&fm=27&gp=0.jpg";

        ManyTypeBean mn12 = new ManyTypeBean();
        mn12.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn12.names = "￥8.8";
        mn12.content="广西荔枝";
        mn12.url="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1518596704,3914782710&fm=27&gp=0.jpg";

        ManyTypeBean mn13 = new ManyTypeBean();
        mn13.itemType = ManyTypeBean.GIRL_VIEW_TYPE;
        mn13.names = "￥12.8";
        mn13.content="美国芒果";
        mn13.url="http://img0.imgtn.bdimg.com/it/u=3217499624,2128130948&fm=27&gp=0.jpg";

        ManyTypeBean mn14 = new ManyTypeBean();
        mn14.itemType = ManyTypeBean.NORMAL_VIEW_TYPE;
        mn14.names = "推荐1";

        ManyTypeBean mn15 = new ManyTypeBean();
        mn15.itemType = ManyTypeBean.NORMAL_VIEW_TYPE;
        mn15.names = "推荐2";

        ManyTypeBean mn16 = new ManyTypeBean();
        mn16.itemType = ManyTypeBean.NORMAL_VIEW_TYPE;
        mn16.names = "推荐3";

        ManyTypeBean mn17 = new ManyTypeBean();
        mn17.itemType = ManyTypeBean.NORMAL_VIEW_TYPE;
        mn17.names = "推荐4";

        ManyTypeBean mn18 = new ManyTypeBean();
        mn18.itemType = ManyTypeBean.NORMAL_VIEW_TYPE;
        mn18.names = "推荐5";



        list.add(mn);
        list.add(mn1);
        list.add(mn2);
        list.add(mn3);
        list.add(mn4);
        list.add(mn5);
        list.add(mn6);
        list.add(mn7);
        list.add(mn8);
        list.add(mn9);
        list.add(mn10);
        list.add(mn11);
        list.add(mn12);
        list.add(mn13);
        list.add(mn14);
        list.add(mn15);
        list.add(mn16);
        list.add(mn17);
        list.add(mn18);
        return list;
    }

}
