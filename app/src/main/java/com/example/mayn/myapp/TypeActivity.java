package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mayn.myapp.adapter.TypeAdapter;
import com.example.mayn.myapp.bean.MultipleItem;

import java.util.ArrayList;
import java.util.List;

public class TypeActivity extends BaseActivity {

    RecyclerView recyclerView;
    TypeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        recyclerView=(RecyclerView)findViewById(R.id.rv_type);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter=new TypeAdapter(getMultipleItemData());
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        recyclerView.setAdapter(adapter);
    }

    public static List<MultipleItem> getMultipleItemData() {
        List<MultipleItem> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            if (i % 3 == 0) {

                MultipleItem item = new MultipleItem();
                item.itemType = MultipleItem.HEADER;
                item.name="帅哥";
                list.add(item);

                MultipleItem item0 = new MultipleItem();
                item0.itemType = MultipleItem.CONTENT;
                item0.content = "你好漂亮";
                list.add(item0);

                MultipleItem item1 = new MultipleItem();
                item1.itemType = MultipleItem.CONTENT;
                item1.content = "你好漂亮" ;
                list.add(item1);

            } else if (i % 4 == 0) {

                MultipleItem item = new MultipleItem();
                item.itemType = MultipleItem.HEADER;
                item.name="帅哥";
                list.add(item);

                MultipleItem item0 = new MultipleItem();
                item0.itemType = MultipleItem.CONTENT;
                item0.content = "你好漂亮";
                list.add(item0);

                MultipleItem item1 = new MultipleItem();
                item1.itemType = MultipleItem.CONTENT;
                item1.content = "你好漂亮";
                list.add(item1);

                MultipleItem item2 = new MultipleItem();
                item2.itemType = MultipleItem.CONTENT;
                item2.content = "你好漂亮";
                list.add(item2);

            } else {
                MultipleItem item = new MultipleItem();
                item.itemType = MultipleItem.HEADER;
                item.name="帅哥";
                list.add(item);
            }
        }
        return list;
    }
}
