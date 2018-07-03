package com.example.mayn.myapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mayn.myapp.Interface.Person;
import com.example.mayn.myapp.UI.WordsNavigation;
import com.example.mayn.myapp.adapter.PhoneAdapter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

public class LinelaoutActivity extends BaseActivity {

    WordsNavigation wordsNavigation;
    RecyclerView word_rv;
    List<Person> lists;
    PhoneAdapter phoneAdapter;
    LinearLayoutManager linearLayoutManager;

    private boolean move;
    private int selectPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linelaout);
        wordsNavigation=findViewById(R.id.wordsNavigation);
        word_rv=(RecyclerView)findViewById(R.id.word_rv);
        wordsNavigation.setListener(new WordsNavigation.onWordsChangeListener() {
            @Override
            public void setWordClick(String words) {
                updateListView(words);
            }
        });
        linearLayoutManager=new LinearLayoutManager(this);
        word_rv.setLayoutManager(linearLayoutManager);
        phoneAdapter=new PhoneAdapter(getData());
        word_rv.setAdapter(phoneAdapter);

        phoneAdapter.setOnScrollPositions(new PhoneAdapter.onScrollPosition() {
            @Override
            public void getPositionPin(String str) {
            //    wordsNavigation.setTouchIndex(str);
            }
        });
        word_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (move) {
                    move = false;
                    //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                    int n = selectPosition - linearLayoutManager.findFirstVisibleItemPosition();
                    if (0 <= n && n < word_rv.getChildCount()) {
                        //获取要置顶的项顶部离RecyclerView顶部的距离
                        int top = word_rv.getChildAt(n).getTop();
                        //最后的移动
                        word_rv.scrollBy(0, top);
                    }
                }else {
                    View view=linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
                        TextView textView = view.findViewById(R.id.tx_pinyin);
                        if (!textView.getText().toString().equals("")) {
                            wordsNavigation.setTouchIndex(textView.getText().toString());
                        }


                }
            }
        });
    }

    /**
     * @param words 首字母
     */
    private void updateListView(String words) {
        for (int i = 0; i < lists.size(); i++) {
            String headerWord = lists.get(i).getFirstpingyin();
            //将手指按下的字母与列表中相同字母开头的项找出来
            if (words.equals(headerWord)) {
                //将列表选中哪一个
                selectPosition=i;
                moveToPosition(i);
                //找到开头的一个即可
                return;
            }
        }
    }

    /**
     * @param n
     */
    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = linearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = linearLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            word_rv.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = word_rv.getChildAt(n - firstItem).getTop();
            word_rv.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            word_rv.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
            move = true;
        }
    }

    public List<Person> getData(){
        lists=new ArrayList<>();
        Person person=new Person("阿达");
        Person person1=new Person("阿回");
        Person person2=new Person("本知道");
        Person person3=new Person("百世");
        Person person4=new Person("长度");
        Person person5=new Person("从的");
        Person person6=new Person("串口");
        Person person7=new Person("叠加");
        Person person8=new Person("达到");
        Person person9=new Person("恶魔");
        Person person10=new Person("飞发");
        Person person11=new Person("付款");
        Person person12=new Person("嗯啊");
        Person person13=new Person("咖喱");
        Person person14=new Person("给我");
        Person person15=new Person("哈哈");
        Person person16=new Person("来电");
        Person person17=new Person("俩啊");
        Person person18=new Person("那发卡机");
        Person person19=new Person("哦哦");
        Person person20=new Person("品牌");
        Person person21=new Person("强化");
        Person person22=new Person("求啊看");
        Person person23=new Person("燃料库");
        Person person24=new Person("似乎就看");
        Person person25=new Person("他都是");
        Person person26=new Person("划分垃圾");
        Person person27=new Person("我饭卡");
        Person person28=new Person("考了放");
        Person person29=new Person("以后就卡");
        Person person30=new Person("选哪款");
        Person person31=new Person("想开了");
        Person person32=new Person("在这里");
        Person person33=new Person("激发了");
        Person person34=new Person("家啦");
        Person person35=new Person("刚好拉开");
        Person person36=new Person("卡汇聚");
        Person person37=new Person("焕发健康");
        Person person38=new Person("黑暗精灵");
        Person person39=new Person("姐姐");
        Person person40=new Person("发卡机");
        lists.add(person);
        lists.add(person1);
        lists.add(person2);
        lists.add(person3);
        lists.add(person4);
        lists.add(person5);
        lists.add(person6);
        lists.add(person7);
        lists.add(person8);
        lists.add(person9);
        lists.add(person10);
        lists.add(person11);
        lists.add(person12);
        lists.add(person13);
        lists.add(person14);
        lists.add(person15);
        lists.add(person16);
        lists.add(person17);
        lists.add(person18);
        lists.add(person19);
        lists.add(person20);
        lists.add(person21);
        lists.add(person22);
        lists.add(person23);
        lists.add(person24);
        lists.add(person25);
        lists.add(person26);
        lists.add(person27);
        lists.add(person28);
        lists.add(person29);
        lists.add(person30);
        lists.add(person31);
        lists.add(person32);
        lists.add(person33);
        lists.add(person34);
        lists.add(person35);
        lists.add(person36);
        lists.add(person37);
        lists.add(person38);
        lists.add(person39);
        lists.add(person40);

        //对集合排序
        Collections.sort(lists, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                //根据拼音进行排序
                return lhs.getFirstpingyin().compareTo(rhs.getFirstpingyin());
            }
        });
        return lists;
    }
}
