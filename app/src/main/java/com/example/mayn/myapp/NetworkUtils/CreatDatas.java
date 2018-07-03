package com.example.mayn.myapp.NetworkUtils;

import com.example.mayn.myapp.bean.OneMessage;
import com.example.mayn.myapp.bean.TwoMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuqinggang on 2018/6/29.
 */

public class CreatDatas {

    public static List<OneMessage> getOneData(){
        List<OneMessage> listOne=new ArrayList<>();
        OneMessage oneMessage=new OneMessage();
        oneMessage.setName("热销");
        OneMessage oneMessage1=new OneMessage();
        oneMessage1.setName("优惠");
        OneMessage oneMessage2=new OneMessage();
        oneMessage2.setName("商家公告");
        OneMessage oneMessage3=new OneMessage();
        oneMessage3.setName("米饭必点");
        OneMessage oneMessage4=new OneMessage();
        oneMessage4.setName("限时特卖");
        OneMessage oneMessage5=new OneMessage();
        oneMessage5.setName("精品小炒");
        OneMessage oneMessage6=new OneMessage();
        oneMessage6.setName("干锅系列");
        OneMessage oneMessage7=new OneMessage();
        oneMessage7.setName("水煮系列");
        OneMessage oneMessage8=new OneMessage();
        oneMessage8.setName("田园蔬菜");
        OneMessage oneMessage9=new OneMessage();
        oneMessage9.setName("汤");
        OneMessage oneMessage10=new OneMessage();
        oneMessage10.setName("美味凉菜");
        OneMessage oneMessage11=new OneMessage();
        oneMessage11.setName("饮料");
        listOne.add(oneMessage);
        listOne.add(1,oneMessage1);
        listOne.add(2,oneMessage2);
        listOne.add(3,oneMessage3);
        listOne.add(4,oneMessage4);
        listOne.add(5,oneMessage5);
        listOne.add(6,oneMessage6);
        listOne.add(7,oneMessage7);
        listOne.add(8,oneMessage8);
        listOne.add(9,oneMessage9);
        listOne.add(10,oneMessage10);
        listOne.add(11,oneMessage11);
        return listOne;
    }
    public static List<TwoMessage> getTwoData(){
        List<TwoMessage> lists=new ArrayList<>();
        TwoMessage twoMessage=new TwoMessage();
        twoMessage.setName("农家小炒肉");
        twoMessage.setNumber(656);
        twoMessage.setPrice(28);
        twoMessage.setUrl("");
        twoMessage.setTag("热销");
        twoMessage.setIsfirst(true);
        twoMessage.setPosition(0);

        TwoMessage twoMessage2=new TwoMessage();
        twoMessage2.setName("番茄鸡蛋");
        twoMessage2.setNumber(66);
        twoMessage2.setPrice(18);
        twoMessage2.setUrl("");
        twoMessage2.setTag("热销");

        TwoMessage twoMessage3=new TwoMessage();
        twoMessage3.setName("红烧茄子");
        twoMessage3.setNumber(52);
        twoMessage3.setPrice(16);
        twoMessage3.setUrl("");
        twoMessage3.setTag("热销");

        TwoMessage twoMessage4=new TwoMessage();
        twoMessage4.setName("尖椒鸡蛋");
        twoMessage4.setNumber(6652);
        twoMessage4.setPrice(18);
        twoMessage4.setUrl("");
        twoMessage4.setTag("热销");

        TwoMessage twoMessage5=new TwoMessage();
        twoMessage5.setName("宫保鸡丁");
        twoMessage5.setNumber(336);
        twoMessage5.setPrice(22);
        twoMessage5.setUrl("");
        twoMessage5.setTag("热销");

        TwoMessage twoMessage6=new TwoMessage();
        twoMessage6.setName("手撕包菜");
        twoMessage6.setNumber(916);
        twoMessage6.setPrice(14);
        twoMessage6.setUrl("");
        twoMessage6.setTag("热销");

        TwoMessage twoMessage7=new TwoMessage();
        twoMessage7.setName("酸豆角肉末");
        twoMessage7.setNumber(807);
        twoMessage7.setPrice(18);
        twoMessage7.setUrl("");
        twoMessage7.setTag("热销");

        TwoMessage twoMessage8=new TwoMessage();
        twoMessage8.setName("清炒小清菜");
        twoMessage8.setNumber(670);
        twoMessage8.setPrice(14);
        twoMessage8.setUrl("");
        twoMessage8.setTag("热销");

        TwoMessage twoMessage9=new TwoMessage();
        twoMessage9.setName("水煮肉片");
        twoMessage9.setNumber(623);
        twoMessage9.setPrice(36);
        twoMessage9.setUrl("");
        twoMessage9.setTag("热销");

        TwoMessage twoMessage10=new TwoMessage();
        twoMessage10.setName("宫保鸡丁#");
        twoMessage10.setNumber(196);
        twoMessage10.setPrice(22);
        twoMessage10.setUrl("");
        twoMessage10.setTag("优惠");
        twoMessage10.setIsfirst(true);
        twoMessage10.setPosition(1);

        TwoMessage twoMessage11=new TwoMessage();
        twoMessage11.setName("水煮肉片#");
        twoMessage11.setNumber(369);
        twoMessage11.setPrice(18.88);
        twoMessage11.setUrl("");
        twoMessage11.setTag("优惠");

        TwoMessage twoMessage12=new TwoMessage();
        twoMessage12.setName("宫保鸡丁超级会员");
        twoMessage12.setNumber(122);
        twoMessage12.setPrice(22);
        twoMessage12.setUrl("");
        twoMessage12.setTag("优惠");

        TwoMessage twoMessage13=new TwoMessage();
        twoMessage13.setName("一定记得点米饭呀");
        twoMessage13.setNumber(656);
        twoMessage13.setPrice(0);
        twoMessage13.setUrl("");
        twoMessage13.setTag("商家公告");
        twoMessage13.setIsfirst(true);
        twoMessage13.setPosition(2);

        TwoMessage twoMessage14=new TwoMessage();
        twoMessage14.setName("饿了吗配送蜂鸟");
        twoMessage14.setNumber(541);
        twoMessage14.setPrice(0);
        twoMessage14.setUrl("");
        twoMessage14.setTag("商家公告");

        TwoMessage twoMessage15=new TwoMessage();
        twoMessage15.setName("米饭");
        twoMessage15.setNumber(12423);
        twoMessage15.setPrice(2);
        twoMessage15.setUrl("");
        twoMessage15.setTag("米饭必点");
        twoMessage15.setIsfirst(true);
        twoMessage15.setPosition(3);

        TwoMessage twoMessage16=new TwoMessage();
        twoMessage16.setName("宫保鸡丁");
        twoMessage16.setNumber(507);
        twoMessage16.setPrice(28);
        twoMessage16.setUrl("");
        twoMessage16.setTag("限时特卖");
        twoMessage16.setIsfirst(true);
        twoMessage16.setPosition(4);

        TwoMessage twoMessage17=new TwoMessage();
        twoMessage17.setName("酸辣土豆丝");
        twoMessage17.setNumber(13365);
        twoMessage17.setPrice(16);
        twoMessage17.setUrl("");
        twoMessage17.setTag("精品小炒");
        twoMessage17.setIsfirst(true);
        twoMessage17.setPosition(5);

        TwoMessage twoMessage18=new TwoMessage();
        twoMessage18.setName("番茄鸡蛋");
        twoMessage18.setNumber(656);
        twoMessage18.setPrice(12);
        twoMessage18.setUrl("");
        twoMessage18.setTag("精品小炒");

        TwoMessage twoMessage19=new TwoMessage();
        twoMessage19.setName("手撕包菜");
        twoMessage19.setNumber(656);
        twoMessage19.setPrice(12);
        twoMessage19.setUrl("");
        twoMessage19.setTag("精品小炒");

        TwoMessage twoMessage20=new TwoMessage();
        twoMessage20.setName("酸豆角肉末");
        twoMessage20.setNumber(807);
        twoMessage20.setPrice(12);
        twoMessage20.setUrl("");
        twoMessage20.setTag("精品小炒");

        TwoMessage twoMessage21=new TwoMessage();
        twoMessage21.setName("干锅土豆片");
        twoMessage21.setNumber(189);
        twoMessage21.setPrice(28);
        twoMessage21.setUrl("");
        twoMessage21.setTag("干锅系列");
        twoMessage21.setIsfirst(true);
        twoMessage21.setPosition(6);

        TwoMessage twoMessage22=new TwoMessage();
        twoMessage22.setName("干锅手撕包菜");
        twoMessage22.setNumber(280);
        twoMessage22.setPrice(28);
        twoMessage22.setUrl("");
        twoMessage22.setTag("干锅系列");

        TwoMessage twoMessage23=new TwoMessage();
        twoMessage23.setName("水煮肉片");
        twoMessage23.setNumber(634);
        twoMessage23.setPrice(38);
        twoMessage23.setUrl("");
        twoMessage23.setTag("水煮系列");
        twoMessage23.setIsfirst(true);
        twoMessage23.setPosition(7);

        TwoMessage twoMessage24=new TwoMessage();
        twoMessage24.setName("外婆酸菜鱼");
        twoMessage24.setNumber(58);
        twoMessage24.setPrice(36);
        twoMessage24.setUrl("");
        twoMessage24.setTag("水煮系列");

        TwoMessage twoMessage25=new TwoMessage();
        twoMessage25.setName("耗油生菜");
        twoMessage25.setNumber(36);
        twoMessage25.setPrice(14);
        twoMessage25.setUrl("");
        twoMessage25.setTag("田园蔬菜");
        twoMessage25.setIsfirst(true);
        twoMessage25.setPosition(8);

        TwoMessage twoMessage26=new TwoMessage();
        twoMessage26.setName("清炒小清菜");
        twoMessage26.setNumber(64);
        twoMessage26.setPrice(12);
        twoMessage26.setUrl("");
        twoMessage26.setTag("田园蔬菜");

        TwoMessage twoMessage27=new TwoMessage();
        twoMessage27.setName("番茄蛋汤");
        twoMessage27.setNumber(410);
        twoMessage27.setPrice(12);
        twoMessage27.setUrl("");
        twoMessage27.setTag("汤");
        twoMessage27.setIsfirst(true);
        twoMessage27.setPosition(9);

        TwoMessage twoMessage28=new TwoMessage();
        twoMessage28.setName("紫菜蛋汤");
        twoMessage28.setNumber(341);
        twoMessage28.setPrice(12);
        twoMessage28.setUrl("");
        twoMessage28.setTag("汤");

        TwoMessage twoMessage29=new TwoMessage();
        twoMessage29.setName("黄瓜");
        twoMessage29.setNumber(656);
        twoMessage29.setPrice(12);
        twoMessage29.setUrl("");
        twoMessage29.setTag("美味凉菜");
        twoMessage29.setIsfirst(true);
        twoMessage29.setPosition(10);

        TwoMessage twoMessage30=new TwoMessage();
        twoMessage30.setName("木耳");
        twoMessage30.setNumber(656);
        twoMessage30.setPrice(12);
        twoMessage30.setUrl("");
        twoMessage30.setTag("美味凉菜");

        TwoMessage twoMessage31=new TwoMessage();
        twoMessage31.setName("口水鸡");
        twoMessage31.setNumber(656);
        twoMessage31.setPrice(12);
        twoMessage31.setUrl("");
        twoMessage31.setTag("美味凉菜");

        TwoMessage twoMessage32=new TwoMessage();
        twoMessage32.setName("可乐");
        twoMessage32.setNumber(656);
        twoMessage32.setPrice(12);
        twoMessage32.setUrl("");
        twoMessage32.setTag("饮料");
        twoMessage32.setIsfirst(true);
        twoMessage32.setPosition(11);

        TwoMessage twoMessage33=new TwoMessage();
        twoMessage33.setName("水");
        twoMessage33.setNumber(656);
        twoMessage33.setPrice(12);
        twoMessage33.setUrl("");
        twoMessage33.setTag("饮料");

        lists.add(0,twoMessage);
        lists.add(1,twoMessage2);
        lists.add(2,twoMessage3);
        lists.add(3,twoMessage4);
        lists.add(4,twoMessage5);
        lists.add(5,twoMessage6);
        lists.add(6,twoMessage7);
        lists.add(7,twoMessage8);
        lists.add(8,twoMessage9);
        lists.add(9,twoMessage10);
        lists.add(10,twoMessage11);
        lists.add(11,twoMessage12);
        lists.add(12,twoMessage13);
        lists.add(13,twoMessage14);
        lists.add(14,twoMessage15);
        lists.add(15,twoMessage16);
        lists.add(16,twoMessage17);
        lists.add(17,twoMessage18);
        lists.add(18,twoMessage19);
        lists.add(19,twoMessage20);
        lists.add(20,twoMessage21);
        lists.add(21,twoMessage22);
        lists.add(22,twoMessage23);
        lists.add(23,twoMessage24);
        lists.add(24,twoMessage25);
        lists.add(25,twoMessage26);
        lists.add(26,twoMessage27);
        lists.add(27,twoMessage28);
        lists.add(28,twoMessage29);
        lists.add(29,twoMessage30);
        lists.add(30,twoMessage31);
        lists.add(31,twoMessage32);
        lists.add(32,twoMessage33);
        return lists;
    }
}
