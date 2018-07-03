package com.example.mayn.myapp.NetworkUtils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * Created by shuqinggang on 2018/6/28.
 * 将汉字转换为拼音
 */

public class Haizizhuanpingying {
    //将汉字转换成拼音
     public static String getPingyin(String name){
         String str= null;
         try {
             str = PinyinHelper.convertToPinyinString(name,",", PinyinFormat.WITHOUT_TONE);
         } catch (PinyinException e) {
             e.printStackTrace();
         }
         return str;
     }
     //获取传入拼音的首个字母，并且转化为大写
     public static String getPinyingDa(String name){
         String str=name.substring(0,1).toUpperCase();
         return str;
     }
}
